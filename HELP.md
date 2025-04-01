# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.4/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### To install any new dependencies:
mvn clean install -u

### To run the application
mvn spring-boot:run

### To create a JAR
mvn clean package

### Test the API
#### Get all records:
curl http://localhost:8080/api/data

#### Get a record by ID:
curl http://localhost:8080/api/data/1

#### Test the POST endpoint:
curl -X POST http://localhost:8080/api/data \
     -H "Content-Type: application/json" \
     -d '{"id": 3, "name": "New User", "email": "new@example.com"}'


