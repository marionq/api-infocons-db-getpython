package mx.com.autofin.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import mx.com.autofin.client.EntityClient;
import mx.com.autofin.model.InfoconstanciaRequestModel;
import mx.com.autofin.model.InfoconstanciaResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityClientService implements EntityClient {
    
    @Autowired
    private EntityClient entityClient;

    @Override
    public List<InfoconstanciaResponseModel> listRespEnt(InfoconstanciaRequestModel infoconstanciaRequestModel) {
        return entityClient.listRespEnt(infoconstanciaRequestModel);
    }
    
}
