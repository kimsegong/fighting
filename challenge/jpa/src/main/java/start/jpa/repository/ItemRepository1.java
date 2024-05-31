package start.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import start.jpa.entity.Item;

import java.util.List;


public interface ItemRepository1 extends JpaRepository<Item, Long>, ItemCustomerRepository {
  List<Item> findByName(String name);
}
