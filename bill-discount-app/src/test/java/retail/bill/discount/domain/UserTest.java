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
import retail.bill.discount.domain.User;

public class UserTest{
	
	 @Test
	 public void testEmployeeDiscount()  {
		 User user = User.EMPLOYEE;
		 Double[] actualDiscounts = new Double[] {user.getDiscount(200),user.getDiscount(400),
				 user.getDiscount(600),user.getDiscount(1200)};
		 Double[] expectedDiscounts = new Double[] {200d*0.3,400d*0.3,600d*0.3,1200*0.3};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testAffiliateDiscount()  {
		 User user = User.AFFILIATE;
		 Double[] actualDiscounts = new Double[] {user.getDiscount(200),user.getDiscount(400),
				 user.getDiscount(600),user.getDiscount(1200)};
		 Double[] expectedDiscounts = new Double[] {200d*0.1,400d*0.1,600d*0.1,1200*0.1};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testCustomerAbove2YearsDiscount()  {
		 User user = User.CUSTOMER;
		 user.setUserRegistrationAge(LocalDate.parse("2016-02-02"));
		 Double[] actualDiscounts = new Double[] {user.getDiscount(200),user.getDiscount(400),
				 user.getDiscount(600),user.getDiscount(1200)};
		 Double[] expectedDiscounts = new Double[] {200d*0.05,400d*0.05,600d*0.05,1200*0.05};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testCustomerBelow2YearsDiscount()  {
		 User user = User.CUSTOMER;
		 user.setUserRegistrationAge(LocalDate.parse("2016-12-21"));
		 Double[] actualDiscounts = new Double[] {user.getDiscount(200),user.getDiscount(400),
				 user.getDiscount(600),user.getDiscount(1200)};
		 Double[] expectedDiscounts = new Double[] {0d,0d,0d,0d};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	
	 
	
}
