package usermanagement.jrtp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import usermanagement.jrtp.dto.QuoteApiResponseDTO;

@Service
public class DashBoardServiceImpl implements DashBoardService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public QuoteApiResponseDTO getQuote() {
		QuoteApiResponseDTO res =restTemplate.getForObject("https://dummyjson.com/quotes/random", QuoteApiResponseDTO.class);
		return res;
	}

}
