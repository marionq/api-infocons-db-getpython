package mx.com.autofin.service;

import java.util.List;
import mx.com.autofin.model.InfoconstanciaRequestModel;
import mx.com.autofin.model.InfoconstanciaResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.autofin.client.InfoPdfPythonClient;

@Service
public class InfoPdfPythonClientService implements InfoPdfPythonClient {
    
    @Autowired
    private InfoPdfPythonClient entityClient;

    @Override
    public List<InfoconstanciaResponseModel> listRespEnt(InfoconstanciaRequestModel infoconstanciaRequestModel) {
        return entityClient.listRespEnt(infoconstanciaRequestModel);
    }
    
}
