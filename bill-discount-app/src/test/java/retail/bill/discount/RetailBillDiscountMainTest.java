package retail.bill.discount;

import org.junit.Test;

import retail.bill.discount.exception.InvalidBillAmountException;

public class RetailBillDiscountMainTest {
	 @Test
	 public void testMainWithArgs()  throws InvalidBillAmountException{
		 RetailBillDiscountMain.main(new String[] {"970","false"});
	 }
	 
	 @Test
	 public void testMainWithNoArgs()  throws InvalidBillAmountException{
		 RetailBillDiscountMain.main(null);
	 }
	 
	 @Test
	 public void testMainWithOneArgs()  throws InvalidBillAmountException{
		 RetailBillDiscountMain.main("970");
	 }
	 
	 
	 
}
