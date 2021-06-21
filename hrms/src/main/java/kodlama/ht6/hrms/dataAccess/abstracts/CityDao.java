package kodlama.ht6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City getByid(Integer id);
}
