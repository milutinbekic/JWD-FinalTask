import React, { useEffect, useState } from 'react';
import CinemaAxios from '../../apis/CinemaAxios';
import {Row, Col, Button, Table, Form} from 'react-bootstrap'
import { useNavigate } from 'react-router-dom';
import NastupRow from './NastupRow';

const Nastupi = (props) => {

    const [nastupi, setNastupi] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPages, setTotalPages] = useState(0)
    const [festId, setFestId] = useState("")
    const [izvId, setIzvId] = useState("")
    const jwt = window.localStorage['jwt'];
    const navigate = useNavigate()


    const getNastupi = (nextPage) => {
        let config = {
            params: {
                izvodjacId: izvId,
                festivalId:  festId,
                pageNo: nextPage
            }
        }

        CinemaAxios.get('/nastupi', config)
            .then(res => {
                // handle success
                console.log(res)
                setPageNo(nextPage)
                setTotalPages(res.headers["total-pages"])
                setNastupi(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }

    useEffect(()=>{
        getNastupi(0)
    }, [izvId, festId])


    // UCITAVANJE POSTOJECIH OBJEKATA DA BI IH STAVILI U PADAJUCU LISTU
    const [izvodjaci, setIzvodjaci] = useState([])
    const getIzvodjaci = () => {
      
        CinemaAxios.get('/izvodjaci')
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

    // UCITAVANJE POSTOJECIH OBJEKATA DA BI IH STAVILI U PADAJUCU LISTU
    const [festivali, setFestivali] = useState([])
    const getFestivali = () => {
      
        CinemaAxios.get('/festivali')
            .then(res => {
                // handle success
                console.log(res)
                setFestivali(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }
    useEffect(()=>{
        getFestivali()
    }, [])
    

    const goToAdd = (nastup) => {
        navigate('/nastupi/add');
    }

    const renderNastupi = () => {
        return nastupi.map((nastup) => {
            return <NastupRow key={nastup.id} nastup={nastup}></NastupRow>
        })
    }

    const onIzvodjacChange = (event) => {
        setIzvId(event.target.value);
      };
    
      const onFestivalChange = (event) => {
        setFestId(event.target.value);
      };

    return (
        <Col>
            <Row><h1>Nastupi</h1></Row>

            {jwt?
            <Button variant="warning" onClick={() => goToAdd()}>Kreiraj novi nastup</Button>
            :null}

            <Row xs="12" sm="10" md="8">
                
                <h3 style={{ marginTop: "25px" }}>Pretraga</h3>
                <Form>
                    {/* IZBOR POSTOJECIH OBJEKATA KROZ PADAJUCU LISTU */}
                    <Row>
                    <Col>
                        <Form.Label htmlFor="izvodjac">Izvodjac</Form.Label>
                        <Form.Select id="izvodjac" onChange={(e) => onIzvodjacChange(e)}>
                        <option value="">Odaberi izvodjaca</option>
                            {izvodjaci.map((izvodjac) => (
                            <option key={izvodjac.id} value={izvodjac.id}>
                                {izvodjac.ime}
                            </option>
                            ))}
                        </Form.Select>
                    </Col>
                    <Col>
                        <Form.Label htmlFor="festival">Festival</Form.Label>
                        <Form.Select id="festival" onChange={(e) => onFestivalChange(e)}>
                        <option value="">Odaberi festival</option>
                            {festivali.map((festival) => (
                            <option key={festival.id} value={festival.id}>
                                {festival.naziv}
                            </option>
                            ))}
                        </Form.Select>
                    </Col>
                    </Row>
                </Form>
            </Row>

            <Row><Col>
            <Table style={{marginTop: 20}}>
            <thead>
                <tr className="bg-dark text-light">
                    <th>Izvodjac</th>
                    <th>Festival</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {renderNastupi()}
            </tbody>
            </Table>
            <Button disabled={pageNo===0} onClick={()=>getNastupi(pageNo-1)}>Prethodna</Button>
            <Button disabled={pageNo==totalPages-1} onClick={()=>getNastupi(pageNo+1)}>Sledeca</Button>
            </Col></Row>
        </Col>
    );

}

export default Nastupi