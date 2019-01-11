package no.nc.apidoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class HomeController {

    @Value("${swagger-ui.version}")
    private String swaggerUiVersion;

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:webjars/swagger-ui/" + swaggerUiVersion + "/index.html?url=/api.yml";
    }
}