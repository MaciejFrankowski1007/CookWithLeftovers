document.getElementById("searchForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const ingredients = document.getElementById("ingredients").value
        .split(",")
        .map((ingredient) => ingredient.trim())
        .join(" ");

    try {
        const response = await fetch(
            `https://www.googleapis.com/customsearch/v1?q=${encodeURIComponent(
                ingredients
            )}+recipes&key=AIzaSyCoJquuu8fZqcqRxRhVP1TgAo_gSn9d1ac`
        );

        if (!response.ok) {
            throw new Error("Failed to fetch recipes");
        }

        const data = await response.json();
        const resultsDiv = document.getElementById("results");
        resultsDiv.innerHTML = "";

        if (data.items && data.items.length > 0) {
            data.items.forEach((item) => {
                const linkElement = document.createElement("a");
                linkElement.href = item.link;
                linkElement.target = "_blank";
                linkElement.textContent = item.title;

                const description = document.createElement("p");
                description.textContent = item.snippet;

                const resultDiv = document.createElement("div");
                resultDiv.appendChild(linkElement);
                resultDiv.appendChild(description);

                resultsDiv.appendChild(resultDiv);
            });
        } else {
            resultsDiv.innerHTML = "<p>No results found. Try different ingredients.</p>";
        }
    } catch (error) {
        console.error("Search error:", error);
        alert("An error occurred while fetching recipes. Please try again.");
    }
});
