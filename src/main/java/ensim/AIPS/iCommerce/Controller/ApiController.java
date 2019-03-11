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
        return productRepository.findById(id).get();
    }

    // Vérifier la modification
    @PutMapping(value="/product/{id}")
    public Product updateProduct(@PathVariable("id") long id,
                                 @RequestBody Product product) {
        if (productRepository.findById(id).get().getId() == id) {
            productRepository.findById(id).get().setName(product.getName());
            productRepository.findById(id).get().setDescription(product.getDescription());
            productRepository.findById(id).get().setStock(product.getStock());
            return getProduct(id);
        }
        else {
            return null;
        }
    }

    // Vérifier le changement
    @DeleteMapping(value="/product/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productRepository.deleteById(id);
    }

    // Vérifier le changement
    // Linker à l'authentification
    @PostMapping(value="/product")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
}
