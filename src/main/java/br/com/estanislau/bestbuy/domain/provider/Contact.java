package br.com.estanislau.bestbuy.domain.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
import br.com.estanislau.bestbuy.domain.utils.MailValidator;
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
@Table(name = "tbcontact", uniqueConstraints = @UniqueConstraint(columnNames = { "tbcontact_email",
		"provider_id" }, name = "tb_contact_email_provider_id_UK"))

public class Contact implements Serializable {

	private static final long serialVersionUID = -9166642389320387001L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbcontact_id")
	private Long id;

	@Column(name = "tbcontact_type")
	private typeContactEnum type;

	@Column(name = "tbcontact_name")
	private String name;

	@Column(name = "tbcontact_telephone")
	private String telephone;

	@Column(name = "tbcontact_email", nullable = false)
	private String email;

	private Contact(final typeContactEnum type, final String name, final String telephone, final String email) {
		this.type = type;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
	}

	/**
	 * Set a provider without override an old existent one. It's a solution for
	 * Cascade bug
	 *
	 * @param provider A provider to be set in a null attribute
	 */
//	public void setProviderWhenNull(final Provider provider) {
//		checkNotNull(provider, "Provider cannot be null to be set on an Contact");
//		final String message = "Not allow override a Provider in Contact.";
//		if (!Objects.isNull(this.provider)) {
//			throw new NotAllowException(message);
//		}
//		this.provider = provider;
//	}

	/**
	 * Update Contact
	 *
	 * @param name      Name of email owner
	 * @param telephone Telephone of the owner
	 * @param email     Email
	 */
	public void update(final typeContactEnum type, final String name, final String telephone, final String email) {
		validateEmail(email);
		this.type = type;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
	}

	public static Contact of(final typeContactEnum type, final String name, final String telephone,
			final String email) {
		validateEmail(email);
		return new Contact(type, name, telephone, email);
	}

	private static void validateEmail(final String email) {
		checkNotNull(email, "Email cannot be null on an Contact.");
		if (!MailValidator.validaEmail(email)) {
			throw new NotAllowException("The e-mail: ".concat(email).concat(" is not valid."));
		}
	}
}
