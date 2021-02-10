import React from 'react';
import editButton from "./EditButton.png";

export function EditButton({onClick}) {
    return <button className={"Edit"} onClick={onClick}>
        <img src={editButton}/>
    </button>
}