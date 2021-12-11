import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";

class EditarCliente extends Component{

    path = null;
    url = [];
    clienteId = null;
    cedulaC = React.createRef();
    nombreC = React.createRef();
    direccionC = React.createRef();
    telefonoC = React.createRef();
    emailC = React.createRef();
    
    state = {
        cliente:[],
        status:null
    }

    componentWillMount(){
        this.path = window.location.pathname;
        this.url = this.path.split("/");
        console.log(this.url);
        this.clienteId = this.url[2];
        this.getCliente(this.clienteId);
    }

    getCliente = (id) => {
        axios.get("http://localhost:8093/clientes/buscar/"+id)
        .then(res =>{
            this.setState({
                cliente:res.data
            })
            console.log(res.data)
        });
    }

    guardarCliente = (e) =>{
        e.preventDefault();
        var cliente = {
            _id:this.clienteId,
            cedulaCliente:this.cedulaC.current.value,
            nombreCliente:this.nombreC.current.value,
            direccionCliente:this.direccionC.current.value,
            telefonoCliente:this.telefonoC.current.value,
            emailCliente:this.emailC.current.value
        }

        axios.put("http://localhost:8093/clientes/actualizar/"+this.clienteId,cliente)
        .then(res=>{
            this.setState({
                status:"success"
            })
        });
    }

    render(){
        if(this.state.status === "success"){
            return <Navigate to ="/clientes"/>
        }
        return(
            <div>
                <h1>Editar Cliente</h1>
                <form onSubmit = {this.guardarCliente}>
                    <div>
                        <label>Cedula del Cliente</label>
                        <input type = "text" name = "cedulaC" ref={this.cedulaC} defaultValue={this.state.cliente.cedulaCliente}/>
                    </div>
                    <div>
                        <label>Nombre del Cliente</label>
                        <input type = "text" name = "nombreC" ref={this.nombreC} defaultValue={this.state.cliente.nombreCliente}/>
                    </div>
                    <div>
                        <label>Direccion</label>
                        <input type = "text" name = "direccionC" ref={this.direccionC} defaultValue={this.state.cliente.direccionCliente}/>
                    </div>
                    <div>
                        <label>Telefono</label>
                        <input type = "text" name = "telefonoC" ref={this.telefonoC} defaultValue={this.state.cliente.telefonoCliente}/>
                    </div>
                    <div>
                        <label>Email</label>
                        <input type = "text" name = "emailC" ref={this.emailC} defaultValue={this.state.cliente.emailCliente}/>
                    </div>
                    <div>
                        <input type = "submit" />
                    </div>
                </form>
            </div>
        );
    }
}

export default EditarCliente;