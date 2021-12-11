import React, { Component } from "react";
import { Navigate } from "react-router";
import axios from "axios";

class AgregarVenta extends Component{
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
        ventas:[],
        status:null
    }

    guardarVenta = (e) =>{
        e.preventDefault();
        var venta = {
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

        axios.post("http://localhost:8082/ventas/agregar",venta)
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
                <h1>Nueva Venta</h1>
                <form onSubmit = {this.guardarVenta}>
                    <div>
                        <label>Código de Venta</label>
                        <input type = "text" name = "codigoV" ref={this.codigoV}/>
                    </div>
                    <div>
                        <label>Cedula del Cliente</label>
                        <input type = "text" name = "cedulaC" ref={this.cedulaC}/>
                    </div>
                    <div>
                        <label>Codigo del Producto</label>
                        <input type = "text" name = "codigoP" ref={this.codigoP}/>
                    </div>
                    <div>
                        <label>Cantidad</label>
                        <input type = "text" name = "cantidadP" ref={this.cantidadP}/>
                    </div>
                    <div>
                        <label>Valor Unitario</label>
                        <input type = "text" name = "valorU" ref={this.valorU}/>
                    </div>
                    <div>
                        <label>Valor Total por Producto</label>
                        <input type = "text" name = "valorTP" ref={this.valorTP}/>
                    </div>
                    <div>
                        <label>Valor Total de Venta</label>
                        <input type = "text" name = "valorTV" ref={this.valorTV}/>
                    </div>
                    <div>
                        <label>Iva</label>
                        <input type = "text" name = "valorI" ref={this.valorI}/>
                    </div>
                    <div>
                        <label>Valor Total con Iva</label>
                        <input type = "text" name = "valorTI" ref={this.valorTI}/>
                    </div>
                    <div>
                        <input type = "submit" />
                    </div>
                </form>
            </div>
        );
    }
}

export default AgregarVenta;