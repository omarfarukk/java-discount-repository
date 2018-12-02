package retail.bill.discount.exception;

/**
 * @InvalidBillAmountException class is custom exception and it should be thrown if the bill Amount is Negative
 * 
 **/

public class InvalidBillAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidBillAmountException(String message) {
		super(message);
	}

}
