package br.com.estanislau.bestbuy.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Default Exception
 *
 * @author GSW
 * @since 6 de fev de 2019
 */
@Getter
@AllArgsConstructor
public class NotAllowException extends RuntimeException {

	private static final long serialVersionUID = 1432998003355197399L;

	private final String message;

}
