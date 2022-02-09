package br.com.gabriel;

import java.util.Scanner;

import javax.security.auth.login.AccountException;

import br.com.gabriel.entities.Account;
import br.com.gabriel.services.AccountService;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter account data");

		System.out.print("Number: ");
		Integer number = input.nextInt();

		System.out.print("Holder: ");
		String holder = input.next();

		System.out.print("Initial balance: ");
		Double balance = input.nextDouble();

		System.out.print("Withdraw limit: ");
		Double withdrawLimit = input.nextDouble();

		Account account = new Account(number, holder, balance, withdrawLimit);

		System.out.println();

		System.out.print("Enter amount for withdraw: ");
		Double withdraw = input.nextDouble();
		
		AccountService accountService = new AccountService(account);
		
		try {
			accountService.withdraw(withdraw);
		} catch (AccountException e) {
			e.printStackTrace();
		}

		System.out.println(account.getBalance());

	}

}
