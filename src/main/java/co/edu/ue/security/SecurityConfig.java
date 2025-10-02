package co.edu.ue.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users = List.of(User.withUsername("client").password("{noop}12345").roles("USER").build(),
				User.withUsername("admin").password("{noop}123456").roles("ADMIN").build());
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cus -> cus.disable())
			.cors(cors -> cors.configurationSource(request -> {
				var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
				corsConfiguration.setAllowedOriginPatterns(List.of(
					"http://127.0.0.1:*",
					"http://localhost:*"
				));
				corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
				corsConfiguration.setAllowedHeaders(List.of("*"));
				corsConfiguration.setAllowCredentials(true);
				corsConfiguration.setExposedHeaders(List.of("*"));
				return corsConfiguration;
			}))
			.authorizeHttpRequests(auth -> auth

				// Permitir acceso a Swagger
				.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**").permitAll()

				// Permitir registro de donantes y receptores (públicos)
				.requestMatchers(HttpMethod.POST, "/donantes/crear").permitAll()
				.requestMatchers(HttpMethod.POST, "/receptor/crear").permitAll()
				
				// Permitir consulta de donantes y receptores (públicos para explorar)
				.requestMatchers(HttpMethod.GET, "/donantes").permitAll()
				.requestMatchers(HttpMethod.GET, "/donantes/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/receptor").permitAll()
				.requestMatchers(HttpMethod.GET, "/receptor/{id}").permitAll()
				
				// Permitir consulta de proyectos (públicos para explorar)
				.requestMatchers(HttpMethod.GET, "/proyecto").permitAll()
				.requestMatchers(HttpMethod.GET, "/proyecto/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/proyecto/receptor/{id}").permitAll()
				
				// Permitir operaciones de donaciones (públicas para hacer donaciones)
				.requestMatchers(HttpMethod.POST, "/api/donaciones").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/donaciones").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/donaciones/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/donaciones/donante/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/donaciones/receptor/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/donaciones/estado/{estado}").permitAll()

				// Rutas administrativas que requieren autenticación
				.requestMatchers(HttpMethod.PUT, "/donantes/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/donantes/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/receptor/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/receptor/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/proyecto/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/proyecto/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/proyecto/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/donaciones/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/donaciones/**").hasRole("ADMIN")

				// Cualquier otra solicitud requiere autenticación
				.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.formLogin(login -> login.permitAll());
		return http.build();
	}
}// Fin de la clase SecurityConfig