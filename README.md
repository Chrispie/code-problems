# What do I want to do

I want to add add the H2 console to my Quarkus application

# What did I do

I looked at this [stack overflow article]https://stackoverflow.com/questions/61853691/how-to-set-h2-database-console-url-in-the-quarkus-application/64132441#64132441 on how to do it.

It states that there are 2 things that need to be done

* Add the `quarkus-vertx` and `quarkus-undertow` extensions which I did [build.gradle.kts](build.gradle.kts)
* Create the deployment descriptor under src/main/resources/META-INF/web.xml [web.xml](src/main/resources/META-INF/web.xml) 

During my gradle build I am getting the following error

`Unsupported Java.
Your build is currently configured to use Java 21.0.3 and Gradle 8.8.`

I played around I am getting this exception as soon as I add the `quarkus-undertow` extensions.

Do I have something wrong configured here or is there another way to achieve this?

