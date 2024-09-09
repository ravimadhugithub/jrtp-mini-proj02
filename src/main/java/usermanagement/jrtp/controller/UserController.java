package usermanagement.jrtp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import usermanagement.jrtp.dto.LoginFormDTO;
import usermanagement.jrtp.dto.RegistrationFormDTO;
import usermanagement.jrtp.dto.ResetPwdFormDTO;
import usermanagement.jrtp.dto.UserDTO;
import usermanagement.jrtp.service.DashBoardService;
import usermanagement.jrtp.service.LocationService;
import usermanagement.jrtp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private DashBoardService dashboardService;
	
	@GetMapping("/")
	public String register(Model model) {
		RegistrationFormDTO registrationFormDTO=new RegistrationFormDTO();
		model.addAttribute("registrationFormDTO", registrationFormDTO);
		model.addAttribute("countries", locationService.getCountries());
		return "register";
	}
	
	//register
	@PostMapping("/register")
	public String register(RegistrationFormDTO registrationFormDTO,Model model) {
		boolean emailExists = userService.duplicateEmailCheck(registrationFormDTO.getEmail());
		if(emailExists) {
			model.addAttribute("eMsg", "EmailId already exists");
			model.addAttribute("countries", locationService.getCountries());
			return "register";
		}
		boolean savedUser = userService.saveUser(registrationFormDTO);
		if(savedUser) {
			model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
			model.addAttribute("sMsg", "User Registration is Succesfull..Please check your email");
			model.addAttribute("countries", locationService.getCountries());
			return "register";
		}
		
		return "register";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		LoginFormDTO loginFormDTO=new LoginFormDTO();
		model.addAttribute("loginFormDTO", loginFormDTO);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(LoginFormDTO loginFormDTO,Model model) {
		UserDTO loggedInUser = userService.login(loginFormDTO);
		if(loggedInUser==null) {
			model.addAttribute("eMsg", "Invalid Login");
			return "login";
		}else {
			if(!loggedInUser.getPwdReset()) {
				ResetPwdFormDTO resetPwdFormDTO=new ResetPwdFormDTO();
				resetPwdFormDTO.setEmail(loggedInUser.getEmail());
				model.addAttribute("resetPwdFormDTO", resetPwdFormDTO);
				return "resetPwd";
				
			}
			else {
				model.addAttribute("quoteApiResponseDTO", dashboardService.getQuote());
				return "dashboard";
				
			}
				
		}
		
	}
	@PostMapping("/resetPwd")
	public String resetPwd(ResetPwdFormDTO resetPwdFormDTO,Model model) {
		boolean resetPwd;
		if(resetPwdFormDTO.getNewPwd().equals(resetPwdFormDTO.getConfirmPwd())) {
			resetPwd = userService.resetPwd(resetPwdFormDTO);
			
		}else {
			model.addAttribute("eMsg", "New Password and Confirm Password are not matched");
			return "resetPwd";
		}
		
		if(resetPwd) {
			model.addAttribute("quoteApiResponseDTO", dashboardService.getQuote());
			return "dashboard";
		}
		else
		{
			model.addAttribute("eMsg", "User is not found");
			return "resetPwd";
		}
			
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(true);
		session.invalidate();
		LoginFormDTO loginFormDTO=new LoginFormDTO();
		model.addAttribute("loginFormDTO", loginFormDTO);
		return "login";
	}
	
}
