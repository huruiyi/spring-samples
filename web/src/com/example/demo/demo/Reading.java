package com.example.demo.demo;

import java.io.FileInputStream;
import java.io.InputStream;

public class Reading {
	public static void main(String[] args) {
		
		String path1 = "1.txt";
		readContent(path1);

		String path2 = "WebContent/2.txt";
		readContent(path2);

		String path3 = "WebContent/WEB-INF/3.txt";
		readContent(path3);

		String path4 = "src/4.txt";
		readContent(path4);
	}

	// 只需要将 路径传递进来, 就可以 打印文件中的 内容
	public static void readContent(String path) {

		try {
			InputStream in = new FileInputStream(path);

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) > 0) {
				System.out.println(new String(buf, 0, len));
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
