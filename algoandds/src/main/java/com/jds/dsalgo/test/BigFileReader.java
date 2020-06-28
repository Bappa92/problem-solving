package com.jds.dsalgo.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BigFileReader {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		int record = 100000;
		File file = new File("Records.txt");
		try {
			file.delete();
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		long start = System.currentTimeMillis();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			String str = "This is a file containing millions of records, evety line has the same string";
			for (int i = 0; i < record; i++) {
				bw.write(new StringBuilder("<").append(i).append(">").append(str).append("\n").toString());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		System.out.println(file.length() / (1024 * 1024) + " mb");
		byte[] filestr = null;
		try {
			Files.readAllBytes(Paths.get("Records.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long total = (System.currentTimeMillis() - start);
		System.out.println(total + " milsecs");
		// BufferedReader reader=new BufferedReader(new File(uri))
	}

}
