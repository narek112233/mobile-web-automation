# mobile-web-automation

This repository has Appium and JAVA combination test framework.

Inorder to run the tests, use command: 

For Android local use this command 

mvn clean test -Dconfig=configs/local-android.properties   OR mvn test

For IOS local use this command

mvn clean test -Dconfig=configs/local-ios.properties


For Browserstack use this command

mvn clean test -Dconfig=configs/browserstack.properties



For test Result Generation use this command

mvn allure:serve 