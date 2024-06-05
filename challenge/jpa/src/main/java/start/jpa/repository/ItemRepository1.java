package start.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import start.jpa.entity.Item;

public interface ItemRepository1 extends JpaRepository<Item, Long>, ItemCustomerRepository {
}
