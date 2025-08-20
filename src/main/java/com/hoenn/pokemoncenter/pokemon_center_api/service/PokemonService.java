package com.hoenn.pokemoncenter.pokemon_center_api.service;

import com.hoenn.pokemoncenter.pokemon_center_api.model.Pokemon;
import com.hoenn.pokemoncenter.pokemon_center_api.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> listAll(){
        return pokemonRepository.findAll();
    }

    public Pokemon admitPokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public void releasePokemon(Long id){
        pokemonRepository.deleteById(id);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        if(pokemonRepository.existsById(id)) {
            pokemon.setId(id);
            return pokemonRepository.save(pokemon);
        }
        throw new RuntimeException("Nurse Joy couldn't find this Pokemon in our records!");
    }

    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

}
