package usermanagement.jrtp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteApiResponseDTO {

	private int id;
	private String quote;
	private String author;
}
