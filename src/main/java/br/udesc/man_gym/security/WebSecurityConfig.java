package br.udesc.man_gym.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/resources/**").permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/cliente.jsf","/cliente.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/medidas.jsf","/medidas.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/dobracutanea.jsf","/dobracutanea.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/administracao.jsf","/administracao.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/avaliacaodobrascutaneas.jsf","/avaliacaodobrascutaneas.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/avaliacaofisica.jsf","/avaliacaofisica.xhtml").hasAnyRole("ADMIN")
				.requestMatchers("/mensalidade.jsf","/mensalidade.xhtml").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
			)
			.csrf(csrf -> csrf.disable())
			.formLogin(formLogin -> formLogin
				.loginPage("/login")
				.defaultSuccessUrl("/inicio")
				.permitAll()
			)
			.logout(logout -> logout
            	.permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/inicio")
			);
		
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN", "ALUNO")
				.build(),
			User.withUsername("aluno")
				.password(passwordEncoder().encode("aluno"))
				.roles("ALUNO")
				.build()
		);
	}

}
