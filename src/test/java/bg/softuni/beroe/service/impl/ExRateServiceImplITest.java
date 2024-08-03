package bg.softuni.beroe.service.impl;


import bg.softuni.beroe.config.ForexApiConfig;
import bg.softuni.beroe.model.dto.ExRatesDTO;
import bg.softuni.beroe.service.ExRateService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import com.maciejwalkowiak.wiremock.spring.InjectWireMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

@SpringBootTest
@EnableWireMock(
    @ConfigureWireMock(name = "exchange-rate-service")
)
public class ExRateServiceImplITest {

  @InjectWireMock("exchange-rate-service")
  private WireMockServer wireMockServer;

  //Create HTTP server with a mock.

  @Autowired
  private ExRateService exRateService;

  @Autowired
  private ForexApiConfig forexApiConfig;

  @BeforeEach
  void setUp() {
    forexApiConfig.setUrl(wireMockServer.baseUrl() + "/test-currencies");
  }

  @Test
  void testFetchExchangeRates() {

    //Stub or create a mock request with response
    wireMockServer.stubFor(get("/test-currencies").willReturn(
        aResponse()
            .withHeader("Content-Type", "application/json")
            .withBody(
                """
                  {
                    "base": "USD",
                    "rates" : {
                      "BGN": 1.86,
                      "EUR": 0.91
                    }
                  }
                """
            )
        )
    );

    ExRatesDTO exRatesDTO = exRateService.fetchExRates();

    Assertions.assertEquals("USD", exRatesDTO.base());
    Assertions.assertEquals(2, exRatesDTO.rates().size());
    Assertions.assertEquals(new BigDecimal("1.86"), exRatesDTO.rates().get("BGN"));
    Assertions.assertEquals(new BigDecimal("0.91"), exRatesDTO.rates().get("EUR"));
  }

}
