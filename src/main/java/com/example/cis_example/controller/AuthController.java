package com.example.cis_example.controller;

import com.example.cis_example.Service.AuthService;
import com.example.cis_example.entity.UserEntity;
import com.example.cis_example.model.LoginModel;
import com.example.cis_example.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth", produces = "application/json;charset=UTF-8")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            authService.registration(user);
            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginModel loginModel){
        try {
            authService.login(loginModel);
            return ResponseEntity.ok("Вы успешно вошли в систему");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getMessage() {
        try {
            return ResponseEntity.ok("OK");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server isn't work");
        }
    }
}
