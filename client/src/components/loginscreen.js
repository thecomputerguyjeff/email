import React from 'react';
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button,
} from 'reactstrap';
import '../App.css';
class LoginScreen extends React.Component {
    constructor() {
        super();
        this.state = {
            username: "",
            password: ""
        };

        this.submit = this.submit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange({ target }) {
        this.setState({
            [target.name]: target.value
        });
    }
    submit() {
        let data = {
            'username': this.state.username,
            'password': this.state.password
        }
        fetch('api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then((response) =>{
                if(response.status!==200) {
                    
                // .catch((error) => {
                        console.log("error= "+ error);
                    // })
                }
                return response.json();

               })
                   // https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
                    // .then(response => response.json())
                    //this.props, not props
                         .then(response=>this.props.setUserId(response.userID))
                         .catch((error)=>{console.log("error= " + error)});

    }

    render() {
        return(
            <div className ="box flex">
            {/*<Container className="box flex">*/}
    <Form>
        <Col>
        <FormGroup >
        <h2>Sign In</h2>
        <Label for="exampleEmail">User Name</Label>
        <Input type="username"
               name="username"
               id="exampleName"
               value={ this.state.username }
               onChange={ this.handleChange }
               placeholder="John Doe" />
        </FormGroup>
        <FormGroup>
        <Label for="examplePassword">Password</Label>
        <Input type="password"
               name="password"
               id="examplePassword"
               value={ this.state.password }
               onChange={ this.handleChange }
               placeholder="Password goes here" />
        </FormGroup>
        </Col></Form>
        <button onClick={ this.submit }>Submit</button>


            {/*</Container>*/}
            </div>

);}
    submitForm(e) {
        e.preventDefault();
        console.log(`Email: ${ this.state.email }`)
    }


}
export default LoginScreen
