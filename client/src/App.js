import React from 'react';
import './App.css';
import LoginScreen from './components/loginscreen.js'
import { Button } from 'reactstrap';
import Inbox from './components/inbox.js'
class App extends React.Component {


  constructor(props) {
    super(props)
    this.state = {
      userId : null,

    }
  }


  render() {
    return (
      <div>
        {<LoginScreen setUserId={(userId) => {this.setState({userId: userId})}}/> }
        {this.state.userId&&<Inbox userId ={this.state.userId}/>}


      </div>
    );
  }
}

export default App;
