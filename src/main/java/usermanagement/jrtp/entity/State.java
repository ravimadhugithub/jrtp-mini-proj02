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
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;
	private String stateName;
	@ManyToOne
	private Country country; 

}
