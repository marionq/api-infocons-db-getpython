package mx.com.autofin.client;

import java.util.List;
import mx.com.autofin.model.InfoconstanciaRequestModel;
import mx.com.autofin.model.InfoconstanciaResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-infoconstancia")
public interface InfoPdfPythonClient {
    
    @PostMapping("/autofin/v1/infoconstancia")
   
    public List<InfoconstanciaResponseModel> listRespEnt(@RequestBody InfoconstanciaRequestModel infoconstanciaRequestModel);
}
