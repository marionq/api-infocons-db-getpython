package mx.com.autofin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    
}
