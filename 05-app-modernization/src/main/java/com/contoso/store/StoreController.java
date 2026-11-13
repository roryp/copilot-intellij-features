package com.contoso.store;

import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringBootVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class StoreController {

    private final Catalog catalog;

    StoreController(Catalog catalog) {
        this.catalog = catalog;
    }

    // Handle the GET request for the home page, showing the six products.
    // Stock changes, so browsers mustn't cache the page.
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model, HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store");
        model.addAttribute("products", catalog.all());
        model.addAttribute("springBootVersion", SpringBootVersion.getVersion());
        return "index";
    }
}
