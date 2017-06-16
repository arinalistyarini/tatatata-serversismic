/**
 * 
 */
package org.chamerling.heroku.service;

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
        public Boolean ubahSaldo(@WebParam(name = "pil") int pil, @WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "saldoKartu") int saldoKartu, @WebParam(name = "via") String via);
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayList<Transaksi> getListTransaksi(@WebParam(name = "idKartu") String idKartu);
        
        @WebMethod(operationName = "getInfoKartu")
        public Kartu getInfoKartu(@WebParam(name = "idKartu") String idKartu);
        /*
        @WebMethod(operationName = "writeKadaluarsa")
        public Boolean writeKadaluarsa(@WebParam(name = "idKartu") String idKartu);*/
}
