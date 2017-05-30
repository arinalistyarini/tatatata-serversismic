/**
 * 
 */
package org.chamerling.heroku.service;

import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	String sayHi(String input);
        Boolean ubahSaldo(int pil, String idKartu, int nominal, int saldoKartu, String via);
}
