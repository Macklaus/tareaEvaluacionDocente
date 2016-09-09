/**
 *
 */
package co.edu.eam.ingesoft.pa.negocio.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/08/2016<br/>
 */
@Entity
@IdClass(value=AccesoRolPK.class)
public class AccesoRol implements Serializable{
	
	@Id
	@ManyToOne
	private Rol rol;
	
	@Id
	@ManyToOne
	private Acceso acceso;

	public AccesoRol() {
		super();
	}

	//Constructor
	public AccesoRol(Rol rol, Acceso acceso) {
		super();
		this.rol = rol;
		this.acceso = acceso;
	}

	//Accesores y modificadores
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	
	
}
