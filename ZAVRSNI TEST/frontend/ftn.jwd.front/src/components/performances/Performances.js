import React, { useEffect, useState } from 'react';
import CinemaAxios from '../../apis/CinemaAxios';
import {Row, Col, Button, Table, Form} from 'react-bootstrap'
import { useNavigate } from 'react-router-dom';
import PerformanceRow from './PerformanceRow';

const Performances = (props) => {

    const [performances, setPerformances] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPages, setTotalPages] = useState(0)
    const [festId, setFestId] = useState("")
    const [artistId, setArtistId] = useState("")
    const jwt = window.localStorage['jwt'];
    const navigate = useNavigate()


    const getPerformances = (nextPage) => {
        let config = {
            params: {
                artistId: artistId,
                festivalId:  festId,
                pageNo: nextPage
            }
        }

        CinemaAxios.get('/performances', config)
            .then(res => {
                // handle success
                console.log(res)
                setPageNo(nextPage)
                setTotalPages(res.headers["total-pages"])
                setPerformances(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }

    useEffect(()=>{
        getPerformances(0)
    }, [artistId, festId])


    // UCITAVANJE POSTOJECIH OBJEKATA DA BI IH STAVILI U PADAJUCU LISTU
    const [artists, setArtists] = useState([])
    const getArtists = () => {
      
        CinemaAxios.get('/artists')
            .then(res => {
                // handle success
                console.log(res)
                setArtists(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }
    useEffect(()=>{
        getArtists()
    }, [])

    // UCITAVANJE POSTOJECIH OBJEKATA DA BI IH STAVILI U PADAJUCU LISTU
    const [festivals, setFestivals] = useState([])
    const getFestivals = () => {
      
        CinemaAxios.get('/festivals')
            .then(res => {
                // handle success
                console.log(res)
                setFestivals(res.data)
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }
    useEffect(()=>{
        getFestivals()
    }, [])
    

    const goToAdd = (performance) => {
        navigate('/performances/add');
    }

    const renderPerformances = () => {
        return performances.map((performance) => {
            return <PerformanceRow key={performance.id} performance={performance}></PerformanceRow>
        })
    }

    const onArtistChange = (event) => {
        setArtistId(event.target.value);
      };
    
      const onFestivalChange = (event) => {
        setFestId(event.target.value);
      };

    return (
        <Col>
            <Row><h1>Performances</h1></Row>

            {jwt?
            <Button variant="warning" onClick={() => goToAdd()}>Kreiraj novi performance</Button>
            :null}

            <Row xs="12" sm="10" md="8">
                
                <h3 style={{ marginTop: "25px" }}>Pretraga</h3>
                <Form>
                    {/* IZBOR POSTOJECIH OBJEKATA KROZ PADAJUCU LISTU */}
                    <Row>
                    <Col>
                        <Form.Label htmlFor="artist">Artist</Form.Label>
                        <Form.Select id="artist" onChange={(e) => onArtistChange(e)}>
                        <option value="">Odaberi artista</option>
                            {artists.map((artist) => (
                            <option key={artist.id} value={artist.id}>
                                {artist.name}
                            </option>
                            ))}
                        </Form.Select>
                    </Col>
                    <Col>
                        <Form.Label htmlFor="festival">Festival</Form.Label>
                        <Form.Select id="festival" onChange={(e) => onFestivalChange(e)}>
                        <option value="">Odaberi festival</option>
                            {festivals.map((festival) => (
                            <option key={festival.id} value={festival.id}>
                                {festival.name}
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
                    <th>Artist</th>
                    <th>Festival</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {renderPerformances()}
            </tbody>
            </Table>
            <Button disabled={pageNo===0} onClick={()=>getPerformances(pageNo-1)}>Prethodna</Button>
            <Button disabled={pageNo==totalPages-1} onClick={()=>getPerformances(pageNo+1)}>Sledeca</Button>
            </Col></Row>
        </Col>
    );

}

export default Performances