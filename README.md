# Road Finder App

This Application reads a file named `city.txt` which contains a list of city pairs(one pair per line `comma` separated) which indicates that there is a road between those cities.

This application exposes one endpoint which is :
- http://localhost:8080/connected?origin=city1&destination=city2

Example of city.txt:  
>Boston, New York  
>Philadelphia, Newark  
>Newark, Boston  
>Trenton, Albany

Expected Output
> http://localhost:8080/connected?origin=Boston&destination=Newark : **yes**
> http://localhost:8080/connected?origin=Boston&destination=Philadelphia : **yes**
> http://localhost:8080/connected?origin=Philadelphia&destination=Albany : **no**

## Technology Used
- Spring Boot (v2.3.2)
- JAVA 8
- Spring MVS Framework

## Approach
To reach at solution I have first read the file into memory and created a bi-directional graph of city which denotes if they have a link between them. Then to findout if two city connects I have used depth first search algorithm.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

For Viewing the code you need:
- [IntelliJ Idea](https://www.jetbrains.com/idea/) or [Eclipse IDE](https://www.eclipse.org/eclipseide/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

> One way is to execute the `main` method in the `com.test.roadfinder.RoadFinderApplication` class from your IDE.

> Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```sh
./gradlew clean bootRun
```

## Running the Tests
 To Run the Tests 
 > One way is to execute `com.test.roadfinder.RoadFinderControllerTest` class from IDE
 
 > Alternatively you can use the following command
 ```sh
 ./gradlew clean test
 ```