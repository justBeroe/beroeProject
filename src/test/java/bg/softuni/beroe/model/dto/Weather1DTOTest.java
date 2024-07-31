package bg.softuni.beroe.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Weather1DTOTest {

    @Test
    public void testLocationGettersAndSetters() {
        Weather1DTO.Location location = new Weather1DTO.Location();

        location.setName("Sofia");
        location.setRegion("Sofia City Province");
        location.setCountry("Bulgaria");
        location.setLat(42.6977);
        location.setLon(23.3219);
        location.setTz_id("Europe/Sofia");
        location.setLocaltime_epoch(1627890000L);
        location.setLocaltime("2021-08-02 14:00");

        assertEquals("Sofia", location.getName());
        assertEquals("Sofia City Province", location.getRegion());
        assertEquals("Bulgaria", location.getCountry());
        assertEquals(42.6977, location.getLat());
        assertEquals(23.3219, location.getLon());
        assertEquals("Europe/Sofia", location.getTz_id());
        assertEquals(1627890000L, location.getLocaltime_epoch());
        assertEquals("2021-08-02 14:00", location.getLocaltime());
    }

    @Test
    public void testConditionGettersAndSetters() {
        Weather1DTO.Condition condition = new Weather1DTO.Condition();

        condition.setText("Sunny");
        condition.setIcon("//cdn.weatherapi.com/weather/64x64/day/113.png");
        condition.setCode(1000);

        assertEquals("Sunny", condition.getText());
        assertEquals("//cdn.weatherapi.com/weather/64x64/day/113.png", condition.getIcon());
        assertEquals(1000, condition.getCode());
    }

    @Test
    public void testCurrentGettersAndSetters() {
        Weather1DTO.Current current = new Weather1DTO.Current();
        Weather1DTO.Condition condition = new Weather1DTO.Condition();
        condition.setText("Partly cloudy");
        condition.setIcon("//cdn.weatherapi.com/weather/64x64/day/116.png");
        condition.setCode(1003);

        current.setLast_updated_epoch(1627890000L);
        current.setLast_updated("2021-08-02 14:00");
        current.setTemp_c(25.0);
        current.setTemp_f(77.0);
        current.setIs_day(1);
        current.setCondition(condition);

        assertEquals(1627890000L, current.getLast_updated_epoch());
        assertEquals("2021-08-02 14:00", current.getLast_updated());
        assertEquals(25.0, current.getTemp_c());
        assertEquals(77.0, current.getTemp_f());
        assertEquals(1, current.getIs_day());
        assertEquals(condition, current.getCondition());
    }

    @Test
    public void testWeather1DTOGettersAndSetters() {
        Weather1DTO weather1DTO = new Weather1DTO();
        Weather1DTO.Location location = new Weather1DTO.Location();
        location.setName("Plovdiv");
        location.setRegion("Plovdiv Province");
        location.setCountry("Bulgaria");
        location.setLat(42.1354);
        location.setLon(24.7453);
        location.setTz_id("Europe/Sofia");
        location.setLocaltime_epoch(1627890000L);
        location.setLocaltime("2021-08-02 14:00");

        Weather1DTO.Current current = new Weather1DTO.Current();
        Weather1DTO.Condition condition = new Weather1DTO.Condition();
        condition.setText("Cloudy");
        condition.setIcon("//cdn.weatherapi.com/weather/64x64/day/119.png");
        condition.setCode(1006);
        current.setLast_updated_epoch(1627890000L);
        current.setLast_updated("2021-08-02 14:00");
        current.setTemp_c(22.0);
        current.setTemp_f(71.6);
        current.setIs_day(1);
        current.setCondition(condition);

        weather1DTO.setLocation(location);
        weather1DTO.setCurrent(current);

        assertEquals(location, weather1DTO.getLocation());
        assertEquals(current, weather1DTO.getCurrent());
    }
}
