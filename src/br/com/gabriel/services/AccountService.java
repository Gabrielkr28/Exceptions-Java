package br.com.gabriel.services;

import javax.security.auth.login.AccountException;

import br.com.gabriel.entities.Account;

public class AccountService {

	private Account account;

	public AccountService(Account account) {
		this.account = account;
	}

	public void deposit(Double amount) throws AccountException {
		if(amount <= 0) {
			throw new AccountException("N�o � possivel depositar valor negativo ou zerado.");
		}
		account.setBalance(account.getBalance() + amount);
	}

	public void withdraw(Double amount) throws AccountException {

		if (amount <= account.getWithdrawLimit()) {
			account.setBalance(account.getBalance() - amount);
			return;
		}
		throw new AccountException("N�o � possivel realizar um saque de: " + amount + "\n"
				+ "Limite permitido: " + account.getWithdrawLimit());

	}

}
