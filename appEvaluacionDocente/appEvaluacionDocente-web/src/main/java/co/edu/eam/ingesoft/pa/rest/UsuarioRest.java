/**
 *
 */
package co.edu.eam.ingesoft.pa.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Decano;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 7/09/2016<br/>
 */
@Path("/usuario")
public class UsuarioRest {

	@EJB
	private BOUsuarioEJB usuarioEJB;
	
	/**
	 * Constructor...
	 */
	public UsuarioRest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 */
	@PUT
	@Path("/crearusuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean crearUsuario(Decano usuario){
		if(usuarioEJB.buscar(usuario.getId()) == null){
			usuarioEJB.crear(usuario);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 * @param cedula
	 * @return
	 */
	@GET
	@Path("/buscarusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuario(@QueryParam(value="ced") int cedula){
		return usuarioEJB.buscar(cedula);
	}
	
}
