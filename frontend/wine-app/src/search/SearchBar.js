import closeIcon from './Close.png';
import React from 'react';

export default function SearchBar() {
    return (
        <div className={"SearchBar"}>
            <div className={"SearchInput"}>
                <div className={"ActionsLeft"}>
                    <img src={closeIcon} className="CloseIcon" alt={"icon"}/>
                </div>
                <div className={"ActionsRight"}>
                </div>
            </div>
        </div>
    )
}