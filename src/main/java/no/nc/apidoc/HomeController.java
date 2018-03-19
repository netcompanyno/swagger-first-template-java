package no.nc.apidoc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home redirection to swagger api documentation
 */
@Controller
@ApiIgnore
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}