package co.edu.eam.ingesoft.negocio.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.negocio.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa.negocio.entidades.Resppreg;

@Stateless
@LocalBean
public class BOResppregEJB extends EJBGenerico<Resppreg>{

	@Override
	public Class getClase() {
		return Resppreg.class;
	}

}
