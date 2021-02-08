export default async function getBreakdownByType(lotCode, breakdownType) {

    // call to backend api to search
    const response = await fetch(`http://localhost:8080/api/breakdown/${breakdownType}/${lotCode}`, {
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