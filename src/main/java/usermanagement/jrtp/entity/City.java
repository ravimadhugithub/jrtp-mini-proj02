package usermanagement.jrtp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	private String cityName;
	@ManyToOne
	private State state;
}
