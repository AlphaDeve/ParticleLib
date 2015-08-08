package me.imodzombies4fun.particle.lib.task.timed;

import com.google.common.collect.MapMaker;
import me.imodzombies4fun.particle.lib.ParticleLibPlugin;
import org.bukkit.Bukkit;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

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
public class ParticleScheduler {

      private static ConcurrentMap<ParticleTimedTask, Long> scheduledParticles = new MapMaker()
              .concurrencyLevel(2)
              .makeMap();

      private static int schedulerTaskId;

      public ParticleScheduler() {
            schedulerTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(ParticleLibPlugin.getInstance(), new Runnable() {
                  public void run() {
                        for (Map.Entry<ParticleTimedTask, Long> taskEntries : scheduledParticles.entrySet()) {
                              ParticleTimedTask task = taskEntries.getKey();
                              long scheduledNextTime = taskEntries.getValue();

                              if (scheduledNextTime <= System.currentTimeMillis()) {
                                    scheduledParticles.remove(task);
                                    scheduledParticles.put(task, systemTimeFromTicks(task.delay));

                                    task.preDisplay();
                                    task.display();
                              }
                        }
                  }
            }, 1, 1);
      }

      public static void cancel(ParticleTimedTask task) {
            scheduledParticles.remove(task);
      }

      public static void schedule(ParticleTimedTask task) {
            scheduledParticles.put(task, System.currentTimeMillis());
      }

      private long systemTimeFromTicks(int ticksFromNow) {
            //20 ticks in a second, 1000 millis in a second
            //1000 / 20 = 50 millis in a tick
            return System.currentTimeMillis() + ticksFromNow * (1000 / 20);
      }

      public static void shutdown() {
            Bukkit.getScheduler().cancelTask(schedulerTaskId);
      }
}
