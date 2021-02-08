import React, {useEffect, useState} from 'react';

export default function BreakdownTable({ breakdown, breakdownType}) {

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
                breakdown.map(row => <tr>
                    <td className={"BreakDownKey"}>
                        {row.key}
                    </td>
                    <td className={"BreakDownVal"}>
                        {row.percentage}
                    </td>
                </tr>)
            }
            </tbody>
        </table>
    )
}