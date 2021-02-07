# How to run tests

Pre-Requisite

1) Please ensure you have a IDE which can run spring boot I use IntelliJ (lincensed) and it should run all fine.
2) Ensure you have chrome webdriver download from https://chromedriver.chromium.org/downloads
3) If you want to run test on firefox https://github.com/mozilla/geckodriver/releases
4) Everything else used in the project is Maven driven and should self download unless there is a firewall blocking it

## via IDE
1) Select Cucumber Runner (Path src/main/java/nz/co/automation/regression/CucumberRunner.java) choose to Edit configuration
2) Set VM options = -Dspring.profiles.active=local -Dselenide.browser=chrome
e.g. `-Dspring.profiles.active=local -Dselenide.browser=chrome`
(Change browser to firefox and the tests will run on firefox)

## via command line
Open a terminal navigate to the folder where your project is type below command to run the test
`mvn -Dit.test=CucumberRunner -Dcucumber.options="--tags @practical-test" -Dspring.profiles.active=local -Dselenide.browser=chrome verify`

## Reports for test run
Navigate to target/cucumber-html-reports/overview-features.html to see a report for the test run
Click across various tabs on the reports to see results in various different forms