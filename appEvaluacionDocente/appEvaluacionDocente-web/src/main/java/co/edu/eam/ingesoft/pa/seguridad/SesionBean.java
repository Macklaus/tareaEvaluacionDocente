/**
 * 
 */
package co.edu.eam.ingesoft.pa.seguridad;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.negocio.bos.BOUsuarioEJB;
import co.edu.eam.ingesoft.negocio.seguridad.SeguridadEJB;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Acceso;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Rol;


/**
 * Entidad encargada de guardar los datos de la sesion 
 * del usuario mientras la sesion perdure
 * @author juansebastian
 *
 */
@Named("SesionBean")
@SessionScoped
public class SesionBean implements Serializable{
	
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SesionBean.class);
	private Usuario usuario;
	private String nombreUsuario;
	private String password;
	
	@EJB
	private SeguridadEJB seguridadEJB;
	
	@EJB
	private BOUsuarioEJB usuarioEJB;
	
	private List<Acceso> accesos;
	private List<Rol> roles;
	
	/**
	 * metodo para verificar los datos del login 
	 * del usuario
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 24/08/2016<br/>
	 * @return
	 */
	public String login(){
		
		Usuario usu = usuarioEJB.buscarUsuarioPorUser(nombreUsuario);
		password = MD5Util.code(password);
		
		if(usu != null && password.equals(usu.getPass())){
			usuario = usu;
			roles = seguridadEJB.listarRolesUsuario(usuario);
			accesos = seguridadEJB.listarAccesosRol(roles);
			FacesMessage mensajeGlobal = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicio de sesión exitoso", null);
			FacesContext.getCurrentInstance().addMessage(null, mensajeGlobal);
			return "/paginas/index.jsf?faces-redirect=true";
		} else {
			usuario = null;
			roles = null;
			accesos = null;
			FacesMessage mensajeGlobal = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o Password incorrecto", null);
			FacesContext.getCurrentInstance().addMessage(null, mensajeGlobal);
			return null;
		}
		
	}
	
	/**
	 * metodo que verifica si el usuario está 
	 * logueado
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 24/08/2016<br/>
	 * @return true, si el usuario está logueado y false si 
	 * no lo está
	 */
	public boolean isLogged(){
		return usuario != null;
	}
	
	/**
	 * metodo que me cierra la sesion y me redirecciona 
	 * a la pagina de LogIn
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 25/08/2016<br/>
	 * @return una cadena con la direccion de la pagina 
	 * LogIn
	 */
	public String logOut(){
		Faces.getSession().invalidate();
		return "/LogIn.jsf?faces-redirect=true";
	}

	/**
	 * @return El atributo accesos
	 */
	public List<Acceso> getAccesos() {
		return accesos;
	}

	/**
	 * Establece el valor del atributo accesos
	 * @param accesos: EL accesos a establecer
	 */
	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	/**
	 * @return El atributo roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * Establece el valor del atributo roles
	 * @param roles: EL roles a establecer
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * @return El atributo usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el valor del atributo usuario
	 * @param usuario: EL usuario a establecer
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return El atributo nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el valor del atributo nombreUsuario
	 * @param nombreUsuario: EL nombreUsuario a establecer
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return El atributo password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece el valor del atributo password
	 * @param password: EL password a establecer
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	/*
	//TODO: Nota:
	 * Para agregar atributos a la sesion
	 * Faces.getSession().setAttribute("usuario", usuario);
	 * 
	 * y para obtenerlo
	 * Usuario us = (Usuario) Faces.getSession().getAttribute("usuario");
	*/
	
}
