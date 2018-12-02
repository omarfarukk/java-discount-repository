package retail.bill.discount.domain;

/**
 * DiscountProcessorBuilder class is responsible to build a particular DiscountProcessorObject based on the input
 * the unit amount and the discount amount per unit can be configured using @withAmountDiscount, else default unit 100 and default unit 5 will be considered.
 * the user category can be configured using @withUser and @withUserAndUserRegistrationDate
 * @getInstance methods should be used to create the AmountDiscount object
 * 
 **/
import java.time.LocalDate;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retail.bill.discount.exception.InvalidBillAmountException;

public class DiscountProcessorBuilder {
	public static final Logger logger = LoggerFactory.getLogger(DiscountProcessorBuilder.class);
	
	/**
	 * DiscountProcessor class is responsible to process the discount based on user and discount amount configuration.
	 * 
	 * @getInstance methods should be used to create the AmountDiscount object
	 * 
	 **/
	
	public static class DiscountProcessor {

		private double billAmount;
		private boolean isGrocerryItems;
		private User user;
		private AmountDiscount amountDiscount = AmountDiscount.getInstance();

		public DiscountProcessor(double billAmount, boolean isGrocerryItems) throws InvalidBillAmountException {
			if (billAmount < 0)
				throw new InvalidBillAmountException("Bill amount can't be negetive");

			this.billAmount = billAmount;
			this.isGrocerryItems = isGrocerryItems;
			this.amountDiscount = AmountDiscount.getInstance();
		}
		
		/**
		 * @getDiscount Method is responsible to calculate the relevant discount amount based on user category
		 * @return double, Total Payable Amount based on the initialized user and amount discount.
		 */
		public double applyDiscount(){
			double discount = amountDiscount.getDiscount(billAmount);
			if (!isGrocerryItems && Objects.nonNull(user))
				discount += user.getDiscount(billAmount);

			return billAmount - discount;

		}

	}

	private static DiscountProcessor discountProcessor;

	public DiscountProcessorBuilder(double billAmount, boolean isGrocerryItems) throws InvalidBillAmountException {
		setDiscountProcessor(new DiscountProcessor(billAmount, isGrocerryItems));
	}

	public static void setDiscountProcessor(DiscountProcessor discountProcessor) {
		DiscountProcessorBuilder.discountProcessor = discountProcessor;
	}

	/**
	 * withUser method is responsible to set the category of USER of the bill.
	 * this user will be considered during discount calculation.
	 * @param user, @USER type to specify the user category
	 * @return @DiscountProcessorBuilder
	 **/
	public DiscountProcessorBuilder withUser(User user) {
		DiscountProcessorBuilder.discountProcessor.user = user;
		return this;
	}
	
	/**
	 * withUserAndUserRegistrationDate method is responsible to set the category of USER of the bill.
	 * This method is particularly useful to set the user as customer and set the customer registration date to identify the customers registration age with the organization
	 * this registration date will be considered to calculate the registrationAge of the customer and accordingly the discount can be given
	 * @param user, @USER type to specify the user category
	 * @param userRegistrationDate, specifies when the user has registered with the organization
	 * @return @DiscountProcessorBuilder
	 **/
	public DiscountProcessorBuilder withUserAndUserRegistrationDate(User user, LocalDate userRegistrationDate) {
		DiscountProcessorBuilder.discountProcessor.user = user;
		DiscountProcessorBuilder.discountProcessor.user.setUserRegistrationAge(userRegistrationDate);
		return this;
	}

	/**
	 * @withAmountDiscount method is responsible to set a new unit amount and discount per unit 
	 * * this values will be considered during discount calculation.
	 * @param unit, unit of amount considered for discount
	 * @param discountAmountPerUnit, discount amount per unit of discount amount of the bill.
	 **/
	public DiscountProcessorBuilder withAmountDiscount(double unit, double discountAmountPerUnit) {
		DiscountProcessorBuilder.discountProcessor.amountDiscount = AmountDiscount.getInstance(unit, discountAmountPerUnit);
		return this;
	}

	/**
	 * @build method is responsible to build actual DiscountProcessor object with will process the discount based on configuration
	 **/
	public DiscountProcessor build() {
		return DiscountProcessorBuilder.discountProcessor;
	}

}
