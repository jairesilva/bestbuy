package br.com.estanislau.bestbuy.domain.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.validator.routines.EmailValidator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
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
@Table(name = "tbemailprovider", uniqueConstraints = @UniqueConstraint(columnNames = { "tbemailprovider_email",
		"tbprovider_id" }, name = "tbemailprovider_email_provider_id_UK"))
public class EmailProvider implements Serializable {
	
	private static final long serialVersionUID = -9166642389320387001L;

	/**
	 * Factory method for create and validate a EmailProvider
	 *
	 * @param name      Name of email owner
	 * @param telephone Telephone of the owner
	 * @param email     Email
	 * @return new EmailProvider
	 */
	public static EmailProvider of(final String name, final String telephone, final String email) {
		validateEmail(email);
		return new EmailProvider(name, telephone, email);
	}

	private static void validateEmail(final String email) {
		checkNotNull(email, "Email cannot be null on an EmailProvider.");
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new NotAllowException("The e-mail: ".concat(email).concat(" is not valid."));
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbemailprovider_id")
	private Long id;

	@Column(name = "tbemailprovider_name")
	private String name;

	@Column(name = "tbemailprovider_telephone")
	private String telephone;

	@Column(name = "tbemailprovider_email", nullable = false)
	private String email;

	@ToString.Exclude
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tbprovider_id", referencedColumnName = "tbprovider_id", foreignKey = @ForeignKey(name = "tbemailprovider_tbprovider_FK"), nullable = false)
	private Provider provider;

	private EmailProvider(final String name, final String telephone, final String email) {
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
	public void setProviderWhenNull(final Provider provider) {
		checkNotNull(provider, "Provider cannot be null to be set on an EmailProvider");
		final String message = "Not allow override a Provider in EmailProvider.";
		if (!Objects.isNull(this.provider)) {
			throw new NotAllowException(message);
		}
		this.provider = provider;
	}

	/**
	 * Update EmailProvider
	 *
	 * @param name      Name of email owner
	 * @param telephone Telephone of the owner
	 * @param email     Email
	 */
	public void update(final String name, final String telephone, final String email) {
		validateEmail(email);
		this.name = name;
		this.telephone = telephone;
		this.email = email;
	}

}
