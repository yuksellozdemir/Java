
public class SavingsAccount extends Account {
	
	private double interestRate;
	
	public SavingsAccount(String accountNumber, Person holder, double interestRate) {
		super(accountNumber, holder);
		this.interestRate = interestRate;
		// 500 cents werden für neue Konten verschenkt
		deposit(500);
	}
	
	public void creditInterest() {
		deposit((int)(getBalanceInCents() * interestRate / 100));
	}

}
