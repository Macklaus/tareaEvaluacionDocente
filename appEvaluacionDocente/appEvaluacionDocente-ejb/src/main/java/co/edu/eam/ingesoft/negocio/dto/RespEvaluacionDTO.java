/**
 *
 */
package co.edu.eam.ingesoft.negocio.dto;

import java.util.List;

/**
 * entidad auxiliar para alamcenar todos los datos 
 * necesarios para responder una pregunta de una evaluacion
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
public class RespEvaluacionDTO {

	private int idEvaluacion;
	
	private String codigoEstudiante;
	
	private String idGrupo;
	
	/**
	 * comentario que dio el estudiante en la 
	 * respuesta
	 */
	private String comentario;
	
	private List<PreguntaDTO> itemsPreguntas;
	
	/**
	 * Constructor...
	 */
	public RespEvaluacionDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor...
	 * @param idEvaluacion, id de la evaluacion
	 * @param codigoEstudiante, codigo del estudiante quien respondio 
	 * la pregunta
	 * @param itemsPreguntas, preguntas que fueron respuestas
	 * @param comentario, comentario que hizo el estudiante en la respuesta
	 * @param idGrupo
	 */
	public RespEvaluacionDTO(int idEvaluacion, String codigoEstudiante, 
			List<PreguntaDTO> itemsPreguntas, String comentario, String idGrupo) {
		super();
		this.idEvaluacion = idEvaluacion;
		this.codigoEstudiante = codigoEstudiante;
		this.itemsPreguntas = itemsPreguntas;
		this.comentario = comentario;
		this.idGrupo = idGrupo;
	}

	/**
	 * @return El atributo idEvaluacion
	 */
	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * Establece el valor del atributo idEvaluacion
	 * @param idEvaluacion: EL idEvaluacion a establecer
	 */
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	/**
	 * @return El atributo codigoEstudiante
	 */
	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	/**
	 * Establece el valor del atributo codigoEstudiante
	 * @param codigoEstudiante: EL codigoEstudiante a establecer
	 */
	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	/**
	 * @return El atributo comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Establece el valor del atributo comentario
	 * @param comentario: EL comentario a establecer
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return El atributo itemsPreguntas
	 */
	public List<PreguntaDTO> getItemsPreguntas() {
		return itemsPreguntas;
	}

	/**
	 * Establece el valor del atributo itemsPreguntas
	 * @param itemsPreguntas: EL itemsPreguntas a establecer
	 */
	public void setItemsPreguntas(List<PreguntaDTO> itemsPreguntas) {
		this.itemsPreguntas = itemsPreguntas;
	}

	/**
	 * @return El atributo idGrupo
	 */
	public String getIdGrupo() {
		return idGrupo;
	}

	/**
	 * Establece el valor del atributo idGrupo
	 * @param idGrupo: EL idGrupo a establecer
	 */
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	
}
