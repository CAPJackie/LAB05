/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */


/**
 * Diseño de pruebas:
 * 
 * Clases de equivalencia:
 *  
 *      CE1: Descripción. El paciente no existe
 *           Resultado esperado: No agrega la consulta.
 *          
 *      CE2: Descripción. Se agrega una consulta de un paciente
 *           Resultado esperado: La lista de consultas del paciente debe aumentar
 * 
 */
public class ServiciosPacientesTest {
    
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void deberiaAgregarUnaConsultaAlPaciente() throws ExcepcionServiciosPacientes{
        Paciente pac1 = new Paciente();
        pac1.setId(10203040);
        pac1.setTipoId("Cedula de ciudadania");
        Consulta consulta = new Consulta(new Date("2017/09/21 12:22 PM"), "Chequeo general", 23000 );
        ServiciosPacientes servPac = new ServiciosPacientesMock();
        servPac.registrarNuevoPaciente(pac1);
        servPac.agregarConsultaPaciente(10203040, "Cedula de ciudadania", consulta);
        
        assertEquals(1, pac1.getConsultas().size());
        
    }
    
}
