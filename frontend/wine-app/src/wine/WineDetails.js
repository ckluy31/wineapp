import React, {useEffect, useState} from 'react';
import {useHistory, useParams} from 'react-router-dom';
import BreakdownTable from './BreakdownTable';
import getBreakdownByType from "./getBreakdownByType";
import {BreakdownTabs} from "./BreakdownTabs";
import getWine from "./getWine";
import './wine.css'
import {BackButton} from "./BackButton";
import {EditButton} from "./EditButton";


export default function WineDetails(){
    const {lotCode} = useParams();
    const [wine, setWine] = useState({});
    const [breakdown, setBreakdown] = useState([]);
    const [breakdownType, setBreakdownType] = useState('year')
    const history = useHistory();

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



    function handleClickBack() {
        history.push("/");
    }

    function handleClickEdit() {
        alert("Edit Button has been Clicked!");
    }

    return(
        <div className={"WineDetailsPage"}>
            <div className={"TableProduct"}>
                <div className={"HeaderProduct"}>
                    <div className={"HeaderProductLeft"}>
                        <BackButton onClick={handleClickBack}/>
                        <p className={"Title"}>{wine.lotCode}</p>
                        <p className={"DescriptionText"}>{wine.description}</p>
                    </div>
                    <div className={"HeaderProductRight"}>
                        <EditButton onClick={handleClickEdit}/>
                    </div>
                </div>
                <div className={"TableSummary"}>
                    <table className={"TableDetails"}>
                        <tbody>
                            <tr className={"TableSummaryRow0"}>
                                <td className={"DetailsAttributes"}>
                                    Volume
                                </td>
                                <td className={"SummaryDetailsRow"}>
                                    {wine.volume + " L"}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow1"}>
                                <td className={"DetailsAttributes"}>
                                    Tank Code
                                </td>
                                <td className={"SummaryDetailsRow"}>
                                    {wine.tankCode}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow2"}>
                                <td className={"DetailsAttributes"}>
                                    Product State
                                </td>
                                <td className={"SummaryDetailsRow"}>
                                    {wine.productState}
                                </td>
                            </tr>
                            <tr className={"TableSummaryRow3"}>
                                <td className={"DetailsAttributes"}>
                                    Owner
                                </td>
                                <td className={"SummaryDetailsRow"}>
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