package com.example.demo.act;

import com.example.demo.entity.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Controller
public class IndexAct {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", "java的世界");
        return "index";
    }


    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error(HttpServletRequest request) {
        return "404";

    }

}
