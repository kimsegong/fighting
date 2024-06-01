package start.jpa.service;


import start.jpa.entity.Item;

import java.util.List;

public interface ItemService {
  public List<Item> selectItem();
  public Item modifyItem();
}
