# create a new project 
go to start.spring.io and using the template. Then load the folder in IDE

# Automated/Integration Tests
install TestContainers library. https://java.testcontainers.org/ -> provides JUnit tests
scroll down to the Managing versions for multiple Testcontainers dependencies' section
copy the code to your pom file just above the build section

- if you're using mongodb for example, you want to copy the maven code as well
- also, copy the JUnit maven code under "Test Framework Integration"