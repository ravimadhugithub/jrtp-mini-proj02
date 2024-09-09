package usermanagement.jrtp.service;

import java.util.List;

import usermanagement.jrtp.entity.City;
import usermanagement.jrtp.entity.Country;
import usermanagement.jrtp.entity.State;

public interface LocationService {
	/**
	 * 
	public Map<Integer,String> getCountries();
	public Map<Integer,String> getStates(Integer countryId);
	public Map<Integer,String> getCities(Integer stateId);
	 */
	public List<Country> getCountries();
	public List<State> getStates(Integer countryId);
	public List<City> getCities(Integer stateId);
}
