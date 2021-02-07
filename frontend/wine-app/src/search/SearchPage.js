import React, {Component, useState} from 'react';
import iconImg from './ICON.png'
import './search.css'
import closeIcon from "./Close.png";

export default function SearchPage(){
    const [searchQuery, setSearchQuery] = useState(''); // keep track of the search query
    const [searchResults, setSearchResults] = useState([]); // regularly update results based on search query

    async function handleSearch({target}){
        const searchQuery = target.value;
        setSearchQuery(searchQuery);

        // call to backend api to search
        const response = await fetch(`http://localhost:8080/api/wine/search/11`, {
            method:"GET",
            headers: {
                Accept: "application/json, text/plain, */*",
                "Content-Type": "application/json"
            }
        });
        const results = await response;
        console.log(results.json());
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
            <h1>hrdrdh</h1>

        </div>

    )


}