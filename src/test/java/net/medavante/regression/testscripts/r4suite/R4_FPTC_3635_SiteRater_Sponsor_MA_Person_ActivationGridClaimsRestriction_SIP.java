/**
 *@author 
* @date 12/05/2020
* ===============================================================================================================================
*  Test Case Id: FP-TC-3635 || Test Case Name: Site Rater - Activation Grid: claims restriction- V10
*  pre-qualification: 1. At least two Studies and Sites (Facility) exist for the test:
                       1.1. Study 1
                       1.2. Study 2
                      2. At least tree Users associated with both Studies Pr.#1.1 and Pr.#1.2 but with different roles:
                       2.1 First User added to the first Study Pr.#1.1 as Site Coordinator with the claim to track Study Raters
                       2.2 First User added to the second Study Pr.#1.2 as Investigator without the claim to track Study Raters
                       2.3 Second User added to the first Study Pr.#1.1 as MA Person (role: Project Manager) with the claim to track Study Raters Global
                       2.4 Second User added to the second Study Pr.#1.2 as MA Person (role: Project Coordinator) without the claim to track Study Raters Global
                       2.5 Third User added to both Study Pr#1 as Sponsor Person (role: Sponsor) without the claim to track Study Raters	
* ================================================================================================================================ 
*/

package net.medavante.regression.testscripts.r4suite;

import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.RatersDetailsPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;

public class R4_FPTC_3635_SiteRater_Sponsor_MA_Person_ActivationGridClaimsRestriction_SIP extends BaseTest {

private String study,studyNew;
	
	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public R4_FPTC_3635_SiteRater_Sponsor_MA_Person_ActivationGridClaimsRestriction_SIP(String browser) {
		super(browser);
	}
	
	
	@BeforeMethod
	public void getTestData() throws Exception {

		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		study = properties.getProperty("Study1089");
		studyNew = properties.getProperty("Study2180");

	}
	
	 @Test(description="FP-TC-3635--Site Rater/Sponsor/MA Person - Activation Grid: claims restriction",  groups = { "R4" } )
	 public void R4_FPTC_3635_SiteRater_Sponsor_MAPerson_ActivationGridClaimsRestriction() throws Exception
	 {
		
		reportLog("2.0:  Log in to Site Portal as First User Pr.#2");
		dashBoardPage = loginPage.loginInApplication(AT_Investigator_Test, AT_Password);

		reportLog("2.1: User successfully logged in");
		dashBoardPage.verifyMedavantePortalPage();
	
		reportLog("3.1: Navigate to University dashboard");
		ratersDetailsPage = dashBoardPage.selectHorizontalUpperNavMenuItem(RatersDetailsPage.class,
					Constants.NavigateText, Constants.SubTabUniversity);

		reportLog("3.2: Select Study and Site Pr.#1.1");
		ratersDetailsPage.selectStudy(study, Constants.ChooseSite);
		
		reportLog("3.3: Onboarding grid screen is displayed	");
		ratersDetailsPage.verifyONBoardingMenuSelected();
		
		reportLog("4.0: At the left side panel select -> Activation menu item");
		ratersDetailsPage.navigateToActivationMenu();
		
		reportLog("4.1: Activation listing screen is displayed");
		ratersDetailsPage.verifyClinicianRatersListingScreenDisplayed();
		
		reportLog("4.2: Activation menu item is displayed");
        ratersDetailsPage.verifyActivationMenuIsDisplayed();
		
		reportLog("4.3: Activation Grid is displayed");
		ratersDetailsPage.verifyActivationGridIsDisplayed();
		ratersDetailsPage.navigateToOnBoardingMenu();

		reportLog("5.0: Select Study and Site Pr.#1.2");
		ratersDetailsPage.reSelectstudy(study);
		ratersDetailsPage.selectStudy(studyNew, Constants.ChooseSite_1);

		reportLog("5.1: Onboarding grid screen is displayed	");
		ratersDetailsPage.verifyONBoardingMenuSelected();

		reportLog("5.2: Activation menu item isn't displayed");
		ratersDetailsPage.verifyActivationMenuIsNotDisplayed();
		
		reportLog("5.3: Activation Grid isn't displayed");
		ratersDetailsPage.verifyActivationGridIsNotDisplayed();
	
		reportLog("Logout application");
		loginPage.logoutApplication();

		reportLog("Verify user is Logout from application");
		loginPage.verifyUserLogout();
		
		reportLog("6.0: Log in to MA Portal as Second User Pr.#2");
		dashBoardPage = loginPage.maLogin(AT_PRODProjectCoordinator, AT_Password);

		reportLog("6.1: User successfully logged in");
		dashBoardPage.verifyMedavantePortalPage();
		
		reportLog("7.0: Navigate to University -> Select Study and Site Pr.#1.1");
		ratersDetailsPage = dashBoardPage.selectHorizontalUpperNavMenuItem(RatersDetailsPage.class,
					Constants.NavigateText, Constants.SubTabUniversity);
		
		reportLog("7.1: Select Study and Site Pr.#1.1");
		ratersDetailsPage.selectStudy(studyNew, Constants.ChooseSite);

		reportLog("7.2: Onboarding grid screen is displayed	");
		ratersDetailsPage.verifyONBoardingMenuSelected();
		
		reportLog("8.0: At the left side panel select Activation menu item");
		ratersDetailsPage.navigateToActivationMenu();
		
        reportLog("8.1: Activation menu item is displayed");
        ratersDetailsPage.verifyActivationMenuIsDisplayed();

        reportLog("8.2: Activation Grid is displayed");
		ratersDetailsPage.verifyActivationGridIsDisplayed();
		ratersDetailsPage.navigateToOnBoardingMenu();

		reportLog("9.0: Select Study and Site Pr.#1.2");
		ratersDetailsPage.reSelectstudy(studyNew);
		ratersDetailsPage.selectStudy(study, Constants.ChooseSite);
				
		reportLog("9.1: At the left side panel select -> Activation menu item");
		ratersDetailsPage.navigateToActivationMenu();

        reportLog("9.2: Activation menu item is displayed");
        ratersDetailsPage.verifyActivationMenuIsDisplayed();

        reportLog("9.3: Activation Grid is displayed");
		ratersDetailsPage.verifyActivationGridIsDisplayed();

		reportLog("Logout application");
		loginPage.logoutApplication();

		reportLog("Verify user is Logout from application");
		loginPage.verifyUserLogout();
		
		reportLog("10.0: Log in to Sponsor Portal as Third User Pr.#2");
		dashBoardPage = loginPage.sponsorLogin(SponsorUser_Test, VU_AT_Password1);

		reportLog("10.1: User successfully logged in");
		dashBoardPage.verifyMedavantePortalPage();
		
		reportLog("11.0: Navigate to University -> Select Study 1 and Site Pr.#1.1");
		ratersDetailsPage = dashBoardPage.selectHorizontalUpperNavMenuItem(RatersDetailsPage.class,
					Constants.NavigateText, Constants.SubTabUniversity);
		
		reportLog("11.1: Select Study and Site Pr.#1.1");
		ratersDetailsPage.selectStudy(studyNew, Constants.ChooseSite);

		reportLog("11.2: Onboarding grid screen is displayed	");
		ratersDetailsPage.verifyONBoardingMenuSelected();
		
		reportLog("11.3: Activation menu item isn't displayed");
		ratersDetailsPage.verifyActivationMenuIsNotDisplayed();
		
		reportLog("11.4: Activation Grid isn't displayed");
		ratersDetailsPage.verifyActivationGridIsNotDisplayed();
		
		reportLog("Logout application");
		loginPage.logoutApplication();

		reportLog("Verify user is Logout from application");
		loginPage.verifyUserLogout();
		
		
	 }
}
