import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";
import '../styles/Formularios.css'
import { urlCliente } from '../utils';
import { Row, Col } from "react-bootstrap";

class AgregarCliente extends Component {
  cedulaC = React.createRef();
  nombreC = React.createRef();
  direccionC = React.createRef();
  telefonoC = React.createRef();
  emailC = React.createRef();

  state = {
    clientes: [],
    status: null
  }
  ciudad = localStorage.getItem('ciudad');

  guardarCliente = (e) => {
    e.preventDefault();
    let cliente = {
      clienteDto: {
        cedula: this.cedulaC.current.value,
        nombre: this.nombreC.current.value,
        direccion: this.direccionC.current.value,
        telefono: this.telefonoC.current.value,
        correo: this.emailC.current.value,
      },
      ciudad: this.ciudad
    }
    console.log(cliente);

    axios.post(`${urlCliente}/crearCliente`, cliente)
      .then(res => {
        this.setState({
          status: "success"
        })
      })
      .catch(err => {
        alert("No ha podido crear correctamente el usuario");
      });
  }

  render() {
    if (this.state.status === "success") {
      return <Navigate to="/clientes" />
    }
    return (
      <div className="marginStyles">
        <h1 class="test">Agregar Cliente</h1>
        <form onSubmit={this.guardarCliente} className="test" >
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon0">Cedula del Cliente</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.cedulaC} placeholder="Ejemplo: 1231231230" aria-label="Ejemplo: 1231231230" aria-describedby="basic-addon0" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon1">Nombre del Cliente</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.nombreC} placeholder="Ejemplo: Carlos Gaviria" aria-label="Ejemplo: Carlos Gaviria" aria-describedby="basic-addon1" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon2">Direccion</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.direccionC} placeholder="Ejemplo: calle falsa 123 #45-67" aria-label="Ejemplo: Ejemplo: calle falsa 123 #45-67" aria-describedby="basic-addon2" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon3">Telefono</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.telefonoC} placeholder="Ejemplo: 3001234567" aria-label="Ejemplo: 3001234567" aria-describedby="basic-addon3" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon4">Email</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.emailC} placeholder="Ejemplo: ciclo4Testing@gmail.com" aria-label="Ejemplo: ciclo4Testing@gmail.com" aria-describedby="basic-addon4" />
              </Col>
            </div>
          </Row>
          <Row>
            <div class="containerButton">
              <input class="buttonStyle" type="submit" />
            </div>
          </Row>
        </form>
      </div>
    );
  }
}

export default AgregarCliente;