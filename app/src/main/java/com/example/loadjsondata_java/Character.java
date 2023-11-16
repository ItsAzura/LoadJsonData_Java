package com.example.loadjsondata_java;

public class Character {
    private int id;
    private String name;
    private String slug;
    private String gender;
    private String birthday;
    private String vision;
    private int rarity;
    private String weapon;
    private String description;
    private String obtain;

    public Character(int id, String name, String slug, String gender, String birthday, String vision, int rarity, String weapon, String description, String obtain) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.gender = gender;
        this.birthday = birthday;
        this.vision = vision;
        this.rarity = rarity;
        this.weapon = weapon;
        this.description = description;
        this.obtain = obtain;
    }
    public Character() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getRarityAsString() {
        return String.valueOf(rarity);
    }

    public String getObtain() {
        return obtain;
    }

    public void setObtain(String obtain) {
        this.obtain = obtain;
    }
}
