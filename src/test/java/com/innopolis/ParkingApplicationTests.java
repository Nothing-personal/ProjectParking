package com.innopolis;

import com.innopolis.entity.Parking;
import com.innopolis.repository.ParkingRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingApplicationTests {

	@Test
	public void test() {
		ParkingRepositoryImpl parkingRepository = new ParkingRepositoryImpl();
        parkingRepository.addParking(new Parking("0.1 2.3", 20, "Moscow"));
        System.out.println(parkingRepository.showParkings());
    }
}
