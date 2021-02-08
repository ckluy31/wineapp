import React from 'react';
import './App.css';
import SearchPage from "./search/SearchPage";
import WineDetails from "./wine/WineDetails";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
        <Router>
            <Switch>

                <Route path="/wine/:lotCode"><WineDetails /></Route>
                <Route path="/"><SearchPage /></Route>
            </Switch>
        </Router>
    </div>
  );
}

export default App;
