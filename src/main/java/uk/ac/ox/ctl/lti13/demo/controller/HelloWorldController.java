package uk.ac.ox.ctl.lti13.demo.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HelloWorldController {
    private final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping({"/index", "/"})
    public String index(Model model) {
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        log.info("user: {}", user.getName() );
        return "index";
    }
}
