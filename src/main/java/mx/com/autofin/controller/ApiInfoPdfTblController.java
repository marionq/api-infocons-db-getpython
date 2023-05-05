package mx.com.autofin.controller;

import java.util.List;
import mx.com.autofin.entity.ApiInfoPdfTblEntity;
import mx.com.autofin.entity.ApiUsoCfdiTblEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.autofin.repository.ApiInfoPdfTblEntityRepository;
import mx.com.autofin.repository.ApiUsoCfdiTblEntityRepository;
import mx.com.autofin.repository.ApiUsoCfdiTblEntityRepositoryCrud;
//mport mx.com.autofin.repository.ApiInfoPdfTblEntityRepositoryCrud;
import mx.com.autofin.response.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/autofin/v1/apiinfopdftbl")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ApiInfoPdfTblController {

    @Autowired
    ApiInfoPdfTblEntityRepository apiInfoPdfTblEntityRepository;
    
    @Autowired
    ApiUsoCfdiTblEntityRepository apiUsoCfdiTblEntityRepository;
    
    @Autowired
    ApiUsoCfdiTblEntityRepositoryCrud apiUsoCfdiTblEntityRepositoryCrud;

    @GetMapping()
    public ResponseEntity<Object> list() {
        List<ApiInfoPdfTblEntity> findAll = apiInfoPdfTblEntityRepository.findAll();
        if (findAll == null || findAll.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, findAll);
        }
    }
    
    @GetMapping(value = "/uso", produces = "application/json")
    public ResponseEntity<Object> listUso() {
        List<ApiUsoCfdiTblEntity> findAll = apiUsoCfdiTblEntityRepository.findAll();
        if (findAll == null || findAll.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, findAll);
        }
    }
    
    @GetMapping(value = "/like/{regFiscal}", produces = "application/json")
    public ResponseEntity<Object> listLike(@PathVariable String regFiscal) {
        List<ApiUsoCfdiTblEntity> findLike = apiUsoCfdiTblEntityRepositoryCrud.findByRegFiscalReceptorContaining(regFiscal);
        if (findLike == null || findLike.isEmpty()) {
            return ResponseHandler.generateResponse("", HttpStatus.NO_CONTENT, null);
        } else {
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, findLike);
        }
    }
}
