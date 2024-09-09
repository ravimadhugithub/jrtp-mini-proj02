package usermanagement.jrtp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import usermanagement.jrtp.dto.QuoteApiResponseDTO;
import usermanagement.jrtp.service.DashBoardService;

@Controller
public class DashboardController {

	@Autowired
	private DashBoardService dashboardService;
	
	@PostMapping("/getQuotes")
	public String getQuotes(QuoteApiResponseDTO quoteApiResponseDTO,Model model) {
		
		model.addAttribute("quoteApiResponseDTO", dashboardService.getQuote());
		return "dashboard";
		
	}
}
