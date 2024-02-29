package BigBasket.BigBasket.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int cartId;
    private int productId;
    private String productName;
    private double productPrice;
    private double discounted_price;
    private String productQty;
    private int tempQty;
    private String productImage;
}
