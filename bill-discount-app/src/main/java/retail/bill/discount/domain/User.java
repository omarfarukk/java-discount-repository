package retail.bill.discount.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This enum is responsible to store information of discount percentage
 * depending on user category Also, it provides one
 * method @getPaybaleAmountAfterApplyingDicount to calculate the bill amount
 * after applying the discount
 * 
 **/
public enum User {
	EMPLOYEE(30), AFFILIATE(10), CUSTOMER(5);
	public static final Logger logger = LoggerFactory.getLogger(User.class);
	private long discountPercenatge;
	private long userRegistrationAgeinYrs;

	User(long discountPercenatge) {
		this.discountPercenatge = discountPercenatge;
	}

	public long getDiscountPercenatge() {
		return this.discountPercenatge;
	}

	void setUserRegistrationAge(LocalDate registrationDate) {
		this.userRegistrationAgeinYrs = calculateCustomerRegistrationAge(registrationDate);
	}

	public boolean isUserAllowedForDiscount() {
		boolean isAllowed = true;
		if (this.equals(CUSTOMER) && this.userRegistrationAgeinYrs < 2)
			isAllowed = false;
		return isAllowed;
	}

	private long calculateCustomerRegistrationAge(LocalDate registrationDate) {
		LocalDate currentDate = LocalDate.now();
		return ChronoUnit.YEARS.between(registrationDate, currentDate);
	}

	/**
	 * This Method is responsible to calculate the total amount applying the
	 * relevant discount percentage depending on user category
	 * 
	 * @param billAmount
	 *            , a double that represents the billAmount Generated.
	 * @return double, discounted payble bill Amount
	 */
	public double getDiscount(double billAmount) {
		if (this.isUserAllowedForDiscount())
			return billAmount * ((double) this.getDiscountPercenatge() / 100);
		else
			return 0;

	}
}
