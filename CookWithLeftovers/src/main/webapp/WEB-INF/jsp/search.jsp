<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Recipes</title>
</head>
<body>
    <h2>Search Recipes</h2>
    <form action="recipes/search" method="get">
        <label for="ingredients">Ingredients:</label>
        <input type="text" id="ingredients" name="ingredients" required>
        <button type="submit">Search</button>
    </form>
    <h3>Results</h3>
    <c:if test="${not empty results}">
        <ul>
            <c:forEach var="result" items="${results}">
                <li><a href="${result}" target="_blank">${result}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
