/**
 *
 */
package co.edu.eam.ingesoft.negocio.bos.rest;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.bos.BOEvaluacionEJB;
import co.edu.eam.ingesoft.negocio.bos.BOGrupoEJB;
import co.edu.eam.ingesoft.negocio.bos.BOPregevalEJB;
import co.edu.eam.ingesoft.negocio.bos.BOPreguntaEJB;
import co.edu.eam.ingesoft.negocio.bos.BOResppregEJB;
import co.edu.eam.ingesoft.negocio.bos.BORespuestaEJB;
import co.edu.eam.ingesoft.negocio.dto.PreguntaDTO;
import co.edu.eam.ingesoft.negocio.dto.RespEvaluacionDTO;
import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa.negocio.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregeval;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregunta;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;
import co.edu.eam.ingesoft.pa.negocio.entidades.Respuesta;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
@Stateless
@LocalBean
public class CalificarEvaluacionEJB {
	
	@EJB
	private BOEvaluacionEJB evalEJB;
	
	@EJB
	private BOPreguntaEJB preguntaEJB;
	
	@EJB
	private BOPregevalEJB pregEvalEJB;
	
	@EJB
	private BOGrupoEJB grupoEJB;
	
	@EJB
	private BORespuestaEJB respuestaEJB;
	
	@EJB
	private BOResppregEJB respPregEJB;

	/**
	 * 
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param dto
	 */
	public void responderEvaluacion(RespEvaluacionDTO dto){
		Respuesta resp = crearRespuesta(dto.getIdGrupo(), dto.getComentario());
		List<PreguntaDTO> preguntasDtos = dto.getItemsPreguntas();
		//se busca la evaluacion con el id de evaluacion que llegó
		Evaluacion eval = evalEJB.buscar(dto.getIdEvaluacion());
		
		for (PreguntaDTO preguntaDTO : preguntasDtos) {
			//se busca la pregunta
			Pregunta pregunta = preguntaEJB.buscar(preguntaDTO.getId());
			Pregeval pregEval = new Pregeval(pregunta, eval);
			pregEvalEJB.crear(pregEval);
			
			Resppreg respPreg = new Resppreg(resp, pregEval, preguntaDTO.getValor());
			respPregEJB.crear(respPreg);
		}
	}
	
	/**
	 * metodo para crear una respuesta con los datos que 
	 * envio el estudiante, el comentario y de cual grupo fue, 
	 * y retorna la respuesta
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param idGrupo, id del grupo en el que respondio la respuesta
	 * @param comentario, comentario que envio el estudiante en la respuesta
	 * @return la respuesta creada
	 */
	private Respuesta crearRespuesta(String idGrupo, String comentario) throws ExcepcionFuncional{
		Grupo grupo = grupoEJB.buscar(idGrupo);
		Respuesta resp = new Respuesta();
		resp.setComentario(comentario);
		resp.setGrupo(grupo);
		resp.setFecha_hora(GregorianCalendar.getInstance().getTime());
		respuestaEJB.crear(resp);
		return resp;
	}
	
}
