package petrolbunk;

import crudoperations.EmployeeMain;

import java.util.Scanner;

public class PetrolMain {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        PetrolMethods pObj =  new PetrolMethods();
        EmployeeMain eObj= new EmployeeMain();

        while (true) {
            System.out.print("\nEnter 1 for setting up today Capacity and Rates\nEnter 2 for filling up petrol and diesel tanks" +
                    "\nEnter 3 employee operations \nEnter your choice......:");
            int choice = get.nextInt();
            switch (choice){
                case 1:
                    pObj.settingup();
                    break;
                case 2:
                    pObj.fillup();
                    break;
                case 3:
                    eObj.employeeManagement();
                case 0:
                    System.exit(0);

            }

        }
    }
}

