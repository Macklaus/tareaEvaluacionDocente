/**
 *
 */
package co.edu.eam.ingesoft.pa.interceptores;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.negocio.excepcion.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa.negocio.seguridad.Rol;
import co.edu.eam.ingesoft.pa.seguridad.SesionBean;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 25/08/2016<br/>
 */
@Interceptor
@Secured
public class SecurityInterceptor implements Serializable{

	private static Logger log = Logger.getLogger(SecurityInterceptor.class);
	
	@Inject
	private SesionBean sesion;

	@AroundInvoke
	public Object interceptar(InvocationContext ctx) throws Exception {
		// verificar que el metodo que se invoca este anotado
		if (ctx.getMethod().isAnnotationPresent(Secured.class)) {
			if (sesion.isLogged()) {
				Secured sec = ctx.getMethod().getAnnotation(Secured.class);
				String rol = sec.rol();
				boolean autorizado = false;

				List<Rol> roles = sesion.getRoles();
				for (Rol r : roles) {
					if (r.getDescripcion().equals(rol)) {
						autorizado = true;
					}
				}

				if (autorizado) {
					Object res = ctx.proceed();
					return res;
				} else {
					throw new ExcepcionFuncional("No está autorizado para " + "realizar esa acción");
				}
			} else {
				throw new ExcepcionFuncional("No está autorizado para " + "realizar esa acción");
			}
		} else {
			Object res = ctx.proceed();
			return res;
		}
	}

}
