# Trying to override a property in SpringBootTest

I have a property defined in
my [src/main/resources/application.properties](override-property-during-spring-boot-test/src/main/resources/application.properties)
defined as `my.property=defaultProp`.

I would like to override the property in my `@SpringBootTest`.

I could add
a [src/test/resources/application-api.properties](override-property-during-spring-boot-test/src/test/resources/application-api.properties)
with the new value and add `@ActiveProfiles("api")` to all my tests but I have several of these tests.

I would like to set the configuration via Spring and let Spring load the configuration file.

I tried adding this to my test sources in the same package as the @SpringBootApplication

```
@Configuration
PropertySource("classpath:application-test.properties")
public class TestConfig {
}
```

I created a
test [TestOverride.java](override-property-during-spring-boot-test/src/test/java/com/chrispie/TestOverride.java) that
tests this but it does not work.
