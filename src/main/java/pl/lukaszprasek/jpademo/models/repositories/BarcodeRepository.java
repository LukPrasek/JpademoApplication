package pl.lukaszprasek.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.jpademo.models.BarcodeEntity;

import java.util.List;

@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
    List<BarcodeEntity> findAllByOrderByIdDesc();
    //List<BarcodeRepository> findAllByProductCompanyStartsWithAndIdIsGeaterThan(String s, int i);
}
