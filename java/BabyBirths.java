/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * This project was completed as part of the Duke University Java Programming course.
 * 
 * @author Xiang Zhang
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }
    public int getRank(FileResource fr,String na,String gr){
        int cnt=0;
        int rk=0;
        int preBorn=-1;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            String name=rec.get(0);
            String gender=rec.get(1);
            if(gender.equals(gr)){
                    rk++;
                if(na.equals(name)) return rk;
            }           
        
    
        }
        return -1;
    }
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int bcnt=0;
        int gcnt=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                bcnt++;
            }
            else {
                totalGirls += numBorn;
                gcnt++;
            }
        }
        System.out.println("男生"+bcnt+"和"+"女生"+gcnt);
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }
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
    public String whatIsNameInYear(String name,String year,String newyear,String gender){
        FileResource fr = new FileResource("data\\yob"+year+".csv");
        int rk=getRank(fr,name,gender);
        fr = new FileResource("data\\yob"+newyear+".csv");
        String na=getName(fr,rk,gender);
        System.out.println(name+"转化为"+na+" "+year+"->"+newyear);
        return na;
    }
    public void getTotalBirthsRankedHigher(FileResource fr,String na,String gr){
        int cnt=0;
        int sum=0;
        int rk=0;
        int preBorn=-1;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            String name=rec.get(0);
            String gender=rec.get(1);
            if(!gender.equals(gr)) continue;
            if(getRank(fr,na,gr)>getRank(fr,name,gr)) sum+=numBorn;
            if(getRank(fr,na,gr)<getRank(fr,name,gr)) break;
        }
        System.out.println(sum);
    }
        

    public void yearOfHighestRank(DirectoryResource dr,String name,String gender){
        String n="";
        int bstrk=0x3f3ff3f;
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
    public void getAverageRank(DirectoryResource dr,String name,String gender){
        String maxn="";
        int maxb=0;
        int count=0;
        double ans=0.0;
        double sum=0.0;
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
        
        //newn=whatIsNameInYear("Susan","1972","2014","F");
        
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
