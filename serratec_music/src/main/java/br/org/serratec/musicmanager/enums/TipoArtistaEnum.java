package br.org.serratec.musicmanager.enums;

public enum TipoArtistaEnum {
	BANDA("B"), SOLO("S"), DUPLA("D");

	private String tipo;

	TipoArtistaEnum(String valor) {
		this.tipo = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
