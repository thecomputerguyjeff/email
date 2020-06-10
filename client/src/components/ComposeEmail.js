import React from 'react';
import { Button,Input,Label,ModalHeader,ModalFooter,ModalBody,Modal} from 'reactstrap';
class ComposeEmail extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            sendTo:null,
            sendFrom:null,
            subject:null,
            email:null
        }
        this.handleInputChange=this.handleInputChange.bind(this);
        this.sendTheEmail=this.sendTheEmail.bind(this);
    }
    handleInputChange (event)  {
        this.setState({ [event.target.name]: event.target.value})
    }
    componentDidMount() {
        fetch('api/getUsersEmail/'+this.props.userId)
            .then(response => response.json())
            .then(data => this.setState({sendFrom:data.email}));
    }

    render() {
        return (
            <div>

                <Modal isOpen={true}>
                    <ModalHeader>Compose Email</ModalHeader>
                    <ModalBody>
                        <Label for="exampleSendTo">To:</Label>
                        <Input type="text" name="sendTo" id="exampleSendTo" onChange={this.handleInputChange} required/><br />
                        <Label for="exampleSubject">Subject:</Label>
                        <Input type="text" name="subject" id="exampleSubject" onChange={this.handleInputChange} required/><br />
                        <Label for="exampleEmail">Email Text:</Label>
                        <Input type="text" name="email" id="exampleEmail" onChange={this.handleInputChange} required/><br />
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={this.sendTheEmail}>Send</Button>{' '}
                        <Button color="secondary" onClick={this.props.reset}>Cancel</Button>
                    </ModalFooter>
                </Modal>
            </div>
        )
    }

    sendTheEmail(){
        let data={
            sendToEmailAddress:[this.state.sendTo],
            sentFromEmailAddress:this.state.sendFrom,
            subject:this.state.subject,
            emailText:this.state.email,
        }
        fetch('api/sendEmail', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => {if(response.status===200)response.json()})
            .then(data => {
                console.log('Success:');
                return this.props.reset()
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
}
export default ComposeEmail;
