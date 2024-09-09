package usermanagement.jrtp.entity;

import java.sql.Time;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String email;
	private Integer phNo;
	private String pwd;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private Boolean pwdReset;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
}
