package prelim;

import java.io.*;
import java.text.*;
import java.util.*;

public class CalculateRecord {
    public static void calcMenu() throws IOException, ParseException {


        int myChoice;
        do {
            MainRecords.showCalcMenu();
            myChoice = MainRecords.enterChoice(1, 5);
            switch (myChoice) {
                case 1 ->
                    // MINIMUM
                        minMenu();

                case 2 ->
                    // MAXIMUM
                        maxMenu();

                case 3 ->
                    // AVERAGE
                        avgMenu();

                case 4 ->
                    // TOTAL
                        totalMenu();

                case 5 ->
                    // MAIN MENU
                        MainRecords.mainMenu();
            }
            MainRecords.continueProgram();
        } while (myChoice != 8);
    }



    public static void minMenu() {
        int column = 0;
        int latitude = 6;
        int longitude = 7;
        int choice;
        double min;

        try (BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"))) {
            List<Double> values = new ArrayList<>();
            String line;

            System.out.println("+============================================================+");
            System.out.println("|                CHOOSE AN OPTION TO GET VALUES              |");
            System.out.println("+============================================================+");
            System.out.println("| [1] Minimum number According to Code                       |");
            System.out.println("| [2] Minimum number According to Latitude                   |");
            System.out.println("| [3] Minimum number According to Longitude                  |");
            System.out.println("+============================================================+");
            Scanner kbd = new Scanner(System.in);
            System.out.print("Input the number corresponding to your choice: ");
            choice = kbd.nextInt();


            if (choice == 1){
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.parseDouble(row[column]));
                }
                min = Double.MAX_VALUE;
                for (double value : values) {
                    if (value < min) {
                        min = value;
                    }
                }
                System.out.println("The minimum value in code is: "  + min );

            } else if (choice == 2) {
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.parseDouble(row[latitude]));
                }
                min = Double.MAX_VALUE;
                for (double value : values) {
                    if (value < min) {
                        min = value;
                    }
                }
                System.out.println("The minimum value in latitude is: " + min );

            } else if (choice == 3) {
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.parseDouble(row[longitude]));
                }
                min = Double.MAX_VALUE;
                for (double value : values) {
                    if (value < min) {
                        min = value;
                    }
                }
                System.out.println("The minimum value in longitude is: " + min );

            }

        } catch (Exception e) {
            e.printStackTrace();


        }
    }



    public static void maxMenu() {
        int column = 0;
        int latitude = 6;
        int longitude = 7;
        int choice;
        double max;

        try (BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"))) {
            List<Double> values = new ArrayList<>();
            String line;

            System.out.println("+============================================================+");
            System.out.println("|               CHOOSE AN OPTION TO GET VALUES               |");
            System.out.println("+============================================================+");
            System.out.println("| [1] Maximum number According to Code                       |");
            System.out.println("| [2] Maximum number According to Latitude                   |");
            System.out.println("| [3] Maximum number According to Longitude                  |");
            System.out.println("+============================================================+");
            Scanner kbd = new Scanner(System.in);
            System.out.print("Input the number corresponding to your choice: ");
            choice = kbd.nextInt();


            if (choice == 1){
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.valueOf(row[column]));
                }
                max = Double.MIN_VALUE;
                double min = Double.MAX_VALUE;
                for (double value : values) {
                    double currentValue = Double.parseDouble(String.valueOf(value));
                    if (currentValue < max) {
                        max = value;
                    }
                    if (max > min) {
                        min = max;
                    }
                }

                System.out.println("Max value in Code " + column + ": " + max);

            } else if (choice == 2) {
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.parseDouble(row[latitude]));
                }
                max = Double.MAX_VALUE;
                for (double value : values) {
                    if (value > max) {
                        max = value;
                    }
                }
                System.out.println("Max value in Latitude is: " + max );

            } else if (choice == 3) {
                while ((line = file.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row[0].equals("CODE"))
                        continue;
                    values.add(Double.parseDouble(row[longitude]));
                }
                max = Double.MAX_VALUE;
                for (double value : values) {
                    if (value > max) {
                        max = value;
                    }
                }
                System.out.println("Max value in Longitude is: " + max);

            }

        } catch (Exception e) {
            e.printStackTrace();


        }
    }



    public static void avgMenu() {
        int choice;

        try (BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"))) {
            String line;

            System.out.println("+============================================================+");
            System.out.println("|             CHOOSE AN OPTION TO GET THE AVERAGE            |");
            System.out.println("+============================================================+");
            System.out.println("| [1] Get the AVERAGE point in Latitude                      |");
            System.out.println("| [2] Get the AVERAGE point in Longitude                     |");
            System.out.println("| [3] Return to CALCULATE MENU                               |");
            System.out.println("+============================================================+");
            Scanner kbd = new Scanner(System.in);
            System.out.print("Input the number corresponding to your choice: ");
            choice = kbd.nextInt();

            if (choice == 1) {

                int latCount = -1;
                double latSum = 0;
                double latAvg = 0;

                while ((line = file.readLine()) != null) {
                    String[] detailed = line.split(",");
                    if (detailed[0].equals("CODE"))
                        continue;
                    double latitude = Double.parseDouble(detailed[6]);
                    latCount++;
                    latSum = latSum + latitude;
                    latAvg = latSum / latCount;
                }

                System.out.println("+============================================================+");
                System.out.println("| THE AVERAGE POINT IN LATITUDE IS: " + latAvg + "       |");
                System.out.println("+============================================================+");

            } else if (choice == 2) {

                int longCount = -1;
                double longSum = 0;
                double longAvg = 0;

                while ((line = file.readLine()) != null) {
                    String[] detailed = line.split(",");
                    if (detailed[0].equals("CODE"))
                        continue;
                    double longitude = Double.parseDouble(detailed[7]);
                    longCount++;
                    longSum = longSum + longitude;
                    longAvg = longSum / longCount;
                }

                System.out.println("+============================================================+");
                System.out.println("| THE AVERAGE POINT IN LONGITUDE IS: " + longAvg + "      |");
                System.out.println("+============================================================+");

            } else if (choice == 3) {
                MainRecords.showCalcMenu();
            }

        } catch (Exception e) {
            e.printStackTrace();


        }
    }



    public static void totalMenu() {
        int choice;
        
        try (BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"))) {
            String line;

            System.out.println("+============================================================+");
            System.out.println("|             CHOOSE AN OPTION TO COUNT THE TOTAL            |");
            System.out.println("+============================================================+");
            System.out.println("| [1] Get the TOTAL number of all cases                      |");
            System.out.println("| [2] Get the TOTAL number of SUSPECTED cases                |");
            System.out.println("| [3] Get the TOTAL number of CONFIRMED cases                |");
            System.out.println("| [4] Return to CALCULATE MENU                               |");
            System.out.println("+============================================================+");
            Scanner kbd = new Scanner(System.in);
            System.out.print("Input the number corresponding to your choice: ");
            choice = kbd.nextInt();
            
            if (choice == 1) {
                // TOTAL NUMBER OF ALL CASES

                int count = -1;

                while ((line = file.readLine()) != null) {
                    count++;
                }
                System.out.println("+============================================================+");
                System.out.println("| THE TOTAL NO. OF ALL CASES IS: " + count + "                        |");
                System.out.println("+============================================================+");

            } else if (choice == 2) {
                // TOTAL NUMBER OF SUSPECTED CASES

                int susCount = 0;

                while ((line = file.readLine()) != null) {
                    String[] detailed = line.split(",");
                    if (detailed[0].equals("CODE"))
                        continue;
                    String status = detailed[3];
                    if (Objects.equals(status, "Suspected")) {
                        susCount++;
                    }
                }
                System.out.println("+============================================================+");
                System.out.println("| THE TOTAL NO. OF SUSPECTED CASES IS: " + susCount + "                  |");
                System.out.println("+============================================================+");

            } else if (choice == 3) {
                // TOTAL NUMBER OF CONFIRMED CASES

                int confCount = 0;

                while ((line = file.readLine()) != null) {
                    String[] detailed = line.split(",");
                    if (detailed[0].equals("CODE"))
                        continue;
                    String status = detailed[3];
                    if (Objects.equals(status, "Confirmed")) {
                        confCount++;
                    }
                }
                System.out.println("+============================================================+");
                System.out.println("| THE TOTAL NO. OF CONFIRMED CASES IS: " + confCount + "                    |");
                System.out.println("+============================================================+");
            } else if (choice == 4) {
                MainRecords.showCalcMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
