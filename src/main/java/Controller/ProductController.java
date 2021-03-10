package Controller;

import Model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    int i = 0;
    List<Product> productList = new ArrayList<>();

    @GetMapping("/product")
    public List<Product> getAllProducts() {

        if (i == 0) {
            productList.add(new Product(1, "Mickey Mouse", 30));
            productList.add(new Product(2, "Donald Duck", 35));
            productList.add(new Product(3, "Peppa Pig", 15));
            i++;
        }
        return productList;
    }

    @GetMapping("/product/{productId}")
    public Product getProductWithId(@PathVariable Integer productId) {
        return productList.stream().filter(o -> o.getId() == (productId)).findFirst().orElse(null);
    }

    @PostMapping("/product/newProduct")
    public void addProduct(@RequestBody Product product) {
        productList.add(product);
        System.out.println("Saving product information");
    }

    @PostMapping("/product/deleteProduct/{productName}")
    public void addProduct(@PathVariable String productName) {
        productList.remove(productList.stream().filter(o -> o.getName().equals(productName)).findFirst().orElse(null));
        System.out.println("Saving product information");
    }

}
