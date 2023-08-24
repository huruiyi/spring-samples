package vip.fairy.demo.web;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET)
  public String welcome(Model model) {
    model.addAttribute("today", LocalDate.now());
    return "welcome";
  }

}
