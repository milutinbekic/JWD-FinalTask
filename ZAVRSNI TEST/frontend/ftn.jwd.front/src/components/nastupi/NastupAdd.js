import React, { useEffect, useState } from "react";
import { Form, Button, Row, Col} from "react-bootstrap";
import CinemaAxios from "./../../apis/CinemaAxios";
import { useNavigate } from "react-router-dom";

const NastupAdd = () => {

  var nastup = {
    izvodjacIme:'',
    festivalNaziv:''
  };

  const [newNastup, setNewNastup] = useState(nastup)
  const navigate = useNavigate()

  const create = () => {
    var params = {
        izvodjacId: newNastup.izvodjacId,
        festivalId: newNastup.festivalId
    };

    CinemaAxios.post("/nastupi", params)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Nastup je uspesno kreiran!");
        navigate("/nastupi");
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Nije proslo validaciju!");
      });
  }

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


  const onIzvodjacChange = (event) => {
    setNewNastup({...newNastup, izvodjacId: event.target.value});
  };
  
  const onFestivalChange = (event) => {
    setNewNastup({...newNastup, festivalId: event.target.value});
  };


  return (
    <>
      <Row>
        <Col></Col>
        <Col xs="12" sm="10" md="8">
          <h1>Add new nastup</h1>
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

export default NastupAdd