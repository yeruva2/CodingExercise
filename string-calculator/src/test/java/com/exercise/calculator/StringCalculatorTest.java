/**
 * 
 */
package com.exercise.calculator;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author satish
 *
 */
public class StringCalculatorTest {

	
	private static StringCalculator strCal = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		strCal = new StringCalculator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * For an empty string it will return 0
	 */
	@Test
	public void enterEmptyStringTest() {	
		
		Assert.assertEquals("Is String Empty", (Integer)0 , strCal.calculator(""));
		
		
	}
	
	
	@Test
	public void covertionStringToIntegerTest() {
		
		Assert.assertEquals("String is not a number", null, strCal.convertStrToInt("afd.,afdafa"));
	    
		//Assert.assertEquals("String is numeric", (Integer)(-5), strCal.convertStrToInt("-5"));
	    
	    Assert.assertEquals("String is numeric", (Integer)50, strCal.convertStrToInt("50.00"));
	    
	    Assert.assertEquals("String is numeric", (Integer)20, strCal.convertStrToInt("$ 20.90"));
	    
	    Assert.assertEquals("String is numeric", (Integer)5, strCal.convertStrToInt(" 5.321"));
	    
	    Assert.assertEquals("String is numeric", (Integer)1000, strCal.convertStrToInt("1,000.50"));
	    
	    Assert.assertEquals("String is numeric", (Integer)0, strCal.convertStrToInt("0.50"));
	    
	    Assert.assertEquals("String is numeric", (Integer)0, strCal.convertStrToInt(".50"));
	    
	   // Assert.assertEquals("String is numeric", (Integer)0, strCal.convertStrToInt("-.10"));
	    
	    Assert.assertEquals("String is numeric", (Integer)0, strCal.convertStrToInt(""+Integer.MAX_VALUE));
	    
	   // Assert.assertEquals("String is numeric", (Integer)Integer.MIN_VALUE, strCal.convertStrToInt(""+Integer.MIN_VALUE));
	    
	  
	}
	
	/**
	 * It test spaces dynamically for 1000 numbers
	 */
	public void stringSpacesTest() {
		
	    for(Integer num = 0; num < 1000; num++) {
	    	
	        for(int spaces = 1; spaces < 6; spaces++) {
	        	
	            String numStr = String.format("%0"+spaces+"d", num);
	            
	            Integer numNeg = num * -1;
	            
	            Assert.assertEquals(numStr + "Numeric", num, strCal.convertStrToInt(numStr));
	            
	            Assert.assertEquals(numNeg + ": Negative Numric", numNeg, strCal.convertStrToInt("- " + numStr));
	            
	        }
	    }
	}
	
	
	
	/**
	 * The following input is ok: “1\n2,3″ (will equal 6)
	 */
	@Test
	public final void calculatorTest() {
		
		Assert.assertEquals((Integer)6, (Integer)strCal.calculator("1\n2,3"));
		
	}
	
	
	/**
	 * This method takes 0, 1 or 2 numbers separated by comma
	 */
	@Test(expected = RuntimeException.class)
    public final void whenMoreThanTwoNumbersAreUsedThenExceptionIsThrown() {
		strCal.calculator("1,2,3");
    }
	
    @Test
    public final void whenTwoNumbersAreUsedThenNoExceptionIsThrown() {
    	strCal.calculator("1,2");
        Assert.assertTrue(true);
    }
    
    
    /**
     * Method will return sum of numbers
     */
    @Test
    public final void whenSingleNumberReturnsSameNumberTest() {
        Assert.assertEquals((Integer)3, strCal.calculator("3"));
    }
     
    @Test
    public final void whenTwoNumbersAreUsedThenRetValueisSumOfTwoNumbers() {
        Assert.assertEquals((Integer)9, strCal.calculator("3,6"));
    }
    
    /**
     *  Allow calculate method to handle an unknown amount of numbers
     */
    @Test
    public final void whenUnKnowAmtOfNumberEnteredThenReturnsSum() {
        Assert.assertEquals((Integer)15, strCal.calculator("1,2,3,4,5"));
    }
    
    
    /**
     * Allow the Add method to handle new lines between numbers (instead of commas).
     */
    @Test
    public final void whenInputContainsNewLinesThenReturnSum() {
    	Assert.assertEquals((Integer)18, (Integer)strCal.calculator("3n10,5"));
    }
    
    
    /**
     * Support different delimiters
     */
    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals((Integer)24, strCal.calculator("//;n3;6;15"));
    }
    
    /**
     * Negative number nut allowed
     */
    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        strCal.calculator("3,-6,15,18,46,33");
    }
    
    
    /**
     * Numbers bigger than 1000 should be ignored
     */
    @Test
    public final void whenNumbersMorethan1000ThenNotIncludedCalculation() {
    	
    	Assert.assertEquals((Integer)1003, strCal.calculator("3,1001,1000,2000"));
    	
    }
    
    /**
     * Allow multiple delimiters
     */
    @Test
    public final void whenNumberAllowMultipleDelimitersThen() {
    	
    	Assert.assertEquals((Integer)6, (Integer)strCal.calculator("//[-][%]\n1-a2%3"));// “//[-][%]\n1-2%3″);
    	
    }
    
}
	
	

