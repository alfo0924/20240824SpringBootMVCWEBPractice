package fcu.web._20240824mvcspringbootmvcwebpractice.Controller;

import fcu.web._20240824mvcspringbootmvcwebpractice.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String pageA() {
        return "a";
    }

    @GetMapping("/b")
    public String pageB() {
        return "b";
    }

    @GetMapping("/c")
    public String pageC(Model model) {
        model.addAttribute("dataList", dataService.getAllData());
        return "c";
    }

    @PostMapping("/save")
    public String saveData(@RequestParam String content) {
        dataService.saveData(content);
        return "redirect:/c";
    }
}