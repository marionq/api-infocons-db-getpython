package mx.com.autofin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;

@Data
public class ApiUsoRegimenCfdiTblModel {
    
    private String regimen;
   
    @JsonProperty("uso_cfdi")
    private  List<ApiUsoCfdiTblEntity> usoCfdi;
    
}
