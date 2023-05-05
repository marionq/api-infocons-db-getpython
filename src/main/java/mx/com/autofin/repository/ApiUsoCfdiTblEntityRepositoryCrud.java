package mx.com.autofin.repository;

import java.util.List;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ApiUsoCfdiTblEntityRepositoryCrud extends CrudRepository<ApiUsoCfdiTblEntity, String> {

    List<ApiUsoCfdiTblEntity> findByusoCfdi(String usoCfdi);

    //List<ApiUsoCfdiTblModel> findByRegFiscalReceptorContaining(String regFiscal);
    
    @Query(value = "select * from infopdf.api_usocfdi_tbl where reg_fiscal_receptor = ?1", nativeQuery = true)
    List<ApiUsoCfdiTblEntity> findLikeRegFiscalReceptor(String regFiscal);

}
