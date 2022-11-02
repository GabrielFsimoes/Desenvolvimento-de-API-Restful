package br.org.serratec.Aula07.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.Aula07.exception.EnumValidationException;

public enum Categoria {
	HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;

	@JsonCreator
	public static Categoria verifica(String value) throws EnumValidationException {
		for (Categoria categ : Categoria.values()) {
			if (value.equals(categ.name())) {
				return categ;
			}
		}
		throw new EnumValidationException("Categoria" + value + " não existe");
	}

}
