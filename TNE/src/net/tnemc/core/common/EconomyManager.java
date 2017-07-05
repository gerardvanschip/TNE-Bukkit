package net.tnemc.core.common;

import net.tnemc.core.common.account.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
 * Created by creatorfromhell on 06/30/2017.
 */
public class EconomyManager {

  private Map<UUID, Account> accounts = new HashMap<>();

  private CurrencyManager currencyManager;

  public EconomyManager() {
    currencyManager = new CurrencyManager();
  }

  public CurrencyManager getCurrencyManager() {
    return currencyManager;
  }

  public boolean exists(UUID id) {
    return accounts.containsKey(id);
  }

  public Account getAccount(UUID id) {
    if(!exists(id)) {
      Account account = new Account(id);
      accounts.put(id, account);
      return account;
    }
    return accounts.get(id);
  }
}