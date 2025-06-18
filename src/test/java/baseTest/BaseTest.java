package baseTest;

import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;

public class BaseTest extends BaseClass{

	@Test
	public void testBase() {
		setUp();
		launchApp();
	}
}
