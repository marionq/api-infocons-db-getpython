package mx.com.autofin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "API_USOCFDI_TBL")
public class ApiUsoCfdiTblEntity {
	
    @Id
    @Column(name = "USO_CFDI")
    @JsonProperty("uso_cfdi")
    private String usoCfdi;
    
    private String descripcion;
   
}
