import React from 'react';

export function SearchResult({ searchResult: wine }) {
    return (
        <div className="SearchResult" >

                <div className={"ActionsLeft"}>
                    <div className={"FrameTen"}>
                        <div className={"MainResultText"}>
                            <p>{wine.lotCode}</p>
                        </div>
                        <div className={"SubResultText"}>
                            <p>{wine.description}</p>
                        </div>
                    </div>
                </div>
                    <div className={"Frame17"}>
                        <div className={"SubResultText"}>
                            <p>{wine.volume}</p>
                        </div>
                        <div className={"SubResultText"}>
                            <p>{wine.tankCode}</p>
                        </div>
                    </div>

        </div>);
}