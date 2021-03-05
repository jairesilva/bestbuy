package br.com.estanislau.bestbuy.domain.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbuser", uniqueConstraints = @UniqueConstraint(columnNames = { "tbuser_id" }, name = "tb_user"))
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbuser_id")
	private Long id;

	@Column(name = "tbuser_name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "tbuser_type")
	private UserTypeEnum userType;

	@Column(name = "tbuser_login")
	private String login;

	@Column(name = "tbuser_status")
	private Boolean status;

	@Column(name = "tbuser_created")
	private LocalDateTime created;

	@Column(name = "tbuser_password")
	private String password;

	public void update(User user) {
		checkNotNull(user, "User need information to update.");
		this.id = user.getId();
		this.name = user.getName();
		this.userType = user.getUserType();
		this.login = user.getLogin();
		this.status = user.getStatus();
		this.password = user.getPassword();
	}
}