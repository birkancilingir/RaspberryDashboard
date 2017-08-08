package me.brkn.raspberrydashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	private static HashMap<String, User> credentialRepository = new HashMap<String, User>();

	static {
		BufferedReader reader = null;
		try {
			ClassLoader classLoader = Application.class.getClassLoader();
			File file = new File(classLoader.getResource("credentials").getFile());
			reader = new BufferedReader(new FileReader(file));

			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				if (!currentLine.isEmpty()) {
					String[] credential = currentLine.split(Pattern.quote(ProjectConstants.getDelimiter()));

					if (credential.length == 3) {
						String[] roles = credential[2].split(Pattern.quote(ProjectConstants.getSecondaryDelimiter()));
						User user = new User(credential[0], credential[1], roles);
						credentialRepository.put(user.username, user);
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

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		User user = credentialRepository.get(authentication.getName().toLowerCase());
		if (user != null) {
			if (user.password.equals(authentication.getCredentials())) {
				List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
				for (String role : user.roles) {
					auths.add(new SimpleGrantedAuthority(role));
				}

				return new UsernamePasswordAuthenticationToken(user.username, user.password, auths);
			} else {
				throw new BadCredentialsException("Invalid Password");
			}
		} else {
			throw new UsernameNotFoundException("Unknown Username");
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	private static class User {
		String username;
		String password;
		ArrayList<String> roles;

		public User(String username, String password, String[] roles) {
			this.username = username;
			this.password = password;
			this.roles = new ArrayList<String>();
			for (String role : roles) {
				this.roles.add(role);
			}
		}
	}
}
