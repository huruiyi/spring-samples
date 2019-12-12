package com.ruiyi.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *    读取  web 应用中的 资源 文件 
 *    
 *    	servletContext对象 
 * 
 */
public class ReadContentServlet extends HttpServlet {

	private static final long serialVersionUID = 8816722636855063702L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ip = request.getRemoteAddr();

		System.out.println(ip);
		ServletContext context = getServletContext();

		// 读取 1.txt
		// 1.txt 不会发布到 tomcat服务器中去, 所以 没法读

		// 读取2.txt 文件

		String realPath2 = context.getRealPath("/2.txt");
		System.out.println(realPath2);
		readContent(realPath2);

		String path3 = context.getRealPath("/WEB-INF/3.txt");
		readContent(path3);

		String path4 = context.getRealPath("/WEB-INF/classes/4.txt");
		readContent(path4);

		System.out.println("==========");

		// 注意: 以上就是 ｗｅｂ应用中如何使用serlvetContext 对象去读取资源文件

		// 对于这些文件 ,比较特殊的是 4.txt ,在src 下.
		// 以后 , 通用的情况下, src 下 就是用来 写 源代码的, src下的源代码对应的 .class文件 会 原封 不 不动 拿到 classes
		// 文件夹下去

		// 由于 4.txt 在src 目录下, 那么 这里4.txt 又 多了一种 使用 类加载器 去 获得 路径的方式
		// 类加载器 : 负责 将 classpath 路径下的 资源 文件 加载到 虚拟机中去, .class文件 一旦被加载到虚拟机中, 那么 就 完成了累
		// 加载的过程, 那么这个
		// .class 的字节码文件就编程 Class 类的一个实例了.

		try {
			Class<?> class1 = Class.forName("com.A");
			String name = class1.getClass().getName();
			System.out.println(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 使用 类加载器 去获得 4.txt 的 路径,获得路径后, 那么 就 o 了
		URL url0 = ReadContentServlet.class.getClassLoader().getResource("4.txt");
		String file0 = url0.getFile();
		readContent(file0);

		// 使用这种方式 的时候 要 加 个 /
		URL url1 = ReadContentServlet.class.getResource("/4.txt");
		String file1 = url1.getFile();
		readContent(file1);

		System.out.println("++++++++++++++++++");

		// 相对于 虚拟器启动的目录

		String path1 = "1.txt";
		readContent(path1);

		String pathxx = "aa/1.txt";
		readContent(pathxx);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
