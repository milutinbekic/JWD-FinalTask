import React, { useEffect, useState } from 'react'
import CinemaAxios from '../../apis/CinemaAxios'
import { Row, Col, Table} from 'react-bootstrap'
import ArtistRow from './ArtistRow'
import AddArtist from './AddArtist'

const Artists = (props) => {

    const [artists, setArtists] = useState([])

    const getArtists = () => {
        let config = {
            params: {
            }
        }

        CinemaAxios.get('/artists', config)
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
    

    const renderArtists = () => {
        return artists.map((artist) => {
            return <ArtistRow key={artist.id} artist={artist}></ArtistRow>
        })
    }

    return (
        <Col>
            <Row><h1>Artists</h1></Row>

            {window.localStorage['role']=='ROLE_ADMIN'?
            <Row><AddArtist></AddArtist></Row>: null}

            <Row><Col>
            <Table style={{marginTop: 5}}>
            <thead>
                <tr className="bg-dark text-light">
                    <th>Name</th>
                    <th>Genre</th>
                    <th>Country</th>
                    <th>Members</th>
                </tr>
            </thead>
            <tbody>
                {renderArtists()}
            </tbody>
            </Table>
            </Col></Row>
        </Col>
    );

}

export default Artists