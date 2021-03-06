package com.greenone.skills.common;

import java.util.Locale;

public enum Skill {

    MINING,
    FIGHTING,
    AGILITY,
    STRENGTH,
    TRADING,
    FARMING,
    BREEDING,
    FISHING;

    private int level;
    private float experience;

    Skill(){
        this.level = 0;
        this.experience=0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExperience() {
        return this.experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String tagName(){
        return this.name().toLowerCase(Locale.ROOT);
    }
}
