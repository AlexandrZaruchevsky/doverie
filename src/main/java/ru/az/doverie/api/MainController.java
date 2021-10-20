package ru.az.doverie.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${MY_SERVER}")
    private String apiRest;

    @GetMapping
    public String index(
            Model model
    ){
        model.addAttribute("apiRest", apiRest);
        return "index";
    }

}
