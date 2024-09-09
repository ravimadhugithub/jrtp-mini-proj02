package usermanagement.jrtp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usermanagement.jrtp.entity.City;
import usermanagement.jrtp.entity.Country;
import usermanagement.jrtp.entity.State;
import usermanagement.jrtp.repo.CityRepo;
import usermanagement.jrtp.repo.CountryRepo;
import usermanagement.jrtp.repo.StateRepo;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private CityRepo cityRepo;
	@Override
	public List<Country> getCountries() {
		return countryRepo.findAll();
	}
	@Override
	public List<State> getStates(Integer countryId) {
		return stateRepo.findByCountryCountryId(countryId);
	}
	@Override
	public List<City> getCities(Integer stateId) {
		return cityRepo.findByStateStateId(stateId);
	}
	
	/**
	 
	@Override
	public Map<Integer, String> getCountries() {
		List<Country> countries = countryRepo.findAll();
		Map<Integer, String> countryMap=new HashMap<>();
		countries.stream().forEach(c->countryMap.put(c.getCountryId(), c.getCountryName()));
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<State> states = stateRepo.findByCountryCountryId(countryId);
		Map<Integer, String> statesMap=new HashMap<>();
		states.stream().forEach(s->statesMap.put(s.getStateId(), s.getStateName()));
		return statesMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<City> cities = cityRepo.findByStateStateId(stateId);
		Map<Integer, String> citiesMap=new HashMap<>();
		cities.stream().forEach(c->citiesMap.put(c.getCityId(), c.getCityName()));
		return citiesMap;
	}
     * 
	 */
}
