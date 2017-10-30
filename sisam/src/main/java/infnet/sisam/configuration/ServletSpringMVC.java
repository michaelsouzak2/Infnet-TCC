package infnet.sisam.configuration;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
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
	
	/**
	 * Definição do mapa de caracteres utilizado pela aplicação.
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("ISO-8859-1");
		return new Filter[] {encodingFilter};
	}
}
