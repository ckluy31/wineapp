export default async function getWineDetails(lotCode) {

    // call to backend api to search
    const response = await fetch(`http://localhost:8080/api/wine/details/${lotCode}`, {
        method: "GET",
        mode: "cors",
        headers: {
            Accept: "application/json, text/plain, */*",
            "Content-Type": "application/json"
        }
    });
    const results = await response.json();

    return results;
}