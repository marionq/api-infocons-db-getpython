package mx.com.autofin.repository;

import java.util.List;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;
import mx.com.autofin.model.ApiUsoCfdiTblModel;
import org.springframework.data.repository.CrudRepository;

public interface ApiUsoCfdiTblEntityRepositoryCrud extends CrudRepository<ApiUsoCfdiTblEntity, String> {

    List<ApiUsoCfdiTblEntity> findByusoCfdi(String usoCfdi);

    List<ApiUsoCfdiTblModel> findByRegFiscalReceptorContaining(String regFiscal);

}
