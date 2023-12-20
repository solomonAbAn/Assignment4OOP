package Main;

public class NotEnoughBalanceException extends BankAccountException {
	
	public NotEnoughBalanceException(String message) {
		super(message);
	}
}
