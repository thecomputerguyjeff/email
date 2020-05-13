import React from 'react';
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button,
} from 'reactstrap';
import '../App.css';

class LoginScreen extends React.Component {
    render() {
        return(
            <div class ="box flex">
            <Container className="box flex">
    <Form>
        <Col>
        <FormGroup >
        <h2>Sign In</h2>
        <Label for="exampleEmail">User Name</Label>
        <Input type="username" onChange={submitEmail()} name="username" id="exampleName" placeholder="John Doe" />
        </FormGroup>
        <FormGroup>
        <Label for="examplePassword">Password</Label>
        <Input type="password" onChange={submitForm()} name="password" id="examplePassword" placeholder="Password goes here" />
        </FormGroup>
        </Col>
        <button onClick="submitFunction()">Submit</button>
        <script>

        </script>
</Form>
            </Container></div>

);}
    submitForm(e) {
        e.preventDefault();
        console.log(`Email: ${ this.state.email }`)
    }

        function submitFunction() {
            //loginService.login(credentials);
            document.getElementById("userId").//? ;
        }

}
export default LoginScreen