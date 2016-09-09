package co.edu.eam.ingesoft.negocio.interfaces;

import co.edu.eam.ingesoft.pa.negocio.entidades.Usuario;

public interface IUsuarioEJBRemote extends InterfaceEJBRemote<Usuario>{

	/**
	 * metodo para buscar un usuario por su nombre de usuario 
	 * o username
	 * @author Sebastian Cardona Morales<br/>
	 *         email: krdona-k44@hotmail.com<br/>
	 *         Fecha: 24/08/2016<br/>
	 * @param nameUser, username o nombre usuario del usuario a buscar
	 * @return el usuario que tenga como username la cadena dada
	 */
	public Usuario buscarUsuarioPorUser(String nameUser);
	
}
