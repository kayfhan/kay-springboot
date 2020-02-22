package me.kay.entities;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 *                  @ConfigurationProperties  @Value
 *                  批量注入                    一个个指定
 *   松散绑定        支持                        不支持       // lastName=last_name=last-name
 *   SPel           不支持                       支持        // ${2+3}
 *   JSR303数据校验  支持                      不支持         //   @Email
 *   复杂类型        支持                         不支持      // map
 *
 *   专门的javabean来获取配置文件中的值，用ConfigurationProperties，只是在某处简单获取一个配置文件中某个属性的值用@value
 *
 *   @Controller
 * public class HelloWorld {
 *
 *     @Value("person.last-name")
 *     private String name;
 *
 *     public String helloWorld(){
 *         return "hello, " + name;
 *     }
 * }
 *
 * ConfigurationProperties 默认加载全局配置文件中的属性值
 *
 * PropertySource 加载指定的配置文件，如果全局存在，先获取全局配置中的属性，在获取指定配置文件中的属性
 * 并且不识别YML配置文件中的属性
 *
 */
@Component
//@EnableConfigurationProperties(Person.class)  // @Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    // slf4j + logback slf4j: 接口。 logback:实现类，slf4j接口编程
    private final static Logger logger = LoggerFactory.getLogger(Person.class);
//    @Email
    private String lastName;
    private int age;
    private String address;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
