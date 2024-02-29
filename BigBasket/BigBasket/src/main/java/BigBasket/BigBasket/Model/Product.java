package BigBasket.BigBasket.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "bigbasket")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "Product_Name")
    private String ProductName;

    @Column(name = "Brand")
    private  String Brand;

    @Column(name = "Price")
    private double Price;

    @Column(name = "discounted_price")
    private double discounted_price;

    @Column(name = "Image_url")
    private String Image_url;

    @Column(name = "Quantity")
    private String Quantity;

    @Column(name = "Category")
    private String Category;

    @Column(name = "SubCategory")
    private String SubCategory;


}
