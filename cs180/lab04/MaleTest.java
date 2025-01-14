

/**
 * CS180 - Lab 04 - MaleTest.java
 *
 * (Put a brief description of your program here. 
 * For example: A JUnit test case class to test 
 * the functionality of the Male class.)
 *
 * @author YourName, <YourEmail@purdue.edu>
 *
 * @lab (Put your lab section # here)
 *
 * @date (Put the date you completed this lab here)
 */
 
import org.junit.Test;
import junit.framework.TestCase; 
 
public class MaleTest extends TestCase {
 
    Male adult1,adult2,child1,child2;
 
    /**
     * Initializes the MaleTest for use.
     */
    protected void setUp() throws Exception {
        super.setUp();
        adult1 = new Male("123", 30, 100, 40, 10);
        adult2 = new Male("124",31,160,30,80);
        child1 = new Male("224",17,100,40,10);
        child2 = new Male("223",16,180,30,80);
    }
 
 
    /**
     * Tests the getTotalCholesterol method.
     */
    @Test
    public void testGetTotalCholesterol() {
        assertEquals(adult1.getTotalCholesterol(), 150);
        assertEquals(adult2.getTotalCholesterol(), 270);
        assertEquals(child1.getTotalCholesterol(), 150);
        assertEquals(child2.getTotalCholesterol(), 290);
    }
 
 
    /**
     * Tests the hasGoodTotalCholesterol method.
     */
    @Test
    public void testHasGoodTotalCholesterol() {
        assertTrue(adult1.hasGoodTotalCholesterol()); 
        assertFalse(adult2.hasGoodTotalCholesterol()); 
        assertTrue(child1.hasGoodTotalCholesterol()); 
        assertFalse(child2.hasGoodTotalCholesterol()); 
    }
 
 
    /**
     * Tests the hasGoodHDL method.
     */
    @Test
    public void testHasGoodHDL() {
        assertTrue(adult1.hasGoodHDL());
        assertFalse(adult2.hasGoodHDL());
        assertTrue(child1.hasGoodHDL());
        assertFalse(child2.hasGoodHDL());
        
    }
 
 
    /**
     * Tests the hasGoodLDL method.
     */
    @Test
    public void testHasGoodLDL() {
        assertTrue(adult1.hasGoodHDL());
        assertFalse(adult2.hasGoodHDL());
        assertTrue(child1.hasGoodHDL());
        assertFalse(child2.hasGoodHDL());
    }
}