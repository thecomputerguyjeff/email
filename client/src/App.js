import React from 'react';
import './App.css';
import LoginScreen from './components/loginscreen.js'
import Inbox from './components/inbox.js'
import ComposeEmail from './components/ComposeEmail.js'
import {Button} from 'reactstrap';

class App extends React.Component {


    constructor(props) {
        super(props)
        this.state = {
            userId: null,
            sendEmail: false,

        }
    }

    render() {
        return (
            <div>
                {<LoginScreen setUserId={(userId) => {
                    this.setState({userId: userId})
                }}/>}
                {this.state.userId &&
                <Button color={"primary"} onClick={() => this.setState({sendEmail: true})}>Compose Email</Button>}
                {this.state.sendEmail || this.state.userId && <Inbox userId={this.state.userId}/>}
                {this.state.sendEmail &&
                <ComposeEmail userId={this.state.userId} reset={() => this.setState({sendEmail: false})}/>}


            </div>
        );
    }
}

export default App;
