import React from "react";
import { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import swal from "sweetalert";
import 'bootstrap/dist/css/bootstrap.min.css';
import {urlProducto} from '../utils';

class Productos extends Component{
    state = {
        productos:[],
        status:null
    }
    ciudad = ''
    componentWillMount(){
        this.ciudad = localStorage.getItem('ciudad');
        this.getProductos(this.ciudad);
    }

    getProductos =(ciudad) =>{
        axios.get(`${urlProducto}/listarProducto/` + ciudad)
        .then(res =>{
            console.log(res.data);
            this.setState({
                productos:res.data
            })
            console.log(this.state)
        });
    }

    borrarProducto =(id) =>{
        axios.delete("http://localhost:8080/productos/eliminar/"+id)
        .then(res=>{
            this.setState({
                status:"deleted"
            });

            

            swal(
                "Producto Eliminado",
                "El artículo ha sido borrado exitosamente",
                "success"
            );

            window.location.reload(true);
        });
    }

    
    render(){
        return(
            <div>
                <h1>Productos</h1>
                <button type="button" class="btn btn-dark">
                    <Link to = "/agregarProducto">Crear Producto</Link>
                </button>
                <table class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th>Código del Producto</th>
                            <th>Nombre del Producto</th>
                            <th>Nit del Proveedor</th>
                            <th>Precio de Compra</th>
                            <th>Iva</th>
                            <th>Precio de Venta</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.productos.map((producto)=>{
                                return(
                                    <React.Fragment>
                                        <tr>
                                            <td>{producto.codigo}</td>
                                            <td>{producto.nombre}</td>
                                            <td>{producto.nitProveedor}</td>
                                            <td>{producto.precioCompra}</td>
                                            <td>{producto.ivaCompra}</td>
                                            <td>{producto.precioVenta}</td>
                                            <td>
                                            <button type="button" class="btn btn-dark">
                                                <Link to = {"/editarProducto/"+producto._id}>Editar</Link>
                                            </button >
                                                <button type="button" class="btn btn-dark" onClick= {
                                                    ()=>{
                                                        this.borrarProducto(producto._id)
                                                    }
                                                }>Eliminar</button>
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

export default Productos;