package mx.com.autofin.repository;

import java.util.List;
import mx.com.autofin.entity.ApiRegimenFiscalTblEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiRegimenFiscalTblEntityCrudRepository extends CrudRepository<ApiRegimenFiscalTblEntity, String> {

    List<ApiRegimenFiscalTblEntity> findByRegFiscal(String regFiscal);
    
    List<ApiRegimenFiscalTblEntity> findByDescripcion(String descripcion);

}
