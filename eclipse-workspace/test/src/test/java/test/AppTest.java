package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void exe_2_Partition_D_min_plus1() {
    	String result = App.NumberToChar(61);
    	String expected_result = "D";
    	org.junit.Assert.assertEquals(result, expected_result);
    }
    @Test
    public void exe_2_Partition_D_max_minus1() {
    	String result = App.NumberToChar(68);
    	String expected_result = "D";
    	org.junit.Assert.assertEquals(result, expected_result);
    }
    @Test
    public void exe_2_Partition_D_nominal() {
    	String result = App.NumberToChar(65);
    	String expected_result = "D";
    	org.junit.Assert.assertEquals(result, expected_result);
    }
   
}
