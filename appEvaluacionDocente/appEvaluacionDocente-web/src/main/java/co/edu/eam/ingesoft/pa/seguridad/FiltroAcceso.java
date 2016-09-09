package co.edu.eam.ingesoft.pa.seguridad;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.eam.ingesoft.pa.negocio.seguridad.Acceso;

/**
 * @author Sebastian Cardona Morales<br/>
 *         email: krdona-k44@hotmail.com<br/>
 *         Fecha: 24/08/2016<br/>
 */
@WebFilter(urlPatterns = "/paginas/*")
public class FiltroAcceso implements Filter{

	@Inject
	private SesionBean sesion;
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FiltroAcceso.class);
	
	@Override
	public void destroy(){
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException{
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) resp;

		String urlCompleta = httpreq.getRequestURI().toString();
		String contextpath = httpreq.getContextPath();

		logger.info("url=" + urlCompleta + ",path=" + contextpath);
		String url = urlCompleta.substring(contextpath.length());

		logger.info("URL a filtrar=" + url);

		// si el usuario ya inicio sesion y la ruta pedida es
		// cualquier otra página diferente al login
		if (sesion.isLogged()) {
			// busca si tiene acceso a la página
			boolean exito = false;
			if (url.equals("/paginas/index.jsf")) {
				exito = true;
			} else {
				// recorre los accesos autorizados
				List<Acceso> accesos = sesion.getAccesos();

				for (Acceso acceso : accesos) {
					// si está en la lista de accesos autorizados
					if (acceso.getUrl().equals(url)) {
						exito = true;
					}
				}
			}
			// si no está en la lista de accesos, lo redirije
			// a la pagina index o inicio.
			if (!exito) {
				httpresp.sendRedirect(httpreq.getContextPath() + "/paginas/index.jsf");
			} else {
				// continua con la peticion
				chain.doFilter(request, resp);
			}
		} else {
			// no está en sesion, lo redirije a la pagina logIn
			httpresp.sendRedirect(httpreq.getContextPath() + "/LogIn.jsf");
		}
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
