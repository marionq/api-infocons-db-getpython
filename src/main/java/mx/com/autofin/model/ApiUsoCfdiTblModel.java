package mx.com.autofin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiUsoCfdiTblModel {
    
    @JsonProperty("uso_cfdi")
    private String usoCfdi;
    
    private String descripcion;
    
}
