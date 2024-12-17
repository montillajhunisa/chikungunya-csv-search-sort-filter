package prelim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainRecords {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner kbd = new Scanner(System.in);

        showIntroduction();
        kbd.nextLine();
        mainMenu();
    }


    public static void showIntroduction() {
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|      THIS PROGRAM DEMONSTRATES INFORMATION MANAGEMENT      |");
        System.out.println("|      USING SEARCH, SORT AND FILTER METHODS. THIS ALSO      |");
        System.out.println("|       IMPLEMENTS THE MAX, MIN, AVG AND TOTAL COUNT OF      |");
        System.out.println("|          CHIKUNGUNYA CASES HEALTH RECORD FROM CSV.         |");
        System.out.println("+------------------------------------------------------------+");
        System.out.print("Press ENTER to continue...");
    }


    public static void mainMenu() throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"));

        ArrayList<HealthRecord> record = new ArrayList<>();
        String currentLine;

        while ((currentLine = file.readLine()) != null) {
            String[] detailed = currentLine.split(",");
            if (detailed[0].equals("CODE"))
                continue;
            int code = Integer.parseInt(detailed[0]);
            String sex = detailed[1];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(detailed[2]);
            String status = detailed[3];
            String community = detailed[4];
            String parish = detailed[5];
            double latitude = Double.parseDouble(detailed[6]);
            double longitude = Double.parseDouble(detailed[7]);
            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
        }

        int myChoice;
        do {
            showMainMenu();
            myChoice = enterChoice(1, 5);
            switch (myChoice) {
                case 1 ->
                    // SORT MENU
                        SortSearchFilter.sortMenu();

                case 2 ->
                    // SEARCH MENU
                        SortSearchFilter.searchMenu();

                case 3 ->
                    // FILTER MENU
                        SortSearchFilter.filterMenu();

                case 4 ->
                    // CALCULATE MENU
                        CalculateRecord.calcMenu();

                case 5 ->
                    // EXIT PROGRAM
                        exitProgram();
            }
            continueProgram();
        } while (myChoice != 8);
    }


    public static void showMainMenu() {
        System.out.println("+============================================================+");
        System.out.println("|                         MAIN MENU                          |");
        System.out.println("+============================================================+");
        System.out.println("| [1] Sort the Health Record According to Categories.        |");
        System.out.println("| [2] Search from the Health Record.                         |");
        System.out.println("| [3] Filter the Health Record.                              |");
        System.out.println("| [4] Calculate data from Health Record.                     |");
        System.out.println("| [5] EXIT PROGRAM                                           |");
        System.out.println("+============================================================+");
    }

    public static void showSortSubMenu() {
        System.out.println("+============================================================+");
        System.out.println("|              [1]  SORT ACCORDING TO CATEGORY               |");
        System.out.println("+============================================================+");
        System.out.println("| [1] Sort According to Chikungunya Code                     |");
        System.out.println("| [2] Sort According to Sex                                  |");
        System.out.println("| [3] Sort According to Date                                 |");
        System.out.println("| [4] Sort According to Status                               |");
        System.out.println("| [5] Sort According to Community                            |");
        System.out.println("| [6] Sort According to Parish                               |");
        System.out.println("| [7] Sort According to Latitude                             |");
        System.out.println("| [8] Sort According to Longitude                            |");
        System.out.println("| [9] Return to MAIN MENU                                    |");
        System.out.println("+============================================================+");
    }

    public static void showSearchSubmenu() {
        System.out.println("==============================================================");
        System.out.println("|            [2]  SEARCH FROM THE HEALTH RECORD              |");
        System.out.println("--------------------------------------------------------------");
        System.out.println("| [1] Search By Chikungunya Code                             |");
        System.out.println("| [2] Search By Date                                         |");
        System.out.println("| [3] Search By Community                                    |");
        System.out.println("| [4] Search By Latitude                                     |");
        System.out.println("| [5] Search By Longitude                                    |");
        System.out.println("| [6] Return to MAIN MENU                                    |");
        System.out.println("==============================================================");
    }

    public static void showFilterSubmenu() {
        System.out.println("==============================================================");
        System.out.println("|             [3]  FILTER FROM THE HEALTH RECORD             |");
        System.out.println("--------------------------------------------------------------");
        System.out.println("| [1] Filter By Sex                                          |");
        System.out.println("| [2] Filter By Status                                       |");
        System.out.println("| [3] Filter By Parish                                       |");
        System.out.println("| [4] Return to MAIN MENU                                    |");
        System.out.println("==============================================================");
    }

    public static void showCalcMenu() {
        System.out.println("+============================================================+");
        System.out.println("|          [4]  CALCULATE DATA FROM HEALTH RECORD            |");
        System.out.println("+============================================================+");
        System.out.println("| [1] Get MINIMUM Values in the Record                       |");
        System.out.println("| [2] Get MAXIMUM Values in the Record                       |");
        System.out.println("| [3] Get AVERAGE Values in the Record                       |");
        System.out.println("| [4] Get TOTAL Number of Cases                              |");
        System.out.println("| [5] Return to MAIN MENU                                    |");
        System.out.println("+============================================================+");
    }


    public static void exitProgram() {
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|         YOU ARE NOW ENDING THE PROGRAM'S PROCESS.          |");
        System.out.println("|             THANK YOU FOR USING THIS PROGRAM!              |");
        System.out.println("|                ENJOY THE REST OF YOUR DAY!                 |");
        System.out.println("+------------------------------------------------------------+");
        System.exit(0);
    }



    /*

    ------    HELPER METHODS    ------

     */

    public static int enterChoice(int min, int max) {
        Scanner kbd = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Input the number corresponding to your choice: ");
            choice = kbd.nextInt();
            if (choice < min || choice > max)
                System.out.println("INVALID CHOICE! Please enter a number from " +
                        min + " to " + max + ".");
        } while (choice < min || choice > max);
        return (choice);
    }

    public static void continueProgram() {
        System.out.print("Press ENTER to continue...");
        System.out.println();
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
