package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa.negocio.entidades.Pregeval;

@Stateless
public class BOPregevalEJB extends EJBGenerico<Pregeval>{

	@Override
	public void crear(Pregeval entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pregeval buscar(Object pk) {
		return null;
	}

	@Override
	public void editar(Pregeval entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Pregeval entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getClase() {
		return Pregeval.class;
	}

}
