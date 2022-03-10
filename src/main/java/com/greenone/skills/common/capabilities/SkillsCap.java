package com.greenone.skills.common.capabilities;

import com.greenone.skills.common.Skill;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillsCap implements ISkillsCap, INBTSerializable<Tag>, ICapabilityProvider {
    private final LazyOptional<ISkillsCap> instance = LazyOptional.of(() -> this);
    private final List<Skill> skills = new ArrayList<>();

    public SkillsCap() {
        skills.addAll(Arrays.asList(Skill.values()));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap != CapabilityRegistry.SKILLSCAP){
            return LazyOptional.empty();
        }
        return this.instance.cast();
    }

    @Override
    public Tag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        for(Skill skill : Skill.values()){
            tag.putInt(skill.tagName()+"_level", this.getLevel(skill));
            tag.putFloat(skill.tagName()+"_experience", this.getExperience(skill));
        }
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        CompoundTag tag = (CompoundTag) nbt;
        for(Skill skill : Skill.values()){
            this.setLevel(skill, tag.getInt(skill.tagName()+"_level"));
            this.setExperience(skill, tag.getFloat(skill.tagName()+"_experience"));
        }
    }

    @Override
    public void levelUp(Skill skill) {
        Skill tempSkill = skills.get(skills.indexOf(skill));
        tempSkill.setLevel(tempSkill.getLevel() + 1);
    }

    @Override
    public int getLevel(Skill skill) {
        return skills.get(skills.indexOf(skill)).getLevel();
    }

    @Override
    public void setLevel(Skill skill, int level) {
        skills.get(skills.indexOf(skill)).setLevel(level);
    }

    @Override
    public float getExperience(Skill skill) {
        return skills.get(skills.indexOf(skill)).getExperience();
    }

    @Override
    public void setExperience(Skill skill, float experience) {
        skills.get(skills.indexOf(skill)).setExperience(experience);
    }

    @Override
    public void addExperience(Skill skill, float modifier) {
        Skill tempSkill = skills.get(skills.indexOf(skill));
        tempSkill.setExperience((float) (tempSkill.getExperience() + 0.1 + tempSkill.getExperience() * (0.1/tempSkill.getLevel()) * modifier));
        System.out.println(tempSkill.getExperience());
    }

    @Override
    public boolean isGood(Skill skill) {
        return false;
    }
}
