import React, {Component, useState} from 'react';
import iconImg from './ICON.png'
import './search.css'
import closeIcon from "./Close.png";

export default function SearchPage(){
    const [searchQuery, setSearchQuery] = useState('');
    const [searchResults, setSearchResults] = useState([]);

    function handleSearch({target}){
        const searchQuery = target.value;
        setSearchQuery(searchQuery);
    }


    return(
        <div className={"SearchPage"}>
            <div className={"Search"}>
                <div className={"SearchFrame"}>
                    <header className={"SearchHeader"}>
                        Wine Search
                    </header>
                    <div className={"IconContainer"}>
                        <img src={iconImg} className={"Icon"} alt={"icon"}/>
                    </div>
                </div>
                <div className={"SearchInputBox"}>
                    <div className={"ActionsLeft"}>
                        <img src={closeIcon} className="CloseIcon" alt={"icon"}/>
                    </div>
                    <div className={"ActionsRight"}>
                    </div>
                    <input className={"SearchQuery"} onChange={handleSearch} />
                </div>
            </div>
            <h1>{searchQuery}</h1>

        </div>

    )


}