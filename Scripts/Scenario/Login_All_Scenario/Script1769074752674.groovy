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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

// ================= START APP =================
Mobile.startApplication('C:\\Users\\Admin\\Downloads\\Advantage+demo+3.2.apk', true)

// ================= POPUP HANDLE =================
Mobile.tap(findTestObject('Advantage_Demo_Mobile/Login/android.widget.Button - OK (1)'), 5)
Mobile.tap(findTestObject('Advantage_Demo_Mobile/Login/android.widget.Button - APPLY (1)'), 5)
Mobile.tap(findTestObject('Advantage_Demo_Mobile/Login/android.widget.Button - OK (2)'), 5)

// ================= OPEN LOGIN PAGE =================
Mobile.tap(findTestObject('Advantage_Demo_Mobile/Login/android.widget.ImageView (2)'), 5)
Mobile.tap(findTestObject('Advantage_Demo_Mobile/Login/android.widget.TextView - LOGIN (1)'), 5)

// ================= INPUT USERNAME =================
Mobile.tap(findTestObject('Object Repository/Advantage_Demo_Mobile/Login/android.widget.TextView - USER NAME (1)'), 0)

Mobile.setText(findTestObject('Object Repository/Advantage_Demo_Mobile/Login/android.widget.EditText (3)'), username, 0)

// ================= INPUT PASSWORD =================
Mobile.tap(findTestObject('Object Repository/Advantage_Demo_Mobile/Login/android.widget.TextView - PASSWORD (1)'), 0)

Mobile.setText(findTestObject('Object Repository/Advantage_Demo_Mobile/Login/android.widget.TextView - PASSWORD (1)'), password, 0)

// ================= TAP LOGIN =================
Mobile.tap(
	findTestObject('Advantage_Demo_Mobile/Login/android.widget.Button - LOGIN'),
	5
)

Mobile.delay(2)

// ================= NORMALIZE EXPECTED RESULT =================
String expected = expectedResult?.trim()?.toUpperCase()

// ================= VALIDATION =================
boolean isLoginSuccess = Mobile.verifyElementVisible(findTestObject('Object Repository/Advantage_Demo_Mobile/Login/android.widget.TextView - LAPTOPS'), 
    5, FailureHandling.OPTIONAL)

println("DEBUG user=" + username +
		", expected=" + expected +
		", isLoginSuccess=" + isLoginSuccess)

// ================= ASSERT =================
if (expected == 'SUCCESS' && isLoginSuccess) {

	println("✅ Login SUCCESS sesuai harapan untuk user: " + username)

}
else if (expected == 'FAILED' && !isLoginSuccess) {

	println("✅ Login FAILED sesuai harapan untuk user: " + username)

}
else {

	assert false :
		"❌ Login TIDAK sesuai expectation | user=" + username +
		", expected=" + expected +
		", actual=" + (isLoginSuccess ? "SUCCESS" : "FAILED")
}

// ================= CLOSE APP =================
Mobile.closeApplication()
