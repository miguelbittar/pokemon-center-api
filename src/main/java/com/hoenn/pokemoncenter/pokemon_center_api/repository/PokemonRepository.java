package com.hoenn.pokemoncenter.pokemon_center_api.repository;

import com.hoenn.pokemoncenter.pokemon_center_api.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
