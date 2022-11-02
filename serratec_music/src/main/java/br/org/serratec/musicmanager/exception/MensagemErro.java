package br.org.serratec.musicmanager.exception;

public class MensagemErro {
	private String atributo;
	private String mensagem;

	public MensagemErro(String atributo, String mensagem) {
		super();
		this.atributo = atributo;
		this.mensagem = mensagem;
	}

	public MensagemErro() {
		super();

	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
