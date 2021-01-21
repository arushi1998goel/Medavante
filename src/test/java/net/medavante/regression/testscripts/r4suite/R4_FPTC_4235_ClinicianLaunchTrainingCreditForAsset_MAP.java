/**
 *@author 
* @date 16/06/2020
* =======================================================================================================================================
*  Test Case Id: FP-TC-4235   Test Case Name: Clinician - Launch training (Credit for asset)- V6
*  pre-qualification :1. Clinician exists for the test
                      2. The clinician has assigned multiple trainings:
                      2.1. Completed or In progress training with the asset in status Completed/Passed/Meets criteria
                      2.2. Not started training with event/course: the asset_1 from Pr.#2.1 + asset_2 (any other asset) + the asset_3 from Pr#2.1
* ======================================================================================================================================= 
*/
package net.medavante.regression.testscripts.r4suite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.RatersDetailsPage;
import net.medavante.portal.pages.traininglibrary.TrainingDetailsPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.utilities.Constants;

public class R4_FPTC_4235_ClinicianLaunchTrainingCreditForAsset_MAP extends BaseTest {

	String training, Asset_2;
	 
	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public R4_FPTC_4235_ClinicianLaunchTrainingCreditForAsset_MAP(String browser) {
		
		super(browser);
	}

	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());

		training = "AT_Training_" + generateRandomString(5);
		Asset_2 = "AT_Asset_" + generateRandomString(3);

		reportLog("create new training with 3 asset");
		dashBoardPage = loginPage.loginInApplication(SuperAdminUN, SuperAdminPW);
		dashBoardPage.verifyMedavantePortalPage();
		trainingDetailsPage = dashBoardPage.selectHorizontalUpperNavMenuItem(TrainingDetailsPage.class,
				Constants.ConfigureNavText, Constants.TrainingLibraryText);

		reportLog("Add new Asset for Asset_2");
		assetsDetailsPage = trainingDetailsPage.navigateToAssetsGrid();
		assetsDetailsPage.clickOnAddAssetButton();
		assetsDetailsPage.verifyAddCoursePopupWindowRequiredFieldsDisplayed();
		assetsDetailsPage.enterLibraryName(Asset_2);
		assetsDetailsPage.enterDisplayNameData(Asset_2);
		assetsDetailsPage.enterDescriptionData(Asset_2);
		assetsDetailsPage.clickonUploadTrainingforDefaultLanguageOption();
		assetsDetailsPage.uploadFileUsingRobotclass(Constants.fileName);
		assetsDetailsPage.clickOnLanguageDropDown();
		assetsDetailsPage.selectLanguage(Constants.subjectLanguage);
		assetsDetailsPage.clickOnAddButton();
		assetsDetailsPage.verifyAddAssetModalWindowNOtDisplayed();
		assetsDetailsPage.applyfilterToVerifyAsset(Asset_2);
		assetsDetailsPage.activateAddedAsset(Asset_2);
		trainingDetailsPage = assetsDetailsPage.navigateToTrainingMenuLink();

		reportLog("Verify Training Library page and add training.");
		trainingDetailsPage.verifyTrainingDetailsPage();
		trainingDetailsPage.clickOnaddTrainingButton();
		trainingDetailsPage.verifyAddTrainingPopupDisplayed();
		trainingDetailsPage.EnterLibraryName(training);
		trainingDetailsPage.EnterLibraryDisplayName(training);
		trainingDetailsPage.selectTrainingTypeField();
		trainingDetailsPage.SelectDropDownTrainingtypeSelectValue(Constants.TrainingType_General);
		trainingDetailsPage.verifyAddEventOptiondisplayed();

		reportLog("Add Event With Asset_1.");
		trainingDetailsPage.clickonaddEventLink();
		trainingDetailsPage.verifyAddEventPopUpDisplayed();
		trainingDetailsPage.enterEventNameinAddEventPopup("event_Teste1");
		trainingDetailsPage.enterEventAssetNameForFormTypeEvent("Asset", "Asset_3010_1");
		trainingDetailsPage.clickOnaddButton();

		reportLog("Add Event With Asset_2.");
		trainingDetailsPage.clickonaddEventLink();
		trainingDetailsPage.verifyAddEventPopUpDisplayed();
		trainingDetailsPage.enterEventNameinAddEventPopup("event_Teste2");
		trainingDetailsPage.enterEventAssetNameForFormTypeEvent("Asset", Asset_2);
		trainingDetailsPage.clickOnaddButton();

		reportLog("Add Event With Asset_3.");
		trainingDetailsPage.clickonaddEventLink();
		trainingDetailsPage.verifyAddEventPopUpDisplayed();
		trainingDetailsPage.enterEventNameinAddEventPopup("event_Teste3");
		trainingDetailsPage.enterEventAssetNameForFormTypeEvent("Asset", "Asset_3010_3");
		trainingDetailsPage.clickOnaddButton();

		reportLog("Activate added training");
		trainingDetailsPage.clickOnAddButton();
		trainingDetailsPage.refreshPage();
		trainingDetailsPage.applyfilterToVerifyTraining(training);
		trainingDetailsPage.verifyAddedTrainingDisplayed(training);
		trainingDetailsPage.activateNewTraining(training);

		reportLog("Assign added training to user");
		ratersDetailsPage = dashBoardPage.selectHorizontalUpperNavMenuItem(RatersDetailsPage.class,
				Constants.NavigateText, Constants.SubTabUniversity);
		ratersDetailsPage.verifyOptionToSelectStudyAndSiteIsDisplayed();
		ratersDetailsPage.selectStudy(Constants.All_Studies, Constants.All_Sites);
		ratersDetailsPage.verifyClinicians_RatersPage();
		ratersDetailsPage.verifyOnBoardingGridIsDisplayed();
		ratersDetailsPage.applyNameFilterUnderTrackingTab(Constants.AutoTest_Clinician);
		ratersDetailsPage.selectRater(Constants.AutoTest_Clinician);
		ratersDetailsPage.verifyRaterIsSelected(Constants.AutoTest_Clinician);
		ratersDetailsPage.selectActionControl();
		ratersDetailsPage.clickOnLinkUnderActionControl(Constants.AssignGeneralTrainingLink);
		ratersDetailsPage.verifyAssignGeneralTrainingPopUp();
		ratersDetailsPage.assignTrainingToUser(training);
		ratersDetailsPage.clickOnSaveButtonOnAssignGeneraltrainingPopUp(SuperAdminUN, SuperAdminPW);

		reportLog("Logout application");
		loginPage.logoutApplication();

		reportLog("Verify user is Logout from application");
		loginPage.verifyUserLogout();
	}

	
	@Test(description="Clinician - Launch training (Credit for asset)- V6")
	public void R4_FPTC_4235_ClinicianLaunchTrainingCreditForAsset() throws Exception{
		
		reportLog("2.0: Log in to the Portal as User Pr.#1");
		dashBoardPage = loginPage.maLogin(Auto_Clinician, VU_AT_Password1);

		reportLog("2.1: User successfully logged in");
		dashBoardPage.verifyMedavantePortalPage();

		reportLog("2.2: The home page is displayed");
		dashBoardPage.verifyMedavantePortalPage();
		dashBoardPage.verifyGeneralTrainingIsDisplayed();
		
		reportLog("2.3: The Training Pr#2.2 is displayed on the Home page");
		dashBoardPage.verifyRespectiveTrainingIsDisplayed(training);
	 	
		reportLog("3.0: Select an action to start the Training Pr#2.2");
		dashBoardPage.selectActionToStartTraining(training);	
		
		reportLog("3.1: Launch the training");
    	dashBoardPage.verifyTrainingProgressCardIsDisplayed(training);	
		dashBoardPage.launchTrainingAndCloseAsset();
		
		reportLog("3.2: Training Progress Card is displayed");
		dashBoardPage.verifyTrainingProgressCardIsDisplayed(training);	
		
		reportLog("3.3: Asset_1 Pr#2.1 is displayed in the list of completed assets");
		dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Constants.Asset_1);
		
		reportLog("3.4: Credit label is displayed next to asset_1 ");
		dashBoardPage.verifyCreditLabelIsDisplayedNextToAssetName(Constants.Asset_1);
		dashBoardPage.eSignature(Auto_Clinician, VU_AT_Password1);
		
		reportLog("3.5: Continue option is available");
		dashBoardPage.verifyContinueButtonIsDisplayed();
		
		reportLog("4.0: Select an option to continue");
		dashBoardPage.clickOnContinueButton();
		
		reportLog("4.1: Training is started from the Asset_2");
	//	dashBoardPage.verifyTrainigIsStartedFromAssetTwo(Asset_2);
		reportLog("5.0: Close the Asset_2");
		dashBoardPage.clickOnDoneButtonForCompleteAsset();
		
		reportLog("5.1: Training Progress Card is displayed");
		dashBoardPage.verifyTrainingProgressCardIsDisplayed(training);	

		reportLog("5.2: Asset_1 Pr#2.1 is displayed in the list of completed assets");
	//	dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Constants.Asset_1);
		
		reportLog("5.3: Credit label is displayed next to asset_1");
	//	dashBoardPage.verifyCreditLabelIsDisplayedNextToAssetName(Constants.Asset_1);

		reportLog("5.4: Continue option is available");
		dashBoardPage.verifyContinueButtonIsDisplayed();

		reportLog("6.0: Select an option to continue");
		//dashBoardPage.clickOnContinueButton();

		reportLog("6.1: Training is started from the Asset_2");
		reportLog("7.0: Complete the Asset_2");
		//dashBoardPage.clickOnDoneButtonForCompleteAsset();
		dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Asset_2);
		dashBoardPage.eSignature(Auto_Clinician, VU_AT_Password1);
		
		reportLog("7.1: Training Progress Card is displayed");
		dashBoardPage.verifyTrainingProgressCardIsDisplayed(training);	
		dashBoardPage.clickOnContinueButton();

      /**Below commented steps are covered above **/
		
//		reportLog("7.2: Asset_1 Pr#2.1 is displayed in the list of completed assets");
//		dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Constants.Asset_1);
//
//		reportLog("7.3: Credit label is displayed next to asset_1");
//		dashBoardPage.verifyCreditLabelIsDisplayedNextToAssetName(Constants.Asset_1);
//
//		reportLog("7.4: Asset_2 is displayed in the list of completed assets");
//     	dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Asset_2);

		reportLog("7.2: Asset_3 Pr#2.1 is displayed in the list of completed assets");
		dashBoardPage.verifyAssetsAreDisplayedInTheCompletedList(Constants.Asset_3);

		reportLog("7.3: Credit label is displayed next to asset_3");
		dashBoardPage.verifyCreditLabelIsDisplayedNextToAssetName(Constants.Asset_3);

		reportLog("7.4: E-sign option is available");
		dashBoardPage.eSignature(Auto_Clinician, VU_AT_Password1);

		reportLog("Logout application");
		loginPage.logoutApplication();

		reportLog("Verify user is Logout from application");
		loginPage.verifyUserLogout();
		
	}

}
