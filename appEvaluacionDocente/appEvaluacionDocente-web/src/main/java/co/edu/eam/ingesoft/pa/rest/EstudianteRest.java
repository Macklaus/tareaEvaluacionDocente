package co.edu.eam.ingesoft.pa.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.negocio.bos.webService.WsdlEJB;
import co.edu.eam.ingesoft.pa.clienteWebService.Estudiante;

@Path("/estudiante")
public class EstudianteRest {

	@EJB
	private WsdlEJB wsdlEJB;
	
	/**
	 * Constructor...
	 */
	public EstudianteRest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * metodo para logear al estudiante, recibe el 
	 * codigo y el numero de documento
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 27/09/2016<br/>
	 * @param codigo, codigo del estudiante
	 * @param documento, documento del estudiante
	 * @return un estudiante y significa que si se pudo 
	 * loguear, si retorna null es que no se puede loguear
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/loginestudiante")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Estudiante loginEstudiante(@FormParam(value = "codigo")String codigo,
			@FormParam(value = "cedula") String documento){
		return wsdlEJB.serviciosAcademicos(codigo, documento);
	}
	
}
