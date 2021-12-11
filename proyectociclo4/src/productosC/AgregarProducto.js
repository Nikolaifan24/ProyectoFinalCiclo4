import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";
import '../styles/Formularios.css'
import { Row, Col } from "react-bootstrap";
import { urlProducto } from '../utils';

class AgregarProducto extends Component {
  codigo = React.createRef();
  nombre = React.createRef();
  nitproveedor = React.createRef();
  precioCompra = React.createRef();
  ivaCompra = React.createRef();
  precioVenta = React.createRef();

  state = {
    productos: [],
    status: null
  }
  ciudad = localStorage.getItem('ciudad');

  guardarProducto = (e) => {
    e.preventDefault();
    let producto = {
      productoDto: {
        codigo: this.codigo.current.value,
        nombre: this.nombre.current.value,
        nitproveedor: this.nitproveedor.current.value,
        precioCompra: this.precioCompra.current.value,
        ivaCompra: this.ivaCompra.current.value,
        precioVenta: this.precioVenta.current.value
      },
      ciudad: this.ciudad
    }
    
    axios.post(`${urlProducto}/crearProducto`, producto)
      .then(res => {
        this.setState({
          status: "success"
        })
      })
      .catch(err => {
        alert("No ha podido crear correctamente el producto");
      });
  }

  render() {
    if (this.state.status === "success") {
       return <Navigate to="/productos" />
    }
    return (
      <div className="marginStyles">
        <h1 class="test">Agregar Producto</h1>
        <form onSubmit={this.guardarProducto} className="test" >
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon0">Código del Producto</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.codigo} placeholder="Ejemplo: 123c" aria-label="Ejemplo: 123c" aria-describedby="basic-addon0" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon1">Producto</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.nombre} placeholder="Ejemplo: Manzana" aria-label="Ejemplo: Manzana" aria-describedby="basic-addon1" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon2">Nit del Proveedor</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.nitproveedor} placeholder="Ejemplo: 10987" aria-label="Ejemplo: 10987" aria-describedby="basic-addon2" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon3">Precio de Compra</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.precioCompra} placeholder="Ejemplo: 10000" aria-label="Ejemplo: 10000" aria-describedby="basic-addon3" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon4">Iva</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.ivaCompra} placeholder="Ejemplo: 19" aria-label="Ejemplo: 19" aria-describedby="basic-addon4" />
              </Col>
            </div>
          </Row>
          <Row className="rowThings">
            <div class="input-group mb-3">
              <Col>
                <span class="labelText" id="basic-addon5">Precio de Venta</span>
              </Col>
              <Col>
                <input type="text" class="form-control" ref={this.precioVenta} placeholder="Ejemplo: 11900" aria-label="Ejemplo: 11900" aria-describedby="basic-addon5" />
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

export default AgregarProducto;