/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.MyBATIS;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.impl.mappers.EpsMapper;
import edu.eci.pdsw.persistence.interfaces.EpsDAO;
import edu.eci.pdsw.samples.entities.Eps;
import java.util.List;

/**
 *
 * @author Nicolás
 */
public class EpsDAOMyBATIS implements EpsDAO{
    @Inject
    EpsMapper epsMap;

    @Override
    public List<Eps> loadAll() {
        return epsMap.loadAllEPS();
    }

    @Override
    public Eps load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Eps loadByID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
