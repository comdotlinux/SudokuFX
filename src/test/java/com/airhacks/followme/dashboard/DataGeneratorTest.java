/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.airhacks.followme.dashboard;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class DataGeneratorTest {

    private DataGenerator cut;

    @Before
    public void setUp() {
       this.cut = new DataGenerator();
    }

//    /**
//     * Test of init method, of class DataGenerator.
//     */
//    @Test
//    public void testInit() {
//        System.out.println("init");
//        instance.init();
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of generateSudoku method, of class DataGenerator.
     */
    @Test(timeout = 20000L)
    public void testGenerateArrayOfRandomNumbers() {
        System.out.println("testGenerateArrayOfRandomNumbers");
        
        long start = System.nanoTime();
        int[][] result = cut.generateArrayOfRandomNumbers();
        long end = System.nanoTime();
        
        System.out.println("GenerateArrayOfRandomNumbers() took :: " + TimeUnit.NANOSECONDS.toMillis(end-start));
        assertNotNull(result);
    }
    
    /**
     * Test of generateSudoku method, of class DataGenerator.
     */
    @Test
    public void testisValidColumn() {
        System.out.println("testGenerateArrayOfRandomNumbers");
        
        int[][] input = cut.generateArrayOfRandomNumbers();
        assertNotNull(input);
        boolean result = cut.isValidColumn(input, 0);
        System.out.println("testisValidColumn() ? " + result);
        
    }
    
    

    /**
     * Test of isValid3x3Box method, of class DataGenerator.
     */
    @Test
    public void testIsValid3x3Box_validInput_Success() {
        System.out.println("testIsValid3x3Box_validInput_Success");
        int[][] _3x3Box = {{1,2,3},{4,5,6},{7,8,9}};
        
        boolean expected = true;
        boolean actual = cut.isValid3x3Box(_3x3Box);
        assertThat(actual, is(expected));
    }
    
    /**
     * Test of isValid3x3Box method, of class DataGenerator.
     */
    @Test
    public void testIsValid3x3Box_validInput_randomOrder_Success() {
        System.out.println("testIsValid3x3Box_validInput_Success");
        int[][] _3x3Box = {{7,4,2},{1,5,9},{8,3,6}};
        
        boolean expected = true;
        boolean actual = cut.isValid3x3Box(_3x3Box);
        assertThat(actual, is(expected));
    }
    
    
    /**
     * Test of isValid3x3Box method, of class DataGenerator.
     */
    @Test
    public void testIsValid3x3Box_invalidInput_Failure() {
        System.out.println("testIsValid3x3Box_invalidInput_Failure");
        int[][] _3x3Box = {{1,2,3},{4,5,7},{7,8,9}};
        
        boolean expected = false;
        boolean actual = cut.isValid3x3Box(_3x3Box);
        assertThat(actual, is(expected));
    }
    
    
    /**
     * Test of isValid3x3Box method, of class DataGenerator.
     */
    @Test
    public void testIsValid3x3Box_invalidInput_randomOrder_Failure() {
        System.out.println("testIsValid3x3Box_invalidInput_RandomOrder_Failure");
        int[][] _3x3Box = {{6,1,8},{2,9,3},{7,6,5}};
        
        boolean expected = false;
        boolean actual = cut.isValid3x3Box(_3x3Box);
        assertThat(actual, is(expected));
    }

}