import React, { useEffect, useState } from "react";
import { Form, Button, Row, Col} from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import { useNavigate } from "react-router-dom";

const PerformanceAdd = () => {

  var performance = {
    artistName:'',
    festivalName:''
  };

  const [newPerformance, setNewPerformance] = useState(performance)
  const navigate = useNavigate()

  const create = () => {
    var params = {
        artistId: newPerformance.artistId,
        festivalId: newPerformance.festivalId
    };

    CinemaAxios.post("/performances", params)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Performance je uspesno kreiran!");
        navigate("/performances");
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Nije proslo validaciju!");
      });
  }

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


  const onArtistChange = (event) => {
    setNewPerformance({...newPerformance, artistId: event.target.value});
  };
  
  const onFestivalChange = (event) => {
    setNewPerformance({...newPerformance, festivalId: event.target.value});
  };


  return (
    <>
      <Row>
        <Col></Col>
        <Col xs="12" sm="10" md="8">
          <h1>Add new performance</h1>
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

            <Button style={{ marginTop: "25px" }} onClick={create}>
              Kreiraj
            </Button>
          </Form>
        </Col>
        <Col></Col>
      </Row>
    </>
  );
}

export default PerformanceAdd