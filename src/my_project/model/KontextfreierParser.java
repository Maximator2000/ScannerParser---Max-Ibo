package my_project.model;

public class KontextfreierParser implements Parser{

    private TimeScanner timeScanner;

    public KontextfreierParser(){
        timeScanner=new TimeScanner();
    }

    @Override
    public boolean parse(String input) {
        if(timeScanner.scanZeit(input)){
            return recursiveParse(0);
        }
        return false;
    }

    private boolean recursiveParse(int count){
        System.out.println(count);
        if(timeScanner.getType().equals("WilderWesten")) {
            System.out.println("hier");
            timeScanner.nextToken();
            if (timeScanner.getType().equals("1970")) {
                System.out.println("hier1");

                timeScanner.nextToken();
                return recursiveParse(count + 1);
            }
        }else if(timeScanner.getType().equals("2077")){
            timeScanner.nextToken();
            if(count>1){
                return recursiveParse(count-2);
            }else{
                return false;
            }
        }else if(timeScanner.getType().equals("1970")){
            timeScanner.nextToken();
            if(timeScanner.getType().equals("2077")){
                timeScanner.nextToken();
                if(count>0){
                    return recursiveParse(count-1);
                }else{
                    return false;
                }
            }
        }else if(timeScanner.getType().equals("NODATA")){
            if(count==0){
                System.out.println("hier2");

                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean getScannerResult(String input) {
        return timeScanner.scanZeit(input);
    }

    public String getScannerOutput(){
        return timeScanner.getDebugOutput();
    }
}
