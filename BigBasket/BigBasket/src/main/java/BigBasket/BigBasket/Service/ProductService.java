package BigBasket.BigBasket.Service;

import BigBasket.BigBasket.Model.Product;
import BigBasket.BigBasket.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productRepository;

        public List<Product> displayAllProducts(){
            return productRepository.findAll();
        }

    public void deleteProductById(int id) {
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Product fetchProductObject(int id) {
        Product p = null;
        try{
            p = productRepository.getSingleProduct(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public void updateProducts(Product p){
        productRepository.save(p);

    }

    public void addProducts(Product p){
        productRepository.save(p);
    }
}
