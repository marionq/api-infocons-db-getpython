package mx.com.autofin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "API_REGIMEN_FISCAL_TBL")
public class ApiRegimenFiscalTblEntity {
	
    @Id
    @Column(name = "REG_FISCAL")
    @JsonProperty("reg_fiscal")
    private String regFiscal;
    
    private String descripcion;
   
}
