/**
 *
 */
package co.edu.eam.ingesoft.negocio.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Acceso;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Rol;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/08/2016<br/>
 */
@LocalBean
@Stateless
public class SeguridadEJB extends EJBGenerico<Usuario>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Rol> listarRolesUsuario(Usuario usuario){
		return dao.ejecutarNamedQuery(Rol.LISTA_ROLES_POR_USUARIOS, usuario);
	}
	
	
	
	public List<Acceso> listarAccesosRol (List<Rol> roles){
		List <Acceso> accesos = new ArrayList<Acceso>();
			for(Rol r : roles){
				List<Acceso> accesos2 = dao.ejecutarNamedQuery(Acceso.LISTAR_ACCESOS_POR_ROL, roles);
				for (Acceso ac : accesos2) {
					accesos.add(ac);
				}
			}
			return accesos;
	}
}