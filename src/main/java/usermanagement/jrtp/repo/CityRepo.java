package usermanagement.jrtp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usermanagement.jrtp.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer>{

	List<City> findByStateStateId(int stateId);
}
