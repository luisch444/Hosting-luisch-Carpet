package xyz.luisch444.carpet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(SquidEntity.class)
public class SquidEntityMixin extends WaterCreatureEntity {
    public SquidEntityMixin(EntityType<? extends SquidEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        return !HostingluischSettings.squidsNoSpawn && super.canSpawn(world, spawnReason);
    }
}
