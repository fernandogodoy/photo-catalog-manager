package br.fsg.filereader.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DirectoryManager {

	private static final Logger LOG = LogManager.getLogger(DirectoryManager.class);
	private static final String JPG = ".jpg";

	public static List<File> moveAll(Path source, Path target) {
		LOG.info("Source Path:" + source.toString());
		LOG.info("Target Path:" + target.toString());

		List<File> fileMoveErros = new ArrayList<>();

		List<File> allFiles = Arrays.asList(source.toFile().listFiles());
		for (File file : allFiles) {
			try {
				FileUtils.moveFileToDirectory(file, target.toFile(), true);
			} catch (IOException e) {
				LOG.info("Move File Error", e);
				fileMoveErros.add(file);
			}
		}
		return fileMoveErros;
	}

	public static List<File> copyAll(Path source, Path target) {
		List<File> fileMoveErros = new ArrayList<>();
		List<File> allFiles = Arrays.asList(source.toFile().listFiles());

		Integer count = 0;
		for (File file : allFiles) {
			try {
				File temp = createNewFile(count.toString(), file);
				FileUtils.moveFileToDirectory(temp, target.toFile(), true);
			} catch (Exception e) {
				LOG.info("Move File Error", e);
				fileMoveErros.add(file);
			}
		}
		return fileMoveErros;
	}

	public static void createAndMove(File source, Path target, Long id) {
		try {
			File temp = createNewFile(id.toString(), source);
			FileUtils.moveFileToDirectory(temp, target.toFile(), true);
		} catch (IOException e) {
			LOG.info("Move File Error", e);
		}
	}

	public static void moveTo(Path source, Path target) {
		try {
			FileUtils.moveFileToDirectory(source.toFile(), target.toFile(), true);
		} catch (IOException e) {
			LOG.info("Move File Error", e);
		}
	}

	public static void createFolder(Path source) {
		File file = source.toFile();
		boolean isExists = file.exists();
		LOG.info("Existing folder: " + isExists);

		if (!isExists) {
			LOG.info("Creating a new folder: " + source.toString());
			file.mkdirs();
		}
	}

	private static File createNewFile(String fileName, File file) throws IOException, FileNotFoundException {
		LOG.info("Creating a new file: " + fileName);
		File temp = new File(fileName + JPG);
		temp.createNewFile();
		try (InputStream is = new FileInputStream(file)) {
			try (OutputStream os = new FileOutputStream(temp)) {
				byte[] bFile = new byte[(int) file.length()];
				is.read(bFile);
				os.write(bFile);
			}
		}
		return temp;
	}

	public static void deleteFile(String description) {
		deleteFile(Paths.get(description));
	}

	public static void createFolder(String reservedPath) {
		createFolder(Paths.get(reservedPath));
	}

	public static void deleteFile(Path path) {
		try {
			Files.delete(path);
		} catch (IOException e) {
			LOG.info("Error on delete " + path.toString(), e);
		}

	}
}
