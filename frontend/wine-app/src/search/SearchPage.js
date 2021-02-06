import React, {Component} from 'react';
import iconImg from './ICON.png'
import './search.css'

export default function SearchPage() {
    return(
        <div className={"SearchPage"}>
            <div className={"Search"}>
                <div className={"SearchFrame"}>
                    <header className={"SearchHeader"}>
                        Wine Search
                    </header>
                    <img src={iconImg} className={"Icon"}/>
                </div>
            </div>
        </div>

    )

}