/**
 *
 */
package co.edu.eam.ingesoft.pa.negocio.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/08/2016<br/>
 */
@Entity
@IdClass(value=UsuarioRolPK.class)
public class UsuarioRol implements Serializable {
	
	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Rol rol;

	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRol() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	

}
