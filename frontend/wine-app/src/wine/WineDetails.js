import React, {Component, useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import BreakdownTable from './BreakdownTable';
import getBreakdownByType from "./getBreakdownByType";
import {BreakdownTabs} from "./BreakdownTabs";


export default function WineDetails(){
    const {lotCode} = useParams();
    const [wine, setWine] = useState({});
    const [breakdown, setBreakdown] = useState([]);
    const [breakdownType, setBreakdownType] = useState('year')
    useEffect(()=> {
            getBreakdownByType(lotCode, breakdownType)
                .then(({breakdown})=>setBreakdown(breakdown))
        }, [lotCode, breakdownType]
    )

    function onBreakdownSelect(key) {
        setBreakdownType(key);
        getBreakdownByType(lotCode, key).then(({breakdown})=>setBreakdown(breakdown));
    }

    return(
        <div className={"WineDetailsPage"}>
            <div className={"TableProduct"}>
                <div className={"HeaderProduct"}>
                    <p>Insert description here</p>
                </div>
                <div className={"TableSummary"}>
                    <table className={"TableDetails"}>
                        <tbody>
                            <tr className={"TableSummaryRow0"}>
                                <td>
                                    Volume
                                </td>
                                <td className={"SummaryDetailsRow"}>
                                    Insert Volume Here
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow1"}>
                                <td>
                                    Tank Code
                                </td>
                                <td>
                                    Insert TankCode Here
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow2"}>
                                <td>
                                    Tank Code
                                </td>
                                <td>
                                    Insert TankCode Here
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow3"}>
                                <td>
                                    Tank Code
                                </td>
                                <td>
                                    Insert TankCode Here
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div className={"NavTabs"}>
                    <BreakdownTabs onBreakdownSelect={onBreakdownSelect}/>
                </div>
                <div className={"TableDetails"}>
                    <BreakdownTable breakdown={breakdown} breakdownType={breakdownType}/>
                </div>
            </div>
        </div>
    )


}