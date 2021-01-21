package net.medavante.mobile.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.medavante.mobile.appium.core.MobileCoreFunctions;
import net.medavante.mobile.appium.core.MobileDriver;
import net.medavante.portal.utilities.MobileConstants;

public class MobileLoginPage extends MobileCoreFunctions {

	public MobileLoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(className = "android.widget.EditText")
	private MobileElement pinInp;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='PIN']")
	private MobileElement pinEditBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Confirm PIN']")
	private MobileElement confirmPinEditBox;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	private MobileElement editBox;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='OK']")
	private MobileElement humBurgerMenuIcon;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][1]")
	private MobileElement homeTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][2]")
	private MobileElement questionnairesTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][3]")
	private MobileElement MessagesTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][4]")
	private MobileElement logAnEventTab;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Registration Code']")
	private MobileElement registrationCodeInp;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Submit']")
	private MobileElement submitBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
	private MobileElement nextBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private MobileElement chooseQuestionDropDownIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Try Again']")
	private MobileElement tryAgainBtn;

	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	private MobileElement crossMarkBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	private MobileElement continueBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	private MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement registerCodeText;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement answerCodeText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	private MobileElement termsAndCondtionTitleText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='(PINs do not match)']")
	private MobileElement PINDontMatchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration Code not found']")
	private MobileElement IncorrectRegCodeTextMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Exit Application'][1]")
	private MobileElement exitApplicationIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Register']")
	private MobileElement registerTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Identity']")
	private MobileElement createIdentityTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign-In']")
	private MobileElement signInTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset PIN']")
	private MobileElement resetPINTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	private MobileElement registerInstruction;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan the code']")
	private MobileElement scanTheCodeBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose a question']")
	private MobileElement choosAQuestion;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter the code']")
	private MobileElement enterTheCodeBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement enterAnAnswerTextBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter an answer']")
	private MobileElement enterAnAnswer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I forgot the PIN']")
	private MobileElement forgetLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='zxingDefaultOverlay_TopTextLabel']")
	private MobileElement scanCodeScreenText;

	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.ImageButton")
	private MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@class='android.view.ViewGroup']//android.view.View")
	private MobileElement successIndicatorTickMarkIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
	private MobileElement acceptBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Participant Version']")
	private MobileElement participantVersionText;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='android:id/statusBarBackground']")
	private MobileElement tapOn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.systemui:id/handler_image_view']")
	private MobileElement tapNext;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Smart View')]")
	private MobileElement smartView;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'360')]")
	private MobileElement systemConfiguration;
	
	

	/**
	 * Verify Create Identity screen is displayed
	 */
	public void verifyCreateIdentityScreenWithPINAndEditPIN() {
		Assert.assertTrue(isElementPresent(pinInp) && isElementPresent(nextBtn));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Register instruction is displayed
	 */
	public void verifyInstructionMessageTextOnCreateIdentity(String messageToBeVerify) {
		waitForElementToBecomeVisible(createIdentityTitle, 60);
		Assert.assertTrue(registerInstruction.getText().equalsIgnoreCase(messageToBeVerify));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Sign-In instruction is displayed
	 */
	public void verifySignInScreenDisplayed() {
		waitForElementToBecomeVisible(signInTitle, globalWaitTime);
		Assert.assertTrue(signInTitle.isDisplayed());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Reset PIN instruction is displayed
	 * 
	 */
	public void verifyInstructionMessageTextOnResetPINScreen(String messageToBeVerify) {

		waitForElementToBecomeVisible(resetPINTitle, 60);
		Assert.assertTrue(registerInstruction.getText().equalsIgnoreCase(messageToBeVerify));

		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/*
	 * Enter PIN and click Submit
	 **/

	public void loginWithPIN(String pinNum) {

		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(submitBtn, globalWaitTime);
		click(submitBtn);
	}

	/*
	 * Enter PIN and edit PIN
	 **/

	public void loginCreateIdentity(String pinNum) {
		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
		
	}

	/**
	 * Enter pin num and login to the application
	 * 
	 * @param pinNum
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void verifyLoginScreenDisplay() {

		waitForElementToBecomeVisible(pinInp, 60);
		Assert.assertTrue(isElementPresent(pinInp));
		verifyPageIsDisplayAndCaptureTheScreenShot();

	}

	/**
	 * Enter pin num and login to the application
	 * 
	 * @param pinNum
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public MobileDashBoardPage loginUser(String pinNum) {
		waitForElementToBecomeVisible(pinInp, DEFAULT_WAIT_ELEMENT);
		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(submitBtn, globalWaitTime);
		click(submitBtn);
		MobileDashBoardPage dashboard = new MobileDashBoardPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), dashboard);
		return dashboard;
	}

	/**
	 * Verify Register instruction is displayed
	 */
	public void verifyInstructionMessageText(String registerMessageToBeVerify) {
		waitForElementToBecomeVisible(registerInstruction, DEFAULT_WAIT_ELEMENT);
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Register screen is displayed
	 */
	public void verifyRegisterScreenIsDisplay() {
		Assert.assertTrue(isElementPresent(registerTitle) && isElementPresent(scanTheCodeBtn)
				&& isElementPresent(enterTheCodeBtn));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Register screen is displayed
	 */
	public void verifyRegisterScreenForEnterCodeIsDisplay() {
		Assert.assertTrue(isElementPresent(registerTitle) && isElementPresent(submitBtn));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Click on enter the code button
	 */
	public void clickOnEnterTheCode() {		
       _normalWait(DEFAULT_WAIT_ELEMENT);
		//longPress(enterTheCodeBtn);
       enterTheCodeBtn.click();
	}

	/**
	 * Click on scan the code button
	 */
	public void clickOnScanTheCode() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		//longPress(scanTheCodeBtn);
		click(scanTheCodeBtn);
	}

	/**
	 * Click on back button
	 */
	public void clickOnBackButton() {
		click(backBtn);
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}

	/**
	 * Verify Scan the code page is displayed with instruction message
	 */
	public void verifyScanTheCodePage(String scanCodeInstructionMessage) {
		Assert.assertTrue(scanCodeScreenText.getText().contains(scanCodeInstructionMessage));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Enter the registration code on enter the code page
	 * 
	 * @param registrationCode
	 */
	public void enterTheRegistrationCode(String registrationCode) {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		registerCodeText.clear();
		setText(registrationCodeInp, registrationCode);
	}

	/**
	 * Verify entered 16-digit registration code is display
	 * 
	 * @param registrationCodeToBeVerify
	 */
	public void verifyRegistratedCode(String registrationCodeToBeVerify) {
		//int registeredCodeLength = registerCodeText.getText().replace("-", "").length();
		Assert.assertTrue(registerCodeText.getText().contains(registrationCodeToBeVerify));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Continue button is display
	 */
	public void verifyContinueButtonIsDisplay() {
		waitForElementToBecomeVisible(continueBtn, globalWaitTime);
		Assert.assertTrue(continueBtn.isEnabled());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Click on continue button
	 */
	public void clickOnContinueButton() {
		waitForElementToBecomeVisible(continueBtn, globalWaitTime);
		_normalWait(DEFAULT_WAIT_2_ELEMENT);
		click(continueBtn);
	}

	/**
	 * Click on accept button
	 */
	public void clickOnAcceptBtn() {
		//longPress(acceptBtn);
		click(acceptBtn);
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyTermsAndConditionPageIsDisplay(String instructionMessageToBeVerify) {
		new WebDriverWait(mobileDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Terms and Conditions']")));
		Assert.assertTrue(termsAndCondtionTitleText.isDisplayed()
				&& termsAndCondtionTitleText.getText().contains("Terms and Conditions"));
		verifyInstructionMessageText(instructionMessageToBeVerify);
	}

	/**
	 * Verify Success Indicator - Tick mark is display
	 */
	public void verifySuccessIndicatorTickMarkIconIsDisplay() {
		Assert.assertTrue(isElementPresent(successIndicatorTickMarkIcon));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * verify Submit Button is DISABLED
	 */
	public void verifySubmitButtonIsDisabled() {
		Assert.assertFalse(submitBtn.isEnabled());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * verify Submit Button is Enabled
	 */
	public void verifySubmitButtonIsEnabled() {
		Assert.assertTrue(submitBtn.isEnabled());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Click on submit button after entered the registration code
	 */
	public void clickOnSubmitButton() {
		click(submitBtn);
		_normalWait(globalWaitTime);
	}
	
	public void verifyContinueButtonDisplay(){
		waitForElementToBecomeVisible(continueBtn, globalWaitTime);
	}

	/**
	 * Verify Try Again button display
	 */
	public void verifyTryAgainButtonDisplayed() {
		Assert.assertTrue(tryAgainBtn.isDisplayed());
	}

	/**
	 * Verify Cross mark button display
	 */
	public void verifyCrossMarkButtonDisplayed() {
		Assert.assertTrue(crossMarkBtn.isDisplayed());
	}

	/**
	 * Click on Try Again button after entered the wrong registration code
	 */
	public void clickOnTryAgainButton() {
		click(tryAgainBtn);
		waitForElementToBecomeVisible(registrationCodeInp, 10);
	}

	public void verifyUserLogin() {
		waitForElementToBecomeVisible(homeTab, 60);
		click(homeTab);
		Assert.assertTrue(isElementPresent(homeTab));
		Assert.assertTrue(homeTab.isSelected());
		
	}
	
	public void exitApplication() {
		click(humBurgerMenuIcon);
		_normalWait(globalWaitTime);
		waitForElementToBecomeVisible(exitApplicationIcon, DEFAULT_WAIT_ELEMENT);
		click(exitApplicationIcon);
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyIncorrectRegistrationCodeErrorMessage() {
		waitForElementToBecomeVisible(IncorrectRegCodeTextMessage,DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue(IncorrectRegCodeTextMessage.isDisplayed());
	}

	/**
	 * Verify forget PIN Link is displayed
	 */
	public void verifyForgetPINLinkDisplay() {
		Assert.assertTrue(isElementPresent(forgetLink));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify forget PIN Link is displayed
	 */
	public void verify(String registerMessageToBeVerify) {
		waitForElementToBecomeVisible(forgetLink, 60);
		Assert.assertTrue(forgetLink.getText().trim().contains(registerMessageToBeVerify));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Sign-In screen is displayed
	 */
	public void verifySignInScreenWithPINEditBox() {
		Assert.assertTrue(isElementPresent(pinInp) && isElementPresent(signInTitle));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	public void clickOnForgetPINLink() throws InterruptedException {
		_normalWait(globalWaitTime);
		click(forgetLink);
		waitForElementToBecomeVisible(registerInstruction, globalWaitTime);

	}

	public void verifyTextOnScreen(String text) {

		WebElement messageText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
		Assert.assertTrue(messageText.isDisplayed());

	}

	public void verifyTextDoesNotAppearOnScreen(String text) {
		WebElement messageText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
		Assert.assertFalse(messageText.isDisplayed());
	}

	/**
	 * verify Next Button is DISABLED
	 */
	public void verifyNextButtonIsDisabled() {
		waitForElementToBecomeVisible(nextBtn, 30);
		Assert.assertFalse(nextBtn.isEnabled());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * verify Next Button is Enabled
	 */
	public void verifyNextButtonIsEnabled() {
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
		Assert.assertTrue(nextBtn.isEnabled());
	}

	/**
	 * verify continue Button is Enabled
	 */
	public void verifyContinueButtonIsEnabled() {
		Assert.assertTrue(continueBtn.isEnabled());
	}

	/**
	 * Click on submit button after entered the registration code
	 */
	public void clickOnNextButton() {
		{
			waitForElementToBecomeVisible(nextBtn, 30);
			click(nextBtn);
			_normalWait(globalWaitTime);
			
		}

	}

	/**
	 * Verify Avatar And Version Label display
	 */
	public void verifyAvatarAndVersionLabelIsDisplay() {
		Assert.assertTrue(participantVersionText.isDisplayed());
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyPinAndConfirmPINEditBoxesAreDisplay() {
		Assert.assertTrue(isElementPresent(pinEditBox) && isElementPresent(confirmPinEditBox));
		verifyPageIsDisplayAndCaptureTheScreenShot();

	}

	/**
	 * Enter the Pin code on enter the code page
	 * 
	 * @param pinCode
	 */
	public void enterPINCode(String PINCode) {
		waitForElementToBecomeVisible(pinEditBox, globalWaitTime);
		setText(pinEditBox, PINCode);

	}

	/**
	 * Enter the Pin code on enter the code page
	 * 
	 * @param pinCode
	 */
	public void enterConfirmPINCode(String PINCode) {
		waitForElementToBecomeVisible(confirmPinEditBox, globalWaitTime);
		setText(confirmPinEditBox, PINCode);
		mobileDriver.hideKeyboard();
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
	}

	public void clearConfirmPINBox() {
		editBox.clear();
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Verify Pin dont match is display
	 */
	public void verifyPinDontMatchTextDisplay() {
		Assert.assertTrue(isElementPresent(PINDontMatchText));
		verifyPageIsDisplayAndCaptureTheScreenShot();

	}

	/**
	 * Verify Pin dont match not display
	 */
	public void verifyPinDontMatchTextisNotDisplay() {
		Assert.assertFalse(isElementPresent(PINDontMatchText));
		verifyPageIsDisplayAndCaptureTheScreenShot();

	}

	public void verifyChooseAQuestionDisplay() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue(isElementPresent(choosAQuestion));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	public void clickOnChooseAQuestionOption() {
		click(choosAQuestion);
	}

	public void clickOnCancelButton() {
		click(cancelBtn);
	}

	public void chooseAQuestion(String question) {
		_normalWait(globalWaitTime);
		click(choosAQuestion);	
		scrollFromTopToBottom();
		WebElement questionText = mobileDriver
		.findElement(By.xpath(String.format("//android.widget.FrameLayout//android.widget.TextView[@text='%s']", question)));
		if (questionText.isDisplayed()) {
			waitForElementToBecomeVisible(questionText, globalWaitTime);
			click(questionText);
		}

	}

	public void verifyQuestionText(String question) {
		WebElement questionText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", question)));
		Assert.assertTrue(isElementPresent(questionText));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	public void verifyAnswerCodeDisplay() {
		Assert.assertTrue(isElementPresent(enterAnAnswer));
		verifyPageIsDisplayAndCaptureTheScreenShot();
	}

	/**
	 * Enter the answer code for secret question
	 * 
	 * @param registrationCode
	 */
	public void enterAnAnswer(String answerCode) {
		setText(enterAnAnswerTextBox, answerCode);
		mobileDriver.hideKeyboard();
	}

	public void closeApp() {
		mobileDriver.closeApp();

	}

	public void reopenApp() {
		mobileDriver.launchApp();
		waitForElementToBecomeVisible(signInTitle, DEFAULT_WAIT_ELEMENT);
	}

	/* Exceptional Condition While Login */

	public MobileDashBoardPage scanCodeOrEnterPin(String registrationCode, String pinNum) {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		if (getApiumDriver().findElementsByXPath("//android.widget.TextView[@text='Enter the code']").size() > 0) {

			clickOnEnterTheCode();
			enterTheRegistrationCode(registrationCode);
			clickOnSubmitButton();
			clickOnContinueButton();
			verifySignInScreenDisplayed();
			loginUser(pinNum);
		} else {
			verifySignInScreenDisplayed();
			loginUser(pinNum);
		}
		MobileDashBoardPage dashboard = new MobileDashBoardPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), dashboard);
		verifyPageIsDisplayAndCaptureTheScreenShot();
		return dashboard;
	
	}


	/* Registration process For Subject For Configuration */

	public void configurationForRegisterTheSubject(String registrationCode) {

		clickOnEnterTheCode();
		enterTheRegistrationCode(registrationCode);
		clickOnSubmitButton();
		clickOnContinueButton();
		enterPINCode(MobileConstants.Mobile_Pin);
		enterConfirmPINCode(MobileConstants.Mobile_Pin);
		clickOnNextButton();
		clickOnChooseAQuestionOption();
		chooseAQuestion(MobileConstants.Choose_QuestionPin);
		enterAnAnswer(MobileConstants.Choose_QuestionAnswer);
		clickOnNextButton();
		clickOnContinueButton();
	}

	public void enterTheAnswerCode(String string) {
		setText(answerCodeText, string);
		mobileDriver.hideKeyboard();
	}
	
	/* To Invoke Smart View*/
	public void tapTopToBottom()
	{
		org.openqa.selenium.Dimension size = mobileDriver.manage().window().getSize();
		int x = size.width / 2;
		int y = size.height/2;
		TouchAction action = new TouchAction(mobileDriver);
		action.longPress(ElementOption.element(tapOn)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y)).release().perform();
		action.longPress(ElementOption.element(tapNext)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y)).release().perform();
		smartView.click();
		waitForElementToBecomeVisible(systemConfiguration,DEFAULT_WAIT_ELEMENT);
		_normalWait(3000);
		systemConfiguration.click();
		_normalWait(5000);
		clickBackButton();
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}
}