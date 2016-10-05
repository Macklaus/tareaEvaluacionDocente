/**
 *
 */
package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.rest.CalificarEvaluacionEJB;
import co.edu.eam.ingesoft.negocio.dto.RespEvaluacionDTO;

/**
 * Entidad con los metodo Rest para las evaluaciones
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
@Path("/evaluacion")
public class EvaluacionRest {
	
	private CalificarEvaluacionEJB ejb;

	/**
	 * Constructor...
	 */
	public EvaluacionRest() {
		// TODO Auto-generated constructor stub
	}
	
	@Path("/responderevaluacion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void responderEvaluacion(RespEvaluacionDTO dto){
		ejb.responderEvaluacion(dto);
	}
}
