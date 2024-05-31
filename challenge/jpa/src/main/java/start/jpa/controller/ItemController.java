package start.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import start.jpa.entity.Item;
import start.jpa.service.ItemServiceImpl;

import java.util.List;

@RequestMapping("/item")
@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemServiceImpl itemService;

    @GetMapping("/save")
    public String item(){
        return "item/save";
    }

    @GetMapping("/itemList")
    public String selectAllItem(Model model){
        List<Item> items = itemService.selectItem();
        model.addAttribute("items", items);
        return "item/itemList";
    }

//    @PostMapping("/modifyItem")
//    public Item itemModify(){
//        int modifyResult = itemService.
//    }

}
