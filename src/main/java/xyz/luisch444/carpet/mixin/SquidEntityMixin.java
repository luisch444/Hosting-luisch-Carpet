package xyz.luisch444.carpet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.WaterAnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(SquidEntity.class)
public abstract class SquidEntityMixin extends WaterAnimalEntity {
    public SquidEntityMixin(EntityType<? extends SquidEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        return !HostingluischSettings.squidsNoSpawn && super.canSpawn(world, spawnReason);
    }
}
