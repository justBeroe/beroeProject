package bg.softuni.beroe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {

  @Bean("genericRestClient")
  public RestClient genericRestClient() {
    return RestClient.create();
  }

  @Bean("offersRestClient")
  public RestClient offersRestClient(OfferApiConfig offersApiConfig) {
    return RestClient
        .builder()
        .baseUrl(offersApiConfig.getBaseUrl())
        .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        .build();
  }

  @Bean("weatherRestClient")
  public RestClient weatherRestClient() {
    return RestClient.create();
  }



  @Bean("AIRestClient")
  public RestClient AIRestClient() {
    return RestClient.create();

  }

  @Bean
  public WebClient AIRestClient1() {
    return WebClient.create();
  }

  @Bean("getPlayers")
  public RestClient getPlayers() {
    return RestClient.create();
  }


}
