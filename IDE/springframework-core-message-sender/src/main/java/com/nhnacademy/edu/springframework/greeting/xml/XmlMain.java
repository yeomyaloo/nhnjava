package com.nhnacademy.edu.springframework.greeting.xml;


import com.nhnacademy.edu.springframework.greeting.Greeter;
import com.nhnacademy.edu.springframework.greeting.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Framework의 ClassPathXmlApplicationContext을 사용하여 beans.xml 을 로딩하고 Spring Bean 객체를 받아온다.
 * */
public class XmlMain {

    public static void main(String[] args) {
        String location = "classpath:/beans.xml";
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);
//
//        Greeter englishGreeter = context.getBean("englishGreeter", Greeter.class);
//        Greeter koreanGreeter  = context.getBean("koreanGreeter", Greeter.class);
//
//        englishGreeter.sayHello();
//        koreanGreeter.sayHello();


        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter", Greeter.class)).doGreat();
            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter", Greeter.class)).doGreat();
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter", Greeter.class)).doGreat();
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter", Greeter.class)).doGreat();
            System.out.println("---------");


        }

    }


}



