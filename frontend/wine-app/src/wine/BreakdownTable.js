import React, {useState} from 'react';

export default function BreakdownTable({ breakdown, breakdownType}) {
    const [resultsLimit, setResultsLimit] = useState(5); // the max number of results to be displayed
    const showMoreActive = breakdown.length > resultsLimit; // boolean to see if showMore button should appear or not


    function handleShowMore() {
        // increase the number of results to be shown
        setResultsLimit(resultsLimit + 10);
    }

    return(
        <table className={"BreakdownTable"}>
            <thead>
                <tr>
                    <th className={"BreakDownKeyHeader"}>
                        {breakdownType.toUpperCase()}
                    </th>
                    <th className={"BreakDownValHeader"}>
                        PERCENTAGE
                    </th>
                </tr>
            </thead>
            <tbody>
            {
                breakdown.slice(0, resultsLimit).map((row) => <tr>
                    <td className={"BreakDownKey"}>
                        {row.key}
                    </td>
                    <td className={"BreakDownVal"}>
                        {row.percentage}
                    </td>
                </tr>)
            }
            {showMoreActive ?
                <div>
                <button onClick={handleShowMore} className="ShowMoreButton">Show more</button>
                </div>
                :""
            }
            </tbody>
        </table>
    )
}