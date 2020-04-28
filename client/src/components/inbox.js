import React from 'react'

class Inbox extends React.Component {

    render() {
        return (
          <div>
            <div id="loader">
                <i class="fa fa-refresh fa-spin fa-5x fa-fw"></i>
                Loading&nbsp;inbox&nbsp;in&nbsp;progress.&nbsp;Please&nbsp;wait...
            </div>

            <div style="display:none;" id="inbox-loaded" class="animate-bottom">
                <h2>Tada!</h2>
                <p>Some text in my newly loaded page..</p>
            </div>

          </div>
        );
      }}

export default Inbox

//when loaded call this function
// function showPage() { 
//     document.getElementById("loader").style.display = "none";
//     document.getElementById("inbox-loaded").style.display = "block";
//   }