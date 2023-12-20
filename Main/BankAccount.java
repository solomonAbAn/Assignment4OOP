package Main;

public class BankAccount {

	private String name; // your name
	private double balance; // current amount of money you save in the bank account
	private final static double depositLimit = 500;
	private final static double withdrawLimit = 500;

	/** constructor */
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	/** constructor */
	public BankAccount(String name) {
		this(name, 0);
	}

	/** return balance */
	public double getbalance() {
		return balance;
	}

	/** return name */
	public String getName() {
		return name;
	}

	public String toString() {
		return "Name: " + name + "\n" + "balance: " + balance +"\n";
	}

	/**
	 * deposit money into the account
	 * 
	 * @throws BankAccountException
	 */
	public void deposit(double depositedAmount) throws BankAccountException {
		if (depositedAmount < 0) {
			throw new InvalidAmountException("the deposited amount amount " + depositedAmount + " is a negative");
		}
		if (depositedAmount > depositLimit) {
			throw new DepositLimitException("you exceeded your deposit amount " + depositLimit);
		} else {
			System.out.println("Deposit: " + depositedAmount);
			balance += depositedAmount;
		}

	}

	/**
	 * withdraw money from the account
	 * 
	 * @throws InvalidAmountException
	 * @throws WithdrawLimitException
	 */
	public void withdraw(double withdrewnAmount) throws BankAccountException {

		if (withdrewnAmount < 0) {
			throw new InvalidAmountException("the withdrewn amount " + withdrewnAmount + " is a negative");
		}
		if (withdrewnAmount > withdrawLimit) {
			throw new WithdrawLimitException("you have exceeded the withdraw limit " + withdrawLimit);

		}
		if(withdrewnAmount>balance) {
			throw new NotEnoughBalanceException(withdrewnAmount + " is greater than your balance: " + balance);
		}else {
			System.out.println("Withdraw: " + withdrewnAmount);
			balance-= withdrewnAmount;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			BankAccount ac1 = new BankAccount("solomon", 100000);
			BankAccount ac2 = new BankAccount("pargol", 1000000);
			BankAccount ac3 = new BankAccount("kawthar", 105000);
			System.out.println(ac1);
			ac1.deposit(500);
			System.out.println(ac1);
			ac1.withdraw(50);
			System.out.println(ac1);
			System.out.println(ac2);
			ac2.deposit(250);
			System.out.println(ac2);
			ac2.withdraw(25);
			System.out.println(ac2);
			System.out.println(ac3);
			ac3.withdraw(30);
			System.out.println(ac3);
			
			
		
			
			
			
		} catch (BankAccountException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
