import React, {Component} from 'react';
import iconImg from './ICON.png'
import './search.css'
import SearchBar from "./SearchBar";

export default function SearchPage() {
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
                <SearchBar/>
            </div>

        </div>

    )

}