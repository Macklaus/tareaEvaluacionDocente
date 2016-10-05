/**
 *
 */
package co.edu.eam.ingesoft.negocio.dto;

/**
 * clase auxiliar para almacenar los datos 
 * de una pregunta, su id y su valor
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 27/09/2016<br/>
 */
public class PreguntaDTO {

	/**
	 * id de la pregunta
	 */
	private int id;
	
	/**
	 * valor de la pregunta
	 */
	private double valor;
	
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor...
	 * @param id, id de la pregunta
	 * @param valor, valor de la pregunta
	 */
	public PreguntaDTO(int id, double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}

	/**
	 * @return El atributo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el valor del atributo id
	 * @param id: EL id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return El atributo valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Establece el valor del atributo valor
	 * @param valor: EL valor a establecer
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
