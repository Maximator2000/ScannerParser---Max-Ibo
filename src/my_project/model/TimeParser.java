package my_project.model;

public class TimeParser implements Parser{

    private TimeScanner timeScanner;

    public TimeParser() {
        this.timeScanner = new TimeScanner();
    }

    @Override
    public boolean parse(String input) {
        if (timeScanner.scanZeit(input)) {
            return checkS();
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
    private boolean checkS() {
        if (timeScanner.getType().equals("WilderWesten")) {
            timeScanner.nextToken();
            return checkA();
        }
        return false;
    }

    private boolean checkA() {
        if (timeScanner.getType().equals("1970")) {
            timeScanner.nextToken();
            return checkB();
        } else if (timeScanner.getType().equals("2077")) {
            timeScanner.nextToken();
            return checkC();
        } else return false;
    }

    private boolean checkB() {
        if (timeScanner.getType().equals("2077")) {
            timeScanner.nextToken();
            return checkC();

        } else return false;
    }

    private boolean checkC() {

        if (timeScanner.getType().equals("1970") || timeScanner.getType().equals("1950")) {
            timeScanner.nextToken();
            return checkD();
        } else if (timeScanner.getType().equals("Weltkrieg")) {
            timeScanner.nextToken();
            return checkE();
        } else return false;
    }

    private boolean checkE() {
        if (timeScanner.getType().equals("1950") || timeScanner.getType().equals("schwarzerDonnerstag")) {
            timeScanner.nextToken();
            return checkD();

        } else return false;

    }

    private boolean checkD() {
        if (timeScanner.getType().equals("1970")) {
            timeScanner.nextToken();
            return checkF();
        } else return false;
    }

    private boolean checkF() {
        if (timeScanner.getType().equals("WilderWesten")) {
            timeScanner.nextToken();
            if (timeScanner.getType().equals("NODATA")) {
                return true;
            } else return false;
        } else return false;
    }
}