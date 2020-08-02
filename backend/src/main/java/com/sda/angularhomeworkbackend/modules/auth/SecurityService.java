package com.sda.angularhomeworkbackend.modules.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sda.angularhomeworkbackend.modules.users.User;
import com.sda.angularhomeworkbackend.modules.users.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService implements UserDetailsService {

	@Value("${app.authentication.signature.secret}")
	private String SECRET;

	@Value("${app.authentication.validity.period}")
	private int VALIDITY;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findOneByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User \"%s\" not found", email));
		}
		return user;
	}

	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(user.getId() + "")
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
				   .signWith(SignatureAlgorithm.HS512, SECRET)
				   .compact();
	}

	public long getUserId() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return Long.parseLong((String)authentication.getPrincipal());
	}
}
