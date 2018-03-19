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

`http://localhost:8080/`

The [SpringFox-library](http://springfox.github.io/springfox/) is used to generate the live documentation.
(Note: The live documentation uses the generated swagger annotations and not the swagger specification file).

## Live Swagger documentation
The handwritten swagger specification is made available at this endpoint:

`http://localhost:8080/api.yml`

Use this swagger-endpoint in external tooling and clients.

## Where can I look at the generated sources?
The sources are generated at build time here:

`target/generated-sources/swagger/src/gen`

## Developing APIs based on this template
Typical workflow when working with APIs and data formats:
1. Change the swagger specification: `src/main/resources/public/api.yml`
2. Regenerate sources: `mvn clean package`
3. Resolve potential compilations errors due to changes
4. Implement new business logic

## Gotchas
* Sadly, for some reason Spring Web does not recognize parameter annotations in interfaces. These have to be added/copied to the implementing Controllers. 