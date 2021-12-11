import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";

class EditarVenta extends Component{

    path = null;
    url = [];
    ventaId = null;
    codigoV = React.createRef();
    cedulaC = React.createRef();
    codigoP = React.createRef();
    cantidadP = React.createRef();
    valorU = React.createRef();
    valorTP = React.createRef();
    valorTV = React.createRef();
    valorI = React.createRef();
    valorTI = React.createRef();

    state = {
        venta:[],
        status:null
    }

    componentWillMount(){
        this.path = window.location.pathname;
        this.url = this.path.split("/");
        console.log(this.url);
        this.ventaId = this.url[2];
        this.getVenta(this.ventaId);
    }

    getVenta = (id) => {
        axios.get("http://localhost:8082/ventas/buscar/"+id)
        .then(res =>{
            this.setState({
                venta:res.data
            })
            console.log(res.data)
        });
    }

    guardarVenta = (e) =>{
        e.preventDefault();
        var venta = {
            _id:this.ventaId,
            codigoVenta:this.codigoV.current.value,
            cedulaCliente:this.cedulaC.current.value,
            codigoProducto:this.codigoP.current.value,
            cantidadProducto:this.cantidadP.current.value,
            valorUnitario:this.valorU.current.value,
            valorTotalPorProducto:this.valorTP.current.value,
            valorTotalVenta:this.valorTV.current.value,
            valorIva:this.valorI.current.value,
            valorTotalConIva:this.valorTI.current.value,
        }

        axios.put("http://localhost:8082/ventas/actualizar/"+this.ventaId,venta)
        .then(res=>{
            this.setState({
                status:"success"
            })
        });
    }

    render(){
        if(this.state.status === "success"){
            return <Navigate to ="/ventas"/>
        }
        return(
            <div>
                <h1>Editar Venta</h1>
                <form onSubmit = {this.guardarProducto}>
                    <div>
                        <label>Código de Venta</label>
                        <input type = "text" name = "codigoV" ref={this.codigoV} defaultValue={this.state.venta.codigoV}/>
                    </div>
                    <div>
                        <label>Cedula del Cliente</label>
                        <input type = "text" name = "cedulaC" ref={this.cedulaC} defaultValue={this.state.venta.cedulaC}/>
                    </div>
                    <div>
                        <label>Codigo del Producto</label>
                        <input type = "text" name = "codigoP" ref={this.codigoP} defaultValue={this.state.venta.codigoP}/>
                    </div>
                    <div>
                        <label>Cantidad</label>
                        <input type = "text" name = "cantidadP" ref={this.cantidadP} defaultValue={this.state.venta.cantidadP}/>
                    </div>
                    <div>
                        <label>Valor Unitario</label>
                        <input type = "text" name = "valorU" ref={this.valorU} defaultValue={this.state.venta.valorU}/>
                    </div>
                    <div>
                        <label>Valor Total por Producto</label>
                        <input type = "text" name = "valorTP" ref={this.valorTP} defaultValue={this.state.venta.valorTP}/>
                    </div>
                    <div>
                        <label>Valor Total de Venta</label>
                        <input type = "text" name = "valorTV" ref={this.valorTV} defaultValue={this.state.venta.valorTV}/>
                    </div>
                    <div>
                        <label>Iva</label>
                        <input type = "text" name = "valorI" ref={this.valorI} defaultValue={this.state.venta.valorI}/>
                    </div>
                    <div>
                        <label>Valor Total con Iva</label>
                        <input type = "text" name = "valorTI" ref={this.valorTI} defaultValue={this.state.venta.valorTI}/>
                    </div>
                    <div>
                        <input type = "submit" />
                    </div>
                </form>
            </div>
        );
    }
}

export default EditarVenta;