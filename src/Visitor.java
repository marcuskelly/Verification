/*
 *  Author: Mark Kelly (c00198041)
 *  Date: 27/02/18
 *  Brief: Class for Visitor kind
 */
import java.math.BigDecimal;

public class Visitor implements iCarParkKind {
    private BigDecimal visitorCashDiscount = BigDecimal.valueOf(10); // First 10.00 is free
    private BigDecimal visitorRateDiscount = BigDecimal.valueOf(0.5); // 50% discount rate

    public BigDecimal calculate (BigDecimal rate) {
        rate = visitorRateDiscount.multiply(rate.subtract(visitorCashDiscount));
        return (rate.compareTo(BigDecimal.ZERO) > 0) ? rate : BigDecimal.ZERO;
    }
}
