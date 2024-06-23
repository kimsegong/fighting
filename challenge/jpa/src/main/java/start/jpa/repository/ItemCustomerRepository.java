package start.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;

import java.util.List;

public interface ItemCustomerRepository {


  List<Item> findAll();
 // List<Item> findById(Long id);
//  @Query("UPDATE Item i SET i.name = :name, i.price = :price, i.amount = :amount, i.status = :status WHERE i.id = :id")
//  Item modifyItem(Long id, String name);
//  @Query("DELETE Item i WHERE i.id =:id")
//  int deleteItem(Long id);
}
