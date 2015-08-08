package me.imodzombies4fun.particle.lib.api;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import me.imodzombies4fun.particle.lib.view.ParticleEngine;
import me.imodzombies4fun.particle.lib.view.ParticleType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import static me.imodzombies4fun.particle.lib.view.ParticleEngine.*;

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
public class Particle {

      @Getter
      @Setter
      private ParticleType display;

      @Getter
      @Setter
      private DisplayPoint location;

      @Getter
      @Setter
      private float offsetX, offsetY, offsetZ;

      @Getter
      @Setter
      private Vector direction;

      @Getter
      @Setter
      private int amount;

      @Getter
      @Setter
      private float speed;

      @Getter
      @Setter
      private ParticleEngine.ParticleData data;

      @Getter
      @Setter
      private ParticleEngine.ParticleColor color;

      private Particle(ParticleType type, DisplayPoint location, float offsetX, float offsetY, float offsetZ,
                       int amount, float speed, Vector direction,ParticleEngine.ParticleData data,
                       ParticleEngine.ParticleColor color) {
            this.display = type;
            this.location = location;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
            this.amount = amount;
            this.speed = speed;
            this.direction = direction;
            this.data = data;
            this.color = color;
      }

      public void send() {
            this.send(this.location);
      }

      public void send(DisplayPoint spot) {
            Location location = spot.bukkitLocation();
            Player[] sendTo = spot.getPlayers().toArray(
                    new Player[spot.getPlayers().size()]);

            if (color != null) {
                  display(display, color, location, sendTo);
                  return;
            }

            if (data != null) {
                  if (direction != null) {
                        display(display, data, direction, speed, location, sendTo);
                        return;
                  } else {
                        display(display, data, offsetX, offsetY, offsetZ, speed, amount, location, sendTo);
                        return;
                  }
            }

            if (direction != null) {
                  display(display, direction, speed, location, sendTo);
                  return;
            }

            display(display, offsetX, offsetY, offsetZ, speed, amount, location, sendTo);
      }

      public static Builder builder() {
            return new Builder();
      }

      public static class Builder {

            private ParticleType type;
            private DisplayPoint location;
            private float offsetX = 0f;
            private float offsetY = 0f;
            private float offsetZ = 0f;
            private int amount = 1;
            private float speed = 1;
            private Vector direction;
            private ParticleEngine.ParticleData data;
            private ParticleEngine.ParticleColor color;

            private Builder() {}

            public Builder withType(ParticleType type) {
                  this.type = type;
                  return this;
            }

            public Builder withLocation(DisplayPoint location) {
                  this.location = location;
                  return this;
            }

            public Builder withOffset(float offsetX, float offsetY, float offsetZ) {
                  this.offsetX = offsetX;
                  this.offsetY = offsetY;
                  this.offsetZ = offsetZ;
                  return this;
            }

            public Builder withAmount(int amount) {
                  this.amount = amount;
                  return this;
            }

            public Builder withData(ParticleEngine.ParticleData data) {
                  this.data = data;
                  return this;
            }

            public Builder withDirection(Vector direction) {
                  this.direction = direction;
                  return this;
            }

            public Builder withSpeed(float speed) {
                  this.speed = speed;
                  return this;
            }

            public Builder withColor(ParticleEngine.ParticleColor color) {
                  this.color = color;
                  return this;
            }

            public Particle build() {
                  Preconditions.checkNotNull(type, "Must have a particle type to display");
                  Preconditions.checkNotNull(location, "Must have a location to display at");
                  return new Particle(type, location, offsetX, offsetY, offsetZ, amount, speed, direction, data, color);
            }
      }
}
