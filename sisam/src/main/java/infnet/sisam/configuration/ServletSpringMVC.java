package infnet.sisam.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Servlet do SpringMVC.
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Mapeamento das classes de configuração.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}
	
	/**
	 * Atende as requisições a partir de "/".
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
