/**
 *
 */
package test.clase.testWebService;

import javax.ejb.EJB;

//import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.bos.webService.WsdlEJB;
import test.clase.PruebaPregunta;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 7/09/2016<br/>
 */
@RunWith(Arquillian.class)
public class PruebaWSDL {

//	@EJB
//	private WsdlEJB wsdlEJB;
//	
//	@Deployment
//	public static EnterpriseArchive desplegar(){
//		 
//		EnterpriseArchive ear= ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
//		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaWSDL.class));
//		return ear;
//		
//	}
//	
//	@Test
//	public void testBuscarEstudiante(){
//		Assert.assertNotNull(wsdlEJB.serviciosAcademicos("123", "123"));
//	}
//	
//	@Test
//	public void testBuscarCursosEstudiante(){
//		Assert.assertNotNull(wsdlEJB.buscarCursosEstudiantes("123", "123"));
//	}
	
}
