package me.imodzombies4fun.particle.lib.view;

import java.util.Arrays;
import java.util.List;

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
public enum ParticleType {

      /**
       * A particle effect which is displayed by exploding tnt and creepers:
       * <ul>
       * <li>It looks like a white cloud
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      EXPLOSION_NORMAL("explode", 0, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by exploding ghast fireballs and wither skulls:
       * <ul>
       * <li>It looks like a gray ball which is fading away
       * <li>The speed value slightly influences the size of this particle effect
       * </ul>
       */
      EXPLOSION_LARGE("largeexplode", 1, -1),
      /**
       * A particle effect which is displayed by exploding tnt and creepers:
       * <ul>
       * <li>It looks like a crowd of gray balls which are fading away
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      EXPLOSION_HUGE("hugeexplosion", 2, -1),
      /**
       * A particle effect which is displayed by launching fireworks:
       * <ul>
       * <li>It looks like a white star which is sparkling
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      FIREWORKS_SPARK("fireworksSpark", 3, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by swimming entities and arrows in water:
       * <ul>
       * <li>It looks like a bubble
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      WATER_BUBBLE("bubble", 4, -1, ParticleEngine.ParticleProperty.DIRECTIONAL, ParticleEngine.ParticleProperty.REQUIRES_WATER),
      /**
       * A particle effect which is displayed by swimming entities and shaking wolves:
       * <ul>
       * <li>It looks like a blue drop
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      WATER_SPLASH("splash", 5, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed on water when fishing:
       * <ul>
       * <li>It looks like a blue droplet
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      WATER_WAKE("wake", 6, 7, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by water:
       * <ul>
       * <li>It looks like a tiny blue square
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      SUSPENDED("suspended", 7, -1, ParticleEngine.ParticleProperty.REQUIRES_WATER),
      /**
       * A particle effect which is displayed by air when close to bedrock and the in the void:
       * <ul>
       * <li>It looks like a tiny gray square
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      SUSPENDED_DEPTH("depthSuspend", 8, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed when landing a critical hit and by arrows:
       * <ul>
       * <li>It looks like a light brown cross
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      CRIT("crit", 9, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed when landing a hit with an enchanted weapon:
       * <ul>
       * <li>It looks like a cyan star
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      CRIT_MAGIC("magicCrit", 10, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by primed tnt, torches, droppers, dispensers, end portals, brewing stands and monster spawners:
       * <ul>
       * <li>It looks like a little gray cloud
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      SMOKE_NORMAL("smoke", 11, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by fire, minecarts with furnace and blazes:
       * <ul>
       * <li>It looks like a large gray cloud
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      SMOKE_LARGE("largesmoke", 12, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed when splash potions or bottles o' enchanting hit something:
       * <ul>
       * <li>It looks like a white swirl
       * <li>The speed value causes the particle to only move upwards when set to 0
       * <li>Only the motion on the y-axis can be controlled, the motion on the x- and z-axis are multiplied by 0.1 when setting the values to 0
       * </ul>
       */
      SPELL("spell", 13, -1),
      /**
       * A particle effect which is displayed when instant splash potions hit something:
       * <ul>
       * <li>It looks like a white cross
       * <li>The speed value causes the particle to only move upwards when set to 0
       * <li>Only the motion on the y-axis can be controlled, the motion on the x- and z-axis are multiplied by 0.1 when setting the values to 0
       * </ul>
       */
      SPELL_INSTANT("instantSpell", 14, -1),
      /**
       * A particle effect which is displayed by entities with active potion effects:
       * <ul>
       * <li>It looks like a colored swirl
       * <li>The speed value causes the particle to be colored black when set to 0
       * <li>The particle color gets lighter when increasing the speed and darker when decreasing the speed
       * </ul>
       */
      SPELL_MOB("mobSpell", 15, -1, ParticleEngine.ParticleProperty.COLOR),
      /**
       * A particle effect which is displayed by entities with active potion effects applied through a beacon:
       * <ul>
       * <li>It looks like a transparent colored swirl
       * <li>The speed value causes the particle to be always colored black when set to 0
       * <li>The particle color gets lighter when increasing the speed and darker when decreasing the speed
       * </ul>
       */
      SPELL_MOB_AMBIENT("mobSpellAmbient", 16, -1, ParticleEngine.ParticleProperty.COLOR),
      /**
       * A particle effect which is displayed by witches:
       * <ul>
       * <li>It looks like a purple cross
       * <li>The speed value causes the particle to only move upwards when set to 0
       * <li>Only the motion on the y-axis can be controlled, the motion on the x- and z-axis are multiplied by 0.1 when setting the values to 0
       * </ul>
       */
      SPELL_WITCH("witchMagic", 17, -1),
      /**
       * A particle effect which is displayed by blocks beneath a water source:
       * <ul>
       * <li>It looks like a blue drip
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      DRIP_WATER("dripWater", 18, -1),
      /**
       * A particle effect which is displayed by blocks beneath a lava source:
       * <ul>
       * <li>It looks like an orange drip
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      DRIP_LAVA("dripLava", 19, -1),
      /**
       * A particle effect which is displayed when attacking a villager in a village:
       * <ul>
       * <li>It looks like a cracked gray heart
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      VILLAGER_ANGRY("angryVillager", 20, -1),
      /**
       * A particle effect which is displayed when using bone meal and trading with a villager in a village:
       * <ul>
       * <li>It looks like a green star
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      VILLAGER_HAPPY("happyVillager", 21, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by mycelium:
       * <ul>
       * <li>It looks like a tiny gray square
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      TOWN_AURA("townaura", 22, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by note blocks:
       * <ul>
       * <li>It looks like a colored note
       * <li>The speed value causes the particle to be colored green when set to 0
       * </ul>
       */
      NOTE("note", 23, -1, ParticleEngine.ParticleProperty.COLOR),
      /**
       * A particle effect which is displayed by nether portals, endermen, ender pearls, eyes of ender, ender chests and dragon eggs:
       * <ul>
       * <li>It looks like a purple cloud
       * <li>The speed value influences the spread of this particle effect
       * </ul>
       */
      PORTAL("portal", 24, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by enchantment tables which are nearby bookshelves:
       * <ul>
       * <li>It looks like a cryptic white letter
       * <li>The speed value influences the spread of this particle effect
       * </ul>
       */
      ENCHANTMENT_TABLE("enchantmenttable", 25, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by torches, active furnaces, magma cubes and monster spawners:
       * <ul>
       * <li>It looks like a tiny flame
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      FLAME("flame", 26, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by lava:
       * <ul>
       * <li>It looks like a spark
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      LAVA("lava", 27, -1),
      /**
       * A particle effect which is currently unused:
       * <ul>
       * <li>It looks like a transparent gray square
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      FOOTSTEP("footstep", 28, -1),
      /**
       * A particle effect which is displayed when a mob dies:
       * <ul>
       * <li>It looks like a large white cloud
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      CLOUD("cloud", 29, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by redstone ore, powered redstone, redstone torches and redstone repeaters:
       * <ul>
       * <li>It looks like a tiny colored cloud
       * <li>The speed value causes the particle to be colored red when set to 0
       * </ul>
       */
      REDSTONE("reddust", 30, -1, ParticleEngine.ParticleProperty.COLOR),
      /**
       * A particle effect which is displayed when snowballs hit a block:
       * <ul>
       * <li>It looks like a little piece with the snowball texture
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      SNOWBALL("snowballpoof", 31, -1),
      /**
       * A particle effect which is currently unused:
       * <ul>
       * <li>It looks like a tiny white cloud
       * <li>The speed value influences the velocity at which the particle flies off
       * </ul>
       */
      SNOW_SHOVEL("snowshovel", 32, -1, ParticleEngine.ParticleProperty.DIRECTIONAL),
      /**
       * A particle effect which is displayed by slimes:
       * <ul>
       * <li>It looks like a tiny part of the slimeball icon
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      SLIME("slime", 33, -1),
      /**
       * A particle effect which is displayed when breeding and taming animals:
       * <ul>
       * <li>It looks like a red heart
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      HEART("heart", 34, -1),
      /**
       * A particle effect which is displayed by barriers:
       * <ul>
       * <li>It looks like a red box with a slash through it
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      BARRIER("barrier", 35, 8),
      /**
       * A particle effect which is displayed when breaking a tool or eggs hit a block:
       * <ul>
       * <li>It looks like a little piece with an item texture
       * </ul>
       */
      ITEM_CRACK("iconcrack", 36, -1, ParticleEngine.ParticleProperty.DIRECTIONAL, ParticleEngine.ParticleProperty.REQUIRES_DATA),
      /**
       * A particle effect which is displayed when breaking blocks or sprinting:
       * <ul>
       * <li>It looks like a little piece with a block texture
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      BLOCK_CRACK("blockcrack", 37, -1, ParticleEngine.ParticleProperty.DIRECTIONAL, ParticleEngine.ParticleProperty.REQUIRES_DATA),
      /**
       * A particle effect which is displayed when falling:
       * <ul>
       * <li>It looks like a little piece with a block texture
       * </ul>
       */
      BLOCK_DUST("blockdust", 38, 7, ParticleEngine.ParticleProperty.DIRECTIONAL, ParticleEngine.ParticleProperty.REQUIRES_DATA),
      /**
       * A particle effect which is displayed when rain hits the ground:
       * <ul>
       * <li>It looks like a blue droplet
       * <li>The speed value has no influence on this particle effect
       * </ul>
       */
      WATER_DROP("droplet", 39, 8),
      /**
       * A particle effect which is currently unused:
       * <ul>
       * <li>It has no visual effect
       * </ul>
       */
      ITEM_TAKE("take", 40, 8),
      /**
       * A particle effect which is displayed by elder guardians:
       * <ul>
       * <li>It looks like the shape of the elder guardian
       * <li>The speed value has no influence on this particle effect
       * <li>The offset values have no influence on this particle effect
       * </ul>
       */
      MOB_APPEARANCE("mobappearance", 41, 8);

      protected final String name;
      protected final int id;
      protected final int requiredVersion;
      protected final List<ParticleEngine.ParticleProperty> properties;

      /**
       * Construct a new particle effect
       *
       * @param name            Name of this particle effect
       * @param id              Id of this particle effect
       * @param requiredVersion Version which is required (1.x)
       * @param properties      Properties of this particle effect
       */
      private ParticleType(String name, int id, int requiredVersion, ParticleEngine.ParticleProperty... properties) {
            this.name = name;
            this.id = id;
            this.requiredVersion = requiredVersion;
            this.properties = Arrays.asList(properties);
      }

      /**
       * Returns the name of this particle effect
       *
       * @return The name
       */
      public String getName() {
            return name;
      }

      /**
       * Returns the id of this particle effect
       *
       * @return The id
       */
      public int getId() {
            return id;
      }

      /**
       * Returns the required version for this particle effect (1.x)
       *
       * @return The required version
       */
      public int getRequiredVersion() {
            return requiredVersion;
      }

      /**
       * Determine if this particle effect has a specific property
       *
       * @return Whether it has the property or not
       */
      public boolean hasProperty(ParticleEngine.ParticleProperty property) {
            return properties.contains(property);
      }

      /**
       * Determine if this particle effect is supported by your current server version
       *
       * @return Whether the particle effect is supported or not
       */
      public boolean isSupported() {
            if (requiredVersion == -1) {
                  return true;
            }
            return ParticleEngine.ParticlePacket.getVersion() >= requiredVersion;
      }
}
