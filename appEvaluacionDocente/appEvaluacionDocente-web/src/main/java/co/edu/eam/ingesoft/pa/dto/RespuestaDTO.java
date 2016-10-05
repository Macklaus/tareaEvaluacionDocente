/**
 *
 */
package co.edu.eam.ingesoft.pa.dto;

/**
 * Entidad para guardar el objeto que devuelve una peticion 
 * rest, devuelve dentro de esta entidad el objeto, mensaje 
 * y codigo de afirmacion o negacion segun si la accion fue 
 * exitosa o no.
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 13/09/2016<br/>
 */
public class RespuestaDTO {

	/**
	 * codigo de la operación
	 */
	private String codigo;
	
	/**
	 * mensaje de la operacion
	 */
	private String mensaje;
	
	/**
	 * objeto que devuelve la peticion
	 */
	private Object object;
	
	/**
	 * Constructor...
	 */
	public RespuestaDTO() {
		super();
	}
	
	/**
	 * Constructor con mensaje para operacion 
	 * exitosa...
	 * @param object, objeto que devuelva la peticion
	 */
	public RespuestaDTO(Object object){
		super();
		this.object = object;
		mensaje = "Operacion realizada exitosamente";
		codigo = "OK";
	}

	/**
	 * Constructor...
	 * @param codigo
	 * @param mensaje
	 * @param object
	 */
	public RespuestaDTO(String codigo, String mensaje, Object object) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.object = object;
	}

	/**
	 * @return El atributo codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece el valor del atributo codigo
	 * @param codigo: EL codigo a establecer
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return El atributo mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece el valor del atributo mensaje
	 * @param mensaje: EL mensaje a establecer
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return El atributo object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Establece el valor del atributo object
	 * @param object: EL object a establecer
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
	
	
	
}
