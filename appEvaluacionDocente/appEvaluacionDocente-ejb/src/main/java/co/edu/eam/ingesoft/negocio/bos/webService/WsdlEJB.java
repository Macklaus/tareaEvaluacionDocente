/**
 *
 */
package co.edu.eam.ingesoft.negocio.bos.webService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa.clienteWebService.Estudiante;
import co.edu.eam.ingesoft.pa.clienteWebService.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa.clienteWebService.ServiciosEducativosService;
import co.edu.eam.ingesoft.negocio.bos.BOAsignaturaEJB;
import co.edu.eam.ingesoft.negocio.bos.BODocenteEJB;
import co.edu.eam.ingesoft.negocio.bos.BOFacultadEJB;
import co.edu.eam.ingesoft.negocio.bos.BOGrupoEJB;
import co.edu.eam.ingesoft.negocio.bos.BOProgramaEJB;
import co.edu.eam.ingesoft.pa.clienteWebService.Curso;
import co.edu.eam.ingesoft.pa.negocio.entidades.Asignatura;
import co.edu.eam.ingesoft.pa.negocio.entidades.Docente;
import co.edu.eam.ingesoft.pa.negocio.entidades.Facultad;
import co.edu.eam.ingesoft.pa.negocio.entidades.Grupo;
import co.edu.eam.ingesoft.pa.negocio.entidades.Programa;

/**
 * Clase donde se utilizan los servicios SOAP, 
 * serviciosAcademicosService.
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 7/09/2016<br/>
 */
@Stateless
@LocalBean
public class WsdlEJB implements  Serializable {
	
	@EJB
	private BOProgramaEJB programaEJB;
	
	@EJB
	private BOFacultadEJB facultadEJB;
	
	@EJB
	private BOAsignaturaEJB asignaturaEJB;
	
	@EJB
	private BODocenteEJB docenteEJB;
	
	@EJB
	private BOGrupoEJB grupoEJB;

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
	 * @return la lista de cursos que posea el estudiante o null si no 
	 * posee ningun curso
	 */
	public List<Grupo> buscarCursosEstudiantes(String codigo, String cedula){
		System.out.println("1 AAAAAAAAQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");

		ServiciosEducativosService cliente = new ServiciosEducativosService();
		
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		
		BindingProvider bp = (BindingProvider)servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos?wsdl");
		
		List<Curso> cursosEstudiante = servicio.consultarCursosEstudiante(codigo, cedula);
		if(!cursosEstudiante.isEmpty()){
			System.out.println("3 AAAAAAAAQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII" + cursosEstudiante.size());
			List<Grupo> grupos = registrarCursosEstudiante(cursosEstudiante);
			return grupos;
		} else {
			return null;
		}
		
	}
	
	/**
	 * metodo que registra todos los cursos que tenga 
	 * una lista de cursos, los registra si no estan 
	 * registrados con aterioridad y actualiza la lista 
	 * de docentes
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 7/09/2016<br/>
	 * @param cursosEstudiante, lista de cursos de un estudiante
	 * @return
	 */
	private List<Grupo> registrarCursosEstudiante(List<Curso> cursosEstudiante){
		List<Grupo> grupos = new ArrayList<>();
		for (Curso curso : cursosEstudiante) {
			//se obtiene el codigo y nombre de la facultad 
			//del webService que esta en el curso del webService
			String nombreFacultad = curso.getAsignatura().getPrograma().getFacultad().getNombre();
			String codigoFacultad = curso.getAsignatura().getPrograma().getFacultad().getCodigo();
			Facultad facultad = registrarFacultad(codigoFacultad,nombreFacultad);
			
			//se obtiene el codigo y nombre del programa del 
			//webService y se le envian al metodo para que verifique 
			//si no esta registrado y lo persista
			String codigoPrograma = curso.getAsignatura().getPrograma().getCodigo();
			String nombrePrograma = curso.getAsignatura().getPrograma().getNombre();
			Programa programa = registrarPrograma(codigoPrograma,nombrePrograma, facultad);
			
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
			
			//se crea un docente del JPa y se le setean los 
			//datos de el docente del webService
			Docente docente = registrarDocente(curso);
			
			Grupo grupo = registrarGrupos(curso, asignatura, docente);
			grupos.add(grupo);
		}
		return grupos;
	}
	
	/**
	 * metodo para registrar los cursos que esten en el 
	 * webService en la base de datos local pero los convierte 
	 * en Grupos, clase del JPA.
	 * Actualiza la lista de cursos
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param curso, curso que hace referencia a los grupos 
	 * en el webservice, contiene los datos de los grupos
	 * @param asignatura, asignatrua del grupo, curso
	 * @param docente, docente del grupo, curso
	 * @return el grupo registrado a partir del curso del 
	 * webService
	 */
	private Grupo registrarGrupos(Curso curso, Asignatura asignatura, Docente docente){
		Grupo grupo = new Grupo();
		grupo.setId(curso.getId());
		grupo.setDocente(docente);
		grupo.setAsignatura(asignatura);
		grupo.setGrupo(curso.getGrupo().toString());
		grupo.setPeriodo(curso.getAsignatura().getSemestre());
		
		GregorianCalendar c = new GregorianCalendar();
		int anio = c.get(Calendar.YEAR);
		grupo.setAnho(anio);
		
		if(grupoEJB.buscar(curso.getId()) == null){
			grupoEJB.crear(grupo);
		}
		return grupo;
	}
	
	/**
	 * metodo para crear un docente del JPA a partir de los 
	 * datos de un docente que se obtenga del webService. 
	 * Actualiza la lista de docente con los docentes en el 
	 * webService
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param curso, curso que tiene el docente
	 * @return el docente de la entidad Docente del modulo JPA
	 */
	private Docente registrarDocente(Curso curso){
		//se crea un docente del JPa y se le setean los 
		//datos de el docente del webService
		Docente docente = new Docente();
		docente.setId(curso.getDocente().getDocumentoidentificacion());
		docente.setNombre(curso.getDocente().getNombre());
		docente.setApellido(curso.getDocente().getApellido());
		String nomFaculDocente = curso.getDocente().getPrograma().getFacultad().getNombre();
		String codFaculDocente = curso.getDocente().getPrograma().getFacultad().getCodigo();
		Facultad faculDocente = registrarFacultad(codFaculDocente,nomFaculDocente);
//		if(faculDocente == null){
//			System.out.println("LA FACULTAD ESTA NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//		} else {
//			System.out.println(faculDocente.getNombre());
//		}
		
		String nomProgDocente = curso.getDocente().getPrograma().getNombre();
		String codProgDocente = curso.getDocente().getPrograma().getCodigo();
		Programa progDocente = registrarPrograma(codProgDocente,nomProgDocente, faculDocente);
//		if(progDocente == null){
//			System.out.println("EL PROGRAMA ESTA NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//		} else {
//			System.out.println(progDocente.getNombre());
//		}
		
		docente.setPrograma(progDocente);
		
		//si el docente no esta registrado lo persiste
		if(docenteEJB.buscar(curso.getDocente().getDocumentoidentificacion()) == null){
			docenteEJB.crear(docente);
		}
		return docente;
	}
	
	
	/**
	 * Metodo para actualizar la lista de programas 
	 * en la base de datos, se recibe el nombre y codigo 
	 * del programa del webservice
	 * se crea un programa JPA .
	 * y se le setan los datos del programa del webService 
	 * si el programa no esta registrado, este metodo lo 
	 * persiste
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 24/09/2016<br/>
	 * @param codigo, codigo del programa del webService
	 * @param nombre, nombre del programa del webService
	 * @param facultad, facultad JPA del programa
	 * @return el programa del JPA
	 */
	private Programa registrarPrograma(String codigo, String nombre, Facultad facultad){
		Programa programa = new Programa();
		programa.setId(codigo);
		programa.setNombre(nombre);
		programa.setFacultad(facultad);
		//si no esta registrado el programa del webService 
		//se persiste el programa creado y seteado
		if(programaEJB.buscar(codigo) == null){
			programaEJB.crear(programa);
		}
		return programa;
	}
	
	/**
	 * metodo para actualizar la lista de facultades,
	 * se recibe el codigo y nombre de la facultad 
	 * del webService. 
	 * Toma una facultad del webService y si no esta 
	 * registrada en nuestra BD crea una facultad del 
	 * JPA y la persiste
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 24/09/2016<br/>
	 * @param codigo, codigo de la facultad del webService
	 * @param nombre, nombre de la facultad del webService
	 * @return la facultad del JPA
	 */
	private Facultad registrarFacultad(String codigo, String nombre){
		Facultad facultad = new Facultad();
		facultad.setId(codigo);
		facultad.setNombre(nombre);
		//si ya está esa facultad registrada no se persiste
		if(facultadEJB.buscar(codigo) == null){
			facultadEJB.crear(facultad);
		}
		return facultad;
	}
	
}
