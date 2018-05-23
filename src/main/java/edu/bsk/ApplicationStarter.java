package edu.bsk;

import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.Resource;
import edu.bsk.database.entities.User;
import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.UserRepository;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class ApplicationStarter extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder
                .sources(ApplicationStarter.class)
                .bannerMode(Banner.Mode.CONSOLE);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Bean
    public CommandLineRunner setupUsers(UserRepository userRepository){
        return (args) -> {
            List<User> initUsers = new ArrayList<>();
            initUsers.add(new User("admin", "admin", new HashSet<>(Arrays.asList("admin", "brygadzista"))));
            initUsers.add(new User("no_role", "no_role", new HashSet<>(Arrays.asList("no_role"))));
            initUsers.add(new User("brygadzista", "brygadzista", new HashSet<>(Arrays.asList("brygadzista"))));
            initUsers.add(new User("magazynier", "magazynier", new HashSet<>(Arrays.asList("magazynier", "sprzedawca"))));
            initUsers.add(new User("sprzedawca", "sprzedawca", new HashSet<>(Arrays.asList("sprzedawca"))));
            initUsers.add(new User("manager_zatrudnienia", "manager_zatrudnienia", new HashSet<>(Arrays.asList("manager_zatrudnienia"))));
            initUsers.add(new User("projektant_produktow", "projektant_produktow", new HashSet<>(Arrays.asList("projektant_produktow"))));
            initUsers.forEach(user -> {
                if(userRepository.findByNickname(user.getNickname()) == null){
                    userRepository.save(user);
                }
            });

        };
    }

    @Bean
    public CommandLineRunner setupData(ProductRepository productRepository){
        return (args) -> {
            for(int i = 0; i <10; i++){
                Product product = new Product("product" + i, i*3.0f+10.0f, i*100%79);
                Resource resource = new Resource("resource" + i*2, i*234%19);
                Resource resource2 = new Resource("resource" + i*2+1, i*234%29);
                product.addResource(resource, i*4356%10);
                product.addResource(resource2, i*435%10);
                productRepository.save(product);
            }

        };
    }

}
