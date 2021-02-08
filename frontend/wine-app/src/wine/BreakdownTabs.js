import React, {useState} from 'react';

export function BreakdownTabs({onBreakdownSelect}) {
    const [breakdownPicked, setBreakdownPicked] = useState(0);
    const breakdownTypes = [
        { key: "year", display: "Year"},
        { key: "variety", display: "Variety"},
        { key: "region", display: "Region"},
        { key: "year-variety", display: "Year/Variety"}
    ]

    function onClickHandler(key) {
        setBreakdownPicked(key)
        // notify that a different key has been picked
        onBreakdownSelect(key)
    }
    return (
        <div className="BreakdownSelector">
            {breakdownTypes.map((name) =>
                (
                    <button key={name} type='button' onClick={() => onClickHandler(name.key)}>{name.display}</button>
                )
            )
            }
        </div>
    );
}