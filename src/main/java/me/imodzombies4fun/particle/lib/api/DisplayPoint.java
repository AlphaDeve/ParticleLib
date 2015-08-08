package me.imodzombies4fun.particle.lib.api;

import lombok.Getter;
import lombok.Setter;
import me.imodzombies4fun.particle.lib.view.DisplayFilter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Collection;

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
public class DisplayPoint {

      @Getter
      private World world;

      @Getter
      @Setter
      private Vector location;

      @Getter
      private Collection<? extends Player> players;

      public DisplayPoint(World world) {
            this(world, new Vector(0, 0, 0));
      }

      public DisplayPoint(World world, Vector location) {
            this(world, location, DisplayFilter.EVERYONE.filter(location.toLocation(world)));
      }

      public DisplayPoint(Location location) {
            this(location.getWorld(), location.toVector());
      }

      public DisplayPoint(Location location, Collection<? extends Player>  filter) {
            this(location.getWorld(), location.toVector(), filter);
      }

      public DisplayPoint(World world, Vector location, Collection<? extends Player>  filter) {
            this.world = world;
            this.location = location;
            this.players = filter;
      }

      public Location bukkitLocation() {
            return location.toLocation(world);
      }

      public DisplayPoint clone(Vector next) {
            DisplayPoint newPoint = new DisplayPoint(world, location, players);
            newPoint.location = next;
            return newPoint;
      }
}
