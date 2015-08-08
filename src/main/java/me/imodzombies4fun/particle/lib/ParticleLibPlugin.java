package me.imodzombies4fun.particle.lib;

import lombok.Getter;
import me.imodzombies4fun.particle.lib.task.timed.ParticleScheduler;
import org.bukkit.plugin.java.JavaPlugin;

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
public class ParticleLibPlugin extends JavaPlugin {

      @Getter
      private static ParticleLibPlugin instance;

      @Getter
      private ParticleScheduler particleScheduler;

      @Override
      public void onEnable() {
            instance = this;
            particleScheduler = new ParticleScheduler();
      }

      @Override
      public void onDisable() {
            particleScheduler.shutdown();
      }
}
