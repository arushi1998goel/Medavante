package net.medavante.mobile.pages;

import java.util.List;

import org.junit.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.medavante.mobile.appium.core.MobileCoreFunctions;

public class MBMessagesPage extends MobileCoreFunctions {

	public MBMessagesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="(//android.view.ViewGroup//android.view.View)[4]")
	private MobileElement addMessageBtn; 
	
	@AndroidFindBy(xpath="//android.widget.ListView//android.view.ViewGroup/android.view.View/following-sibling::android.widget.TextView")
	private List<MobileElement> messageTodayList; 
	
	
	/* Verify Today Message List is Present */
	public void verifyMessageListPresent() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		boolean flag = false;
		if (messageTodayList.size() > 0) {
			flag = true;
		}
		Assert.assertTrue(flag);
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}
	
	
	
}
