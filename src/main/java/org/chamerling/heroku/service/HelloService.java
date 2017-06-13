/**
 * 
 */
package org.chamerling.heroku.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	String sayHi(String input);
        @WebMethod(operationName = "ubahSaldo")
        public Boolean ubahSaldo(@WebParam(name = "pil") int pil, @WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "saldoKartu") int saldoKartu, @WebParam(name = "via") String via);
}
