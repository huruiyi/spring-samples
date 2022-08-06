package com.example.demo.demo;

import java.io.FileInputStream;
import java.io.InputStream;

public class Reading {
	public static void main(String[] args) {

		String path = System.getProperty("user.dir");
		System.out.println(path);

		String path1 = path + "\\src\\main\\resources\\1.txt";
		readContent(path1);
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
