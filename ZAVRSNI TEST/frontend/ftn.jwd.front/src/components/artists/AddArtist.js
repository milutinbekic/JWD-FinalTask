import React, { useState } from "react";
import { Form, Button, Col} from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import { useNavigate } from "react-router-dom";

const ArtistAdd = () => {

  var artist = {
    name: '',
    genre: '',
    country: '',
    members: 0
  };

  const [newArtist, setNewArtist] = useState(artist);

  const navigate = useNavigate()

  const create = () => {
    var params = {
        name: newArtist.name,
        genre: newArtist.genre,
        country: newArtist.country,
        members: newArtist.members
    };

    CinemaAxios.post("/artists", params)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Artist je uspesno kreiran!");
        navigate("/artists");
        window.location.reload()
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Greska, nije uspelo dodavanje novog artista!");
      });
  }

  const onNameChange = (event) => {
    setNewArtist({...newArtist, name: event.target.value});
  };

  const onCountryChange = (event) => {
    setNewArtist({...newArtist, country: event.target.value});
  };

  const onMembersChange = (event) => {
    setNewArtist({...newArtist, members: event.target.value});
  };

  const onZanrChange = (event) => {
    setNewArtist({...newArtist, genre: event.target.value});
  };

  const isFormValid = newArtist.name && newArtist.country && newArtist.genre && newArtist.members > 0;


  return (
    <>
      
        <Col xs="12" sm="12" md="12" className="mb-4">
          <Form>
            <Form.Label htmlFor="name">Name</Form.Label>
            <Form.Control
              id="name"
              type="text"
              onChange={(e) => onNameChange(e)}
            />
            <Form.Label htmlFor="country">Drzava porekla</Form.Label>
            <Form.Control
              id="country"
              type="text"
              onChange={(e) => onCountryChange(e)}
            />
            <Form.Label htmlFor="genre">Zanr</Form.Label>
            <Form.Control
              id="genre"
              type="text"
              onChange={(e) => onZanrChange(e)}
            />
            <Form.Label htmlFor="members">Broj clanova</Form.Label>
            <Form.Control
              id="members"
              type="number"
              onChange={(e) => onMembersChange(e)}
            />

            <Button style={{ marginTop: "25px" }} onClick={create} disabled={!isFormValid}>
              Kreiraj
            </Button>
          </Form>
        </Col>
    </>
  );
}

export default ArtistAdd