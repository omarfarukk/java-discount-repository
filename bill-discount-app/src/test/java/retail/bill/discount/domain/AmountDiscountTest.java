package retail.bill.discount.domain;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.verification.VerificationMode;

import retail.bill.discount.domain.AmountDiscount;
import retail.bill.discount.domain.DiscountProcessorBuilder.DiscountProcessor;
import retail.bill.discount.exception.InvalidBillAmountException;

public class AmountDiscountTest{
	
	 @Mock
	 AmountDiscount amountDiscountMock;
	 @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	 
	 @Test
	 public void testGetAmount1()  {
		 when(amountDiscountMock.getDiscount(100)).thenReturn(5d);
		 when(amountDiscountMock.getDiscount(300)).thenReturn(15d);
		 when(amountDiscountMock.getDiscount(600)).thenReturn(30d);
		 when(amountDiscountMock.getDiscount(900)).thenReturn(45d);
		 Double[] actualDiscounts = new Double[] {amountDiscountMock.getDiscount(100),amountDiscountMock.getDiscount(300),
				 amountDiscountMock.getDiscount(600),amountDiscountMock.getDiscount(900)};
		 Double[] expectedDiscounts = new Double[] {5d,15d,30d,45d};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testGetAmount2()  {
		 AmountDiscount amountDiscount = AmountDiscount.getInstance(200, 5);
		 Double[] actualDiscounts = new Double[] {amountDiscount.getDiscount(200),amountDiscount.getDiscount(400),
				 amountDiscount.getDiscount(600),amountDiscount.getDiscount(1200)};
		 Double[] expectedDiscounts = new Double[] {5d,10d,15d,30d};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testGetAmount3()  {
		 when(amountDiscountMock.getDiscount(200)).thenReturn(10d);
		 when(amountDiscountMock.getDiscount(400)).thenReturn(2*10d);
		 when(amountDiscountMock.getDiscount(600)).thenReturn(3*10d);
		 when(amountDiscountMock.getDiscount(800)).thenReturn(4*10d);
		 Double[] actualDiscounts = new Double[] {amountDiscountMock.getDiscount(200),amountDiscountMock.getDiscount(400),
				 amountDiscountMock.getDiscount(600),amountDiscountMock.getDiscount(800)};
		 Double[] expectedDiscounts = new Double[] {10d,20d,30d,40d};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testGetAmount4()  {
		 AmountDiscount amountDiscount = AmountDiscount.getInstance(200, 10);
		 when(amountDiscountMock.getDiscount(200)).thenReturn(10d);
		 when(amountDiscountMock.getDiscount(400)).thenReturn(2*10d);
		 when(amountDiscountMock.getDiscount(600)).thenReturn(3*10d);
		 when(amountDiscountMock.getDiscount(800)).thenReturn(4*10d);
		 Double[] actualDiscounts = new Double[] {amountDiscount.getDiscount(200),amountDiscount.getDiscount(400),
				 amountDiscount.getDiscount(600),amountDiscount.getDiscount(800)};
		 Double[] expectedDiscounts = new Double[] {amountDiscountMock.getDiscount(200),amountDiscountMock.getDiscount(400),
				 amountDiscountMock.getDiscount(600),amountDiscountMock.getDiscount(800)};
		 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 }
	 
	 @Test
	 public void testGetAmountDiscountObject()  throws InvalidBillAmountException{
		 AmountDiscount amountDiscount = AmountDiscount.getInstance(200, 10);
			Double[] actualDiscounts = new Double[] {amountDiscount.getAmountDiscountObject().getDiscountAmountPerUnit(),amountDiscount.getAmountDiscountObject().getUnit()};
			 Double[] expectedDiscounts = new Double[] {10d,200d};
			 assertArrayEquals(expectedDiscounts, actualDiscounts);
	 } 
	
}
