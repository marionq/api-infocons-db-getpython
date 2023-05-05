package mx.com.autofin.controller;

import java.util.List;
import mx.com.autofin.entity.ApiInfoPdfTblEntity;
import mx.com.autofin.entity.ApiRegimenFiscalTblEntity;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.autofin.model.InfoconstanciaRequestModel;
import mx.com.autofin.model.InfoconstanciaResponseModel;
import mx.com.autofin.repository.ApiInfoPdfTblEntityRepository;
import mx.com.autofin.repository.ApiRegimenFiscalTblEntityCrudRepository;
import mx.com.autofin.repository.ApiUsoCfdiTblEntityRepositoryCrud;
import mx.com.autofin.response.ResponseHandler;

import mx.com.autofin.service.InfoPdfPythonClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autofin/v1/infopdf")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE, RequestMethod.OPTIONS})
public class InfoPdfPythonController {

    @Autowired
    private InfoPdfPythonClientService entityClientService;
    
    @Autowired
    ApiInfoPdfTblEntityRepository apiInfoPdfTblEntityRepository;
    
    @Autowired
    ApiRegimenFiscalTblEntityCrudRepository apiRegimenFiscalTblEntityCrudRepository;
    
    @Autowired
    ApiUsoCfdiTblEntityRepositoryCrud apiUsoCfdiTblEntityRepositoryCrud;
    

    @PostMapping(value = "/constancia", produces = "application/json")
    public ResponseEntity<Object> getAccessToken(@RequestBody InfoconstanciaRequestModel infoconstanciaRequestModel) {
        List<InfoconstanciaResponseModel> findAll = entityClientService.listRespEnt(infoconstanciaRequestModel);
        if (findAll == null || findAll.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, findAll);
        }

    }
    
    @PostMapping(value = "/get-insert", produces = "application/json")
    public ResponseEntity<Object> insert(@RequestBody InfoconstanciaRequestModel infoconstanciaRequestModel) {               
        
        //SE hace la consulta a servicio python ocr
        List<InfoconstanciaResponseModel> infoConstancia = entityClientService.listRespEnt(infoconstanciaRequestModel);
                
        //Se guarda el RFC y PDF en la base de datos
        ApiInfoPdfTblEntity apiInfoPdfTblEntity = new ApiInfoPdfTblEntity();
        apiInfoPdfTblEntity.setRfc(infoConstancia.get(0).getRfc());
        apiInfoPdfTblEntity.setConstanciaPdf(infoconstanciaRequestModel.getStringBase64());
        apiInfoPdfTblEntityRepository.save(apiInfoPdfTblEntity);
        
        //Consulta a la DB para traer el id del regimen y concatenarlo con la descripción
        List<ApiRegimenFiscalTblEntity> apiRegimenFiscalTblEntity = apiRegimenFiscalTblEntityCrudRepository.findByDescripcion(infoConstancia.get(0).getRegimen());
        String regimenCompleto = apiRegimenFiscalTblEntity.get(0).getRegFiscal() + ":" + infoConstancia.get(0).getRegimen();
        infoConstancia.get(0).setRegimen(regimenCompleto);
        
        //Cunsulta a la DB para recuperar los Usos de Cfdi
        List<ApiUsoCfdiTblEntity> usoCfdi = apiUsoCfdiTblEntityRepositoryCrud.findLikeRegFiscalReceptor(apiRegimenFiscalTblEntity.get(0).getRegFiscal());
        
        //Se la lista de uso de cfdi al response
        infoConstancia.get(0).setUsoCfdi(usoCfdi);
        
        if (infoConstancia == null || infoConstancia.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, infoConstancia);
        }

    }

}
