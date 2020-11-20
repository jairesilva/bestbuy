package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbprovider", uniqueConstraints = @UniqueConstraint(columnNames = {"tbprovider_id"}, name = "tb_provider" ))
public class Provider implements Serializable{

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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmailProvider> emailProviders;
	
	@Column(name = "tbprovider_status")
	private boolean status;
	
	
	@Column(name = "tbprovider_created")
	private LocalDateTime created;
}
