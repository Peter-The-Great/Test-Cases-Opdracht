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
        if(isbaas){
            System.out.println("De baas heeft toegang tot de kluis en kassa");
            return true;
        }else{
            if(ismanager) {
                if(jareninDienst > 8){
                    if(leeftijd > 18 && leeftijd < 65){
                        System.out.println("De manager heeft toegang tot de kluis en kassa");
                        return true;
                    }else{
                        System.out.println("De manager heeft toegang tot de kluis en kassa");
                        return true;
                    }
                }else{
                    System.out.println("De manager heeft toegang tot de kassa, maar niet de kluis");
                    return false;
                }
            }else{
                System.out.println("Klanten krijgen geen toegang tot de kluis of kassa");
                return false;
            }
        }
    }
}
