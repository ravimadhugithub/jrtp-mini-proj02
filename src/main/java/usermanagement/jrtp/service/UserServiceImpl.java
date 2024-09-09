package usermanagement.jrtp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usermanagement.jrtp.dto.LoginFormDTO;
import usermanagement.jrtp.dto.RegistrationFormDTO;
import usermanagement.jrtp.dto.ResetPwdFormDTO;
import usermanagement.jrtp.dto.UserDTO;
import usermanagement.jrtp.entity.User;
import usermanagement.jrtp.repo.UserRepo;
import usermanagement.jrtp.util.PasswordGenerator;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EmailService emailService;
	
	@Override
	public boolean saveUser(RegistrationFormDTO regFormDto) {
		User user = modelMapper.map(regFormDto, User.class);
		user.setPwdReset(false);
		user.setPwd(PasswordGenerator.generateRandomPassword(8));//generate random pwd
		User savedUser = userRepo.save(user);
		if(null!=savedUser) {
			emailService.sendEmail("User Registration is Succesfull", savedUser.getPwd(), regFormDto.getEmail());
			return true;
		}
		return false;
	}

	@Override
	public UserDTO login(LoginFormDTO loginFormDto) {
		User user=userRepo.findByEmailAndPwd(loginFormDto.getEmail(),loginFormDto.getPwd());
		if(null!=user) {
			return modelMapper.map(user, UserDTO.class);
		}
		else 
			return null;
	}

	@Override
	public boolean resetPwd(ResetPwdFormDTO resetPwdFormDTO) {
		User user=userRepo.findByEmailAndPwd(resetPwdFormDTO.getEmail(),resetPwdFormDTO.getOldPwd());
		User updatedUser = null;
		if(null!=user) {
			user.setPwd(resetPwdFormDTO.getNewPwd());
			user.setPwdReset(true);
			updatedUser = userRepo.save(user);
		}
		
		if(null!=updatedUser) {
			return true;
		}
		return false;
	}

	@Override
	public boolean duplicateEmailCheck(String email) {
		User user = userRepo.findByEmail(email);
		if(null!=user) {
			return true; //true indicates email exists
		}
		return false; //false indicates email does not exists
	}


}
