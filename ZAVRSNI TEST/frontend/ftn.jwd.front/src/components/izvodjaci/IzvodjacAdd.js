import React, { useState } from "react";
import { Form, Button, Col} from "react-bootstrap";
import CinemaAxios from "./../../apis/CinemaAxios";
import { useNavigate } from "react-router-dom";

const IzvodjacAdd = () => {

  var izvodjac = {
    ime: '',
    zanr: '',
    drzavaPorekla: '',
    brojClanova: 0
  };

  const [newIzvodjac, setNewIzvodjac] = useState(izvodjac);

  const navigate = useNavigate()

  const create = () => {
    var params = {
        ime: newIzvodjac.ime,
        zanr: newIzvodjac.zanr,
        drzavaPorekla: newIzvodjac.drzavaPorekla,
        brojClanova: newIzvodjac.brojClanova
    };

    CinemaAxios.post("/izvodjaci", params)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Izvodjac je uspesno kreiran!");
        navigate("/izvodjaci");
        window.location.reload()
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Greska, nije uspelo dodavanje novog izvodjaca!");
      });
  }

  const onImeChange = (event) => {
    setNewIzvodjac({...newIzvodjac, ime: event.target.value});
  };

  const onDrzavaPoreklaChange = (event) => {
    setNewIzvodjac({...newIzvodjac, drzavaPorekla: event.target.value});
  };

  const onBrojClanovaChange = (event) => {
    setNewIzvodjac({...newIzvodjac, brojClanova: event.target.value});
  };

  const onZanrChange = (event) => {
    setNewIzvodjac({...newIzvodjac, zanr: event.target.value});
  };

  const isFormValid = newIzvodjac.ime && newIzvodjac.drzavaPorekla && newIzvodjac.zanr && newIzvodjac.brojClanova > 0;


  return (
    <>
      
        <Col xs="12" sm="12" md="12" className="mb-4">
          <Form>
            <Form.Label htmlFor="ime">Ime</Form.Label>
            <Form.Control
              id="ime"
              type="text"
              onChange={(e) => onImeChange(e)}
            />
            <Form.Label htmlFor="drzavaPorekla">Drzava porekla</Form.Label>
            <Form.Control
              id="drzavaPorekla"
              type="text"
              onChange={(e) => onDrzavaPoreklaChange(e)}
            />
            <Form.Label htmlFor="zanr">Zanr</Form.Label>
            <Form.Control
              id="zanr"
              type="text"
              onChange={(e) => onZanrChange(e)}
            />
            <Form.Label htmlFor="brojClanova">Broj clanova</Form.Label>
            <Form.Control
              id="brojClanova"
              type="number"
              onChange={(e) => onBrojClanovaChange(e)}
            />

            <Button style={{ marginTop: "25px" }} onClick={create} disabled={!isFormValid}>
              Kreiraj
            </Button>
          </Form>
        </Col>
    </>
  );
}

export default IzvodjacAdd