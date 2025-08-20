package com.hoenn.pokemoncenter.pokemon_center_api.service;

import com.hoenn.pokemoncenter.pokemon_center_api.model.NurseJoy;
import com.hoenn.pokemoncenter.pokemon_center_api.repository.NurseJoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final NurseJoyRepository nurseJoyRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(NurseJoyRepository nurseJoyRepository, PasswordEncoder passwordEncoder){
        this.nurseJoyRepository = nurseJoyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public NurseJoy register(NurseJoy nurseJoy){
        nurseJoy.setPassword(passwordEncoder.encode(nurseJoy.getPassword()));
        return nurseJoyRepository.save(nurseJoy);
    }

    public String login(String username, String password){
        Optional<NurseJoy> nurseJoyOpt = nurseJoyRepository.findByUsername(username);

        if(nurseJoyOpt.isEmpty()){
            throw new RuntimeException("Nurse Joy not found!");
        }

        NurseJoy nurseJoy = nurseJoyOpt.get();

        if(!passwordEncoder.matches(password, nurseJoy.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

            return "JWT_TOKEN_NURSE_JOY";
        }

}
