package com.ssm.maven.core.admin;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/loadimg")
public class LoadImageController {

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam("file") MultipartFile file) throws Exception {
        ServletContext sc = request.getSession().getServletContext();
        String dir = sc.getRealPath("/upload");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String imgName;
        switch (type) {
            case "jpg":
                imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpg";
                break;
            case "png":
                imgName = sdf.format(new Date()) + r.nextInt(100) + ".png";
                break;
            case "jpeg":
                imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpeg";
                break;
            default:
                return null;
        }
        FileUtils.writeByteArrayToFile(new File(dir, imgName), file.getBytes());
        response.getWriter().print("upload/" + imgName);
        return null;
    }
}
