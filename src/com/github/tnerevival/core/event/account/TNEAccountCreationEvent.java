package com.github.tnerevival.core.event.account;

import com.github.tnerevival.account.Account;

import java.util.UUID;

public class TNEAccountCreationEvent extends TNEAccountEvent {

  private Account account;

  public TNEAccountCreationEvent(UUID id, Account account) {
    super(id);
    this.account = account;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}