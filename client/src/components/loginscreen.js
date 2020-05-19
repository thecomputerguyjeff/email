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
        debugger;
        let data = {
            'username': this.state.username,
            'password': this.state.password
        }
        fetch('https://ti-email.herokuapp.com/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then((response) =>{
                if(response.status===200){
                    this.setState({renderModal:true})
                }
            })
            .catch((error)=> {
                console.log("error=",error);
            });

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
        </Col>
        <button onClick={ this.submit }>Submit</button>
        <script>

        </script>
</Form>
            {/*</Container>*/}
            </div>

);}
    submitForm(e) {
        e.preventDefault();
        console.log(`Email: ${ this.state.email }`)
    }

        function submitFunction() {
            //loginService.login(credentials);
            document.getElementById("userId");
        }

}
export default LoginScreen
