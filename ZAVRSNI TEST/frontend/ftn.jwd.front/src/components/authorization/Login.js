import {Row, Col, Form, Button} from 'react-bootstrap'
import React, { useState} from 'react'
import {login} from '../../services/auth'
import { useNavigate } from 'react-router-dom'

function Login() {
    const [username, changeUsername] = useState("")
    const [password, changePassword] = useState("")
    const navigate = useNavigate()

    return(
        <Col>
        <Row className="justify-content-center">
            <Col md={6}>
            <Form>
                <Form.Group>
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" name="username" onChange={(e)=>changeUsername(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" name="password" onChange={(e)=>changePassword(e.target.value)}></Form.Control>
                </Form.Group>
            </Form>
            <Button onClick={()=>{login(username, password); navigate("/")}}>Log in</Button>
            </Col>
        </Row>
        <br/>
        <br/>
        <br/>
        <Row className="justify-content-center">
            <Col md={6}>
                    <u>ZA TESTIRANJE APLIKACIJE!</u><br/><br/>
                
                    <u>ADMIN</u> - username: <strong>miroslav</strong>, password: <strong>miroslav</strong><br/>
                    <u>USER</u> - username: <strong>tamara</strong>, password: <strong>tamara</strong><br/>
            </Col>
        </Row>
        </Col>
    )
}

export default Login