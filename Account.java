public abstract class Account implements HasBalance {
	
	private Person holder;
	private String accountNumber;
	private int balanceInCents; // wird auf 0 initialisiert
	
	public Account(String accountNumber, Person holder) {
		this.accountNumber = accountNumber;
		this.holder = holder;
	}

	public Person getHolder() {
		return holder;
	}

	public void setHolder(Person holder) {
		this.holder = holder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public int getBalanceInCents() {
		return balanceInCents;
	}
	
	public void deposit(int amountInCents) {
		balanceInCents += amountInCents;
	}
	
	public boolean hasPositiveBalance() {
		return balanceInCents > 0;
	}
	
	public void transferTo(Account anotherAccount, int amountInCents) {
		if (this.withdraw(amountInCents)) {
			anotherAccount.deposit(amountInCents);
		}
	}
	
	public boolean withdraw(int amountInCents) {
		if (balanceInCents >= amountInCents) {
			balanceInCents -= amountInCents;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		int euros = balanceInCents / 100;
		int cents = balanceInCents % 100;
		return accountNumber + ": " + String.format("%5d,%02d", euros, cents);
	}
	
}
