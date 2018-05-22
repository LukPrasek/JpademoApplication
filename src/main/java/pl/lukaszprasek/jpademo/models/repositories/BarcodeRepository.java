package pl.lukaszprasek.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.jpademo.models.BarcodeEntity;

import java.util.List;

@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
    List<BarcodeEntity> findAllByOrderByIdDesc();

    List<BarcodeEntity> findByBarcodeContainsAndBarcodeContainsAndWeightIsGreaterThanEqual(String s, String a, int i);

    //List<BarcodeEntity> findAllByWeightBetween(int s, int i);
    //Dorob pole wyszukiwania na ekranie glownym, gdzie uzytkownik poda fraze. Natepne wyswietl tylko te barcody,
    // ktore w nazwie produktu lub nazwie firmy zawieraja to co wpisal uzytkownik
    List<BarcodeEntity> findAllByProductCompanyContains(String text);
    List<BarcodeEntity> findAllByProductNameContains(String text);
}
