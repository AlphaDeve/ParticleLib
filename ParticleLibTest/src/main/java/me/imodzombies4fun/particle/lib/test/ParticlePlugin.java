package me.imodzombies4fun.particle.lib.test;

import me.imodzombies4fun.particle.lib.api.DisplayPoint;
import me.imodzombies4fun.particle.lib.api.Particle;
import me.imodzombies4fun.particle.lib.task.generic.SpiralTask;
import me.imodzombies4fun.particle.lib.task.timed.ParticleModifier;
import me.imodzombies4fun.particle.lib.task.timed.ParticleScheduler;
import me.imodzombies4fun.particle.lib.view.DisplayFilter;
import me.imodzombies4fun.particle.lib.view.ParticleEngine;
import me.imodzombies4fun.particle.lib.view.ParticleType;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

/**
 * @author Connor
 * @since 8/8/2015
 * <p/>
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ParticlePlugin extends JavaPlugin {

      @Override
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Player player = (Player) sender;

            SpiralTask task = new SpiralTask(Particle.builder()
                    .withType(ParticleType.FLAME)
                    .withLocation(new DisplayPoint(player.getLocation(), DisplayFilter.EVERYONE.filter()))
                    .withSpeed(0.03f)
                    .build()
            );

            task.radius(5);
            task.increment(5);
            task.makeSolid();
            task.delay(3);

            /*
            task.delay(3);
            task.limitedRotations(3);*/

            ParticleScheduler.schedule(task);

            return true;
      }
}
