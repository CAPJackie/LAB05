/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {

    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    
    private int idPaciente;
    private String tipoIdPaciente;
    private String nombrePaciente;
    private Date fechaNacimientoCliente;
    private Eps epsCliente;

    public String getTipoIdPaciente() {
        return tipoIdPaciente;
    }

    public void setTipoIdPaciente(String tipoIdPaciente) {
        this.tipoIdPaciente = tipoIdPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Date getFechaNacimientoCliente() {
        return fechaNacimientoCliente;
    }

    public void setFechaNacimientoCliente(Date fechaNacimientoCliente) {
        this.fechaNacimientoCliente = fechaNacimientoCliente;
    }

    public Eps getEpsCliente() {
        return epsCliente;
    }

    public void setEpsCliente(Eps epsCliente) {
        this.epsCliente = epsCliente;
    }
    

    public RegistroConsultaBean() {
    }
    
    public int getIdPaciente(){
        return idPaciente;
    }
    
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente;
    }
    
    public void registrarCliente() throws ExcepcionServiciosPacientes{
        servicepacientes.registrarNuevoPaciente(new Paciente());
    }
    
    public ServiciosPacientes getServicePacientes(){
        return servicepacientes;
    }
    
    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        servicepacientes.registrarNuevoPaciente(new Paciente(idPaciente, tipoIdPaciente, nombrePaciente, fechaNacimientoCliente, epsCliente));
    }
    
    

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
