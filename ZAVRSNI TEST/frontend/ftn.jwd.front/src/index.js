// import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, HashRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Navbar, Nav, Button, Container} from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login'

import NotFound from './components/NotFound';
import {logout} from './services/auth';
import Izvodjaci from './components/izvodjaci/Izvodjaci';
import Nastupi from './components/nastupi/Nastupi';
import NastupAdd from './components/nastupi/NastupAdd';

const App = () => {

    const jwt = window.localStorage['jwt'];

    if(jwt){
        return (
        <>
            <Router>
                <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand as={Link} to="/">
                        JWD
                    </Navbar.Brand>
                    <Nav>
                        <Nav.Link as={Link} to="/izvodjaci">
                            Izvodjaci
                        </Nav.Link>
                        <Nav.Link as={Link} to="/nastupi">
                            Nastupi
                        </Nav.Link>
                        <Button onClick={()=>logout()}>Logout</Button>:
                    </Nav>
                </Navbar>
                
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/izvodjaci" element={<Izvodjaci/>} />
                    <Route path="/nastupi" element={<Nastupi/>} />
                    <Route path="/nastupi/add" element={<NastupAdd/>} />
                    <Route path="*" element={<NotFound/>} />
                </Routes>
                </Container>
            </Router>
        </>
    );
    }else{
        return( 
        <>
            <Router>
                <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand as={Link} to="/">
                        JWD
                    </Navbar.Brand>
                    <Nav>
                    <Nav.Link as={Link} to="/nastupi">
                            Nastupi
                        </Nav.Link>
                        <Nav.Link as={Link} to="/login">
                            Login
                        </Nav.Link>
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/nastupi" element={<Nastupi/>} />
                    <Route path="*" element={<Navigate replace to = "/login"/>}/>
                </Routes>
                </Container>
            </Router>
        </>);
    }
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App/>,
)