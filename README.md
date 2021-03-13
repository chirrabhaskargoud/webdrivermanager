# WebDriverManager GitLab Pipeline
This project shows how to run an automated web test inside a docker container using the GitLab CI.

You can read my blog post explaining this repo at http://www.eliasnogueira.com/how-to-run-selenium-webdriver-tests-on-free-gitlab-ci

## Tech stack
* Java 11
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) is being used to, automatically, manage the browser driver
* [Selenium WebDriver](https://www.selenium.dev/) as the automated testing library
* [GitLab CI](https://docs.gitlab.com/ee/ci/) as the CI/CD tool to build and run the tests
* [JUnit 5](https://junit.org/junit5/) as the support testing tool

## Code structure/explanation
There is a Page Object class to find the elements and do the actions on the targeting web page.
It only one element and action to, later on in the test, make an assertion.

The test script has a before method to set up the Google Chrome driver using WebDriverManager and access the main page.
There is a method that asserts if the page description is the expected one. Simple like that just to demonstrate the 
most important part: how we can execute it into a container inside the GitLab CI.

## Pipeline script
At the beginning of the `.gitlab-ci.yml` there is a docker container that already has Java 11, Maven, and Google Chrome 
browser. The image is from [markhobson/maven-chrome/](https://hub.docker.com/r/markhobson/maven-chrome/) project.

There are two stages in this pipeline, to make it simple and show to you how to execute the tests:
* build: compile and download the necessary libraries
* test: run the test we have

To see an example where you can create your custom Docker image, push into the GitLab container registry and use it 
in the pipeline script, switch to the [gitlab-registry](https://gitlab.com/elias.nogueira/webdrivermanager-pipeline-test/-/tree/gitlab-registry) branch.
