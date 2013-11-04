package guitesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.maveryx.bootstrap.Bootstrap;
import org.maveryx.core.guiApi.GuiButton;
import org.maveryx.core.guiApi.GuiFrame;
import org.maveryx.core.guiApi.*;

@RunWith(org.maveryx.test.junit.MaveryxTestRunner.class)
public class AgricolaTest {
	
	/**
	 * Change this path to your current application's XML launch file.
	 */
	private static final String pathName = "C:\\Maveryx\\Agricola\\Agricola.xml";

	/**
	 * Default constructor.
	 * @throws Exception
	 */
	public AgricolaTest() throws Exception {
		super();
	}
	
	/**
	 * Start the application-under-test by loading the launch parameters from an XML file.
	 * @param xmlFile - pathname string of the XML file containing the launch parameters  
	 * @throws Exception 
	 */
	private void startApp(String xmlFile) {
		try {
			Bootstrap.startApplication(xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Start the Application-Under-Test.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Bootstrap.startApplication(pathName); //start the application under test
		
	}

	/**
	 * Close the Application-Under-Test.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {

		//close the application under test
		GuiFrame f = new GuiFrame();
		f.close(); 
		
		Bootstrap.stop(pathName); //close the application under test
	}

	/**
	 *  Test 1
	 * @throws Exception
	 */
	@Test
	/* Random Test to try out maveryx*/
	public void test001() throws Exception {
		startApp(pathName); //launch the application under test
		GuiFrame f = new GuiFrame("Agricola"); //the application frame
		GuiButton dmb = new GuiButton("Take clay (+1 per round)", f);
		assertEquals(true, dmb.isShowing());
		GuiText fld = new GuiText("textclay", f);
		dmb.click();
		assertEquals("1", fld.getText());
		assertEquals(false, dmb.isShowing());
	}

}
