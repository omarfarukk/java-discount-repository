package retail.bill.discount.domain;

import java.time.LocalDate;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retail.bill.discount.exception.InvalidBillAmountException;

public class DiscountProcessorBuilder {
	public static final Logger logger = LoggerFactory.getLogger(DiscountProcessorBuilder.class);
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


	public DiscountProcessorBuilder withUser(User user) {
		DiscountProcessorBuilder.discountProcessor.user = user;
		return this;
	}
	
	public DiscountProcessorBuilder withUserAndUserRegistrationDate(User user, LocalDate userRegistrationDate) {
		DiscountProcessorBuilder.discountProcessor.user = user;
		DiscountProcessorBuilder.discountProcessor.user.setUserRegistrationAge(userRegistrationDate);
		return this;
	}

	public DiscountProcessorBuilder withAmountDiscount(double unit, double discountAmountPerUnit) {
		DiscountProcessorBuilder.discountProcessor.amountDiscount = AmountDiscount.getInstance(unit, discountAmountPerUnit);
		return this;
	}

	public DiscountProcessor build() {
		return DiscountProcessorBuilder.discountProcessor;
	}

}
