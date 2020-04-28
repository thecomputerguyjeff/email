import React from 'react';
import './App.css';
import LoginScreen from './components/loginscreen.js'

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
        {/* <LoginScreen setUserId={(userId) => {this.setState(userId)}} /> */}
        {/* <Inbox userId ={this.state.userId}/>>  */}
      

      </div>
    );
  }
}

export default App;
