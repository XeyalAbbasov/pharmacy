package com.commerce.pharmacy.service;
import java.util.List;
import java.util.Optional;
import com.commerce.pharmacy.model.Authorities;
import com.commerce.pharmacy.model.Product;
import com.commerce.pharmacy.repository.AuthoritiesRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.commerce.pharmacy.converter.UserDtoConverter;
import com.commerce.pharmacy.dto.CreateUserRequest;
import com.commerce.pharmacy.dto.UpdateUserRequest;
import com.commerce.pharmacy.dto.UserDto;
import com.commerce.pharmacy.exception.UserIsNotActiveException;
import com.commerce.pharmacy.exception.UserNotFoundException;
import com.commerce.pharmacy.model.User;
import com.commerce.pharmacy.repository.UserRepository;

@Service
public class UserService {


	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private final UserRepository userRepository;
	private final UserDtoConverter converter;
	private final Authorities authorities;
	private final AuthoritiesRepository authoritiesRepository;

	public UserService(UserRepository userRepository, UserDtoConverter converter, Authorities authorities, AuthoritiesRepository authoritiesRepositoryr) {
		this.userRepository = userRepository;
		this.converter = converter;
		this.authorities = authorities;
		this.authoritiesRepository = authoritiesRepositoryr;
	}

	public Optional<User> getUserById(Integer id) {
		User user = findUserById(id);

		return userRepository.findById(id);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public UserDto createUser(final CreateUserRequest request) {
		User user = new User(	
					request.getEmail(),
					request.getUsername(),
					request.getSurname(),
					request.getAge(),
					request.getPassword());
					user.setIsActive(false);
					user.setEnabled(true);
				Authorities auth=new Authorities();
				auth.setUsername(request.getUsername());
				auth.setAuthority("ROLE_USER");
				user.setPassword(passwordEncoder.encode(request.getPassword()));
				authoritiesRepository.save(auth);
				
		return converter.convert(userRepository.save(user));
	}

	public UserDto updateUser(final UpdateUserRequest updateRequest,final Integer id) {

		User user = findUserById(id);
		if (!user.getIsActive()) {
			throw new UserIsNotActiveException("User is not active for updating! User id:" + id);
		} 
			User updateUser = new User(
					user.getId(),
					user.getEmail(),
					updateRequest.getUsername(),
					updateRequest.getSurname(),
					updateRequest.getAge(),
					user.getIsActive(),
					user.getPassword());
					updateUser.setEnabled(true);

			return converter.convert(userRepository.save(updateUser));

		}
	public void deleteUser(Integer id){
		
		if (doesUserExist(id)) {
			
			userRepository.deleteById(id);	
		}else {
			throw new UserNotFoundException("User couldn't be found by following id:" + id);
		}
	}
	public void activateUser(Integer id) {
		User user = findUserById(id);

		user.setIsActive(true);

		userRepository.save(user);

	}

	public void deactivateUser(Integer id) {
		User user = findUserById(id);

		user.setIsActive(false);

		userRepository.save(user);

	}

	protected User findUserById(Integer id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id:" + id));

	}

	private Boolean doesUserExist(Integer id) {

		return userRepository.existsById(id);
	}

}
