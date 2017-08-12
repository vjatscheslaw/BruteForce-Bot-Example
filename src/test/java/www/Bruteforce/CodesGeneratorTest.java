
package www.Bruteforce;


import org.junit.Test;
import static org.junit.Assert.*;

public class CodesGeneratorTest {
 
    
    public CodesGeneratorTest() {
        
    }

    @Test
    public void testCodesGeneratorFourDigits() {       
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesFourDigits");  
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFourDigits().get(0), "0000");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFourDigits().get(5), "0005");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFourDigits().get(9999), "9999");
        
    }

    /**
     * Test of getListOfCodesSevenDigits method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCodesSevenDigits() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesSevenDigits");  
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSevenDigits().get(0), "0000000");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSevenDigits().get(5), "0000005");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSevenDigits().get(9999999), "9999999");
          
    }

    /**
     * Test of getListOfCodesSixDigits method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCodesSixDigits() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesSixDigits");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSixDigits().get(0), "000000");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSixDigits().get(5), "000005");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesSixDigits().get(999999), "999999");
        
    }

    /**
     * Test of getListOfCodesFiveDigits method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCodesFiveDigits() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesFiveDigits");  
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFiveDigits().get(0), "00000");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFiveDigits().get(5), "00005");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesFiveDigits().get(99999), "99999");
        
    }

    /**
     * Test of getListOfCodesThreeDigits method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCodesThreeDigits() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesThreeDigits");             
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesThreeDigits().get(0), "000");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesThreeDigits().get(5), "005");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesThreeDigits().get(999), "999");
        
    }

    /**
     * Test of getListOfCodesTwoDigits method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCodesTwoDigits() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCodesTwoDigits");    
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesTwoDigits().get(0), "00");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesTwoDigits().get(5), "05");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCodesTwoDigits().get(99), "99");
       
    }

    /**
     * Test of getListOfCheatCodes method, of class CodesGenerator.
     */
    @Test
    public void testGetListOfCheatCodes() {
        CodesGenerator codegen = new CodesGenerator();
        System.out.println("getListOfCheatCodes");              
        assertEquals("Code values are not in their places in the List", codegen.getListOfCheatCodes().get(0), "1770");
        assertEquals("Code values are not in their places in the List", codegen.getListOfCheatCodes().get(20), "1790");        
    }

}
