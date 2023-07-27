import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";


const NastupRow = (props) => {


    var navigate = useNavigate()

    const deleteNastup = (nastupId) => {
        CinemaAxios.delete('/nastupi/' + nastupId)
            .then(res => {
                // handle success
                console.log(res)
                alert('Deleted successfully!')
                navigate('/nastupi')
                window.location.reload()
            })
            .catch(error => {
                // handle error
                console.log(error)
                alert('Error occured please try again!')
            });
    }


    return (
        <tr>
           <td>{props.nastup.izvodjacIme}</td>
           <td>{props.nastup.festivalNaziv}</td>

           {window.localStorage['role']=='ROLE_ADMIN'?
           <td><Button variant="danger" onClick={() => deleteNastup(props.nastup.id)}>Delete</Button></td>: null}
           
        </tr>
     )
}

export default NastupRow;