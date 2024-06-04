package start.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import start.jpa.entity.Item;
import start.jpa.repository.ItemCustomerRepository;
import start.jpa.repository.ItemRepository1;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemCustomerRepository itemCustomerRepository;

    @Override
    public List<Item> selectItem(){
      return itemCustomerRepository.getItem();
    }

  @Override
  public Item modifyItem(Long id, String name) {
    return itemCustomerRepository.modifyItem(id, name);
  }
}
