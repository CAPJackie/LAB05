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
 *      CE3: Solo se pueden agregar pacientes al sistema.
 *           Resultado esperado: Es verdadero si el parametro de entrada es de tipo paciente.
 *          
 *      CE5: Cuando se agrega un paciente, la lista de pacientes aumenta en 1.
 *           Resultado esperado: el tamaño de pacientes aumente en 1 cuando se agrege un paciente
 * 
 *      CE5: Error en la persistencia al momento de registrar un nuevo paciente.
 *           Resultado esperado: ExcepcionOperacionConPaciente
 * 
 *  
 * Condiciones de frontera:
 * 
 *      CF1: Se registra una persona creada. 
 *           Clases de equivalencia relacionadas: CE3,CE4
 *           Resultado esperado: la longuitud de los pacientes aumentó en 1.
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
    
    

    //CF1:
    @Test
    public void testRegistrarNuevoPaciente() throws ExcepcionServiciosPacientes{
        ServiciosPacientesMock servicioPacientes= new ServiciosPacientesMock();
        int sizeClientes= servicioPacientes.consultarPacientes().size();
        Paciente pac=new Paciente(); 
        servicioPacientes.registrarNuevoPaciente(pac);
        assertEquals(sizeClientes+1,servicioPacientes.consultarPacientes().size());
    }
    
}
