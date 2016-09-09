/**
 *
 */
package co.edu.eam.ingesoft.pa.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.interceptores.ExceptionLogger;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

/**
 * Clase que se encarga de controlar los 
 * datos para la pagina ManejoPrograma
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 25/08/2016<br/>
 */
@Named("ControladorManejoPrograma")
@ViewScoped
@ExceptionLogger
public class ControladorManejoPrograma implements Serializable{
	
	@EJB
	private BOFacultadEJB facultadEJB;
	
	@EJB
	private BOProgramaEJB programaEJB;
	
	private Facultad facultad;
	
	private Programa programa;
	
	private List<Facultad> facultades;
	
	@PostConstruct
	public void inicializar() {
		facultades = listarFacultades();
		programa = new Programa();
	}
	
	/**
	 * metodo para crear un programa
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 25/08/2016<br/>
	 */
	public void crearPrograma(){
		Programa p = new Programa();
		p.setFacultad(facultad);
		String id = facultad.getNombre() + "-" + programa.getNombre();
		p.setId(id);
		p.setNombre(programa.getNombre());
		programaEJB.crear(p);
		Messages.addGlobalInfo("El programa ha sido registrado");
		programa = new Programa();
	}
	
	/**
	 * metodo para listar todas las facultades 
	 * que esten registradas
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 25/08/2016<br/>
	 * @return una lista con las facultades registradas
	 */
	public List<Facultad> listarFacultades(){
		return facultadEJB.listarFacultades();
	}

	/**
	 * @return El atributo facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * Establece el valor del atributo facultad
	 * @param facultad: EL facultad a establecer
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return El atributo programa
	 */
	public Programa getPrograma() {
		return programa;
	}

	/**
	 * Establece el valor del atributo programa
	 * @param programa: EL programa a establecer
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	/**
	 * @return El atributo facultades
	 */
	public List<Facultad> getFacultades() {
		facultades = facultadEJB.listarFacultades();
		return facultades;
	}

	/**
	 * Establece el valor del atributo facultades
	 * @param facultades: EL facultades a establecer
	 */
	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}
	
	
	
	
}
