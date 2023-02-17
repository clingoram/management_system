package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Handle requests from the client side.
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    // direct to index.html.
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model){
       List<Product> list = service.listAllData();
       model.addAttribute("listProducts", list);
       return "index";
    }

    // direct to add product page.
    @RequestMapping(path = "/data", method = RequestMethod.GET)
    public String showAddPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add_product";
    }

    // direct to edit page and save the edited data.
//    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
//    public ModelAndView showEditPageAndSave(@PathVariable(name = "id") String id){
//        int convertType = Integer.parseInt(id);
//
//        ModelAndView edit  = new ModelAndView("edit_product");
//        String get = service.getOneData(convertType);
//        edit.addObject("product",get);
//
//        return edit;
//    }

    // insert
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/data/{id}")
    public ModelAndView showUpdatePage(@PathVariable(name = "id") Long id){
//        String getData = service.getOneData(id);

        Product getData = service.get(id);

        ModelAndView mav  = new ModelAndView("edit_product");
        mav.addObject("product",getData);
        return  mav;
//        model.addAttribute("product",getData);
//        System.out.println(model);
//        return "edit_product";
    }

    // Put method
    @RequestMapping(value="/data/{id}", method = RequestMethod.PUT)
    public String updateData(@PathVariable("id") Long id, @RequestBody Product product){
//        System.out.println(price.getClass().getName());
        String productName = product.getName();
        Integer productPrice = product.getPrice();
        System.out.println(productName);
        System.out.println(productPrice);

        service.update(id,productName,productPrice);
        return "redirect:/";
    }

//     Delete
    @RequestMapping(value = "/data/{id}", method = RequestMethod.DELETE)
//    @DeleteMapping(path="data/{id}")
    public String deleteData(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
