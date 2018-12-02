package retail.bill.discount.exception;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import retail.bill.discount.domain.DiscountProcessorBuilder;
import retail.bill.discount.domain.User;
import retail.bill.discount.domain.DiscountProcessorBuilder.DiscountProcessor;

public class InvalidBillAmountExceptionTest{
	
	 @Test(expected=InvalidBillAmountException.class)
	 public void testApplyDiscountonNonForNegetiveBillAount() throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(-900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.CUSTOMER).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test(expected=InvalidBillAmountException.class)
	 public void testApplyDiscountonNonForNegetiveBillAount2() throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(-900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.EMPLOYEE).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 
}
