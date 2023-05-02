package com.example.demo.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FilesController {

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(Model model) {
		model.addAttribute("message", "文件上传实验");
		return "upload";
	}

	@RequestMapping(value = "/fileupload")
	@ResponseBody
	public String handleFormupload(@RequestParam("uploadfile") List<MultipartFile> uploadfile) {
		System.out.println(uploadfile.size());
		return "";
	}

	@RequestMapping(value = "uploads")
	public String loginMethod(@RequestParam("file") List<MultipartFile> uploadfile, MultipartHttpServletRequest request)
			throws IOException {

		String username = request.getParameter("username");
		System.out.println("username=" + username);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");

		for (MultipartFile file : uploadfile) {
			String eachFileName = file.getOriginalFilename();
			InputStream eachFileStream = file.getInputStream();

			String dateString = format.format(new Date());
			dateString = dateString + "_" + System.currentTimeMillis() + "_" + eachFileName;

			File destination = new File(uploadPath, dateString);
			FileUtils.copyInputStreamToFile(eachFileStream, destination);
		}
		return "upload";
	}
}
