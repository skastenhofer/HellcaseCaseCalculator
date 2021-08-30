import model.Case;

import java.util.Scanner;

public class Main {

    private static String CASE_NAME_URL="blackmail";

    public static void main(String []args){
        boolean isrunning=true;
        String temp="";
        while(isrunning){
            System.out.println("Case Name or exit");
            Scanner sc = new Scanner(System.in);
            temp = sc.next().toLowerCase();
            switch (temp){
                case "exit":
                    System.exit(0);
                    break;
                default:
                    HellcaseCaseDownloader downloader = new HellcaseCaseDownloader(temp);
                    downloader.downloadCase();
                    downloader.getHellCase().getOdds();
            }
        }



//        HellcaseCaseDownloader calc = new HellcaseCaseDownloader(CASE_NAME_URL);
//        calc.downloadCase();
//        Case dream = calc.getHellCase();
//        dream.getOdds();
    }
}
