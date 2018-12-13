package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shengliyi on 2017/1/17.
 */
@SpringBootApplication
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public RestTemplate template(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate template) throws Exception{
        return args -> {
            Quote quote = template.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
            log.info(quote.toString());
        };
    }
}
