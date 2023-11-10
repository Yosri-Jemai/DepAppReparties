package rmiClient;

import rmiService.IConversion;

import java.rmi.Naming;

public class ConversionClient {
    public static void main(String[] args) {
        IConversion stub;

        {
            try {
                stub = (IConversion) Naming.lookup("rmi://localhost:1098/ConversionObject");
                double montantConv =stub.convertirMontant(15.3);
                System.out.println(montantConv);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}