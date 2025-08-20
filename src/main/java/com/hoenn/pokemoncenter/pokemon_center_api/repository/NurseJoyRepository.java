package com.hoenn.pokemoncenter.pokemon_center_api.repository;

import com.hoenn.pokemoncenter.pokemon_center_api.model.NurseJoy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NurseJoyRepository extends JpaRepository<NurseJoy, Long> {
    Optional<NurseJoy> findByUsername(String username);
}