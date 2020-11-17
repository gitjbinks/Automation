# Amazon buy hats automation
## Installation
You need to have Java 8 JDK installed along with maven.
To install all dependencies, run
> mvn clean install

Chrome and firefox drivers are installed with chocolatey https://chocolatey.org/install

To install chrome driver with chocolatey https://chocolatey.org/packages/chromedriver

To install geckodriver with chocolatey https://chocolatey.org/packages/selenium-gecko-driver

## Allure report installation
To get allure reports working, scoop should be installed https://scoop.sh/

instruction are also here https://docs.qameta.io/allure/#_installing_a_commandline

## Running tests

By Default, chrome is the broswser used.

To run tests for chrome browser
> mvn test

To run test for Firefox Browser
> mvn -Dbrowser=firefox test

## Create the report

To create the report type in command line
> allure server target/allure-reports

In case of test failure, screenshot is attached to the report

### Considerations

As the search results can be diferrent some times, the hat selected (defined in feature file as "1") can be de second depending id/css added By Amazon for promotion/flash buy.

If the selected hat is a flash offer or just rest 1 unit the automation will fail because don't have quantity drop down to select.

The automation in Chrome have texts to assert in Spanish, and in English for Firefox automation (at least in my case is opening Amazon in Spanish for chrome and in english for Firefox)

Tweaked Steps to buy different quantity, buy the second, third, fourth, etc... also for assert prices and total items for different quantities.
> When the user click option in position "1"

> Then user add "2" units to cart

> Then user check quantity of items is "2"

> And total price is updated for 1 hat for men and 1 hat for women






