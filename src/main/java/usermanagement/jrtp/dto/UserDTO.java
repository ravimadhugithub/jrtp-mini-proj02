package usermanagement.jrtp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Integer userId;
	private String userName;
	private String email;
	private Integer phNo;
	private String pwd;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private Boolean pwdReset;
	private Date createdDate;
	private Date updatedDate;
}
