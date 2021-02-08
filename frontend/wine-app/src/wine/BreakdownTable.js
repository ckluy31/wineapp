import React, {useEffect, useState} from 'react';

export default function BreakdownTable({ breakdown, breakdownType}) {

    return(
        <table>
            <thead>
                <tr>
                    <th>
                        {breakdownType.toUpperCase()}
                    </th>
                    <th>
                        PERCENTAGE
                    </th>
                </tr>
            </thead>
            <tbody>
            {
                breakdown.map(row => <tr>
                    <td>
                        {row.key}
                    </td>
                    <td>
                        {row.percentage}
                    </td>
                </tr>)
            }
            </tbody>
        </table>
    )
}