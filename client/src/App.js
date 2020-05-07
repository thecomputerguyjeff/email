import React from 'react';
import './App.css';
// import LoginScreen from './components/loginscreen.js'
import Inbox from './components/inbox.js'
// import { Button } from 'reactstrap';
class App extends React.Component {


  constructor(props) {
    super(props)
    this.state = {
      userId : "5e795552096fba1f7837dd01",
    }
  }

  render() {
    return (
      <div>        
        {/* { <LoginScreen setUserId={(userId) => {this.props(userId)}} /> } */}
        {this.state.userId&&<Inbox userId ={this.state.userId}/>}
      

      </div>
    );
  }
}

export default App;
