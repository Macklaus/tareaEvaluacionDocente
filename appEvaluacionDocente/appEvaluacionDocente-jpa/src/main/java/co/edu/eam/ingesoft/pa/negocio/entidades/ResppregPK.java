/**
 *
 */
package co.edu.eam.ingesoft.pa.negocio.entidades;

import java.io.Serializable;

/**
 * entidad que simula el id para una entidad 
 * con llave primaria compuesta
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
public class ResppregPK implements Serializable{

	private String respuesta;
	
	private PregevalPK pregeval;
	
	/**
	 * Constructor...
	 */
	public ResppregPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor...
	 * @param respuesta
	 * @param pregeval
	 */
	public ResppregPK(String respuesta, PregevalPK pregeval) {
		super();
		this.respuesta = respuesta;
		this.pregeval = pregeval;
	}

	/**
	 * @return El atributo respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Establece el valor del atributo respuesta
	 * @param respuesta: EL respuesta a establecer
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return El atributo pregeval
	 */
	public PregevalPK getPregeval() {
		return pregeval;
	}

	/**
	 * Establece el valor del atributo pregeval
	 * @param pregeval: EL pregeval a establecer
	 */
	public void setPregeval(PregevalPK pregeval) {
		this.pregeval = pregeval;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
