# agoda-demo-project
Demo test automation framework

## Test Execution
### Run tests with Gradle & JUnit5:
```
./gradlew clean test
```
### To generate html report and automatically open it in a web browser, run:
```
./gradlew allureServe build/allure-results
```
## CI/CD Server
### Parametrized Jenkins job to run tests remotely on different browsers:
<img width="1342" alt="Screenshot 2022-06-05 at 23 42 35" src="https://user-images.githubusercontent.com/86495466/172069785-b4ca782f-ce9f-482e-a37f-aae32f4fe49d.png">

<a target="_blank" href="https://jenkins.autotests.cloud/job/agoda-demo/">agoda-demo (open to view)</a>

## Test Results
### Results can be viewed in Allure Report:

<img width="1440" alt="Screenshot 2022-06-05 at 20 32 17" src="https://user-images.githubusercontent.com/86495466/172069240-b28a914c-35eb-41ae-80b1-e3cedc6335f1.png">
<img width="1440" alt="Screenshot 2022-06-05 at 02 30 53" src="https://user-images.githubusercontent.com/86495466/172069242-ad377f0e-0df5-4eb4-9825-49f604a0ee4b.png">

<a target="_blank" href="https://jenkins.autotests.cloud/job/agoda-demo/allure/">Report Example</a>
