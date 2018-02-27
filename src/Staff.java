/*
 *  Author: Mark Kelly (c00198041)
 *  Date: 27/02/18
 *  Brief: Class for Staff kind
 */
import java.math.BigDecimal;

public class Staff implements iCarParkKind {
    private BigDecimal staffRateMaxCharge = BigDecimal.valueOf(15); // Maximum payable is 15.00 per day for staff

    public BigDecimal calculate (BigDecimal rate) {
        return (rate.compareTo(BigDecimal.valueOf(15)) <= 0) ? rate : staffRateMaxCharge;
    }
}
