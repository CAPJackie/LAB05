/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.MyBATIS;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.impl.mappers.PacienteMapper;
import edu.eci.pdsw.persistence.interfaces.PacienteDAO;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Nicolás
 */
public class PacienteDAOMyBATIS implements PacienteDAO {

    @Inject
    PacienteMapper pacienteMap;
    
    @Override
    public List<Paciente> loadAll() {
        return pacienteMap.loadPacientes();
    }

    @Override
    public Paciente load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente loadByID(int id, String tipoId) throws PersistenceException {
        try {
            return pacienteMap.loadPacienteByID(id, tipoId);
        }catch(PersistenceException e){
            throw new PersistenceException(e.getMessage());
        } 
        
    }
    

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Paciente paciente) throws PersistenceException {
        try {
            pacienteMap.actualizarPaciente(paciente);
        }catch(PersistenceException e){
            throw new PersistenceException(e.getMessage());
        } 
    }
}
