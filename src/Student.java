/*
 *  Author: Mark Kelly (c00198041)
 *  Date: 27/02/18
 *  Brief: Class for Student kind
 */
import java.math.BigDecimal;

public class Student implements iCarParkKind {
    // Discount applies for over 5.00
    private BigDecimal studentCap = BigDecimal.valueOf(5);
    // 30% discount for students. e.g. 10 * 0.7 = 7
    private BigDecimal studentRateDiscount = BigDecimal.valueOf(0.7);

    public BigDecimal calculate (BigDecimal rate) {
        if (rate.compareTo(studentCap) > 0) {
            return rate.subtract(studentCap).multiply(studentRateDiscount).add(studentCap);
        }
        return rate;
    }
}
