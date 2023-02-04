package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// handle requests from the client side.
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String index(Model model){
       List<Product> list = service.listAllData();
       model.addAttribute("listProducts", list);

       // direct to index.html
       return "index";
    }

    @GetMapping("/add")
    public String savePage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);

        return "add_product";
    }

    @PostMapping(value = "/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";
    }

//    @PutMapping("/edit/{id}")
//    public ModelAndView showEditPage(@PathVariable(name = "id") int id){
//        ModelAndView edit  = new ModelAndView("edit");
//        Product product = service.get(id);
//        edit.addObject("product",product);
//
//        return edit;
//    }
}
