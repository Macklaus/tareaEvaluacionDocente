/**
 *
 */
package co.edu.eam.ingesoft.negocio.bos.webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa.clienteWebService.Estudiante;
import co.edu.eam.ingesoft.pa.clienteWebService.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa.clienteWebService.ServiciosEducativosService;
import co.edu.eam.ingesoft.negocio.bos.BOAsignaturaEJB;
import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.clienteWebService.Curso;
import co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

/**
 * Clase donde se utilizan los servicios SOAP, 
 * serviciosAcademicosService.
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 7/09/2016<br/>
 */
@Stateless
public class WsdlEJB {
	
	@EJB
	private BOProgramaEJB programaEJB;
	
	@EJB
	private BOFacultadEJB facultadEJB;
	
	@EJB
	private BOAsignaturaEJB asignaturaEJB;

	/**
	 * metodo para buscar un estudiante 
	 * en el webService
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 * @param codigoEstudiante, codigo del estudiante que se desea buscar
	 * @param cedulaEstudiante, cedula del estudiante que se desea buscar
	 * 
	 * @return el estudiante que tenga el codigo y nombre dados o null 
	 * 		   si no lo encuentra.
	 */
	public Estudiante serviciosAcademicos(String codigoEstudiante, 
			                               String cedulaEstudiante){
		
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		
		BindingProvider bp = (BindingProvider)servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");
		
		Estudiante estudiante = servicio.consultaEstudiante(codigoEstudiante, cedulaEstudiante);
		
		return estudiante;
	}
	
	/**
	 * metodo para buscar los cursos de los estudiantes 
	 * del webService y crea los que no estan registrados
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 * @param codigo, codigo del estudiante a buscar
	 * @param cedula, cedula del estudiante a buscar
	 * @return la lista de cursos que posea el estudiante
	 */
	public List<Curso> buscarCursosEstudiantes(String codigo, String cedula){
		
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		
		BindingProvider bp = (BindingProvider)servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");
		
		List<Curso> cursosEstudiante = servicio.consultarCursosEstudiante(codigo, cedula);
		if(!cursosEstudiante.isEmpty()){
			registrarCursosEstudiante(cursosEstudiante);
			return cursosEstudiante;
		} else {
			return null;
		}
		
	}
	
	/**
	 * metodo que registra todos los cursos que tenga 
	 * una lista de cursos, los registra si no estan 
	 * registrados con aterioridad
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 * @param cursosEstudiante, lista de cursos de un estudiante
	 */
	private void registrarCursosEstudiante(List<Curso> cursosEstudiante){
		for (Curso curso : cursosEstudiante) {
			//se crea una asignatura del JPA y se le setean los 
			//datos de la faculta del webService
			Facultad facultad = new Facultad();
			facultad.setId(curso.getAsignatura().getPrograma().getFacultad().getCodigo());
			facultad.setNombre(curso.getAsignatura().getPrograma().getFacultad().getNombre());
			//si ya está esa facultad registrada no se persiste
			if(facultadEJB.buscar(curso.getAsignatura().getPrograma().getFacultad().getCodigo()) == null){
				facultadEJB.crear(facultad);
			}
			
			//se crea un programa del JPA y se le setean los 
			//datos del programa del webService
			Programa programa = new Programa();
			programa.setId(curso.getAsignatura().getPrograma().getCodigo());
			programa.setNombre(curso.getAsignatura().getPrograma().getNombre());
			programa.setFacultad(facultad);
			//si no esta registrado el programa del webService 
			//se persiste el programa creado y seteado
			if(programaEJB.buscar(curso.getAsignatura().getPrograma().getCodigo()) == null){
				programaEJB.crear(programa);
			}
			
			//se crea una asignatura del JPA y se le setean los 
			//datos de la asignatura del webService
			Asignatura asignatura = new Asignatura();
			asignatura.setId(curso.getAsignatura().getCodigo());
			asignatura.setNombre(curso.getAsignatura().getNombre());
			asignatura.setPrograma(programa);
			//si no esta registrada la asignatura del webService
			//se persiste la asignatura creada
			if(asignaturaEJB.buscar(curso.getAsignatura().getCodigo()) == null){
				asignaturaEJB.crear(asignatura);
			}
		}
	}
	
}
