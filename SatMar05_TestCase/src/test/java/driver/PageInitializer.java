package driver;

import pages.MyAccountLoginPage;

public class PageInitializer extends Driver {
	
	
		
	public static MyAccountLoginPage myAPageLogin;
	
	
	
	public static void initialize() {
		
		myAPageLogin = new MyAccountLoginPage();
	}

}
