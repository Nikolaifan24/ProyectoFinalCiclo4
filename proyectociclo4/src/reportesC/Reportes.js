import React from "react";
import { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import swal from "sweetalert";
import 'bootstrap/dist/css/bootstrap.min.css';
import { urlVenta, urlProducto, urlCliente } from '../utils'
import { Row, Col } from "react-bootstrap";
import '../styles/Formularios.css'

class Reportes extends Component {
  state = {
    clientes: [],
    ciudad: '',
    status: null
  }

  componentWillMount() {
    // this.getClientes();
  }

  getClientes = () => {
    console.log("status -> ", this.state)
    axios.get(`${urlCliente}/listarCliente/${this.state.ciudad}`)
      .then(res => {
        console.log(res.data);
        this.setState({
          clientes: res.data
        })
      });
  }

  handleChange = (e) => {
    this.setState({
      ciudad: e.target.value
    })
    this.getClientes();
  }


  render() {
    return (
      <div className="marginStyles">
        <Row>
          <h1 className="test">Listado de Clientes</h1>
        </Row>
        <Row className="rowThings">
          <div class="input-group mb-3">
            <Col>
              <span class="labelText" id="basic-addon0">Ciudad a consultar</span>
            </Col>
            <Col>
              <select class="form-select" aria-label="Default select example" onChange={this.handleChange}>
                <option selected>Seleccione la ciudad</option>
                <option value="medellin">Medellin</option>
                <option value="bogota">Bogota</option>
                <option value="cali">Cali</option>
              </select>
            </Col>
          </div>
        </Row>

        <table class="table table-dark table-striped">
          <thead>
            <tr>
              <th>Cedula del Cliente</th>
              <th>Nombre del Cliente</th>
              <th>Direccion</th>
              <th>Telefono</th>
              <th>Email</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {
              this.state.clientes.map((cliente) => {
                return (
                  <React.Fragment>
                    <tr>
                      <td>{cliente.cedula}</td>
                      <td>{cliente.nombre}</td>
                      <td>{cliente.direccion}</td>
                      <td>{cliente.telefono}</td>
                      <td>{cliente.correo}</td>
                      <td>
                        <button type="button" class="btn btn-dark">
                          <Link to={"/editarCliente/" + cliente._id}>Ventas por Cliente</Link>
                        </button >
                      </td>
                    </tr>
                  </React.Fragment>
                )
              })
            }
          </tbody>

        </table>
      </div>


    );
  }
}

export default Reportes;