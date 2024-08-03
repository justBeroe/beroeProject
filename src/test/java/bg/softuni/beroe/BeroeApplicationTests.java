package bg.softuni.beroe;


import bg.softuni.beroe.repository.ExRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeroeApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ExRateRepository exRateRepository;
	@Test
	void contextLoads() {
		// This test will fail if the application context cannot be loaded
	}

	@Test
	void testBeanPresence() {
		assertNotNull(exRateRepository, "ExRateRepository bean should be present in the application context");
	}


}
