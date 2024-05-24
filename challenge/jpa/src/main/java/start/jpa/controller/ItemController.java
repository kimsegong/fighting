package start.jpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import start.jpa.entity.Member;
import start.jpa.service.ItemServiceImpl;
import start.jpa.service.MemberServiceImpl;

@RequestMapping("/item")
@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemServiceImpl itemService;

    @GetMapping("/save")
    public String item(){
        return "item/save";
    }

}
