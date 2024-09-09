package usermanagement.jrtp.service;

import usermanagement.jrtp.dto.LoginFormDTO;
import usermanagement.jrtp.dto.RegistrationFormDTO;
import usermanagement.jrtp.dto.ResetPwdFormDTO;
import usermanagement.jrtp.dto.UserDTO;

public interface UserService {

	public boolean saveUser(RegistrationFormDTO regFormDto);
	public UserDTO login(LoginFormDTO loginFormDto);
	public boolean resetPwd(ResetPwdFormDTO resetPwdFormDTO);
	public boolean duplicateEmailCheck(String email);
}
