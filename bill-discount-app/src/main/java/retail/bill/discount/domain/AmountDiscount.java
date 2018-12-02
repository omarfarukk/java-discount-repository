package retail.bill.discount.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmountDiscount {
	public static final Logger logger = LoggerFactory.getLogger(User.class);
	private double discountAmountPerUnit;
	private static final double DEFAULT_DISCOUNT_AMOUNT_PER_UNIT = 5;
	private double unit;
	private static final double DEFAULT_UNIT = 100;
	private static AmountDiscount amountDiscountObject;

	private AmountDiscount(double unit, double discountAmountPerUnit) {
		this.unit = unit;
		this.discountAmountPerUnit = discountAmountPerUnit;
	}

	public double getDiscountAmountPerUnit() {
		return discountAmountPerUnit;
	}

	public void setDiscountAmountPerUnit(double discountAmountPerUnit) {
		this.discountAmountPerUnit = discountAmountPerUnit;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public static AmountDiscount getAmountDiscountObject() {
		return amountDiscountObject;
	}

	public static void setAmountDiscountObject(AmountDiscount amountDiscountObject) {
		AmountDiscount.amountDiscountObject = amountDiscountObject;
	}

	private int calculateNumberofUnits(double billAmount) {
		return (int)billAmount / (int)getUnit();
	}

	/**
	 * This Method is responsible to calculate the total amount applying the
	 * relevant discount amount based on total Bill Amount
	 * 
	 * @param billAmount
	 *            , a double that represents the billAmount Generated.
	 * @return double, discounted payble bill Amount
	 */
	public double getDiscount(double billAmount) {
		return calculateNumberofUnits(billAmount) * getDiscountAmountPerUnit();
	}

	
	
	public static AmountDiscount getInstance(double unit, double discountAmountPerUnit) {
		if (amountDiscountObject == null)
			setAmountDiscountObject(new AmountDiscount(unit, discountAmountPerUnit));
		else {
			amountDiscountObject.setUnit(unit);
			amountDiscountObject.setDiscountAmountPerUnit(discountAmountPerUnit);
		}
			
		return amountDiscountObject;
	}

	public static AmountDiscount getInstance() {
		return getInstance(DEFAULT_UNIT, DEFAULT_DISCOUNT_AMOUNT_PER_UNIT);
	}
}
