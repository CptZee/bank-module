package groupnine.bank.auth;

import java.util.HashMap;

public class Credentials {
    public static HashMap<String, Integer> credentials = new HashMap<String, Integer>();
    public static void injectCredentials(){
        credentials.put("user", 1234);
        credentials.put("Aaron James", 2020);
        credentials.put("John Benigno", 1028);
        credentials.put("Elizabeth", 209385);
        credentials.put("John Empe", 202010);
        credentials.put("Kurt Adrian", 6996);
        credentials.put("Mhel Adrian", 969696);
    }
    //A place holder method for future stuff... (Since this is a static project LAMEEEEE)
    public static void addCredentials(String username, Integer passcode){
        credentials.put(username, passcode);
    }
    public static void modifyCredentials(String username, Integer passcode){
        credentials.replace(username, passcode);
    }
}
