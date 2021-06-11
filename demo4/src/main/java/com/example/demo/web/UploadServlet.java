package com.example.demo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(value = "/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 6339400552646746952L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			System.out.println(items.size());
			for (FileItem item : items) {

				if (item.isFormField()) {
					processFormField(item);
				} else {
					processUploadedFile(item);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	private void processFormField(FileItem item) {
		if (item.isFormField()) {
			String name = item.getFieldName();
			String value = item.getString();
			System.out.println(name + " " + value);
		}
	}

	private void processUploadedFile(FileItem item) {
		String fieldName = item.getFieldName();
		String fileName = item.getName();
		String contentType = item.getContentType();
		boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();
		System.out.println(fieldName + "  " + fileName + "  " + contentType + "  " + isInMemory + "  " + sizeInBytes);
	}

}
