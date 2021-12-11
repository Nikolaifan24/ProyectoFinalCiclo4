import React from "react";
import { Component } from "react";
import { BrowserRouter, Routes, Route, NavLink } from "react-router-dom";
import AgregarProducto from "./productosC/AgregarProducto";
import navigationStyle from './styles/NavigationBar.module.css'

import Clientes from "./clientesC/Clientes";
import EditarProducto from "./productosC/EditarProducto";
import Productos from "./productosC/Productos";
import Ventas from "./ventasC/Ventas";
import Reportes from "./reportesC/Reportes";
import Consolidacion from "./componentes/Consolidacion";
import EditarCliente from "./clientesC/EditarCliente";
import AgregarCliente from "./clientesC/AgregarCliente";
import Login from "./Login/Login";
import Home from "./Home/Home";
import LoadFile from "./LoadFile/LoadFile";


class Router extends Component {

  state = {
    showNavBar: true,
  }
  auth = false;

  comeBackEvent = () => {
    localStorage.setItem('auth', false)
    this.state.showNavBar = false
    console.log("logout", this.state.showNavBar)
  }
  LoginAuth = () => {
    localStorage.setItem('auth', true)
    console.log("login")
    this.state.showNavBar = true
  }
  
  render() {
    this.auth = localStorage.getItem("auth");
    console.log("1", window.location)
    return (
      <BrowserRouter>
        {window.location.pathname != '/'
          &&
          <header className={navigationStyle.style}>
            <nav className={navigationStyle.content}>
              <NavLink className={navigationStyle.textColor} to='/clientes' activeClassName="active"> Clientes </NavLink>
              <NavLink className={navigationStyle.textColor} to='/loadFile' activeClassName="active">Load files</NavLink>
              <NavLink className={navigationStyle.textColor} to="/productos" activeClassName="active">Productos</NavLink>
              <NavLink className={navigationStyle.textColor} to="/ventas" activeClassName="active">Ventas</NavLink>
              <NavLink className={navigationStyle.textColor} to="/reportes" activeClassName="active">Reportes</NavLink>
              <NavLink className={navigationStyle.textColor} to="/consolidacion" activeClassName="active">Consolidacion</NavLink>
              <NavLink className={navigationStyle.textColor} to='/' activeClassName="active" onClick={this.comeBackEvent}> Logout </NavLink>
            </nav>
          </header>
        }
        <Routes>
          <Route path="/" exact element={<Login />} />
          <Route path="/home" exact element={<Home />} />
          <Route path="/loadFile" exact element={<LoadFile />} />
          <Route path="/clientes" element={<Clientes />} />
          <Route path="/productos" element={<Productos />} />
          <Route path="/ventas" element={<Ventas />} />
          <Route path="/reportes" element={<Reportes />} />
          <Route path="/consolidacion" element={<Consolidacion />} />
          <Route path="/agregarProducto" element={<AgregarProducto />} />
          <Route path="/editarProducto/:id" element={<EditarProducto />} />
          <Route path="/agregarCliente" element={<AgregarCliente />} />
          <Route path="/editarCliente/:id" element={<EditarCliente />} />
        </Routes>
      </BrowserRouter>
    );
  }
}

export default Router;
