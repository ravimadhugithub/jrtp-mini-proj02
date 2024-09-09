package usermanagement.jrtp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import usermanagement.jrtp.entity.City;
import usermanagement.jrtp.entity.State;
import usermanagement.jrtp.service.LocationService;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;


    @ResponseBody
    @GetMapping("/states/{countryId}")
    public List<State> getStatesByCountry(@PathVariable int countryId) {
        return locationService.getStates(countryId);
    }

    @ResponseBody
    @GetMapping("/cities/{stateId}")
    public List<City> getCitiesByState(@PathVariable int stateId) {
        return locationService.getCities(stateId);
    }
}
