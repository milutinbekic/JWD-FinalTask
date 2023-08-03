import { useEffect } from "react";
import { useState } from "react";
import CinemaAxios from "../../apis/CinemaAxios";

const ArtistRow = (props) => {

   const [performances, setPerformances] = useState([])
   const [numberOfPerformances, setNumberOfPerformances] = useState(0)

   const getPerformances = () => {

      CinemaAxios.get('/performances')
          .then(res => {
              // handle success
              console.log(res)
              setPerformances(res.data)
          })
          .catch(error => {
              // handle error
              console.log(error)
              alert('Error occured please try again!')
          });
  }

  useEffect(()=>{
      getPerformances()
  }, [])

  useEffect(()=>{
   let counter = 0;
  
   for (const nastup of performances) {
     if (nastup.artistName === props.artist.name) {
       counter++;
     }
   }

   setNumberOfPerformances(counter)

  },[performances, props.artist.name])


   const showNumberOfPerformances = () => {
      console.log(performances)
      console.log(props.artistName)
      alert(`Artist ima ${numberOfPerformances} nastupa`);
    };

    return (
        <tr onClick={showNumberOfPerformances}>
           <td>{props.artist.name}</td>
           <td>{props.artist.genre}</td>
           <td>{props.artist.country}</td>
           <td>{props.artist.members}</td>
        </tr>
     )
}

export default ArtistRow;