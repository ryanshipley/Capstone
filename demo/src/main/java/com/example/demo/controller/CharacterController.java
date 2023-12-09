package com.example.demo.controller;

import com.example.demo.model.Character;
import com.example.demo.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

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
    public ModelAndView saveCharacter(
            @RequestParam String name,
            @RequestParam String race,
            @RequestParam String characterClass,
            @RequestParam String description,
            @RequestParam String image,
            @RequestParam int strength,
            @RequestParam int dexterity,
            @RequestParam int constitution,
            @RequestParam int intelligence,
            @RequestParam int wisdom,
            @RequestParam int charisma
    ) {
        Character character = new Character();
        character.setName(name);
        character.setRace(race);
        character.setCharacterClass(characterClass);
        character.setDescription(description);
        character.setImage(image);
        character.setStrength(strength);
        character.setDexterity(dexterity);
        character.setConstitution(constitution);
        character.setIntelligence(intelligence);
        character.setWisdom(wisdom);
        character.setCharisma(charisma);

        // Save the character
        characterRepository.save(character);

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("successMessage", "Character added successfully!");
    

        // Redirect to home page or show a success message
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/all")
    public ModelAndView showAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("all-characters");
        modelAndView.addObject("characters", characters);
        return modelAndView;
}
}