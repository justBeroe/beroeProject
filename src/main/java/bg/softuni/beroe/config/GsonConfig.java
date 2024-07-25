package bg.softuni.beroe.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GsonConfig {

    @Bean("withNulls")
    @Primary //Primary
    public Gson createGSONWithNulls() {

        return new GsonBuilder()
                // .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    @Bean("withoutNulls")
    public Gson createGSONWithoutNulls() {

        return new GsonBuilder()
                // .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

//    @Bean
//     public PersonService personService(AddressService addressService,
//                                        @Value("${samoBeroe.key.config}") String config, @Value("${samoBeroe.key.connectionCount}") int connectionCount) {
//
//
//
//        System.out.println(config);
//        System.out.println(connectionCount);
//        return new PersonService(addressService);
//     }
}
