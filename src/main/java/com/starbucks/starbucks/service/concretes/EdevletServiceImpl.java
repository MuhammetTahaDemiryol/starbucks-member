package com.starbucks.starbucks.service.concretes;


import com.starbucks.starbucks.adapter.EDUKPSPublicSoap;
import com.starbucks.starbucks.repository.EdevletRepository;
import com.starbucks.starbucks.service.abstracts.EdevletService;
import com.starbucks.starbucks.service.dto.request.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class EdevletServiceImpl implements EdevletService  {
    private final EdevletRepository edevletRepository;
    private final EDUKPSPublicSoap qbgkpsPublicSoap;

    public EdevletServiceImpl(EdevletRepository edevletRepository, EDUKPSPublicSoap qbgkpsPublicSoap) {
        this.edevletRepository = edevletRepository;
        this.qbgkpsPublicSoap = qbgkpsPublicSoap;
    }
    @Override
    public boolean checkUserIsReal(CreateUserRequest createUserRequest) {
        return edevletRepository.existsByNameAndSurnameAndIdentityNumberAndBirthDay(createUserRequest.getName()
                , createUserRequest.getSurname()
                , createUserRequest.getIdentityNumber(),createUserRequest.getBirthDay());
    }
    @Override
    public boolean checkUserWithMernis(CreateUserRequest createUserRequest) throws Exception{
        return qbgkpsPublicSoap.TCKimlikNoDogrula(Long.valueOf(createUserRequest.getIdentityNumber()),
                createUserRequest.getName().toUpperCase()
                ,createUserRequest.getSurname(),createUserRequest.getBirthDay().getYear());
    }
}