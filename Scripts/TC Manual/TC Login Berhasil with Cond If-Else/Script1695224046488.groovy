import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.baseUrl)

WebUI.setViewPortSize(GlobalVariable.viewportWidth, GlobalVariable.viewportHeight)

WebUI.click(findTestObject('ObjManualSpy/HomepageLogin/btn_home_login'))

WebUI.waitForElementPresent(findTestObject('ObjManualSpy/HomepageLogin/btn_home_login'), 0)

String username = 'ABCDEFGHIJKLMN'
WebUI.setText(findTestObject('ObjManualSpy/HomepageLogin/input_Username_loginusername'), username)

if(username.length() > 10) { 
	KeywordUtil.println('Username tidak dapat melebihi dari 10 karakter')
//	KeywordUtil.markFailed('Username tidak dapat melebihi dari 10 karakter')
	WebUI.setText(findTestObject('ObjManualSpy/HomepageLogin/input_Username_loginusername'), GlobalVariable.globalUsername)
} else if (username.length() < 5){ 
	KeywordUtil.println('Username tidak dapat kurang dari 5 karakter')
	//KeywordUtil.markFailed('Username tidak dapat kurang dari 5 karakter')
	WebUI.setText(findTestObject('ObjManualSpy/HomepageLogin/input_Username_loginusername'), GlobalVariable.globalUsername)
} 
else { 
	WebUI.setText(findTestObject('ObjManualSpy/HomepageLogin/input_Username_loginusername'), GlobalVariable.globalUsername)
}

WebUI.setText(findTestObject('ObjManualSpy/HomepageLogin/input_Password_loginpassword'), GlobalVariable.globalPassword)

WebUI.click(findTestObject('ObjManualSpy/HomepageLogin/btn_login'))

WebUI.waitForElementPresent(findTestObject('ObjManualSpy/HomepageLogin/assert_welcome'), 0)

WebUI.click(findTestObject('ObjManualSpy/HomepageLogin/btn_logout'))

WebUI.verifyElementPresent(findTestObject('ObjManualSpy/HomepageLogin/assert_homepage_product'), 0)

WebUI.closeBrowser()

