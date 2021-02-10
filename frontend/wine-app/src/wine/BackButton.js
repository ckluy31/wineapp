import React from 'react';
import backButton from "./Back.png";

export function BackButton({onClick}) {
    return <button className={"Back"} onClick={onClick}>
        <img src={backButton}/>
    </button>
}