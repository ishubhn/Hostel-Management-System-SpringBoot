package com.management.hostel.model.mapper;

import com.management.hostel.model.UserEntity;
import com.management.hostel.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	public static UserResponse toUserResponse(UserEntity user) {
		return new UserResponse(user.getFirstName(), user.getLastName(), user.getGender(), user.getPhoneNumber(),
				user.getEmailId(),user.getDateOfBirth(), user.getPermanentAddress());
	}
}
