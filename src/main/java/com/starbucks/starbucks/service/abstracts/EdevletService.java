package com.starbucks.starbucks.service.abstracts;

import com.starbucks.starbucks.service.dto.request.CreateUserRequest;

public interface EdevletService {
    boolean checkUserIsReal(CreateUserRequest createUserRequest);
    boolean checkUserWithMernis(CreateUserRequest createUserRequest) throws Exception;
}