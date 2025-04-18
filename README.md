# Issue

I am using the `hisrc-higherjaxb30-maven-plugin` plugin to generate Java classes from an XML schema. 

I have an XJC file that tells the generated code to use `MyLocalDateTimeAdapter` to convert dates instead of the standard xsd:dateTime".

When compiling the code (I use intellij), I get a compilation error:
```
symbol:   class MyLocalDateTimeAdapter
[ERROR]   location: class com.chrispie.generated.xsd.ObjectFactory
```
Opening the ObjectFactory I can see the import is done correctly:
```java
import java.time.LocalDateTime;
import javax.xml.namespace.QName;
import com.chrispie.MyLocalDateTimeAdapter;                    <-- This one here
import jakarta.annotation.Generated;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRegistry
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-04-18T11:59:44+02:00")
public class ObjectFactory {
```

And in the editor it is not complaining about the import since it does exists.

The thing is I am using Kotlin and in the kotlin project I am getting this issue.

If I were to do the same in java, it works fine.
