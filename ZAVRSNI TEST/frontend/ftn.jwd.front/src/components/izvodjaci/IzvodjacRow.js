import { useEffect } from "react";
import { useState } from "react";
import CinemaAxios from "../../apis/CinemaAxios";

const IzvodjacRow = (props) => {

   const [nastupi, setNastupi] = useState([])
   const [brojNastupa, setBrojNastupa] = useState(0)

   const getNastupi = () => {

      CinemaAxios.get('/nastupi')
          .then(res => {
              // handle success
              console.log(res)
              setNastupi(res.data)
          })
          .catch(error => {
              // handle error
              console.log(error)
              alert('Error occured please try again!')
          });
  }

  useEffect(()=>{
      getNastupi()
  }, [])

  useEffect(()=>{
   let counter = 0;
  
   for (const nastup of nastupi) {
     if (nastup.izvodjacIme === props.izvodjac.ime) {
       counter++;
     }
   }

   setBrojNastupa(counter)

  },[nastupi, props.izvodjac.ime])


   const prikaziBrojNastupa = () => {
      console.log(nastupi)
      console.log(props.izvodjacIme)
      alert(`Izvodjac ima ${brojNastupa} nastupa`);
    };

    return (
        <tr onClick={prikaziBrojNastupa}>
           <td>{props.izvodjac.ime}</td>
           <td>{props.izvodjac.zanr}</td>
           <td>{props.izvodjac.drzavaPorekla}</td>
           <td>{props.izvodjac.brojClanova}</td>
        </tr>
     )
}

export default IzvodjacRow;