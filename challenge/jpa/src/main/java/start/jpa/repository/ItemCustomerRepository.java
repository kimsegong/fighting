package start.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import start.jpa.entity.Item;

import java.util.List;

@Repository
public interface ItemCustomerRepository {

  @Query("SELECT i FROM Item i")
  List<Item> getItem();
}
