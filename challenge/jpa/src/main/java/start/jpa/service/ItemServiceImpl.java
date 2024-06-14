package start.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.jpa.entity.Item;
import start.jpa.repository.ItemCustomerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemCustomerRepository itemCustomerRepository;

    @Override
    public List<Item> selectItem(){
      return itemCustomerRepository.findAll();
    }

  @Override
  public Item modifyItem(Long id, String name) {
    return itemCustomerRepository.modifyItem(id, name);
  }

  @Override
  public int deleteItem(Long id) {
    return itemCustomerRepository.deleteItem(id);
  }
}
