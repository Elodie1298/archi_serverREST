package ensim.AIPS.iCommerce.Controller;

import ensim.AIPS.iCommerce.Model.Product;
import ensim.AIPS.iCommerce.Model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value="/product")
    public List<Product> getProductList() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping(value="/product/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        try {
            Product product = productRepository.findById(id).get();
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(value="/product/{id}")
    public Product updateProduct(@PathVariable("id") long id,
                                 @RequestBody Product product) {
        if (!productRepository.findById(id).isEmpty()) {
            productRepository.save(product);
        }
        return getProduct(id);
    }

    @DeleteMapping(value="/product/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productRepository.deleteById(id);
    }

    @PostMapping(value="/product")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
}
