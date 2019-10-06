package com.admin.ziputils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.admin.util.ZipUtils;

public class ZipUtilsTest {

	@Test
	public void zipFilesTest() throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Project_Work/samples/src_sample1.zip");
		File file = new File("C:\\Project_Work\\samples\\outputzip\\sample.txt");
		File file1 = new File("C:\\Project_Work\\samples\\outputzip\\sample1.txt");
		File file2 = new File("C:\\Project_Work\\samples\\outputzip\\sample2.txt");

		List<File> files = new ArrayList<>();
		files.add(file);
		files.add(file1);
		files.add(file2);
		ZipUtils.zipFiles(files, fos);
	}

	@Test
	public void unZipFilesTest() throws IOException {
		File zipFile = new File("C:/Project_Work/samples/src_sample1.zip");
		File unZipOutputFolder = new File("C:/Project_Work/samples/dest_folder");
		ZipUtils.unZipFiles(zipFile, unZipOutputFolder);
	}
}