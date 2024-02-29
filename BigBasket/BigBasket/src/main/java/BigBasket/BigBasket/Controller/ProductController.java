package BigBasket.BigBasket.Controller;

import BigBasket.BigBasket.Model.Product;
import BigBasket.BigBasket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/display")
    public String displayAllData(Model model){
        List<Product> temp= productService.displayAllProducts();
        model.addAttribute("productList",temp);
        return "displayProduct";

    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProductById(id);
        return "redirect:/product/display";
    }
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable int id , Model model ){
        Product p = productService.fetchProductObject(id);
        model.addAttribute("currentProductObject",p);
        productService.fetchProductObject(id);
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProductData(Product p){
        productService.updateProducts(p);
        return "redirect:/product/display";

    }


    @GetMapping("/addProduct")
    public String addNewProducts(Model model){
        model.addAttribute("newProduct", new Product());
        return "addProducts";
    }

    @GetMapping("/addProducts")
    public String saveNewProducts(@ModelAttribute("newProduct") Product p ){
        productService.addProducts(p);
        return "redirect:/product/display";


    }


}
