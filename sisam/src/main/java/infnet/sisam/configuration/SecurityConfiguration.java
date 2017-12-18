package infnet.sisam.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.enumeration.PermissaoEnum;

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/turmas/rest").permitAll()
				.antMatchers("/usuarios/**").hasRole(PermissaoEnum.ROLE_ADMINISTRADOR.getDescricao())
				.antMatchers("/avaliacoes/responder/**").hasRole(PermissaoEnum.ROLE_ALUNO.getDescricao())
				.antMatchers("/cargaInicialBD").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout").permitAll()
			.and()
				.rememberMe()
				.userDetailsService(usuarioDao);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(passwordEncoder);
	}

}
