import React from 'react';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class LoginScreen extends React.Component {
    render() {
        return(
    <Form>
    <FormGroup>
        <Label for="exampleEmail">User Name</Label>
        <Input type="username" name="username" id="exampleName" placeholder="John Doe" />
        </FormGroup>
        <FormGroup>
        <Label for="examplePassword">Password</Label>
        <Input type="password" name="password" id="examplePassword" placeholder="password goes here" />
        </FormGroup>
        <Button>Submit</Button>
</Form>
);
}
}
export default LoginScreen