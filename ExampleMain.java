package com.project;

import com.sulacosoft.bitcoindconnector4j.BitcoindApi;
import com.sulacosoft.bitcoindconnector4j.BitcoindApiFactory;
import com.sulacosoft.bitcoindconnector4j.core.BitcoindConnector4JException;
import com.sulacosoft.bitcoindconnector4j.response.Info;
import java.util.Map;



public class ExampleMain {

    public static void main(String[] args) throws BitcoindConnector4JException {

        
        String address = "127.0.0.1";
        int port = 18332;
        String protocol = "http";
        String user = "dracon";
        String password = "1234$##$$$$";

        
        BitcoindApi api = BitcoindApiFactory.createConnection(address, port, protocol, user, password);
       

       
        Info info = api.getinfo();
        System.out.println("Protocol version: " + info.getProtocolversion());
        info.setBalance(80000.00d);
        System.out.println("Total balance : " + info.getBalance());
       
         

      
        Map<String, Double> accounts = api.listaccounts();
        
        accounts.forEach((k, v) -> System.out.println(String.format("account %s balance : %s", k, v)));
    }
}
