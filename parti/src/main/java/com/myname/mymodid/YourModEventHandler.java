package com.myname.mymodid;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class YourModEventHandler {

    @SubscribeEvent
    public static void onPlayerAttack(LivingAttackEvent event) {
        if (!YourModConfig.isParticleEnabled) return;

        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            World world = player.world;

            if (world.isRemote) {
                double x = event.getEntity().posX;
                double y = event.getEntity().posY + 0.4;
                double z = event.getEntity().posZ;

                int particleCount = (int) (10 * YourModConfig.particleMultiplier);

                if (YourModConfig.effectMode == 2) {
                    particleCount = 1;
                } else if (YourModConfig.effectMode == 3 || YourModConfig.effectMode == 1) {
                    particleCount = (int) (20 * YourModConfig.particleMultiplier);
                }

                for (int i = 0; i < particleCount; i++) {
                    double px = x + (world.rand.nextDouble() - 0.5) * 1.6;
                    double py = y + world.rand.nextDouble() * 1.5;
                    double pz = z + (world.rand.nextDouble() - 0.5) * 1.6;

                    double vx = (world.rand.nextDouble() - 0.5) * 1.4;
                    double vy = 0.1 + world.rand.nextDouble() * 0.7;
                    double vz = (world.rand.nextDouble() - 0.5) * 1.4;


                    switch (YourModConfig.effectMode) {
                        case 0:
                            world.spawnParticle(EnumParticleTypes.CRIT_MAGIC,
                                    px, py, pz,
                                    vx, vy, vz);
                            break;

                        case 1:
                            int redstoneBlockId = Block.getStateId(Blocks.REDSTONE_WIRE.getDefaultState());
                            world.spawnParticle(EnumParticleTypes.BLOCK_CRACK,
                                    px, py, pz,
                                    vx, vy, vz, redstoneBlockId);
                            break;

                        case 2:
                            double slashYOffset = 0.8;
                            world.spawnParticle(EnumParticleTypes.SWEEP_ATTACK,
                                    px, py + slashYOffset, pz,
                                    vx, vy, vz);
                            break;

                        case 3:
                            int endStoneBlockId = Block.getStateId(Blocks.END_STONE.getDefaultState());
                            world.spawnParticle(EnumParticleTypes.BLOCK_CRACK,
                                    px, py, pz,
                                    vx, vy, vz, endStoneBlockId);
                            break;
                    }
                }
            }
        }
    }
}
