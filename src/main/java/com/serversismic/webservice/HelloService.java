/**
 * 
 */
package com.serversismic.webservice;

import com.serversismic.model.*;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {
        @WebMethod(operationName = "ubahSaldo")
        public String ubahSaldo(@WebParam(name = "pil") int pil, @WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "saldoKartu") int saldoKartu, @WebParam(name = "via") String via);
        
        @WebMethod(operationName = "tambahLog")
        public Boolean tambahLog(@WebParam(name = "idKartu") String idKartu, @WebParam(name = "yangDilakukan") String yangDilakukan, @WebParam(name = "waktu") String waktu);
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayTransaksi getListTransaksi(@WebParam(name = "idKartu") String idKartu);
        
        @WebMethod(operationName = "getInfoKartu")
        public Kartu getInfoKartu(@WebParam(name = "idKartu") String idKartu);
                
        /*
        @WebMethod(operationName = "writeKadaluarsa")
        public Boolean writeKadaluarsa(@WebParam(name = "idKartu") String idKartu);*/
}
