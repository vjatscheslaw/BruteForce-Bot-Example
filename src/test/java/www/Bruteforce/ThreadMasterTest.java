
package www.Bruteforce;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThreadMasterTest {
    
    public ThreadMasterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of runThreads method, of class ThreadMaster.
     */
    @Test
    public void testRunThreads() {
        System.out.println("runThreads");
        ThreadMaster instance = new ThreadMaster(1, new CodesGenerator().getListOfCheatCodes());
        assertEquals(21, instance.getScopeOfWorkForASingleThread());        
    }
    
}
