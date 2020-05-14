package cuncurrency.challenge;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private Lock lock;
	private double balance;
	private String accountNumber;
	
	public BankAccount( double balance, String accountNumber ) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		lock = new ReentrantLock();
	}
	
	public void deposit( double amount ) {
		boolean status = false;
		try {
			if ( lock.tryLock( 1000, TimeUnit.MILLISECONDS) ) {
				try {
					balance += amount;
					System.out.println( Thread.currentThread().getName() + " depositou " +amount+ " e saldo e: " + getBalance() );
					status = true;
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println( Thread.currentThread().getName() + " nao conseguiu pegar a chave da conta");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O estado da tranzacao e: " +status);
	}
	
	public void withdraw( double amount ) {
		boolean status = false;
		try {
			if ( lock.tryLock( 1000, TimeUnit.MILLISECONDS) ) {
				try {
					balance -= amount;
					System.out.println( Thread.currentThread().getName() + " levantou " +amount+ " e saldo e: " + getBalance() );
					status = true;
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println( Thread.currentThread().getName() + " nao conseguiu pegar a chave da conta");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O estado da tranzacao e: " +status);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void printAccountNumber() {
		System.out.println( "Account number = " +accountNumber );
	}
	
}


