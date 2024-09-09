package usermanagement.jrtp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usermanagement.jrtp.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer>{

	List<State> findByCountryCountryId(int countryId);
}
