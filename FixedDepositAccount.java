
public class FixedDepositAccount extends SavingsAccount {
	
	// Strafgebuehr fuer fruehzeitiges Abheben
	private int earlyTerminationFine = 1000;
	// Mindestlaufzeit
	private int remainingYears = 5;

	
	public FixedDepositAccount(String accountNumber, Person holder, double interestRate) {
		super(accountNumber, holder, interestRate);		
	}
	
	@Override
	public boolean withdraw(int amountInCents) {
		int totalAmount = amountInCents;
		if (remainingYears > 0) {
			totalAmount += earlyTerminationFine;
		}
		return super.withdraw(totalAmount);
	}
	
	@Override
	public void creditInterest() {
		if (remainingYears > 0) {
			--remainingYears;
		}
		super.creditInterest();
	}
}
