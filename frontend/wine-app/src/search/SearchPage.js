import React, {useState} from 'react';
import iconImg from './ICON.png'
import './search.css'
import closeIcon from "./Close.png";
import {SearchResult} from "./SearchResult";
import { useHistory } from "react-router-dom";

export default function SearchPage(){
    const [searchQuery, setSearchQuery] = useState(''); // keep track of the search query
    const [searchResults, setSearchResults] = useState([]); // regularly update results based on search query
    const history = useHistory();

    function handleClick(wine) {
        history.push(`/wine/${wine.lotCode}`);
    }

    async function handleSearch({target}){
        const searchQuery = target.value;
        setSearchQuery(searchQuery);

        // call to backend api to search
        const response = await fetch(`http://localhost:8080/api/wine/search/${searchQuery}`, {
            method:"GET",
            mode: "cors",
            headers: {
                Accept: "application/json, text/plain, */*",
                "Content-Type": "application/json"
            }
        });
        const results = await response.json();
        // update search results
        setSearchResults(results);
    }


    return(
        <div className={"SearchPage"}>
            <div className={"Search"}>
                <div className={"SearchFrame"}>
                    <header className={"SearchHeader"}>
                        Wine Search
                    </header>
                    <div className={"IconContainer"}>
                        <img src={iconImg} className={"IconContainer"} alt={"icon"}/>
                    </div>
                </div>
                <div className={"SearchRows"}>
                    <div className={"SearchInputBox"}>
                        <div className={"SearchActionsLeft"}>
                            <div className={"LabelLeft"}>
                                <input className={"SearchQuery"} onChange={handleSearch} />
                            </div>
                            <div className={"SearchIconBox"}>
                                <img src={closeIcon} className="CloseIcon" alt={"icon"}/>
                            </div>

                        </div>

                        <div className={"SearchActionsRight"}>
                        </div>

                    </div>
                    <div className={"ListResults"}>
                        {searchResults.map((wine) => <SearchResult key={wine.lotCode} searchResult={wine} onSelect={handleClick}/>)}
                    </div>
                </div>
            </div>


        </div>

    )


}