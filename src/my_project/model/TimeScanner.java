package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class TimeScanner extends Scanner<String, String> {


    @Override
    public boolean scan(String input) {
        return false;
    }

    private String debugOutput;

    public boolean scanZeit(String input){
        if(input == null  || input.length()== 0){
            return false;
        }
        debugOutput="";
        this.tokenList = new List<>();
        for(int i = 0; i<input.length();i++){
            if(input.charAt(i)== 'w'){
                if(i<input.length()-1){
                    if(input.charAt(i+1) == 'w'){
                        this.tokenList.append(new Token(input.substring(i,i+2),"WilderWesten"));
                        debugOutput=debugOutput+" > Wilder Westen";
                        i++;
                    }else if(input.charAt(i+1) == 'k'){
                        this.tokenList.append(new Token(input.substring(i,i+2),"Weltkrieg"));
                        debugOutput=debugOutput+" > Weltkrieg";
                        i++;
                    }else return false;
                }else return false;
            }else if(input.charAt(i)== 's'){
                if(i<input.length()-1){
                    if(input.charAt(i+1)== 'd'){
                        this.tokenList.append(new Token(input.substring(i,i+2),"schwarzerDonnerstag"));
                        debugOutput=debugOutput+" > schwarzerDonnerstag";
                        i++;
                    }else return false;
                }else return false;
            }else if(input.charAt(i)== 'a'){
                this.tokenList.append(new Token(input.charAt(i),"1950"));
                debugOutput=debugOutput+" > 1950";
            }else if(input.charAt(i)== 'b'){
                this.tokenList.append(new Token(input.charAt(i),"1970"));
                debugOutput=debugOutput+" > 1970";
            } else if(input.charAt(i)== 'c') {
                this.tokenList.append(new Token(input.charAt(i), "2077"));
                debugOutput=debugOutput+" > 2077";
            } else return false;
        }
        this.tokenList.append(new Token("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }

    public String getDebugOutput() {
        return debugOutput;
    }
}
