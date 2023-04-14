package com.starbucks.starbucks.service.abstracts;

import com.starbucks.starbucks.service.dto.request.CreateUserRequest;
import com.starbucks.starbucks.service.dto.request.UpdateUserRequest;
import com.starbucks.starbucks.service.dto.response.CreateUserResponse;
import com.starbucks.starbucks.service.dto.response.GetAllUsersResponse;
import com.starbucks.starbucks.service.dto.response.GetUserResponse;
import com.starbucks.starbucks.service.dto.response.UpdateUserResponse;

import java.util.List;

public interface UserService {
 List<GetAllUsersResponse> getALl();
 GetUserResponse getUserById(int id);
 CreateUserResponse saveUser(CreateUserRequest createUserRequest)throws Exception;
 UpdateUserResponse updateUser(int id,UpdateUserRequest updateUserRequest);
 void deleteUser(int id);
}