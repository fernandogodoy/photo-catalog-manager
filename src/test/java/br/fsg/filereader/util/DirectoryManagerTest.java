package br.fsg.filereader.util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirectoryManagerTest {

	private Path newFile;
	private Path driveDir;

	@Before
	public void init() throws URISyntaxException {
		newFile = Paths.get("D:\\workspaceFernando\\file-manager\\src\\test\\resources\\all-files\\new");
		driveDir = Paths.get("D:\\workspaceFernando\\file-manager\\src\\test\\resources\\all-files\\drive");
	}

	@After
	public void finish() {
		DirectoryManager.moveAll(driveDir, newFile);

	}

	@Test
	public void testMoveToDrive() throws URISyntaxException {
		List<File> erros = DirectoryManager.moveAll(newFile, driveDir);
		assertTrue(erros.isEmpty());
	}

	@Test
	public void testCopyToDrive() {
		List<File> erros = DirectoryManager.copyAll(newFile, driveDir);
		assertTrue(erros.isEmpty());
	}

}
