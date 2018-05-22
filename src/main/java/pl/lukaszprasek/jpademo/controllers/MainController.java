package pl.lukaszprasek.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.jpademo.models.BarcodeEntity;
import pl.lukaszprasek.jpademo.models.forms.BarcodeForm;
import pl.lukaszprasek.jpademo.models.repositories.BarcodeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository; // = new BarcodeRepostitory();

    @GetMapping("/search")
    public String index(Model model) {
        model.addAttribute("barcodeForm", new BarcodeForm());
        // model.addAttribute("allBarcodes",barcodeRepository.findAllByWeightBetween(10,200));
        //model.addAttribute("allBarcodes", barcodeRepository.findByBarcodeContainsAndBarcodeContainsAndWeightIsGreaterThanEqual("1237", "2", 10));//barcode 1 lub 2 i waga >= 10
        //model.addAttribute("barcodesFromUser", )

        //Dorob pole wyszukiwania na ekranie glownym, gdzie uzytkownik poda fraze. Natepne wyswietl tylko te barcody,
        // ktore w nazwie produktu lub nazwie firmy zawieraja to co wpisal uzytkownik

        return "addBarcode";
    }



    @PostMapping("/")
    public String index(@ModelAttribute BarcodeForm barcodeForm){
        BarcodeEntity barcodeEntity = new BarcodeEntity(barcodeForm);
        barcodeRepository.save(barcodeEntity);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        List<BarcodeEntity> barcodeEntityList = new ArrayList<>();
        barcodeEntityList.addAll(barcodeRepository.findAllByProductCompanyContains(search));
        barcodeEntityList.addAll(barcodeRepository.findAllByProductNameContains(search));

        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes", barcodeEntityList);
        return "addBarcode";
    }


}