import React, {Component, useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import BreakdownTable from './BreakdownTable';
import getBreakdownByType from "./getBreakdownByType";
import {BreakdownTabs} from "./BreakdownTabs";
import getWine from "./getWine";


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

    useEffect(()=> {
            getWine(lotCode)
                .then(setWine)
        }, [lotCode]
    )

    function onBreakdownSelect(key) {
        setBreakdownType(key);
        getBreakdownByType(lotCode, key).then(({breakdown})=>setBreakdown(breakdown));
    }

    return(
        <div className={"WineDetailsPage"}>
            <div className={"TableProduct"}>
                <div className={"HeaderProduct"}>
                    <p>{wine.lotCode}</p>
                    <p>{wine.description}</p>
                </div>
                <div className={"TableSummary"}>
                    <table className={"TableDetails"}>
                        <tbody>
                            <tr className={"TableSummaryRow0"}>
                                <td>
                                    Volume
                                </td>
                                <td className={"SummaryDetailsRow"}>
                                    {wine.volume}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow1"}>
                                <td>
                                    Tank Code
                                </td>
                                <td>
                                    {wine.tankCode}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow2"}>
                                <td>
                                    Product State
                                </td>
                                <td>
                                    {wine.productState}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow3"}>
                                <td>
                                    Owner
                                </td>
                                <td>
                                    {wine.ownerName}
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