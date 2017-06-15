/**
 * 
 */
package org.chamerling.heroku.service;

import com.firebase.client.Firebase;
import com.serversismic.model.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONObject;
import org.json.JSONTokener;


/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {
        private final String rootURL = "https://ta-sismic.firebaseio.com/";

        @WebMethod(operationName = "ubahSaldo")
        @Override
        public Boolean ubahSaldo(@WebParam(name = "pil") int pil, @WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "saldoKartu") int saldoKartu, @WebParam(name = "via") String via){
                
            // ubah saldo di firebase
            Firebase ref = new Firebase(rootURL);
            saldoKartu = saldoKartu + nominal;
            String saldoURL = "kartu/" + idKartu;
            Firebase saldoRef = ref.child(saldoURL);

            Map<String, Object> ubahSaldo = new HashMap<String, Object>();
            ubahSaldo.put("saldo", saldoKartu);
            saldoRef.updateChildren(ubahSaldo);

            //nulis riwayat transaksi
            String transaksiURL = "kartu/" + idKartu + "/transaksi/" + System.currentTimeMillis(); // timestamp
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
        /*
        @WebMethod(operationName = "getListTransaksi")
        @Override
        public ArrayList<Transaksi> getListTransaksi(@WebParam(name = "idKartu") String idKartu){
            Transaksi a = new Transaksi();
            ArrayList<Transaksi> b = new ArrayList<Transaksi>();
            b.add(a);
            try {
                URL url = new URL(rootURL + "/kartu/" + idKartu + "/transaksi.json");
                URLConnection con = url.openConnection();
                JSONTokener json = new JSONTokener(con.getInputStream());
                JSONObject obj = new JSONObject(json);
                Iterator<String> data = obj.keys();
                ArrayList<Transaksi> t = new ArrayList<Transaksi>();
                
                while(data.hasNext()){
                    String waktu = data.next();
                    
                    JSONObject getTrans = obj.getJSONObject(waktu);

                    Transaksi transaksi = new Transaksi();
                    transaksi.setIdKartu(idKartu);
                    transaksi.setJenisTransaksi(getTrans.getString("jenis_transaksi"));
                    transaksi.setNominal(getTrans.getInt("nominal"));
                    transaksi.setStatus(getTrans.getString("status"));
                    transaksi.setVia(getTrans.getString("via"));
                    transaksi.setWaktu(null);
                    t.add(transaksi);
                }                
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return b;
        }
        
        @WebMethod(operationName = "getInfoKartu")
        @Override
        public Kartu getInfoKartu(@WebParam(name = "idKartu") String idKartu){
            Kartu a = new Kartu();
            return a;
        }
        
        @WebMethod(operationName = "writeKadaluarsa")
        @Override
        public Boolean writeKadaluarsa(@WebParam(name = "idKartu") String idKartu){
            return true;
        }*/
}
