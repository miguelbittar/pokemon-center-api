package com.hoenn.pokemoncenter.pokemon_center_api.controller;

import com.hoenn.pokemoncenter.pokemon_center_api.model.LoginRequest;
import com.hoenn.pokemoncenter.pokemon_center_api.model.NurseJoy;
import com.hoenn.pokemoncenter.pokemon_center_api.service.AuthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public NurseJoy register(@RequestBody NurseJoy nurseJoy){
        return authService.register(nurseJoy);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

}
