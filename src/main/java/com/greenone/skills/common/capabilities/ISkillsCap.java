package com.greenone.skills.common.capabilities;

import com.greenone.skills.common.Skill;

public interface ISkillsCap {
    void levelUp(Skill skill);
    int getLevel(Skill skill);
    int getExperience(Skill skill);
    void addExperience(Skill skill, float modifier);
    boolean isGood(Skill skill);
}
