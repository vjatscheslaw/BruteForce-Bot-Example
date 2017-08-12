package www.Bruteforce;

import static java.lang.String.format;
import java.util.ArrayList;
import java.util.logging.Logger;
// A class for generating all the possible code combinations
public class CodesGenerator {
    
    private ArrayList<String> codes;

    public CodesGenerator() {     
        codes = new ArrayList<>();       
    }

    public ArrayList<String> getListOfCodesSevenDigits() {
        for (int i = 0; i <= 9999999; i++) {
            codes.add(format("%07d", i));
        }      
        return codes;
    }
    
    public ArrayList<String> getListOfCodesSixDigits() {
        for (int i = 0; i <= 999999; i++) {
            codes.add(format("%06d", i));
        }      
        return codes;
    }
    
    public ArrayList<String> getListOfCodesFiveDigits() {
        for (int i = 0; i <= 99999; i++) {
            codes.add(format("%05d", i));
        }      
        return codes;
    }
    
    public ArrayList<String> getListOfCodesFourDigits() {
        for (int i = 0; i <= 9999; i++) {
            codes.add(format("%04d", i));
        }      
        return codes;
    }
    
    public ArrayList<String> getListOfCodesThreeDigits() {
        for (int i = 0; i <= 999; i++) {
            codes.add(format("%03d", i));
        }      
        return codes;
    }
    
    public ArrayList<String> getListOfCodesTwoDigits() {
        for (int i = 0; i <= 99; i++) {
            codes.add(format("%02d", i));
        }      
        return codes;
    }
    
    //Debugging purposes only
    public ArrayList<String> getListOfCheatCodes() {
        for (int i = 1770; i <= 1790; i++) {
            codes.add(format("%04d", i));
        }      
        return codes;
    }
    
    //a default logger
    private static final Logger LOG = Logger.getLogger(CodesGenerator.class.getName());
    
}
