import logo from './logo.svg';
import './App.css';
import React from 'react';
import {Route,Switch,Link, Redirect} from 'react-router-dom';
import Home from './component/Home';
function App() {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/" component={Home}></Route>
      </Switch>
    </div>
  );
}

export default App;
