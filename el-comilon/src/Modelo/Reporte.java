/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDateTime;

/**
 *
 * @author vbape
 */
public class Reporte {
    
    private int id, montoPromVentas, cantidadVentas, cantidadReclamos;
    private int cantidadReclamosPendientes, cantidadReclamosResueltos;
    private String calidadReclamo;
    private int cantidadPedidofinalizado, cantidadPedidoCancelado;
    private String fecha;
    
    public Reporte() {
    
    }

    public Reporte(int id, int montoPromVentas, int cantidadVentas, int cantidadReclamos, int cantidadReclamosPendientes, int cantidadReclamosResueltos, String calidadReclamo, int cantidadPedidofinalizado, int cantidadPedidoCancelado, String fecha) {
        this.id = id;
        this.montoPromVentas = montoPromVentas;
        this.cantidadVentas = cantidadVentas;
        this.cantidadReclamos = cantidadReclamos;
        this.cantidadReclamosPendientes = cantidadReclamosPendientes;
        this.cantidadReclamosResueltos = cantidadReclamosResueltos;
        this.calidadReclamo = calidadReclamo;
        this.cantidadPedidofinalizado = cantidadPedidofinalizado;
        this.cantidadPedidoCancelado = cantidadPedidoCancelado;
        this.fecha = fecha;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontoPromVentas() {
        return montoPromVentas;
    }

    public void setMontoPromVentas(int montoPromVentas) {
        this.montoPromVentas = montoPromVentas;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public int getCantidadReclamos() {
        return cantidadReclamos;
    }

    public void setCantidadReclamos(int cantidadReclamos) {
        this.cantidadReclamos = cantidadReclamos;
    }

    public int getCantidadReclamosPendientes() {
        return cantidadReclamosPendientes;
    }

    public void setCantidadReclamosPendientes(int cantidadReclamosPendientes) {
        this.cantidadReclamosPendientes = cantidadReclamosPendientes;
    }

    public int getCantidadReclamosResueltos() {
        return cantidadReclamosResueltos;
    }

    public void setCantidadReclamosResueltos(int cantidadReclamosResueltos) {
        this.cantidadReclamosResueltos = cantidadReclamosResueltos;
    }

    public String getCalidadReclamo() {
        return calidadReclamo;
    }

    public void setCalidadReclamo(String calidadReclamo) {
        this.calidadReclamo = calidadReclamo;
    }

    public int getCantidadPedidofinalizado() {
        return cantidadPedidofinalizado;
    }

    public void setCantidadPedidofinalizado(int cantidadPedidofinalizado) {
        this.cantidadPedidofinalizado = cantidadPedidofinalizado;
    }

    public int getCantidadPedidoCancelado() {
        return cantidadPedidoCancelado;
    }

    public void setCantidadPedidoCancelado(int cantidadPedidoCancelado) {
        this.cantidadPedidoCancelado = cantidadPedidoCancelado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
