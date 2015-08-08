package me.imodzombies4fun.particle.lib.task;

import com.google.common.base.Preconditions;
import me.imodzombies4fun.particle.lib.api.Particle;

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
public abstract class ParticleTask implements IParticleTask {

      protected Particle particle;

      public ParticleTask(Particle particle) {
            this.particle = particle;
      }

      @Override
      public void preDisplay() {
            Preconditions.checkState(particle.getDisplay().isSupported(), "Particle is not supported on your current version");
      }
}
