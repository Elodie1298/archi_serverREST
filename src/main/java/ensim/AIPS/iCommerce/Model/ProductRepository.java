package ensim.AIPS.iCommerce.Model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Modifying
    @Query("update Product p set p.name = ?2, p.description = ?3, p.stock = ?4 where p.id = ?1")
    void setProductInfoById(Long id, String name, String description, int stock);
}
