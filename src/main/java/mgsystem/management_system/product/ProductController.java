package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public ModelAndView showEditPageAndSave(@PathVariable(name = "id") String id){
        int convertType = Integer.parseInt(id);

        ModelAndView edit  = new ModelAndView("edit_product");
        String get = service.getOneData(convertType);
        edit.addObject("product",get);

        return edit;
    }


    // insert
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    // Put method
    @RequestMapping(value="/data/{id}", method = RequestMethod.PUT)
    public String updateData(@PathVariable("id") Long id, @RequestBody Product product){
//        String get = service.getOneData(id);
//        System.out.println(price.getClass().getName());

        String product_name = product.getName();
        Integer product_price = product.getPrice();
        System.out.println(product_price);

//        if(product_name != null && product_price > 0){
            int result = service.update(id,product_name,product_price);
            if(result == 1){
                System.out.println("Success");
            }else{
                System.out.println("Fail");
            }
//        }

        return "redirect:/";
    }

//     Delete
//    @RequestMapping(path = "/data/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(path="data/{id}")
    public String deleteData(@PathVariable("id") String id){
        int convertType = Integer.parseInt(id);
//        service.delete(convertType);

        String rspMessage = null;
        int removeResult = service.delete(convertType);

        if(removeResult == 1){
            rspMessage = "Data Removed. Effect row: " + removeResult;
        }else{
            rspMessage = "Nothing removed";
        }

        return "redirect:/";
    }
}
