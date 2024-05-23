package spring_boot_questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import spring_boot_questions.config.DataSourceConfig;
import spring_boot_questions.services.DemoService;
import spring_boot_questions.impl.DemoServiceImpl;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class InterviewQaApplication implements CommandLineRunner {


    @Value("${discount.offer.price}")
    private int discountPrice;

    @Value("${spring.profiles.active}")
    private String envArgs;

    @Autowired
    private Environment environment;


    @Autowired
    private DataSourceConfig config;


    @PostConstruct
    public void initLogic() {
        System.out.println("------------------------------------");
        System.out.println("PostConstruct logic ..... executed");
        System.out.println("------------------------------------");
    }



    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("SpringApplication run() method ..... executed");
        System.out.println("------------------------------------");

        ConfigurableApplicationContext context =
                SpringApplication.run(InterviewQaApplication.class);

        DemoService service = context.getBean("demoServiceImpl", DemoServiceImpl.class);
        service.test();


        System.out.println("Finished");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------------");
        System.out.println("Discount price: " + environment.getProperty("discount.offer.price"));

        System.out.println("Environment variable: " + environment.getProperty("spring.profiles.active"));
        System.out.println("Environment envArgs: " + envArgs);
        System.out.println("Config value: " + config);


        System.out.println("CommandLineRunner run() method ..... executed");
        System.out.println("------------------------------------");
    }
}
