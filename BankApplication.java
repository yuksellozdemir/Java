public class BankApplication {
	public static void main(String[] args) {
		Person p1 = new Person("Max", "Mustermann");
		Person p2 = new Person("Martina", "Musterfrau");
		
		Account[] accounts = new Account[2];
		
		accounts[0] = new CheckingAccount("DE123456", p1, 10);
		accounts[1] = new FixedDepositAccount("DE654321", p2, 3.8);
		
		StockPortfolio stockPortfolio = new StockPortfolio();
		printAllBalances(accounts[0], stockPortfolio);
		
		System.out.println(accounts[1]);
		
		accounts[0].deposit(200);
		accounts[1].deposit(50000);
		
		System.out.println(accounts[1]);
		for (int i=0; i<50; i++) {
			creditAllInterests(accounts);
		}
		System.out.println(accounts[1]);

		System.out.println();
		boolean erfolgreich = accounts[1].withdraw(150);
		if (!erfolgreich) {
			System.out.println("Abheben nicht möglich, zu wenig Guthaben!");
		} else {
			System.out.println("150 Cent erfolgreich abgehoben.");
		}
		
		System.out.println("Kontohalter Konto 1: " + 
		accounts[0].getHolder().getLastName());
		System.out.println(accounts[0]);
		System.out.println("Kontohalter Konto 2: " + 
		accounts[1].getHolder().getLastName());
		System.out.println(accounts[1]);
		
		
		for (Account account : accounts) {
			if (!account.hasPositiveBalance()) {
				System.out.println("Nicht positiv: " + account.getAccountNumber());
			}
		}

	}
	
	public static void printAllBalances(HasBalance... balanceArray) {
		for (HasBalance b : balanceArray) {
			System.out.println(b.getBalanceInCents());
		}
		
	}
	
	public static void creditAllInterests(Account[] accounts) {
		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingsAccount savings = (SavingsAccount)account;
				savings.creditInterest();
			}
		}
	}
}
