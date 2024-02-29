package BigBasket.BigBasket.Service;

import BigBasket.BigBasket.Model.Cart;
import BigBasket.BigBasket.Model.Product;
import BigBasket.BigBasket.Repository.CartRepository;
import BigBasket.BigBasket.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
        @Autowired
  private  CartRepository cartRepository;

        @Autowired
    private ProductRepository productRepository;

    public void addProductToTheCart(int id){
        Product p = productRepository.getSingleProduct(id);
        Cart temp = cartRepository.getSingleCartProduct(id);

        if (temp==null){
            Cart c = new Cart();
            c.setProductId(p.getProductId());
            c.setProductName(p.getProductName());
            c.setProductQty(p.getQuantity());
            c.setProductPrice(p.getPrice());
            c.setDiscounted_price(p.getDiscounted_price());
            c.setProductImage(p.getImage_url());
            c.setTempQty(1);
            cartRepository.save(c);
        }else {
            int count = temp.getTempQty();
            temp.setTempQty(++count);
            cartRepository.save(temp);

        }


    }
    public List<Cart> getAllProducts(){
        return cartRepository.findAll();
    }


        public void decreaseProductQty(int id){

        Cart c = cartRepository.getSingleCartProductsById(id);
            System.out.println(c);
            int pQty = c.getTempQty();
            if (pQty==1){
                cartRepository.deleteById(id);
            }else {
                c.setTempQty(pQty-1);
                cartRepository.save(c);
            }

        }

        public void increaseProductQty(int id ){
        Cart c = cartRepository.getSingleCartProductsById(id);
            System.out.println(c);
            int pQty = c.getTempQty();
            c.setTempQty(pQty+1);
            cartRepository.save(c);
        }
    }



