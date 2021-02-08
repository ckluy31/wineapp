import React from 'react';

export function SearchResult({ searchResult: wine, onSelect}) {
    return (
        <div className="SearchResult" onClick={() => onSelect(wine)} >

            <div className={"ActionsLeft"}>
                <div className={"FrameTen"}>
                    <div className={"MainResultText"}>
                        <p>{wine.lotCode}</p>
                    </div>
                    <div className={"SubResultDescription"}>
                        <p>{wine.description}</p>
                    </div>
                </div>
            </div>
            <div className={"ActionsRight"}>
                <div className={"Frame17"}>
                    <div className={"SubResultText"}>
                        <p>{wine.volume}</p>
                    </div>
                    <div className={"SubResultText"}>
                        <p>{wine.tankCode}</p>
                    </div>
                </div>
            </div>


        </div>);
}