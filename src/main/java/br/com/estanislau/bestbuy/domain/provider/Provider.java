package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbprovider", uniqueConstraints = @UniqueConstraint(columnNames = {
		"tbprovider_id" }, name = "tb_provider"))
public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbprovider_id")
	private Long id;

	@Column(name = "tbprovider_name")
	private String name;

	@Column(name = "tbprovider_address")
	private String address;

	@Column(name = "tbprovider_postal_code")
	private int postalCode;

	@Column(name = "tbprovider_city")
	private String city;

	@Column(name = "tbprovider_state")
	private String state;

	@Column(name = "tbprovider_country")
	private String country;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "provider_id")
	private List<Contact> contacts;

	@Column(name = "tbprovider_status")
	private boolean status;

	@Column(name = "tbprovider_created")
	private LocalDateTime created;

	public void updateContact(List<Contact> contacts) {
		if (this.contacts.equals(contacts)) {
			return;
		}
		if (this.contacts.size() > contacts.size()) {
			this.contacts.retainAll(contacts);
		} else if (this.contacts.size() < contacts.size()) {
			for (int i = 0; i < this.contacts.size(); i++) {
				this.contacts.get(i).update(contacts.get(i).getType(), contacts.get(i).getName(),
						contacts.get(i).getTelephone(), contacts.get(i).getEmail());
			}
			for (int i = this.contacts.size(); i < contacts.size(); i++) {
				this.contacts.add(contacts.get(i));
			}
		} else {
			for (int i = 0; i < this.contacts.size(); i++) {
				this.contacts.get(i).update(contacts.get(i).getType(), contacts.get(i).getName(),
						contacts.get(i).getTelephone(), contacts.get(i).getEmail());
			}
		}
	}

	public void update(Provider provider) {
		this.name = provider.getName();
		this.address = provider.getAddress();
		this.postalCode = provider.getPostalCode();
		this.city = provider.getCity();
		this.state = provider.getState();
		this.country = provider.getCountry();
		this.contacts = provider.getContacts();
	}

	public void updateFromDTO(ProviderDTO providerDTO) {
		this.name = providerDTO.getName();
		this.address = providerDTO.getAddress();
		this.postalCode = providerDTO.getPostalCode();
		this.city = providerDTO.getCity();
		this.state = providerDTO.getState();
		this.country = providerDTO.getCountry();
	}

}
