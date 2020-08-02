package com.sda.angularhomeworkbackend.modules.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(rollbackFor = Exception.class)
	public User save(final UserTO user) {
		final User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(userEntity);
	}
}
