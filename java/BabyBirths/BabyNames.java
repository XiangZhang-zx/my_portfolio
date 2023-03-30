/**
 * To summarize, this Java program processes and analyzes data on baby names from the United States, including finding the rank, name, and average rank of a given name and gender in different years
 * as well as calculating the total births and births ranked higher than a given name in a specific year. 
 * The program includes several methods that have been modified and tested to ensure correct functionality.
 * This project was completed as part of the Duke University Java Programming course.
 * 
 * @author Xiang Zhang
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        int boysNames = 0;
        int girlsNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalNames += 1;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boysNames += 1;
            }
            else {
                totalGirls += numBorn;
                girlsNames += 1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total names = " + totalNames);
        System.out.println("unique boys = " + boysNames);
        System.out.println("unique girls = " + girlsNames);
    }

    public int getRank(FileResource fr,String name,String gender){
        int rank=0;
        int cnt=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String gen=rec.get(1);
            if(!gen.equals(gender)) continue;
            cnt++;
            String na=rec.get(0);
            if(na.equals(name)) {
                rank=cnt;
                break;
            }
        }
        if(rank!=0) return rank;
        return -1;
    }
    
    // Given a FileResource fr, an integer rk1, and a String gr representing gender, returns the name of the baby with the given rank. If no such name exists, returns "No name".
    public String getName(FileResource fr,int rk1,String gr){
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            String name=rec.get(0);
            String gender=rec.get(1);
            if(gender.equals(gr)) {
                int rk=getRank(fr,name,gr);
                if(rk==rk1) return name;
            }
        }
        return "No name";
    }
    
    // Given a String name, String year, String newyear, and String gender, returns the name that corresponds to name in the year newyear, based on its rank in the year year.
    public String whatIsNameInYear(String name,String year,String newyear,String gender){
        FileResource fr = new FileResource("data\\yob"+year+".csv");
        int rk=getRank(fr,name,gender);
        fr = new FileResource("data\\yob"+newyear+".csv");
        String na=getName(fr,rk,gender);
        System.out.println(name+" converted to "+na+" "+year+"->"+newyear);
        return na;
    }
    // This method calculates the total number of births that occurred
    // for those names ranked higher than the input name for the input year and gender.
    // This method calculates the total number of births that occurred
    // for those names ranked higher than the input name for the input year and gender.
    public void getTotalBirthsRankedHigher(FileResource fr,String na,String gr){
        int cnt=0;
        int sum=0;
        int rk=0;
        int preBorn=-1;
        // loop over each record in the CSV file and check the rank of the names
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            String name=rec.get(0);
            String gender=rec.get(1);
            // if the gender of the name matches with the input gender
            if(!gender.equals(gr)) continue;
            // if the rank of the current name is higher than the rank of the input name
            if(getRank(fr,na,gr)>getRank(fr,name,gr)) sum+=numBorn;
            // if the rank of the current name is lower than the rank of the input name, then exit the loop
            if(getRank(fr,na,gr)<getRank(fr,name,gr)) break;
        }
        System.out.println(sum);
    }
    
    // This method finds the year with the highest rank for the input name and gender by checking multiple files
    public void yearOfHighestRank(DirectoryResource dr,String name,String gender){
        String n="";
        int bstrk=0x3f3ff3f;
        // loop over each file in the directory and find the year with the highest rank for the input name and gender
        for(File Fr: dr.selectedFiles()){
            FileResource fr = new FileResource(Fr);
            int numrk=getRank(fr,name,gender);
            if(numrk<bstrk){
                bstrk=numrk;
                n=Fr.getName();
            }
        }
        System.out.println(n);
    }
    
    // This method finds the average rank of the input name and gender by checking multiple files
    public void getAverageRank(DirectoryResource dr,String name,String gender){
        String maxn="";
        int maxb=0;
        int count=0;
        double ans=0.0;
        double sum=0.0;
        // loop over each file in the directory and calculate the average rank of the input name and gender
        for(File Fr: dr.selectedFiles()){
            FileResource fr = new FileResource(Fr);
            count++;
            int numrk=getRank(fr,name,gender);
            sum+=numrk;
            if(numrk<maxb){
                maxb=numrk;
                maxn=Fr.getName();
            }
        }
        ans=sum/count;
        System.out.println(ans);
    }
    
    // This method tests all the functionalities of the program
    public void testTotalBirths() {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data\\yob1905.csv");
        totalBirths(fr);
        fr = new FileResource("data\\yob1960.csv");
        int rk=getRank(fr,"Frank","M");
        System.out.println(rk);
        int rk1=350;
        fr = new FileResource("data\\yob1980.csv");
        String ans=getName(fr,rk1,"F");
        rk1=450;
        fr = new FileResource("data\\yob1982.csv");
        ans=getName(fr,rk1,"M");
        System.out.println(ans);
        
        //String newn=whatIsNameInYear("Isabella","2012short","2014short","F");

        
        //newn=whatIsNameInYear("Owen","1974","2014","M");
        DirectoryResource dr = new DirectoryResource();
        String name="Mason";
        String gender="M";
        //yearOfHighestRank(dr,name,gender);
        System.out.println("要填的");
        name="Genevieve";
        gender="F";
        yearOfHighestRank(dr,name,gender);
        name="Mich";
        gender="M";
        yearOfHighestRank(dr,name,gender);
        System.out.println("平均题");
        name="Susan";
        gender="F";
        getAverageRank(dr,name,gender);
        name="Robert";
        gender="M";
        getAverageRank(dr,name,gender);
        //getAverageRank(dr,name,gender);
        System.out.println("最后一种");
        name="Emily";
        gender="F";
        fr = new FileResource("data\\yob1990.csv");
        getTotalBirthsRankedHigher(fr,name,gender);
        name="Drew";
        gender="M";
        getTotalBirthsRankedHigher(fr,name,gender);
        //fr = new FileResource("data\\yob2012short.csv");
        //name="Ethan";
        //getTotalBirthsRankedHigher(fr,name,gender);
    }
}
