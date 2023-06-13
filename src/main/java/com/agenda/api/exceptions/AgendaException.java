package com.agenda.api.exceptions;

public class AgendaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgendaException(String errorMessage) {
		super(errorMessage);
	}
}
