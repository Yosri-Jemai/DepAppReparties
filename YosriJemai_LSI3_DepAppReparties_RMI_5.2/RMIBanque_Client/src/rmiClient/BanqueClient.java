package rmiClient;

import rmiService.IBanque;
import metier.Compte;

import java.rmi.Naming;
import java.util.Date;

// La classe BanqueClient représente le client RMI pour interagir avec le service bancaire distant
public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Recherche le service bancaire distant en utilisant le nom fourni lors de la liaison
            IBanque banque = (IBanque) Naming.lookup("rmi://localhost:1090/BanqueService");

            // Crée un nouveau compte avec un code, un solde et une date de création spécifiques
            Compte nouveauCompte = new Compte(12, 700.5, new Date());

            // Appelle la méthode distante pour créer le compte et récupère le message de création
            String messageCreation = banque.creerCompte(nouveauCompte);
            System.out.println("Message de création de compte : " + messageCreation);

            // Définit le code du compte pour lequel obtenir des informations
            int codeCompte = 12;

            // Appelle la méthode distante pour obtenir les informations du compte et affiche le résultat
            String infoCompte = banque.getInfoCompte(codeCompte);
            System.out.println("Information du compte : " + infoCompte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}