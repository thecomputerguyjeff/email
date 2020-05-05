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
        <Input type="username" name="username" id="exampleName" placeholder="John Doe" />
        </FormGroup>
        <FormGroup>
        <Label for="examplePassword">Password</Label>
        <Input type="password" name="password" id="examplePassword" placeholder="password goes here" />
        </FormGroup>
        </Col>
        <Button>Submit</Button>
</Form>
            </Container></div>

);
}
}
export default LoginScreen