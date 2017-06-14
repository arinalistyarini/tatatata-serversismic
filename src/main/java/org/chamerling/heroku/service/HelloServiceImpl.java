/**
 * 
 */
package org.chamerling.heroku.service;

import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {
        private final String rootURL = "https://ta-sismic.firebaseio.com/";

	@Override
	public String sayHi(String input) {
            System.out.println("Hello invoked : " + input);
            return String.format("Hello '%s'", input);
	}
        
        @Override
        public Boolean ubahSaldo(int pil, String idKartu, int nominal, int saldoKartu, String via){
                
            // ubah saldo di firebase
            Firebase ref = new Firebase(rootURL);
            saldoKartu = saldoKartu + nominal;
            String saldoURL = "kartu/" + idKartu;
            Firebase saldoRef = ref.child(saldoURL);

            Map<String, Object> ubahSaldo = new HashMap<String, Object>();
            ubahSaldo.put("saldo", saldoKartu);
            saldoRef.updateChildren(ubahSaldo);

            //nulis riwayat transaksi
            String transaksiURL = "kartu/" + idKartu + "/transaction/" + System.currentTimeMillis(); // timestamp
            Firebase transaksiRef = ref.child(transaksiURL);
            Map<String, Object> transaction = new HashMap<String, Object>();
            //buat insert id_transaksi unique:  - get key unik: String key = userRef.push().getKey();
            // - masukin ke db: transaction.put("id_transaksi", key);
            transaction.put("nominal", nominal);
            if(pil == 0){ // top-up saldo
                transaction.put("jenis_transaksi", "top-up saldo");
            }
            else if(pil == 1){ // pembelian
                transaction.put("jenis_transaksi", "pembelian");
            }
            else {
                transaction.put("jenis_transaksi", "undefined");
            }
            transaction.put("status", "berhasil");
            transaction.put("via", via);
            transaksiRef.updateChildren(transaction);
            return true;
        }

}
