package mx.com.autofin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InfoconstanciaRequestModel {
    
    @JsonProperty("image_base64")
    private String stringBase64;
    
}
