package mx.com.autofin.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "API_INFO_PDF_TBL")
public class ApiInfoPdfTblEntity {
	
	private String rfc;
	
	@Column(name = "constancia_pdf")
	private String constanciaPdf;

}
