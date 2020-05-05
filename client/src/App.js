import React from 'react';
import './App.css';
import LoginScreen from './components/loginscreen.js'
import { Button } from 'reactstrap';
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
        {/*//This is react App.js*/}
        { <LoginScreen setUserId={(userId) => {this.props(userId)}} /> }
        {/* <Inbox userId ={this.state.userId}/>>  */}
      

      </div>
    );
  }
}

export default App;
