package com.starbucks.starbucks.service.concretes;

import com.starbucks.starbucks.entity.User;
import com.starbucks.starbucks.entity.enums.Role;
import com.starbucks.starbucks.exception.EdevletException;
import com.starbucks.starbucks.exception.UserException;
import com.starbucks.starbucks.repository.UserRepository;
import com.starbucks.starbucks.service.abstracts.UserService;
import com.starbucks.starbucks.service.dto.request.CreateUserRequest;
import com.starbucks.starbucks.service.dto.request.UpdateUserRequest;
import com.starbucks.starbucks.service.dto.response.CreateUserResponse;
import com.starbucks.starbucks.service.dto.response.GetAllUsersResponse;
import com.starbucks.starbucks.service.dto.response.GetUserResponse;
import com.starbucks.starbucks.service.dto.response.UpdateUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final EdevletServiceImpl edevletService;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, EdevletServiceImpl edevletService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.edevletService = edevletService;
    }

    @Override
    public List<GetAllUsersResponse> getALl() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, GetAllUsersResponse.class)).toList();
    }

    @Override
    public GetUserResponse getUserById(int id) {
        checkUserIsMember(id);
        User user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user, GetUserResponse.class);
    }

    @Override
    public CreateUserResponse saveUser(CreateUserRequest createUserRequest) throws Exception{
        checkUserExisist(createUserRequest.getIdentityNumber());
        if (checkUserIsReal(createUserRequest)){

            User user=modelMapper.map(createUserRequest, User.class);
            user.setId(0);
            user.setRole(Role.USER);
            User createdUser = userRepository.save(user);
            return modelMapper.map(createdUser, CreateUserResponse.class);
        }else {
            throw new EdevletException("The user is not registered because it is not real");
        }
    }
    @Override
    public UpdateUserResponse updateUser(int id,UpdateUserRequest updateUserRequest) {
        checkUserIsMember(id);
        User user=userRepository.findById(id).orElseThrow();
        user.setRole(updateUserRequest.getRole());
        userRepository.save(user);
        return modelMapper.map(user, UpdateUserResponse.class);
    }

    @Override
    public void deleteUser(int id) {
        checkUserIsMember(id);
        userRepository.deleteById(id);
    }

    ///////////***************++++//////////////
    ////////// !private jobs!    //////////////
    private void checkUserExisist(String identityNumber){
        if (userRepository.existsByIdentityNumber(identityNumber))
            throw new UserException("The user is already a member");
    }
    private boolean checkUserIsReal(CreateUserRequest createUserRequest) throws Exception{
        return edevletService.checkUserWithMernis(createUserRequest);
    }
    private void checkUserIsMember(int id){
        if (!userRepository.existsById(id)) throw new UserException("User not found by this id");
    }
}