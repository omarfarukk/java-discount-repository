package retail.bill.discount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retail.bill.discount.domain.DiscountProcessorBuilder;
import retail.bill.discount.exception.InvalidBillAmountException;

public abstract class RetailBillDiscountMain {
	public static final Logger logger = LoggerFactory.getLogger(RetailBillDiscountMain.class);
	static DiscountProcessorBuilder discountProcessorBuilder;

	public static void main(String... args) throws InvalidBillAmountException {
			if (args!= null &&  args.length == 2)
				discountProcessorBuilder = new DiscountProcessorBuilder(Double.parseDouble(args[0]),
						Boolean.parseBoolean(args[1]));
			else
				discountProcessorBuilder = new DiscountProcessorBuilder(980, false);
			logger.info("Total Payble Amount: {}" , discountProcessorBuilder.build().applyDiscount());
			
		
		
	}

}
