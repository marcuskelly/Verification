/*
 *  Author: Mark Kelly (c00198041)
 *  Date: 08/02/18
 *  Brief: Verification Project - Test suite
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Before;
//import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

/*
 *  Tests for Rate constructor
 *  Task 1: Create Black Box test cases
 */
public class KellyMarkTestTask3 {

    ArrayList<Period> discountPeriods;
    ArrayList<Period> normalPeriods;
    ArrayList<Period> discountPeriods2;
    ArrayList<Period> normalPeriods2;
    ArrayList<Period> discountPeriodsOverlap;
    ArrayList<Period> normalPeriodsOverlap;
    ArrayList<Period> discountPeriodsInvalid;
    ArrayList<Period> normalPeriodsInvalid;
    BigDecimal BD_Null;
    Period period;


    @Before
    public void preTest(){
        String val_N = null;
        String val_E = "";
        discountPeriods= new ArrayList<Period>(){{
            add(new Period(7,9));
            add(new Period(18,23));
        }};
        normalPeriods= new ArrayList<Period>(){{
            add(new Period(9,18));
            //add(new Period(16,22));
        }};

        discountPeriods2= new ArrayList<Period>(){{
            add(new Period(7,18));
        }};
        normalPeriods2= new ArrayList<Period>(){{
            add(new Period(18,24));
        }};

        discountPeriodsOverlap= new ArrayList<Period>(){{
            add(new Period(7,10));
        }};
        normalPeriodsOverlap= new ArrayList<Period>(){{
            add(new Period(7,10));
        }};

        discountPeriodsInvalid= new ArrayList<Period>(){{
            add(new Period(7,11));
            add(new Period(10,12));
        }};
        normalPeriodsInvalid= new ArrayList<Period>(){{
            add(new Period(7,11));
            add(new Period(10,12));
        }};

        BD_Null = null;
    }

    // Test 1 - Check enum
    @org.junit.Test
    public void kindIsValid(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // Test 2 - positive check boundary
    @org.junit.Test
    public void normalRateGreaterEqualZero(){
        Rate rate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(0),new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // Test 3 - positive check boundary
    @org.junit.Test
    public void normalRateGreaterEqualZero_ValueEqual_1(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1),new BigDecimal(0),discountPeriods,normalPeriods);
    }

    // Test 4 - positive check random
    @org.junit.Test
    public void normalRateGreaterEqualZero_ValueEqual_10(){
        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // Test 5 - positive check maxInt
    @org.junit.Test
    public void normalRateGreaterEqualZero_ValueMaxInt(){
        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(100000000),new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // TEST 6 - negative check NULL input
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateNullInput() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, BD_Null,BigDecimal.valueOf(5), discountPeriods, normalPeriods);
    }

    // TEST 7 - negative check empty input
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateEmptyInput() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(' '),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    // TEST 8 - negative check -1
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateMinus1() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(-1),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    // TEST 9 - negative check -maxInt
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateMinusMaxInt() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(-100000000),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    /*
    // TEST 10 -  normalRate == -100000000 (positive boundary check nR > dR)
    @org.junit.Test
    public void normalRateGreaterDiscountRate() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(2),new BigDecimal(1), discountPeriods, normalPeriods);
    }
    */

    // TEST 10 - negative boundary check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanDiscountRate() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(0),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    //TEST 11 - negative boundary check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanDiscountRateNULL() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1), BD_Null, discountPeriods, normalPeriods);
    }

    // TEST 12 - negative check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateEmptyLessThanDiscountRate() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(' '),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    // TEST 13 - negative check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanDiscountRateEmpty() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5),new BigDecimal(' '), discountPeriods, normalPeriods);
    }

    // TEST 14 -  normalRate == discountedRate
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessEqualDiscountRateEmpty() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5),new BigDecimal(5), discountPeriods, normalPeriods);
    }

    // TEST 15 - positive boundary check
    @org.junit.Test
    public void discountRateGreaterEqualZero() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(0), discountPeriods, normalPeriods);
    }

    // TEST 16 - positive boundary check
    @org.junit.Test
    public void discountRateGreaterZero() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(1), discountPeriods, normalPeriods);
    }

    // TEST 17 - positive random check
    @org.junit.Test
    public void discountRateGreaterEqualZeroRan() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(11), new BigDecimal(10), discountPeriods, normalPeriods);
    }

    // TEST 18 - positive bigNum check
    @org.junit.Test
    public void discountRateGreaterEqualZeroMaxInt() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1000000000), new BigDecimal(100000000), discountPeriods, normalPeriods);
    }

    // TEST 19 -  discountedRate >=0  (negative boundary check - dR == -1)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void discountRateLessThanZero() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(-1), discountPeriods, normalPeriods);
    }

    // TEST 20-  discountedRate >=0  (negative boundary check - dR == -100000000)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void discountRateLessThanZeroBigNum() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(-100000000), discountPeriods, normalPeriods);
    }

    // TEST 21-  discountedRate < normalRate (positve boundary check - dR == -100000000)
    @org.junit.Test
    public void discountRateEqualsZero() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1), new BigDecimal(0), discountPeriods, normalPeriods);
    }

    // TEST 22-  discountedRate < normalRate (positve boundary check - dR == -100000000)
    @org.junit.Test
    public void discountRateRandomCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(15), new BigDecimal(10), discountPeriods, normalPeriods);
    }

    // TEST 23-  discountedRate < normalRate (positve boundary check - dR == -100000000)
    @org.junit.Test
    public void discountRateBigNumCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1000000000), new BigDecimal(100000000), discountPeriods, normalPeriods);
    }

    // TEST 24-  discountedRate < normalRate (positve boundary check - dR == -100000000)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void discountRateNegativeBoundaryCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(1), new BigDecimal(-1), discountPeriods, normalPeriods);
    }

    ///////////////////////////////////////////////////////////////////////////////

    /*
        Calculate tests
     */

    //Calculate Test #1:
    @org.junit.Test
    public void normalPeriodBoundaryMin(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(7,8);
        assertEquals(new BigDecimal(5), rate.calculate(p));
    }

    //Calculate Test #2:
    @org.junit.Test
    public void normalPeriodBoundaryMax(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(17,18);
        assertEquals(new BigDecimal(5), rate.calculate(p));
    }

    //Calculate Test #3:
    @org.junit.Test
    public void normalPeriodRandom(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(10,11);
        assertEquals(new BigDecimal(5), rate.calculate(p));
    }

    //Calculate Test #4:
    @org.junit.Test
    public void discountPeriodBoundaryMin(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(18,19);
        assertEquals(new BigDecimal(1), rate.calculate(p));
    }

    //Calculate Test #5:
    @org.junit.Test
    public void discountPeriodBoundaryMax(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(23,24);
        assertEquals(new BigDecimal(1), rate.calculate(p));
    }

    //Calculate Test #6:
    @org.junit.Test
    public void discountPeriodRandom(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(20,21);
        assertEquals(new BigDecimal(1), rate.calculate(p));
    }

    //Calculate Test #7:
    @org.junit.Test
    public void normalAndFree(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(6,9);
        assertEquals(new BigDecimal(10), rate.calculate(p));
    }

    //Calculate Test #8:
    @org.junit.Test
    public void normalAndDiscount(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(16,20);
        assertEquals(new BigDecimal(12), rate.calculate(p));
    }

    //Calculate Test #9:
    @org.junit.Test
    public void normalAndDiscountAndFree(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(16,2);
        assertEquals(new BigDecimal(16), rate.calculate(p));
    }

    //Calculate Test #10:
    @org.junit.Test
    public void discountAndFree(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(22,2);
        assertEquals(new BigDecimal(2), rate.calculate(p));
    }

    //Calculate Test #11:
    @org.junit.Test
    public void discountAndNormal(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(22,8);
        assertEquals(new BigDecimal(7), rate.calculate(p));
    }

    //Calculate Test #12:
    @org.junit.Test
    public void freeNoramAndDiscount(){
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5),new BigDecimal(1),discountPeriods2, normalPeriods2);
        Period p = new Period(6,19);
        assertEquals(new BigDecimal(56), rate.calculate(p));
    }

    //////////////////////////////////////////////////////////////////////

    /*
        Task 2 - New test cases
    */
    // TEST 1- discount period null check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void discountPeriodNullCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), null, normalPeriods);
    }

    // TEST 2- normal period null check
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodNullCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), discountPeriods, null);
    }

    // TEST 3- check period overlap
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodOverlapCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), discountPeriodsOverlap, normalPeriodsOverlap);
    }

    // TEST 4- check for invalid discount period
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void validDiscountPeriodCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), discountPeriodsInvalid, normalPeriods);
    }

    // TEST 5- check for invalid normal period
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void validNormalPeriodCheck() throws Exception {
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), discountPeriods, normalPeriodsInvalid);
    }

    //////////////////////////////////////////////////////////////////////

    /*
        Task 3 - New test cases
    */
    // Test 1 - Check normalrate less than zero
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessZero(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // Test 2 - Check discountRate less than zero
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void discountRateLessZero(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(-1),discountPeriods,normalPeriods);
    }

    // Test 3 - The normalRate has to be greater or equal to the discountedRate
    @org.junit.Test
    public void normalRateEqualDiscountRate(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5),discountPeriods,normalPeriods);
    }

    // Test 4 - The normalRate has to be greater or equal to the discountedRate
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateGreaterThanDiscountRate(){
        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(6),discountPeriods,normalPeriods);
    }

    // Test 5 - Check Management kind rate
    @org.junit.Test
    public void checkManagementRate() {
        Rate rate = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,11);
        assertTrue(new BigDecimal(10).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 6 - Check Staff kind rate
    @org.junit.Test
    public void checkStaffRateLessThanMaximum() {
        Rate rate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,11);
        assertTrue(new BigDecimal(10).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 7 - Check Staff kind rate
    @org.junit.Test
    public void checkStaffRateMaximum() {
        Rate rate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,13);
        assertTrue(new BigDecimal(15).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 8 - Check Visitor kind rate
    @org.junit.Test
    public void checkVisitorRateFirstTenFree() {
        Rate rate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,11);
        assertTrue(new BigDecimal(0).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 9 - Check Visitor kind rate
    @org.junit.Test
    public void checkVisitorRateOverTenDiscount() {
        Rate rate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,12);
        assertTrue(new BigDecimal(2.5).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 10 - Check Student kind rate with no discount
    @org.junit.Test
    public void checkStudentRateNoDiscount() {
        Rate rate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2), BigDecimal.valueOf(1), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,11);
        assertTrue(new BigDecimal(4).compareTo(rate.calculate(periodStay)) == 0);
    }

    // Test 11 - Check Student kind rate with discount
    @org.junit.Test
    public void checkStudentRateWithDiscount() {
        Rate rate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), discountPeriods, normalPeriods);
        Period periodStay = new Period(9,12);
        assertTrue(new BigDecimal(12).compareTo(rate.calculate(periodStay)) == 0);
    }
}
