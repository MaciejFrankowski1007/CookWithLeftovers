document.getElementById("searchForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const ingredients = document.getElementById("ingredients").value
        .split(",")
        .map(i => i.trim())
        .join(" ");

    try {
        const response = await fetch(`https://www.googleapis.com/customsearch/v1?q=${encodeURIComponent(ingredients)}&key=YOUR_API_KEY&cx=YOUR_CX`);
        if (!response.ok) {
            throw new Error("Failed to fetch recipes");
        }

        const data = await response.json();
        const resultsDiv = document.getElementById("results");
        resultsDiv.innerHTML = ""; 

        if (data.items && data.items.length > 0) {
            data.items.forEach(item => {
                const link = document.createElement("a");
                link.href = item.link;
                link.textContent = item.title;
                link.target = "_blank";
                link.classList.add("result-link");

                resultsDiv.appendChild(link);
                resultsDiv.appendChild(document.createElement("br"));
            });
        } else {
            resultsDiv.innerHTML = "<p>No results found. Try different ingredients.</p>";
        }
    } catch (error) {
        console.error("Error during search:", error);
        alert("An error occurred while searching. Please try again.");
    }
});
