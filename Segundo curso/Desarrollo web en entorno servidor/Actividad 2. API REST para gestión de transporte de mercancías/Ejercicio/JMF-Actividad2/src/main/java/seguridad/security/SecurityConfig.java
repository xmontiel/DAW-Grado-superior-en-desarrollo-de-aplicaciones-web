package seguridad.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;  // ← IMPORTANTE
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.cors(Customizer.withDefaults())
			.authorizeHttpRequests(auth -> auth
				// Rutas públicas
				.requestMatchers("/", "/register").permitAll()
				.requestMatchers("/swagger-ui/**", "/api-docs/**", "/swagger-ui.html").permitAll()
				
				// Rutas de mercancías
				.requestMatchers(HttpMethod.GET, "/mercancias/disponibles").hasAnyRole("EMPRESA", "CONDUCTOR")
				.requestMatchers(HttpMethod.GET, "/mercancias/mis-mercancias").hasRole("CONDUCTOR")
				.requestMatchers(HttpMethod.GET, "/mercancias/buscar/**").hasAnyRole("EMPRESA", "CONDUCTOR")
				.requestMatchers("/mercancias/**").hasRole("EMPRESA")
				
				// Rutas de camiones
				.requestMatchers("/camiones/**").hasRole("CONDUCTOR")
				
				// Rutas de incidencias
				.requestMatchers("/incidencias/**").hasRole("CONDUCTOR")
				
				// Rutas de inscripciones
				.requestMatchers(HttpMethod.POST, "/inscripciones").hasRole("CONDUCTOR")
				.requestMatchers(HttpMethod.PUT, "/inscripciones/**").hasRole("EMPRESA")
				.requestMatchers(HttpMethod.DELETE, "/inscripciones/**").hasRole("EMPRESA")
				.requestMatchers("/inscripciones/**").hasAnyRole("EMPRESA", "CONDUCTOR")
				
				// Cualquier otra petición requiere autenticación
				.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			.formLogin(form -> form.disable());
		
		return http.build();
	}
}