# Swagger first template
A template project for creating swagger first APIs in java. Use it as a starting point for your API.

The project generates API code at build time from a swagger specification using the [swagger-codegen-maven-plugin](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin). It uses [Spring Boot](https://projects.spring.io/spring-boot) to serve the API.

The template API consists of a ping-endpoint, with integration tests to demonstrate code generation:

`/ping?message=Hello`

**Philosophy**:
* All API structures and data formats are mastered and maintained in the swagger specification: `src/main/resources/public/api.yml`
* Business logic is developed by implementing generated API interfaces and using generated data classes as input and output
* Add services, domain classes and data access logic as needed 

## Build
`mvn clean package`

## Run

`java -jar target/swagger-first-template-java.jar`

or

`mvn spring-boot:run`

or simply run the `no.nc.Main` from your IDE.

## Live visual documentation
Live documentation of the running API is available at the root. I.e: 

<http://localhost:8080/>

## Live Swagger documentation
The handwritten swagger specification is made available at this endpoint:

<http://localhost:8080/api.yml>

Use this swagger-endpoint in external tooling and clients.

## Where can I look at the generated sources?
The sources are generated at build time here:

`target/generated-sources/swagger/src/gen`

## Developing APIs based on this template
Typical workflow when working with APIs and data formats:
1. Change the swagger specification: `src/main/resources/public/api.yml`
2. Regenerate sources: `mvn clean package`
3. Resolve potential compilations errors due to changes
4. Implement new business logic by extending generated API interfaces
    * Do not forget to add `@Controller` to controller classes
    
Rinse and repeat...

## Tips and tricks
* Mark the directory `target/generated-sources/swagger/src/gen/java` as a generated sources root in your IDE if it is not done automatically
* Web-based swagger editors can be used to edit the swagger specification. E.g. <http://editor.swagger.io>
* Zalando has made a decent IntelliJ swagger editor with code completion: <https://github.com/zalando/intellij-swagger>

## Gotchas
* Sadly, for some reason Spring Web does not recognize parameter annotations in interfaces. These have to be added/copied to the implementing Controllers. (E.g. `@RequestParam(value = "message", required = false) String message`)
* Do not forget to add `@Controller` to controller classes