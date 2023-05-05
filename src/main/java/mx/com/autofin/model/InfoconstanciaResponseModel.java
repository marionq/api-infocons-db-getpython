package mx.com.autofin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;

@Data
public class InfoconstanciaResponseModel {
    
    @JsonProperty("codigo_postal")
    private String codigoPostal;
    
    @JsonProperty("fecha_emision")
    private String fechaEmision;
    
    @JsonProperty("razon_social")
    private String razonSocial;
    
    private String regimen;
    
    private String rfc;
    
    @JsonProperty("uso_cfdi")
    private  List<ApiUsoCfdiTblEntity> usoCfdi;
    
}
