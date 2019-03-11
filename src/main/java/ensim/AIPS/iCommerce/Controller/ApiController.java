package ensim.AIPS.iCommerce.Controller;

import ensim.AIPS.iCommerce.Model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Linker au controller firebase
    @GetMapping(value="/product")
    public List<Product> getProductList() {
        return new ArrayList<Product>();
    }

    // Verifier type id
    // Linker au controller firebase
    @GetMapping(value="/product/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return new Product(0, null, null, 0);
    }

    // Verifier type id
    // Linker au controller firebase
    @PutMapping(value="/product/{id}")
    public Product updateProduct(@PathVariable("id") long id,
                                 @RequestBody Product product) {
        System.out.println("product.getName() = " + product.getName());
        return new Product(0, null, null, 0);
    }

    // Verifier type id
    // Linker au controller firebase
    @DeleteMapping(value="/product/{id}")
    public Product deleteProduct(@PathVariable("id") long id) {
        return new Product(0, null, null, 0);
    }

    // Verifier type id
    // Linker au controller firebase
    // Linker à l'authentification
    @PostMapping(value="/product")
    public Product addProduct(@RequestBody Product product) {
        System.out.println("product = " + product.getName());
        return new Product(0, null, null, 0);
    }
}
