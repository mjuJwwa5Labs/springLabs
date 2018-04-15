package com.mjuApps.springDemo.task08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author marek_j on 2018-04-15
 */
@Controller
public class SwaggerController {

    @RequestMapping(value = "/documentation")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}
