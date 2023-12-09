package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String race;
    private String characterClass;
    private String description;
    private String image;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    public Character() {
        // Default constructor
    }

    public Character(String name, String race, String characterClass, String description, String image, int strength,
                    int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.description = description;
        this.image = image;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStrength(){
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getConstitution(){
        return constitution;
    }

    public void setConstitution(int constitution){
        this.constitution = constitution;
    }

    public int getDexterity(){
        return dexterity;
    }

    public void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }

    public int getIntelligence(){
        return intelligence;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }

    public int getWisdom(){
        return wisdom;
    }

    public void setWisdom(int wisdom){
        this.wisdom = wisdom;
    }

    public int getCharisma(){
        return charisma;
    }

    public void setCharisma(int charisma){
        this.charisma = charisma;
    }

}
