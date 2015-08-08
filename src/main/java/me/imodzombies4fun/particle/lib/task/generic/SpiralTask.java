package me.imodzombies4fun.particle.lib.task.generic;

import me.imodzombies4fun.particle.lib.api.DisplayPoint;
import me.imodzombies4fun.particle.lib.api.Particle;
import me.imodzombies4fun.particle.lib.task.timed.ParticleScheduler;
import me.imodzombies4fun.particle.lib.task.timed.ParticleTimedTask;
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
public class SpiralTask extends ParticleTimedTask {

      private double currentAngle = 0;

      private boolean solid = false;

      private int radius = 1;
      private int increment = 10;

      private int limitedRotations = 0;

      public SpiralTask(Particle particle) {
            super(particle);
      }

      public void radius(int radius) {
            this.radius = radius;
      }

      public void increment(int increment) {
            this.increment = increment;
      }

      public void limitedRotations(int rotations) {
            this.limitedRotations = rotations;
      }

      public void makeSolid() {
            this.solid = true;
      }

      @Override
      public void run() {
            if (solid) {
                  for (int deg = 0; deg < 360; deg += increment) {
                        double cos = Math.cos(Math.toRadians(deg));
                        double sin = Math.sin(Math.toRadians(deg));

                        DisplayPoint point = modify(cos * radius, 0, sin * radius);
                        particle.send(point);
                  }

                  if (currentAngle >= limitedRotations && limitedRotations != 0) {
                        ParticleScheduler.cancel(this);
                  }
            } else {
                  double cos = Math.cos(Math.toRadians(currentAngle));
                  double sin = Math.sin(Math.toRadians(currentAngle));

                  DisplayPoint point = modify(cos * radius, 0, sin * radius);
                  particle.send(point);

                  currentAngle += increment;

                  if (currentAngle >= 360) {
                        currentAngle -= 360;
                        --limitedRotations;
                  }

                  if (limitedRotations <= 0) {
                        ParticleScheduler.cancel(this);
                  }
            }
      }

      private DisplayPoint modify(double x, double y, double z) {
            Vector origin = particle.getLocation().getLocation();
            Vector next = new Vector(origin.getX() + x, origin.getY() + y, origin.getZ() + z);
            DisplayPoint point = particle.getLocation().clone(next);
            return point;
      }
}
