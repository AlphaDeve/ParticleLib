package me.imodzombies4fun.particle.lib.view;

import com.google.common.base.Preconditions;
import lombok.Getter;
import me.imodzombies4fun.particle.lib.api.DisplayPoint;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

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
public enum DisplayFilter {

      EVERYONE {
            @Override
            public Collection<? extends Player>  filter(Location display, Object... args) {
                  return Bukkit.getOnlinePlayers();
            }
      },

      RADIUS {
            @Override
            public Collection<? extends Player>  filter(Location display, Object... args) {
                  Preconditions.checkState(args.length > 0, "Required a radius but got nothing");
                  Preconditions.checkState(args[0] instanceof Number, "Radius is not of type number");

                  Number number = (Number) args[0];
                  double radius = number.doubleValue();

                  Collection<Player> filtered = new HashSet<>();

                  for (Player player : display.getWorld().getPlayers()) {
                        if (player.getLocation().distance(display) <= radius) {
                              filtered.add(player);
                        }
                  }

                  return filtered;
            }
      },

      SELECT {
            @Override
            public Collection<? extends Player>  filter(Location display, Object... args) {
                  Preconditions.checkState(args == null || args.length == 0, "Required a collection of players but got nothing");
                  if (args[0] instanceof Collection) {
                        Collection collection = (Collection) args[0];

                        Preconditions.checkState(collection.size() == 0, "Required a collection of players, got an empty collection");
                        Preconditions.checkState(collection.iterator().next() instanceof Player, "Collection is not of type player");

                        return (Collection<Player>) collection;
                  }

                  Collection<Player> filtered = new HashSet<>();

                  for (Object object : args) {
                        Preconditions.checkState(object instanceof Player, "Arguments require a player");
                        filtered.add((Player) object);
                  }

                  return filtered;
            }
      };

      public Collection<? extends Player> filter() {
            return this.filter(null);
      }

      public abstract Collection<? extends Player>  filter(Location display, Object... args);
}
