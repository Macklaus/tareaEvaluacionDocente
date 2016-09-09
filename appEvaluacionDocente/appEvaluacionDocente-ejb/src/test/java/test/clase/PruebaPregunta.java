/**
 * 
 */
package test.clase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;


/**
 * 
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 25/08/2016<br/>
 */
@RunWith(Arquillian.class)
public class PruebaPregunta {

	@EJB
	private BOPreguntaEJB preguntaEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaPregunta.class));
		return ear;
		
	}

	
	@Test
	public void testCrearPregunta(){
		Pregunta p = new Pregunta();
		
		p.setTexto("Pregunta de la prueba");
		p.setValor(5);
		preguntaEJB.crear(p);
		
		Pregunta pre = preguntaEJB.buscar(p.getId());
		Assert.assertEquals("Pregunta de la prueba", pre.getTexto());
	}
	
	@AfterClass
	public static void finPrueba(){
		TestDataUtil.ejecutarSQL("sqlTest/testPregunta-fin.sql");
	}
	
}
