package kr.jobtc.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConditionController {
   
   @RequestMapping(path="/if")
   public String ifTest(Model model){
      model.addAttribute("x", 100);
      model.addAttribute("y", 200);
      return "if.html";
   }

   @RequestMapping(path="/switch")
   public String switchTest(Model model){
      model.addAttribute("grade", "F");
      return "switch.html";
   }
}
