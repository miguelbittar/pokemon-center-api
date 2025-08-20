package com.hoenn.pokemoncenter.pokemon_center_api.controller;

import com.hoenn.pokemoncenter.pokemon_center_api.model.Pokemon;
import com.hoenn.pokemoncenter.pokemon_center_api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> listAll(){
        return pokemonService.listAll();
    }

    @GetMapping("/{id}")
    public Pokemon findById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.findById(id);
        if (pokemon.isPresent()){
            return pokemon.get();
        } else {
            throw new RuntimeException("Nurse Joy couldn't find this Pokemon!");
        }
    }

    @PostMapping
    public Pokemon admitPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.admitPokemon(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.updatePokemon(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void releasePokemon(@PathVariable Long id) {
        pokemonService.releasePokemon(id);
    }

}
