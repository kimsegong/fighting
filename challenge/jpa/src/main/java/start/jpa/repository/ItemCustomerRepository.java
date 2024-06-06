package start.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;

import java.util.List;

public interface ItemCustomerRepository {


  List<Item> findAll();
  List<Item> findById(Long id);
  //Item modifyItem(Long id, String name);
}
