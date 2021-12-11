import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";

class EditarProducto extends Component{

    path = null;
    url = [];
    productoId = null;
    codigo = React.createRef();
    producto = React.createRef();
    nit = React.createRef();
    precioCompra = React.createRef();
    iva = React.createRef();
    precioVenta = React.createRef();

    state = {
        producto:[],
        status:null
    }

    componentWillMount(){
        this.path = window.location.pathname;
        this.url = this.path.split("/");
        console.log(this.url);
        this.productoId = this.url[2];
        this.getProducto(this.productoId);
    }

    getProducto = (id) => {
        axios.get("http://localhost:8080/productos/buscar/"+id)
        .then(res =>{
            this.setState({
                producto:res.data
            })
            console.log(res.data)
        });
    }

    guardarProducto = (e) =>{
        e.preventDefault();
        var producto = {
            _id:this.productoId,
            codigo_producto:this.codigo.current.value,
            nombre_producto:this.producto.current.value,
            nitProveedor:this.nit.current.value,
            precio_compra:this.precioCompra.current.value,
            iva_compra:this.iva.current.value,
            precio_venta:this.precioVenta.current.value,
        }

        axios.put("http://localhost:8080/productos/actualizar/"+this.productoId,producto)
        .then(res=>{
            this.setState({
                status:"success"
            })
        });
    }

    render(){
        if(this.state.status === "success"){
            return <Navigate to ="/productos"/>
        }
        return(
            <div>
                <h1>Editar Producto</h1>
                <form onSubmit = {this.guardarProducto}>
                    <div>
                        <label>Código del Producto</label>
                        <input type = "text" name = "codigo" ref={this.codigo} defaultValue={this.state.producto.codigo_producto}/>
                    </div>
                    <div>
                        <label>Producto</label>
                        <input type = "text" name = "producto" ref={this.producto} defaultValue={this.state.producto.nombre_producto}/>
                    </div>
                    <div>
                        <label>Nit del Proveedor</label>
                        <input type = "text" name = "nit" ref={this.nit} defaultValue={this.state.producto.nitProveedor}/>
                    </div>
                    <div>
                        <label>Precio de Compra</label>
                        <input type = "text" name = "precioCompra" ref={this.precioCompra} defaultValue={this.state.producto.precio_compra}/>
                    </div>
                    <div>
                        <label>Iva</label>
                        <input type = "text" name = "iva" ref={this.iva} defaultValue={this.state.producto.iva_compra}/>
                    </div>
                    <div>
                        <label>Precio de Venta</label>
                        <input type = "text" name = "precioVenta" ref={this.precioVenta} defaultValue={this.state.producto.precio_venta}/>
                    </div>
                    <div>
                        <input type = "submit" />
                    </div>
                </form>
            </div>
        );
    }
}

export default EditarProducto;