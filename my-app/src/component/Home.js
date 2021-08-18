import React,{useEffect} from 'react';
import {Link, Redirect, withRouter} from 'react-router-dom';
import axios from 'axios';
import { Button, Container, Row, Col, Alert, Table, Navbar, Nav, NavDropdown, Carousel } from 'react-bootstrap';

class Home extends React.Component{

    state={
        ergebnisseData:[]

    }
    componentDidMount(){
        axios.get("http://localhost:9090/test/api/ergebnisse/").then(res=>{
            const ergebnisseData = res.data;
            this.setState({ergebnisseData})
        })
    }

    render()
    {
        return(<div>

        <Container fluid>
        <Row className="justify-content-center mt-4">  
        <Col md="auto" xs="auto" sm="auto" lg="auto" xl="auto" xxl="auto"><h2 class="mt-5">List of Patients:</h2></Col>
        </Row>
        </Container>
        <div class="table-responsive-sm text-nowrap ">
        <Container>
        <Row className="justify-content-center mt-5">
          <Col md="auto" xs="auto" sm="auto" lg="auto" xl="auto" xxl="auto">
        <Table striped bordered hover variant="dark">
         
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
                    {this.state.ergebnisseData.map(record=><RowCreater item={record} recordId={record.id} key={record.id}/>)}
                </tbody>
                
                </Table>
                </Col>
                </Row>
                    </Container >
                    
                    </div>
           
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