/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.interfaces;

import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Nicolás
 */
public interface PacienteDAO {
    
    public  List<Paciente> loadAll();
    
    public Paciente load();
    
    public Paciente loadByID(int id, String tipoId)throws PersistenceException;
    
    public void save();
    
    public void update(Paciente paciente) throws PersistenceException;

}
