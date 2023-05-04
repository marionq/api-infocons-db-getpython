package mx.com.autofin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "API_INFO_PDF_TBL")
public class ApiInfoPdfTblEntity {
	
    @Id
    private String rfc;
	
    @Column(name = "CONSTANCIA_PDF")
    @JsonProperty("constancia_pdf")
    private String constanciaPdf;

}
