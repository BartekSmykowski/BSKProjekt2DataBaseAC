package edu.bsk.confguration;

import edu.bsk.security.LoginPasswordRoleAuthenticationFilter;
import edu.bsk.security.RoleAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	@CustomAuthentication
	private UserDetailsService userDetailsService;

    @Bean
    public RoleAuthenticationProvider roleAuthenticationProvider(){
    	return new RoleAuthenticationProvider();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(roleAuthenticationProvider());
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new FakePasswordEncoder();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.debug(true);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception  
	{ 
        http
			.addFilterAfter(authenticationFilter(),
					UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
				.antMatchers("/authentication/login/**", "/javax.faces.resource/**").permitAll()
                .anyRequest().authenticated()
            .and()
            	.formLogin().loginPage("/authentication/login")
            .and()
                .logout().logoutSuccessUrl("/")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
            .and()
            	.csrf().disable()
            .exceptionHandling()
            .and()
            	.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false);
	}

	@Bean
	public LoginPasswordRoleAuthenticationFilter authenticationFilter() throws Exception {
		LoginPasswordRoleAuthenticationFilter filter
				= new LoginPasswordRoleAuthenticationFilter();
		filter.setFilterProcessesUrl("/authentication/login/process");
		filter.setAuthenticationFailureHandler(failureHandler());
		filter.setAuthenticationSuccessHandler(successHandler());
		filter.setAuthenticationManager(authenticationManager());
		return filter;
	}

	@Bean
	public AuthenticationManager authenticationManager(){
		return new ProviderManager(Collections.singletonList(roleAuthenticationProvider()));
	}

	public SimpleUrlAuthenticationFailureHandler failureHandler() {
		return new SimpleUrlAuthenticationFailureHandler("/authentication/login?error=true");
	}

	public SimpleUrlAuthenticationSuccessHandler successHandler(){
		SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler("/");
		handler.setAlwaysUseDefaultTargetUrl(true);
		return handler;
	}
}