package com.jds.dsalgo.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioTest {

	public static void main(String[] args) throws IOException {
		String name = "Records.txt";
		String mode = "r";
		String str="<0>This is a file containing millions of records, evety line has the same string";
		
 
		try (RandomAccessFile file = new RandomAccessFile(name, mode); FileChannel reader = file.getChannel()) {
			ByteBuffer dst = ByteBuffer.allocate(100);
			
			reader.read(dst,1000);
			System.out.println(new String(dst.array(), StandardCharsets.UTF_8));
			
			RandomAccessFile file2 = new RandomAccessFile(name, "rws");
			FileChannel writer = file2.getChannel();
            ByteBuffer dst2 = ByteBuffer.wrap(str.getBytes());
            System.out.println(writer.size());
            int i=0;
            writer.force(true);

            while( i++<10000000) {
    			writer.write(dst2);
            }
            System.out.println(writer.size());
//            .read(dst2,1000);
//			System.out.println(new String(dst2.array(), StandardCharsets.UTF_8));
			
			writer.close();
			file2.close();
		} 
	}

}
