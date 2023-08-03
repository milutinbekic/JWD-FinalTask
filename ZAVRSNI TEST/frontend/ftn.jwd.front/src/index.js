// import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, HashRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Navbar, Nav, Button, Container} from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login'

import NotFound from './components/NotFound';
import {logout} from './services/auth';
import Artists from './components/artists/Artists';
import Performances from './components/performances/Performances';
import AddPerformance from './components/performances/AddPerformance';

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
                        <Nav.Link as={Link} to="/artists">
                            Artists
                        </Nav.Link>
                        <Nav.Link as={Link} to="/performances">
                            Performances
                        </Nav.Link>
                        <Button onClick={()=>logout()}>Logout</Button>:
                    </Nav>
                </Navbar>
                
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/artists" element={<Artists/>} />
                    <Route path="/performances" element={<Performances/>} />
                    <Route path="/performances/add" element={<AddPerformance/>} />
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
                    <Nav.Link as={Link} to="/performances">
                            Performances
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
                    <Route path="/performances" element={<Performances/>} />
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