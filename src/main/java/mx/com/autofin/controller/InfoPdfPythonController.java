package mx.com.autofin.controller;

import java.util.List;
import mx.com.autofin.entity.ApiInfoPdfTblEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.autofin.model.InfoconstanciaRequestModel;
import mx.com.autofin.model.InfoconstanciaResponseModel;
import mx.com.autofin.repository.ApiInfoPdfTblEntityRepository;
import mx.com.autofin.response.ResponseHandler;

import mx.com.autofin.service.InfoPdfPythonClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autofin/v1/info")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE, RequestMethod.OPTIONS})
public class InfoPdfPythonController {

    @Autowired
    private InfoPdfPythonClientService entityClientService;
    
    @Autowired
    ApiInfoPdfTblEntityRepository apiInfoPdfTblEntityRepository;

    @PostMapping(value = "/constancia", produces = "application/json")
    public ResponseEntity<Object> getAccessToken(@RequestBody InfoconstanciaRequestModel infoconstanciaRequestModel) {
        List<InfoconstanciaResponseModel> findAll = entityClientService.listRespEnt(infoconstanciaRequestModel);
        if (findAll == null || findAll.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, findAll);
        }

    }
    
    @PostMapping(value = "/insert", produces = "application/json")
    public ResponseEntity<Object> insert(@RequestBody InfoconstanciaRequestModel infoconstanciaRequestModel) {               
        
        //SE hace la consulta a servicio python ocr
        List<InfoconstanciaResponseModel> infoConstancia = entityClientService.listRespEnt(infoconstanciaRequestModel);
        
        //Se guarda el RFC y PDF en la base de datos
        ApiInfoPdfTblEntity apiInfoPdfTblEntity = new ApiInfoPdfTblEntity();
        apiInfoPdfTblEntity.setRfc(infoConstancia.get(0).getRfc());
        apiInfoPdfTblEntity.setConstanciaPdf(infoconstanciaRequestModel.getStringBase64());
        apiInfoPdfTblEntityRepository.save(apiInfoPdfTblEntity);
        
        
        if (infoConstancia == null || infoConstancia.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, infoConstancia);
        }

    }

}
