package com.dfsek.bees;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.LimitedRegion;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BeeRandomAccessPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent event) {
        event.getWorld().getPopulators().add(new BlockPopulator() {
            @Override
            public void populate(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull LimitedRegion limitedRegion) {
                for (int i = 0; i < 10; i++) {
                    limitedRegion.spawnEntity(new Location(limitedRegion.getWorld(), (chunkX << 4) + 8, 100 + i, (chunkZ << 4) + 8), EntityType.BEE);
                }
            }
        });
    }
}
