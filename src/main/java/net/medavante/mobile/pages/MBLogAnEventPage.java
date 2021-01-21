package net.medavante.mobile.pages;

import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.medavante.mobile.appium.core.MobileCoreFunctions;

public class MBLogAnEventPage extends MobileCoreFunctions{

	public MBLogAnEventPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.ListView//android.view.ViewGroup/android.view.View/following-sibling::android.widget.TextView")
	private List<MobileElement> eventList; 
	
	public void clickOnEvent(String eventToBeOpen){
		for(MobileElement we:eventList){
			if(we.getText().equalsIgnoreCase(eventToBeOpen)){
				click(we);
				break;
			}
		}
	}

}
