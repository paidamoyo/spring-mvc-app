package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        System.out.println("Customers found with findAll:");
        System.out.println("--------------------------------");

        for(Customer customer: repository.findAll()) {
            System.out.println(customer);
        }

        System.out.println();

        System.out.println("Customer found with findByFirstNAme('Alice')");
        System.out.println("-----------------------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customer found with findByLastName('Smith')");
        System.out.println("--------------------------------------------");

        for (Customer customer : repository.findByLastName("Smith")){
            System.out.println(customer);
        }
    }
}