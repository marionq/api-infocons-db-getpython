package mx.com.autofin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import mx.com.autofin.entity.ApiInfoPdfTblEntity;

public interface ApiInfoPdfTblEntityRepositoryCrud extends CrudRepository<ApiInfoPdfTblEntity, String>, JpaSpecificationExecutor<ApiInfoPdfTblEntity> {
	
	List<ApiInfoPdfTblEntity> findByUsername(String username);

}
