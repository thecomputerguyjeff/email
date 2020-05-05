import React from 'react';
import logo from './logo.svg';
import './App.css';
import LoginScreen from './components/loginscreen.js'
import Inbox from './components/inbox.js'
// import { Button } from 'reactstrap';
class App extends React.Component {


  constructor() {
    super()

    this.state = {
      userId : null,

    }
  }


  render() {
    return (
      <div>
        //This is react App.js
        
        { <LoginScreen setUserId={(userId) => {this.props(userId)}} /> }
        <Inbox userId ={this.state.userId}/>
      

      </div>
    );
  }
}

export default App;
