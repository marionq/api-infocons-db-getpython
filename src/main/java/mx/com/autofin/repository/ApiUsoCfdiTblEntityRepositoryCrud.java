package mx.com.autofin.repository;

import java.util.List;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ApiUsoCfdiTblEntityRepositoryCrud extends CrudRepository<ApiUsoCfdiTblEntity, String> {

    List<ApiUsoCfdiTblEntity> findByusoCfdi(String usoCfdi);

    @Query("select u from api_usocfdi_tbl u where u.reg_fiscal_receptor like '%regFiscal%'")
    List<ApiUsoCfdiTblEntity> findUserByregFiscalReceptorLike(@Param("regFiscal") String regFiscal);

}
