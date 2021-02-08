async function getBreakdown() {
    async function handleSearch({target}){
        const searchQuery = target.value;
        setSearchQuery(searchQuery);

        // call to backend api to search
        const response = await fetch(`http://localhost:8080/api/wine/search/${searchQuery}`, {
            method:"GET",
            mode: "cors",
            headers: {
                Accept: "application/json, text/plain, */*",
                "Content-Type": "application/json"
            }
        });
        const results = await response.json();
        // update search results
        setWine(results);
    }
}