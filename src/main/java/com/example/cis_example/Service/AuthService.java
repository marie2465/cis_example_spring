package com.example.cis_example.Service;

import com.example.cis_example.entity.UserEntity;
import com.example.cis_example.exception.UserAlreadyExistException;
import com.example.cis_example.model.LoginModel;
import com.example.cis_example.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(authRepository.findByLogin(user.getLogin())!=null){
            throw new UserAlreadyExistException("Пользователь с таким логином уже существует");
        }
        return authRepository.save(user);
    }

    public UserEntity login (LoginModel login) throws UserAlreadyExistException {
        UserEntity user = authRepository.findByLoginAndPassword(login.getLogin(), login.getPassword());
        if(user==null){
            throw new UserAlreadyExistException("Пользователь не найден");
        }
        return user;
    }
}
