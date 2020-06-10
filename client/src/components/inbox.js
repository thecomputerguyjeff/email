import React from 'react'

class Inbox extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      userId : this.props.userId,
      emails:[],
      isLoading:true,
    }
    this.loadInbox=this.loadInbox.bind(this)
    this.renderInbox=this.renderInbox.bind(this)
  }
  componentDidMount(){
    this.loadInbox()
  }

  renderInbox() {
    return this.state.emails.map(e => 
      <tr><td>{e.sentFromEmailAddress}</td><td>{e.subject}</td></tr>
    );
  }

    render() {
        return (
          <div>
            {this.state.isLoading ?
                <div id="loader">
                    <i className="fa fa-refresh fa-spin fa-5x fa-fw"></i>
                    Loading&nbsp;inbox&nbsp;in&nbsp;progress.&nbsp;Please&nbsp;wait...
                </div>
            :<div>
              <table>
                <tr>
                  <th>From</th>
                  <th>Subject</th>
                </tr>
                {this.renderInbox()}
              </table>
              </div>}
          </div>
        );
    };
  
    loadInbox(){
      fetch("api/getInbox/"+this.state.userId)
      .then(res => 
        res.json(),
        (err)=>{
          console.log("Couldn't access the database.")
          console.log(err)
        })
        .then((json)=>{
            this.setState({emails:json,isLoading:false})
        }, (error)=>{
            console.log("There was an error mapping to json")
            console.log(err)
            this.setState({isLoading:false})
            alert("There was an error." +error)
        })
    }

}export default Inbox
