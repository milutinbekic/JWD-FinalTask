import React, { useEffect, useState } from 'react'
import CinemaAxios from '../../apis/CinemaAxios'
import { Row, Col, Table} from 'react-bootstrap'
import IzvodjacRow from './IzvodjacRow'
import IzvodjacAdd from './IzvodjacAdd'

const Izvodjaci = (props) => {

    const [izvodjaci, setIzvodjaci] = useState([])

    const getIzvodjaci = () => {
        let config = {
            params: {
            }
        }

        CinemaAxios.get('/izvodjaci', config)
            .then(res => {
                // handle success
                console.log(res)
                setIzvodjaci(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }


    useEffect(()=>{
        getIzvodjaci()
    }, [])
    

    const renderIzvodjaci = () => {
        return izvodjaci.map((izvodjac) => {
            return <IzvodjacRow key={izvodjac.id} izvodjac={izvodjac}></IzvodjacRow>
        })
    }

    return (
        <Col>
            <Row><h1>Izvodjaci</h1></Row>

            {window.localStorage['role']=='ROLE_ADMIN'?
            <Row><IzvodjacAdd></IzvodjacAdd></Row>: null}

            <Row><Col>
            <Table style={{marginTop: 5}}>
            <thead>
                <tr className="bg-dark text-light">
                    <th>Naziv</th>
                    <th>Zanr</th>
                    <th>Drzava Porekla</th>
                    <th>Broj Clanova</th>
                </tr>
            </thead>
            <tbody>
                {renderIzvodjaci()}
            </tbody>
            </Table>
            </Col></Row>
        </Col>
    );

}

export default Izvodjaci