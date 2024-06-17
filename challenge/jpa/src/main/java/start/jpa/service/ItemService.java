package start.jpa.service;


import start.jpa.entity.Item;

import java.util.List;

public interface ItemService {
  public List<Item> selectItem();
//  public Item modifyItem(Long id, String name);
//  public int deleteItem(Long id);
}
