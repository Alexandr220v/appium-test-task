
Project Appium maven with cucumber for Android 

## Requirements

* Java 8
* Appium 2.0.1
* Maven
* Android  Simulators or Devices

## Running Tests

1. Start appium server: `$ appium` 
	
2. Run android tests from terminal: `$ mvn clean test -Dcucumber.options="--tags @smoke" -DplatformName=ANDROID -Ddevice="Nexus 5X API 29"
3. Run android tests by cucumber: `$ Run  CucumberRunnerTest with VM options -DplatformName=ANDROID -Ddevice="Nexus 5X API 29"
   `

4. Open cucumber reports:  `target/cucumber-reports/index.html`

## IMPORTANT

* Before run the tests you need to start android device or emulator and appium server.


## Documentation

* **[maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)**
* **[Appium Docs](http://appium.io/)**
* **[Selenium Docs](https://www.seleniumhq.org/docs/)**
* **[cucumber.io](https://cucumber.io/docs/guides/10-minute-tutorial/)**
* **[pagefactory](https://github.com/appium/java-client/blob/master/docs/Page-objects.md)**









