import React,{useEffect} from 'react';
import {Link, Redirect, withRouter} from 'react-router-dom';
import axios from 'axios';
import { Button, Container, Row, Col, Alert, Table, Navbar, Nav, NavDropdown, Carousel } from 'react-bootstrap';
import '../css/Home.css'
import {toast} from 'react-toastify';

class Home extends React.Component{

    state={
        ergebnisseData:{

        content:[]

        },
        click:0,
        Ready:false
    }

    previus(event){
        if(this.state.click===0){
            toast("Minumun/Maximum data",{autoClose:4000,position:toast.POSITION.BOTTOM_CENTER});
        }else{
        this.setState(
            {click:this.state.click-1},
            this.callApi // here is where you put the callback without()
            )
        }
       
    }

    handleSubmit(event){
        
        this.setState(
            {click:this.state.click+1},
            this.callApi
            )
       
    }

    callApi(){
        const data={
            from:this.state.click,
            to:20
        }

        console.log(data);
        
        axios.post("http://localhost:9090/test/api/ergebnisse/",data).then(res=>{
            this.setState({ergebnisseData:res.data})
        }).catch(error => {
            if(error.response.status===400){
             toast("The request was invalid.",{autoClose:4000,position:toast.POSITION.BOTTOM_CENTER});
            } else if(error.response.status === 500){
             toast("Minumun/Maximum data",{autoClose:4000,position:toast.POSITION.BOTTOM_CENTER});
             this.setState(
                {click:this.state.click-1},
                this.callApi // here is where you put the callback without()
                )
            }

        })

    }
    componentDidMount(){
        const data={
            from:0,
            to:20,
        }
        axios.post("http://localhost:9090/test/api/ergebnisse/",data).then(res=>{
            this.setState({ergebnisseData:res.data})
        })

    }

    render()
    {
        return(<div>

        <Container fluid>
        <Row className="justify-content-center mt-4">  
        <Col md="auto" xs="auto" sm="auto" lg="auto" xl="auto" xxl="auto"><h2 class="mt-5">Data:</h2></Col>
        </Row>
        </Container>
        <Container>
        <Row className="justify-content-center">
          <Col md="auto" xs="auto" sm="auto" lg="auto" xl="auto" xxl="auto">
        <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <Table striped bordered table striped hover mb-0 variant="dark">
         
          <thead>
                <tr>
                <th>Messwert</th>
                <th>Einheit</th>
                <th>Material</th>
                <th>Date</th>
                <th>Status</th>
                <th>Parametar</th>
                </tr>
                </thead> 
                <tbody>
                    {this.state.ergebnisseData.content.map(record=><RowCreater item={record} recordId={record.id} key={record.id}/>)}
                </tbody>
                
                </Table>
                </div>
                </Col>
                </Row>
                    </Container >

                 <button id="customButton" type="submit" class="btn btn-dark" onClick={this.previus.bind(this)}>Previus</button>
                 <button id="customButton1" type="submit" class="btn btn-dark" onClick={this.handleSubmit.bind(this)}>Next</button>
        </div>)
    }

}

class RowCreater extends React.Component{

    render(){

        var data = this.props.item
        

        return(
            <tr>
                <td>{data.messwert}</td>
                <td>{data.einheit}</td>
                <td>{data.material}</td>
                <td>{data.laboreingangsdatum}</td>
                <td>{data.status}</td>
                <td>{data.parameter}</td>
            </tr>
        )
    }
        
}

export default Home;