import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";


const PerformanceRow = (props) => {


    var navigate = useNavigate()

    const deletePerformance = (performanceId) => {
        CinemaAxios.delete('/performances/' + performanceId)
            .then(res => {
                // handle success
                console.log(res)
                alert('Deleted successfully!')
                navigate('/performances')
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
           <td>{props.performance.artistName}</td>
           <td>{props.performance.festivalName}</td>

           {window.localStorage['role']=='ROLE_ADMIN'?
           <td><Button variant="danger" onClick={() => deletePerformance(props.performance.id)}>Delete</Button></td>: null}
           
        </tr>
     )
}

export default PerformanceRow;