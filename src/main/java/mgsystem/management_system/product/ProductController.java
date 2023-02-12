package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.data.repository.query.Param;
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

    @RequestMapping(value = "/update/{id}", method=RequestMethod.GET)
    public String showUpdatePage(@PathVariable(name = "id") Long id){
//        int convertIdType = Integer.parseInt(id);
        String getData = service.getOneData(id);

        ModelAndView edit  = new ModelAndView("edit_product");
        edit.addObject("product",getData);
        return "edit_product";
    }


    // insert
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    // Put method
    @RequestMapping(value="/data/{id}", method = RequestMethod.PUT)
    public String updateData(@PathVariable("id") Long id, @RequestBody Product product,Model model){
//        String get = service.getOneData(id);
//        System.out.println(price.getClass().getName());

        String productName = product.getName();
        Integer productPrice = product.getPrice();

        int updateResult = service.update(id,productName,productPrice);
//        if(updateResult == 1){
//            System.out.println("Success");
//        }else{
//            System.out.println("Fail");
//        }

        return "redirect:/";
    }

//     Delete
    @RequestMapping(path = "/data/{id}", method = RequestMethod.DELETE)
//    @DeleteMapping(path="data/{id}")
    public String deleteData(@PathVariable("id") Long id){
//        int convertIdType = Integer.parseInt(id);
        service.delete(id);
        return "redirect:/";
    }
}
