package com.greenone.skills.common;

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
    private int experience;

    Skill(){
        level = 0;
        experience=0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
