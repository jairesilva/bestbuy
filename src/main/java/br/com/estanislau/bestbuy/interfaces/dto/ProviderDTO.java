package br.com.estanislau.bestbuy.interfaces.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.estanislau.bestbuy.domain.person.Contact;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderDTO implements Serializable {

	private static final long serialVersionUID = -6401213504101251026L;

	private Long id;
	private String name;
	private String address;
	private int postalCode;
	private String city;
	private String state;
	private String country;
	private boolean status;
	private LocalDateTime created;
	private List<Contact> contacts;

	public void updateCreated(LocalDateTime created) {
		if (Objects.isNull(created)) {
			return;
		}

		this.created = created;
	}
}
