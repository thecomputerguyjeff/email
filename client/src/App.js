import React from 'react';
import logo from './logo.svg';
import './App.css';
import LoginScreen from './component/loginscreen.js'
import Inbox from './component/inbox.js'

class App extends React.Component {

  constructor() {
    super()

    this.state = {
      // userId = null

    }
  }


  render() {
    return (
      <div>
        <LoginScreen setUserId={(userId) => {this.setState(userId)}} />
        <Inbox userId ={this.state.userId}/>
      

      </div>
    );
  }
}

export default App;
