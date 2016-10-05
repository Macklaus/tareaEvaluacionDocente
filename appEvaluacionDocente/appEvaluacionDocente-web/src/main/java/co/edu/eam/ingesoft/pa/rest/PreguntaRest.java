/**
 *
 */
package co.edu.eam.ingesoft.pa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;

/**
 * Entidad con los metodos Rest referente a 
 * las preguntas
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
@Path("/pregunta")
public class PreguntaRest {

	@EJB
	private BOPreguntaEJB preguntaEJB;
	
	/**
	 * Constructor...
	 */
	public PreguntaRest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * metodo para listar todas las preguntas
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @return una lista de preguntas con todas 
	 * las preguntas realizadas
	 */
	@GET
	@Path("/listarpreguntas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pregunta> listarPreguntas(){
		return preguntaEJB.listarPreguntas();
	}
	
}
