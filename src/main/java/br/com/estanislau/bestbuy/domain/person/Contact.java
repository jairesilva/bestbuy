package br.com.estanislau.bestbuy.domain.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.estanislau.bestbuy.domain.provider.Provider;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbcontact", uniqueConstraints = @UniqueConstraint(columnNames = { "tbcontact_id" }, name = "tb_contact"))
public class Contact implements Serializable {

	private static final long serialVersionUID = -9166642389320387001L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbcontact_id")
	private Long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "tbprovider_id", nullable = false)
	private Provider provider;

	@Column(name = "tbcontact_phone")
	private String phone;

	@Column(name = "tbcontact_email", nullable = false)
	private String email;

}
