package com.greenone.skills.common.capabilities;

import com.greenone.skills.common.Skill;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class SkillsCap implements ISkillsCap, INBTSerializable<Tag>, ICapabilityProvider {
    private final LazyOptional<ISkillsCap> instance = LazyOptional.of(() -> this);

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
        return null;
    }

    @Override
    public void deserializeNBT(Tag nbt) {

    }

    @Override
    public void levelUp(Skill skill) {

    }

    @Override
    public int getLevel(Skill skill) {
        return 0;
    }

    @Override
    public int getExperience(Skill skill) {
        return 0;
    }

    @Override
    public void addExperience(Skill skill, float modifier) {

    }

    @Override
    public boolean isGood(Skill skill) {
        return false;
    }
}
