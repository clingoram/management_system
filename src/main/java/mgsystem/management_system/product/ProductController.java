package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Handle requests from the client side.
@Controller
//@RestController
//@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    // direct to index.html.
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model){
       List<Product> list = service.listAllData();
       model.addAttribute("listProducts", list);

       return "/index";
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
        if(product.getName() != null && product.getPrice() > 0){
            service.save(product);
            return "redirect:/";
        }
        return "redirect:/";
    }

//    @RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable(name = "id") Long id){

//        String getData = service.getOneData(id.intValue());
        System.out.println("showUpdatePage");
        Product getData = service.get(id);
//        System.out.println(getData);

        ModelAndView mav  = new ModelAndView("edit_product");
        mav.addObject("product",getData);
        return  mav;

//        model.addAttribute("product",getData);
//        System.out.println(model);
//        return "edit_product";
    }

    // Put method
    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public String updateData(@PathVariable("id") Long id, @RequestBody Product product){
        String productName = product.getName();
        Integer productPrice = product.getPrice();
//        System.out.println(productPrice.getClass().getName());

        service.update(id,productName,productPrice);
        return "redirect:/";
    }

//     Delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteData(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
