package com.management.hostel.service;

import com.management.hostel.exception.UserAlreadyPresentException;
import com.management.hostel.exception.UserNotFoundException;
import com.management.hostel.model.UserEntity;
import com.management.hostel.model.dto.response.UserResponse;
import com.management.hostel.model.mapper.UserMapper;
import com.management.hostel.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.management.hostel.model.mapper.UserMapper.toUserResponse;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public UserResponse findUserById(String id) {
		return userRepo.findById(id)
				.stream()
				.map(UserMapper::toUserResponse)
				.findFirst()
				.orElseThrow(() -> new UserNotFoundException(String.format("User '%s' not found", id)));
	}

	public List<UserResponse> findAll() {
		return userRepo.findAll()
				.stream()
				.map(UserMapper::toUserResponse)
				.collect(Collectors.toList());
	}

	public UserResponse loginUser(UserEntity user) {
		return null;
	}

	public UserResponse registerUser(UserEntity user) {
		if(isUserPresent(user.getEmailId())) {
			throw new UserAlreadyPresentException(String.format("User '%s' already exist", user.getEmailId()));
		}
		else {
			userRepo.save(user);
			log.info("User {0} created successfully", user.getEmailId());
			return toUserResponse(user);
		}
	}

	public boolean isUserPresent(String emailId) {
		UserEntity user = userRepo.findById(emailId).orElse(null);
		return user!=null;  //true = user is not null
	}
}
