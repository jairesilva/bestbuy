package br.com.estanislau.bestbuy.interfaces.dto;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderDTO {

	private Long id;
	private String name;
	private String address;
	private int postalCode;
	private String city;
	private String state;
	private String country;
	private List<ContactDTO> contactDTO;
	private boolean status;
	private LocalDateTime created;

	public void updateCreated(ProviderDTO providerDTO) {
		checkNotNull(providerDTO, "Provider need information to update.");
		this.created = LocalDateTime.now();
	}

}
