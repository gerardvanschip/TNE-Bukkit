package net.tnemc.core.menu.screens.main;

import com.github.tnerevival.menu.icon.impl.ScreenIcon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The New Economy Minecraft Server Plugin
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * Created by Daniel on 7/28/2017.
 */
public class TakeIcon extends ScreenIcon {
  public TakeIcon() {
    super(4, null, "main", "tne.menu.take", "take");

    ItemStack item = new ItemStack(Material.WOOL, 1, (byte)14);
    ItemMeta setMeta = item.getItemMeta();
    setMeta.setDisplayName(ChatColor.WHITE + "Take Funds");
    item.setItemMeta(setMeta);
    this.stack = item;
  }
}