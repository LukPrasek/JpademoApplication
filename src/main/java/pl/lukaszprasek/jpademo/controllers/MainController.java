package pl.lukaszprasek.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukaszprasek.jpademo.models.BarcodeEntity;
import pl.lukaszprasek.jpademo.models.forms.BarcodeForm;
import pl.lukaszprasek.jpademo.models.repositories.BarcodeRepository;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository; // = new BarcodeRepostitory();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes",barcodeRepository.findAll());
        return "addBarcode";
    }

    @PostMapping("/")
    @ResponseBody
    public String index(@ModelAttribute BarcodeForm barcodeForm) {
        BarcodeEntity barcodeEntity = new BarcodeEntity(barcodeForm);
        barcodeRepository.save(barcodeEntity);
        return "Dodano do bazy";
    }


}
