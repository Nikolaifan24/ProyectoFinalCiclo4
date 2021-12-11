import React from "react";
import { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import swal from "sweetalert";
import 'bootstrap/dist/css/bootstrap.min.css';
import {urlCliente} from '../utils';


class Clientes extends Component{
    state = {
        clientes:[],
        status:null
    }
    ciudad = ''
    componentWillMount(){
        this.ciudad = localStorage.getItem('ciudad');
        this.getClientes(this.ciudad);
    }
    
    getClientes =(ciudad) =>{
        axios.get(`${urlCliente}/listarCliente/` + ciudad)
        .then(res =>{
            console.log(res.data);
            this.setState({
                clientes:res.data
            })
            console.log(this.state)
            

        });
    }

    borrarCliente =(id) =>{
        axios.delete("http://localhost:8093/clientes/eliminar/"+id)
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
                <h1>Clientes</h1>
                <button type="button" class="btn btn-dark">
                    <Link to = "/agregarCliente">Crear Cliente</Link>
                </button>
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
                            this.state.clientes.map((cliente)=>{
                                return(
                                    <React.Fragment>
                                        <tr>
                                            <td>{cliente.cedula}</td>
                                            <td>{cliente.nombre}</td>
                                            <td>{cliente.direccion}</td>
                                            <td>{cliente.telefono}</td>
                                            <td>{cliente.correo}</td>
                                            <td>
                                            <button type="button" class="btn btn-dark">
                                                <Link to = {"/editarCliente/"+cliente._id}>Editar</Link>
                                            </button >
                                                <button type="button" class="btn btn-dark" onClick= {
                                                    ()=>{
                                                        this.borrarCliente(cliente._id)
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

export default Clientes;