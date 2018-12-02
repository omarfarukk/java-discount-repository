package retail.bill.discount.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import retail.bill.discount.domain.AmountDiscount;
import retail.bill.discount.domain.DiscountProcessorBuilder.DiscountProcessor;
import retail.bill.discount.domain.User;
import retail.bill.discount.exception.InvalidBillAmountException;

public class DiscountProcessorBuilderTest{
	
	 @Test
	 public void testApplyDiscountForGrocerryItemsWithoutUser()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountForGrocerryItemsForEmployee()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.EMPLOYEE).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountonForGrocerryItemsForAffiliate()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.AFFILIATE).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountonForGrocerryItemsForCustomerLess2Years()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.CUSTOMER).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 @Test
	 public void testApplyDiscountonForGrocerryItemsForCustomerSince2Years()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, true);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUserAndUserRegistrationDate(User.CUSTOMER, LocalDate.parse("2016-02-02")).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountForNonGrocerryItemsWithoutUser()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountForNonGrocerryItemsForEmployee()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.EMPLOYEE).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d-270d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountonForNonGrocerryItemsForAffiliate()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.AFFILIATE).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d-90};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testApplyDiscountonNonForGrocerryItemsForCustomerLess2Years()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUser(User.CUSTOMER).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 @Test
	 public void testApplyDiscountonForNonGrocerryItemsForCustomerSince2Years()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withUserAndUserRegistrationDate(User.CUSTOMER, LocalDate.parse("2016-02-02")).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-45d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 } 
	 
	 @Test
	 public void testNonDefaultApplyDiscountonForNonGrocerryItems()  throws InvalidBillAmountException{
			DiscountProcessorBuilder discountProcessorBuilder = new DiscountProcessorBuilder(900, false);
			DiscountProcessor discountProcessor = discountProcessorBuilder.withAmountDiscount(300, 10).withUserAndUserRegistrationDate(User.CUSTOMER, LocalDate.parse("2016-02-02")).build();
			Double[] actualDiscounts = new Double[] {discountProcessor.applyDiscount()};
			 Double[] expectedDiscounts = new Double[] {900d-30d-45d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 } 
	 
	 
	 
	 
	
}
