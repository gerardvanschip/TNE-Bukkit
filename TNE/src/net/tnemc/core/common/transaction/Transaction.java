package net.tnemc.core.common.transaction;

import net.tnemc.core.TNE;
import net.tnemc.core.common.account.Account;
import net.tnemc.core.event.transaction.TNETransactionEvent;
import org.bukkit.Bukkit;

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
public class Transaction {

  private UUID uuid;
  private String initiator;
  private String recipient;
  private String world;
  private TransactionCost cost;
  private TransactionType type;

  public Transaction(String initiator, String recipient, String world, TransactionCost cost, TransactionType type) {
    this(TNE.instance().manager().transactionManager().generateTransactionID(), initiator, recipient, world, cost, type);
  }

  public Transaction(UUID id, String initiator, String recipient, String world, TransactionCost cost, TransactionType type) {
    this.uuid = id;
    this.initiator = initiator;
    this.recipient = recipient;
    this.world = world;
    this.cost = cost;
    this.type = type;
  }

  TransactionResult handle() {
    TransactionResult result = type.handle(initiator, recipient, world, cost);
    TNETransactionEvent event = new TNETransactionEvent(this, result);
    Bukkit.getServer().getPluginManager().callEvent(event);
    if(event.getResult().proceed()) {
      setBalances();
    }
    return event.getResult();
  }

  private void setBalances() {
    if(initiator != null) {
      Account initiatorAccount = Account.getAccount(initiator);
      if(initiatorAccount != null) {
        initiatorAccount.setBalance(world, cost.getCurrency().getSingle(), type.initiatorBalance());
      }
    }

    if(recipient != null) {
      Account recipientAccount = Account.getAccount(recipient);
      if(recipientAccount != null) {
        recipientAccount.setBalance(world, cost.getCurrency().getSingle(), type.recipientBalance());
      }
    }
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getInitiator() {
    return initiator;
  }

  public void setInitiator(String initiator) {
    this.initiator = initiator;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getWorld() {
    return world;
  }

  public void setWorld(String world) {
    this.world = world;
  }

  public TransactionCost getCost() {
    return cost;
  }

  public void setCost(TransactionCost cost) {
    this.cost = cost;
  }

  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }
}