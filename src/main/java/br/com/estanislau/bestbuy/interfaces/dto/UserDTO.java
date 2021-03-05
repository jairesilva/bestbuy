package br.com.estanislau.bestbuy.interfaces.dto;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.estanislau.bestbuy.domain.user.UserTypeEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3743404578869630625L;

	private Long id;
	private String name;
	private UserTypeEnum userType;
	private String login;
	private LocalDateTime created;
	private String password;

	public void updateCreated(UserDTO userDTO) {
		checkNotNull(userDTO, "User need information to update.");
		this.created = LocalDateTime.now();
	}

	public void encriptPassword(UserDTO userDTO) {
		String salGerado = BCrypt.gensalt();
		this.password = BCrypt.hashpw(userDTO.getPassword(), salGerado);
	}

//	public boolean autentica(Usuario usuarioCandidato) {
//
//	    String loginDoCandidato = usuarioCandidato.getLogin();
//	    String senhaDoCandidato = usuarioCandidato.getSenha(); // Essa senha está em texto puro, sem hash.
//
//	    Usuario usuarioComSenhaHasheada = this.pegaUsuarioDoBanco(loginDoCandidato);
//	    String senhaDoBanco = usuarioComSenhaHasheada.getSenha(); // Essa senha está hasheada.
//
//	    // Usa o BCrypt para verificar se a senha passada está correta.
//	    // Isso envolve ler a senhaDoBanco, separar o que é sal e o que é hash
//	    // usar o sal para criar um hash da senhaDoCandidato e, por fim
//	    // verificar se os hashes gerados são iguais.
//	    boolean autenticacaoBateu = BCrypt.checkpw(senhaDoCandidato, senhaDoBanco);
//
//	    return autenticacaoBateu;
//
//	}
}
