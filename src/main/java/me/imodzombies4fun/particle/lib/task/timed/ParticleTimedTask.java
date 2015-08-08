package me.imodzombies4fun.particle.lib.task.timed;

import me.imodzombies4fun.particle.lib.api.Particle;
import me.imodzombies4fun.particle.lib.task.ParticleTask;

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
public abstract class ParticleTimedTask extends ParticleTask {

      protected int delay;
      protected int currentIteration;
      protected ParticleModifier modifier;

      public ParticleTimedTask(Particle particle) {
            super(particle);
      }

      public void delay(int delay) {
            this.delay = delay;
      }

      @Override
      public void display() {
            if (modifier != null) {
                  modifier.modify(currentIteration, particle);
            }

            run();
            ++currentIteration;
      }

      public abstract void run();

      public void modifier(ParticleModifier modifier) {
            this.modifier = modifier;
      }
}
