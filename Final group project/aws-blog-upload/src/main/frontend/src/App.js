import React, {useState, useEffect, useCallback} from 'react';
import './App.css';
import Navbar from './compentents/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Reports from './pages/Reports';
import Products from './pages/Products';


function App() {
  return (
    <>
    <Router>
      <Navbar/>
      <Routes>
        <Route path='/' exact element = {Home}/>
        <Route path='/reports' element= {<Reports />} />
        <Route path='/products' component = {Products}/>
      </Routes>
    </Router>
    </>
  );
}

export default App;
