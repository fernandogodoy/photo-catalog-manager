package br.fsg.filereader.exception;

public class FileProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FileProductNotFoundException() {
		super("Arquivo de imagem do produto não encontrado");
	}

}
