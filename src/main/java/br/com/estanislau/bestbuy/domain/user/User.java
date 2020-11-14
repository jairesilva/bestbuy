package br.com.estanislau.bestbuy.domain.user;

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
@Table(name = "tbuser", uniqueConstraints = @UniqueConstraint(columnNames = {"tbuser_id"}, name = "tb_user" ))
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbuser_id")
	private Long id;
	
	@Column(name = "tbuser_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tbuser_type")
	private UserType userType;
	
	@Column(name = "tbuser_user_name")
	private String userName;

	@Column(name = "tbuser_status")
	private Boolean status;
	
	@Column(name = "tbuser_created")
	private LocalDateTime created;

	@Column(name = "tbuser_password")
	private String password;
}