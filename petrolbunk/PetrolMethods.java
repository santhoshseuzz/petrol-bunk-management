package petrolbunk;


import java.sql.Date;
import java.util.Scanner;

public class PetrolMethods {
    Scanner get = new Scanner(System.in);
    long milliSec = System.currentTimeMillis();
    Date date = new Date(milliSec);
    PetrolData dataObj= new PetrolData();

    void settingup() {
        System.out.println("Today Date::" + date);
        System.out.print("Enter the PetrolRate         ::");
        double petrolRate = get.nextDouble();
        dataObj.setPetrolRate(petrolRate);
        System.out.print("Enter the PetrolQuantity     ::");
        double petrolQuantity = get.nextDouble();
        dataObj.setPetrolQuantity(petrolQuantity);
        System.out.print("Enter the DieselRate         ::");
        double DieselRate = get.nextDouble();
        dataObj.setDieselRate(DieselRate);
        System.out.print("Enter the DieselQuantity     ::");
        double DieselQuantity = get.nextDouble();
        dataObj.setDieselQuantity(DieselQuantity);
        dataObj.setDate(date);
        PetrolDb petrolDbObj = new PetrolDb();
        petrolDbObj.setup(dataObj);
        PetrolDb conObject = new PetrolDb();
    }
    void fillup(){
        System.out.print("Enter 1.for Petrol OR 2.for diesel:");
        dataObj.setDate(date);
        int choice = get.nextInt();
        dataObj.setChoice(choice);
        System.out.print("Enter the Quantity                :");
        double qunatity = get.nextDouble();
        dataObj.setCapacity(qunatity);
        PetrolDb petrolDbObj=  new PetrolDb();
        petrolDbObj.fillUpDb(dataObj);
    }
    void callRefill(int a){
        if(a==11)
        {
            System.out.println("Enter the Quantity of petrol you wanto fill.....");
            double refill= get.nextDouble();
            dataObj.setRefillColumn("petrolquantity");
            dataObj.setDate(date);
            dataObj.setRefill(refill);
        }
        else if (a==12){

            System.out.println("Enter the Quzntity of Diesel you wanto fill.....");
            double refill= get.nextDouble();
            dataObj.setRefillColumn("dieselquantity");
            dataObj.setDate(date);
            dataObj.setRefill(refill);
        }
        else{

        }
    }
}
