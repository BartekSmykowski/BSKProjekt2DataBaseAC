package edu.bsk;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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

}
