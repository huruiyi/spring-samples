package vip.fairy.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vip.fairy.demo.model.FormDataWithFile;


@Controller
public class FileController {


  @GetMapping(path = "/fileUpload")
  public String uploadSingleFile(Model model) {
    return "fileUpload";
  }

  @PostMapping(path = "/uploadFile")
  public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
    modelMap.addAttribute("file", file);
    return "fileUploadView";
  }


  @GetMapping(path = "/fileUploads")
  public String uploadMultiFile(Model model) {
    return "fileUploads";
  }

  @PostMapping(path = "/uploadMultiFile")
  public String submit(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {
    modelMap.addAttribute("files", files);
    return "fileUploadView";
  }


  @RequestMapping(path = "/fileUploadExt")
  public String fileUploadExt(Model model) {
    return "fileUploadExt";
  }

  @PostMapping(path = "/uploadFileWithAddtionalData")
  public String submit(@RequestParam MultipartFile file, @RequestParam String name, @RequestParam String email, ModelMap modelMap) {
    modelMap.addAttribute("name", name);
    modelMap.addAttribute("email", email);
    modelMap.addAttribute("file", file);
    return "fileUploadView";
  }


  @PostMapping("/uploadFileModelAttribute")
  public String submit(@ModelAttribute FormDataWithFile formDataWithFile, ModelMap modelMap) {
    modelMap.addAttribute("formDataWithFile", formDataWithFile);
    return "fileUploadView";
  }
}

