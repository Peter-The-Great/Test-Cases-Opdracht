package org.pjotr;

public class Bank2 {
    /**
     * Deze checkt of een medewerker toegang heeft tot de kluis en kassa.
     * @param isbaas
     * @param ismanager
     * @param jareninDienst
     * @param leeftijd
     * @return boolean false of true
     */
    public static boolean getToegangVault(boolean isbaas, boolean ismanager, int jareninDienst, int leeftijd){
        if(leeftijd >= 16){
            if(isbaas){
                System.out.println("De baas heeft toegang tot de kluis en kassa");
                return true;
            }else{
                if(ismanager && leeftijd > 18 && leeftijd < 65) {
                    if(jareninDienst > 8){
                        System.out.println("De manager heeft toegang tot de kluis en kassa");
                        return true;
                    }else{
                        System.out.println("De manager heeft toegang tot de kassa, maar niet de kluis");
                        return false;
                    }
                }else{
                    System.out.println("Normale medewerkers krijgen geen toegang tot de kluis of kassa");
                    return false;
                }
            }
        }else{
            System.out.println("Kinderen onder de 16 kunnen niet binnen ons bedrijf komen en zeker niet bij de kluis of kassa");
            return false;
        }
    }
}
