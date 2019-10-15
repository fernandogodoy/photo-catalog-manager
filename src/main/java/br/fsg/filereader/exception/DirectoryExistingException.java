package br.fsg.filereader.exception;

public class DirectoryExistingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DirectoryExistingException() {
		super("Existing directory");
	}

}
