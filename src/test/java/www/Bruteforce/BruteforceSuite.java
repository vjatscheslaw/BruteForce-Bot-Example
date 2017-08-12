
package www.Bruteforce;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({www.Bruteforce.CodesGeneratorTest.class, www.Bruteforce.LoggerTest.class, www.Bruteforce.BruteforceBotTest.class, www.Bruteforce.MainClassTest.class, www.Bruteforce.ThreadMasterTest.class})
public class BruteforceSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
