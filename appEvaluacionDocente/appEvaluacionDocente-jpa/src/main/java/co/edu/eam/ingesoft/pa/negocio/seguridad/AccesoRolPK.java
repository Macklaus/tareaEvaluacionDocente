/**
 *
 */
package co.edu.eam.ingesoft.pa.negocio.seguridad;

import java.io.Serializable;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/08/2016<br/>
 */
public class AccesoRolPK implements Serializable {
	
	
	private Long acceso;
	
	private Long rol;

	
	
	//Constructor vacio
	public AccesoRolPK() {
		super();
	}

	//Constructor 
	public AccesoRolPK(long acceso, long rol) {
		super();
		this.acceso = acceso;
		this.rol = rol;
	}

	//Accesores y modificadores
	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long acceso) {
		this.acceso = acceso;
	}

	public Long getRol() {
		return rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
	}
		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceso == null) ? 0 : acceso.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccesoRolPK other = (AccesoRolPK) obj;
		if (acceso == null) {
			if (other.acceso != null)
				return false;
		} else if (!acceso.equals(other.acceso))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
	
}
