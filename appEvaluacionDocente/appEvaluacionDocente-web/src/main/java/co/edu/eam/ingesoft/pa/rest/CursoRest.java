/**
 *
 */
package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.webService.WsdlEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/09/2016<br/>
 */
@Path("/curso")
public class CursoRest {

	@EJB
	private WsdlEJB wsdlEJB;
	
	/**
	 * Constructor...
	 */
	public CursoRest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * metodo para listar los cursos de un estudiante por 
	 * el codigo y numero de documento del estudiante
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param codigo, codigo de estudiante
	 * @param cedula, cedula o numero de documento del estudiante
	 * @return una lista de cursos, los cursos que tenga 
	 * el estudiante
	 */
	@GET
	@Path("/listarcursosestudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Grupo> listarCursosEstudiantes(@QueryParam(value = "codigo")String codigo, 
			@QueryParam(value = "cedula")String cedula){
		return wsdlEJB.buscarCursosEstudiantes(codigo, cedula);
	}
	
	
}
