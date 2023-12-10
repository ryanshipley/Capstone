package com.example.demo.controller;

import com.example.demo.model.Character;
import com.example.demo.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/create")
    public ModelAndView showCreateCharacterForm() {
        return new ModelAndView("create-character");
    }

    @PostMapping("/save")
    public String saveCharacter(@ModelAttribute Character character) {
        if (character.getId() == null) {
            // If the character ID is null, it's a new character, so save it
            characterRepository.save(character);
        } else {
            // If the character ID is not null, it's an existing character, so update it
            Optional<Character> existingCharacter = characterRepository.findById(character.getId());
            existingCharacter.ifPresent(updatedCharacter -> {
                // Update the existing character with the new data
                updatedCharacter.setName(character.getName());
                updatedCharacter.setRace(character.getRace());
                updatedCharacter.setCharacterClass(character.getCharacterClass());
                updatedCharacter.setDescription(character.getDescription());
                updatedCharacter.setImage(character.getImage());
                updatedCharacter.setStrength(character.getStrength());
                updatedCharacter.setDexterity(character.getDexterity());
                updatedCharacter.setConstitution(character.getConstitution());
                updatedCharacter.setIntelligence(character.getIntelligence());
                updatedCharacter.setWisdom(character.getWisdom());
                updatedCharacter.setCharisma(character.getCharisma());
            

                // Save the updated character
                characterRepository.save(updatedCharacter);
            });
        }

        return "redirect:/characters/details/" + character.getId();
    }

    @GetMapping("/all")
    public String getAllCharacters(Model model) {
        List<Character> characters = characterRepository.findAll();
        model.addAttribute("characters", characters);
        return "all-characters";
    }

    @GetMapping("/details/{id}")
    public String viewCharacterDetails(@PathVariable Long id, Model model) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (optionalCharacter.isPresent()) {
            Character character = optionalCharacter.get();
            model.addAttribute("character", character);
            return "character-details";
        } else {
            return "redirect:/characters/all";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCharacter(@PathVariable Long id, Model model) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (optionalCharacter.isPresent()) {
            Character character = optionalCharacter.get();
            model.addAttribute("character", character);
            return "edit-character";
        } else {
            return "redirect:/characters/all";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id) {
            characterRepository.deleteById(id);
            return "redirect:/characters/all";
    }

}