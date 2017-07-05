package net.tnemc.core.common.account;

import com.github.tnerevival.user.IDFinder;
import net.tnemc.core.TNE;
import net.tnemc.core.common.account.history.AccountHistory;
import net.tnemc.core.common.transaction.Transaction;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
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
 * Created by creatorfromhell on 07/01/2017.
 */
public class Account {
  private Map<String, WorldAccount> worlds = new HashMap<>();
  private Map<Location, TrackedItems> trackedItems = new HashMap<>();

  private AccountHistory history;

  private int accountNumber = 0;
  private UUID id;
  private AccountStatus status;
  private String pin;
  private boolean special;
  private String joined;
  private long lastOnline;

  public Account(UUID id) {
    this.id = id;
  }

  public void log(Transaction transaction) {
    history.log(transaction);
  }

  public static Account getAccount(String identifier) {
    return TNE.instance().manager.getAccount(IDFinder.getID(identifier));
  }
}