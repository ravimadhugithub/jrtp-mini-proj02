package usermanagement.jrtp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usermanagement.jrtp.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

}
