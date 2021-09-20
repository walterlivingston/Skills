package com.greenone.skills.common.capabilities;

import com.greenone.skills.common.Skill;

public interface ISkillsCap {
    void levelUp(Skill skill);
    int getLevel(Skill skill);
    void setLevel(Skill skill, int level);
    float getExperience(Skill skill);
    void setExperience(Skill skill, float experience);
    void addExperience(Skill skill, float modifier);
    boolean isGood(Skill skill);
}
