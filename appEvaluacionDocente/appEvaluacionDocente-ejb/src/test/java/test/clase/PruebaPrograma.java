/**
 *
 */
package test.clase;

import java.util.List;

import javax.ejb.EJB;

//import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;


/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 26/08/2016<br/>
 */
@RunWith(Arquillian.class)
public class PruebaPrograma {

	/*@EJB
	private BOProgramaEJB programaEJB;
	
	@EJB
	private BOFacultadEJB facultadEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaPrograma.class));
		return ear;
		
	}
	
	@Test
	public void testCrearPrograma(){
		List<Facultad> facultades = facultadEJB.listarFacultades();
		
		Programa programa = new Programa();
		programa.setFacultad(facultades.get(0));
		programa.setId("prueba-Arquillian");
		programa.setNombre("Programa Arquillian");
		
		programaEJB.crear(programa);
		
		//se busca el programa registrado anteriormente
		Programa res = programaEJB.buscar(programa.getId());
		Assert.assertEquals("Programa Arquillian", res.getNombre());
		
	}
	
	@AfterClass
	public static void finPrueba(){
		TestDataUtil.ejecutarSQL("sqlTest/testPrograma-fin.sql");
	}*/
	
}
