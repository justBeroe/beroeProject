package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.ConversionResultDTO;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.exception.ApiObjectNotFoundException;
import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

  private final ExRateService exRateService;

  public CurrencyController(ExRateService exRateService) {
    this.exRateService = exRateService;
  }

  @GetMapping("/api/convert")
  public ResponseEntity<ConversionResultDTO> convert(
      @RequestParam("from") String from,
      @RequestParam("to") String to,
      @RequestParam("amount") BigDecimal amount
  ) {
    BigDecimal result = exRateService.convert(from, to, amount);

    return ResponseEntity.ok(new ConversionResultDTO(
        from,
        to,
        amount,
        result
    ));
  }



  @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
  @ExceptionHandler(ApiObjectNotFoundException.class)
  @ResponseBody
  public NotFoundErrorInfo handleApiObjectNotFoundException(ApiObjectNotFoundException apiObjectNotFoundException) {


    return new NotFoundErrorInfo("NOT FOUND", apiObjectNotFoundException.getId(), "SAMO BEROE");
  }


  public record NotFoundErrorInfo(String code, Object id, String beroe) {

  }
}
