import React from "react";
import { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import swal from "sweetalert";
import 'bootstrap/dist/css/bootstrap.min.css';

class Ventas extends Component{
    state = {
        ventas:[],
        status:null
    }

    componentWillMount(){
        this.getVentas();
    }

    getVentas =() =>{
        axios.get("http://localhost:8082/ventas/listar")
        .then(res =>{
            console.log(res.data);
            this.setState({
                ventas:res.data
            })
        });
    }

    borrarventa =(id) =>{
        axios.delete("http://localhost:8082/ventas/eliminar/"+id)
        .then(res=>{
            this.setState({
                status:"deleted"
            });

            

            swal(
                "Venta Eliminada",
                "La venta ha sido eliminada exitosamente",
                "success"
            );

            window.location.reload(true);
        });
    }

    
    render(){
        return(
            <div>
                <h1>Ventas</h1>
                <button type="button" class="btn btn-dark">
                    <Link to = "/agregarVenta">Nueva Venta</Link>
                </button>
                <table class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th>Código de Venta</th>
                            <th>Cedula del Cliente</th>
                            <th>Codigo del Producto</th>
                            <th>Cantidad</th>
                            <th>Valor Unitario</th>
                            <th>Valor Total por Producto</th>
                            <th>Valor Total de Venta</th>
                            <th>Iva</th>
                            <th>Valor Total con Iva</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.ventas.map((venta)=>{
                                return(
                                    <React.Fragment>
                                        <tr>
                                            <td>{venta.codigoVenta}</td>
                                            <td>{venta.cedulaCliente}</td>
                                            <td>{venta.codigoProducto}</td>
                                            <td>{venta.cantidadProducto}</td>
                                            <td>{venta.valorUnitario}</td>
                                            <td>{venta.valorTotalPorProducto}</td>
                                            <td>{venta.valorTotalVenta}</td>
                                            <td>{venta.valorIva}</td>
                                            <td>{venta.valorTotalConIva}</td>
                                            <td>
                                            <button type="button" class="btn btn-dark">
                                                <Link to = {"/editarVenta/"+venta._id}>Editar</Link>
                                            </button >
                                                <button type="button" class="btn btn-dark" onClick= {
                                                    ()=>{
                                                        this.borrarventa(venta._id)
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

export default Ventas;