package pl.lukaszprasek.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukaszprasek.jpademo.models.BarcodeEntity;
import pl.lukaszprasek.jpademo.models.services.BasketService;
import javax.persistence.GeneratedValue;
import java.util.stream.Collectors;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;


    @GetMapping("/basket")
    @ResponseBody
    public String basket() {
        return basketService.getBasketList().stream().map(BarcodeEntity::toString)
                .collect(Collectors.joining(", ", "Twoja lista:", "."));
    }

}
