package test.clase;

import java.util.List;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.negocio.seguridad.SeguridadEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Rol;

/**
 * 
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 25/08/2016<br/>
 */
@RunWith(Arquillian.class)
public class PruebaRol {

	
	@EJB
	private SeguridadEJB seguridadEJB;
	
	@EJB
	private BOUsuarioEJB usuarioEJB;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../appEvaluacionDocente-ear/target/appEvaluacionDocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaRol.class));
		return ear;
	}
	
	
	@Test
	public void rolesTest(){
		Usuario u = usuarioEJB.buscarUsuarioPorUser("cris");
		List<Rol> listaRoles = seguridadEJB.listarRolesUsuario(u);
		Assert.assertEquals(1,listaRoles.size());
	}
	
}
