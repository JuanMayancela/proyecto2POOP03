/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author mamay
 */
public class Factura {
    private Cliente clienteEmpresa;
    private String periodoFacturacion;
    private int totalPagar;
    
    public Factura(Cliente clienteEmpresa, String periodoFacturacion, int totalPagar){
        this.clienteEmpresa=clienteEmpresa;
        this.periodoFacturacion=periodoFacturacion;
        this.totalPagar=totalPagar;
    }
    
    public Cliente getClienteEmpresa(){
        return clienteEmpresa;
    }

    public void setClienteEmpresa(Cliente clienteEmpresa) {
        this.clienteEmpresa=clienteEmpresa;
    }

    public String getPeriodoFacturacion() {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(String periodoFacturacion) {
        this.periodoFacturacion=periodoFacturacion;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar=totalPagar;
    }
    
}
