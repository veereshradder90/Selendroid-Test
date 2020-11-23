# Selendroid-Test
I have automated one end to end below scenarios to do POC
Scenario
Launch Selendroid test app and register multiple users.


Instatiate Appium Server on the following address: Host:Port = localhost:4723
with below capabilities
platformName=Android
platformVersion=5.1
deviceName=Android Emulator
automationName=UiAutomator2
app = D:\\Harness API\\SelendroidTestApp\\resources\\selendroid-test-app-0.17.0.apk
fileName=D:\\Harness API\\SelendroidTestApp\\resources\\RegistrationData.xlsx
sheetName=Sheet1

I have used properties file to pass appium capbilities and to provide file path
I have also Excel file to provide data to test using Dataprovider
Configured extents reports
Can run scripts in cmd using Maven commands(mvn test)
Placed all data files under resuorce folder
Extent report will be generated folowing folder SelendroidTestApp\Reports\ExecutionReport_"+actualDate+".html
