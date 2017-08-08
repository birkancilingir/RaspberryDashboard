package me.brkn.raspberrydashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CustomWebSecurityConfigurer.class);

	private static ArrayList<String> allowedUrlsForUsers = new ArrayList<String>();
	private static ArrayList<String> allowedUrlsForAdmins = new ArrayList<String>();

	static {
		BufferedReader reader = null;
		try {
			ClassLoader classLoader = Application.class.getClassLoader();
			File file = new File(classLoader.getResource("allowed-pages").getFile());
			reader = new BufferedReader(new FileReader(file));

			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				if (!currentLine.isEmpty()) {
					String[] allowedPage = currentLine.split(Pattern.quote(ProjectConstants.getDelimiter()));

					if (allowedPage.length == 2) {
						String[] roles = allowedPage[1].split(Pattern.quote(ProjectConstants.getSecondaryDelimiter()));

						for (String role : roles) {
							if (role.equals(ProjectConstants.getRoleUser()))
								allowedUrlsForUsers.add(allowedPage[0]);
							if (role.equals(ProjectConstants.getRoleAdmin()))
								allowedUrlsForAdmins.add(allowedPage[0]);
						}
					}
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().and().authorizeRequests()
				.antMatchers(allowedUrlsForAdmins.toArray(new String[0])).hasRole("ADMIN")
				.antMatchers(allowedUrlsForUsers.toArray(new String[0])).hasRole("USER").anyRequest().authenticated()
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").permitAll().and().logout()
				.logoutUrl("/logout").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthenticationProvider());
	}

}
