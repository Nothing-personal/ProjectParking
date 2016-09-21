package com.innopolis.controller;

import com.innopolis.service.ParkingService;
import com.innopolis.service.UserServiceImpl;
import com.innopolis.utils.Ajax;
import com.innopolis.utils.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */

@Controller
public class DataController extends ExceptionHandlerController {

    @Autowired
    @Qualifier("parkingService")
    private ParkingService parkingService;

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;

    @RequestMapping(value = "/addParking", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addParking(@RequestParam("coordinates") String coordinates, @RequestParam("capacity") int capacity,
                                   @RequestParam("parkingName") String parkingName) throws RestException {
        try {
            if (coordinates == null || parkingName == null) {
                return Ajax.emptyResponse();
            }
            parkingService.addParking(coordinates, capacity, parkingName);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/showParkings", method = RequestMethod.GET)
    public @ResponseBody
    String showParkings() {
        return parkingService.showParkings();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addUser(@RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("password") String password)
                                throws RestException {
        try {
            if (email == null || phone == null || password == null) {
                return Ajax.emptyResponse();
            }
            userService.addUser(email, phone, password);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
}
