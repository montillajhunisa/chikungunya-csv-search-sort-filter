package prelim;

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SortSearchFilter {
    public static void sortMenu() throws IOException, ParseException {
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
            MainRecords.showSortSubMenu();
            myChoice = MainRecords.enterChoice(1, 9);
            switch (myChoice) {
                case 1 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getCode() - (o2.getCode());
                                    }
                                });

                                System.out.println();
                                System.out.println("========================================== SORTED ACCORDING TO CHIKUNGUNYA CODE " +
                                        "============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> (int) (c1.getCode() - c2.getCode());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("========================================== SORTED ACCORDING TO CHIKUNGUNYA CODE " +
                                        "============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 2 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getSex().compareTo(o2.getSex());
                                    }
                                });

                                System.out.println();
                                System.out.println("================================================= SORTED ACCORDING TO SEX " +
                                        "==================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> c1.getSex().compareTo(c2.getSex());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("================================================= SORTED ACCORDING TO SEX " +
                                        "==================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);

                }

                case 3 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getDate().compareTo(o2.getDate());
                                    }
                                });

                                System.out.println();
                                System.out.println("================================================ SORTED ACCORDING TO DATE " +
                                        "==================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> c1.getDate().compareTo(c2.getDate());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("================================================ SORTED ACCORDING TO DATE " +
                                        "==================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 4 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getStatus().compareTo(o2.getStatus());
                                    }
                                });

                                System.out.println();
                                System.out.println("=============================================== SORTED ACCORDING TO STATUS " +
                                        "=================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> c1.getStatus().compareTo(c2.getStatus());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("=============================================== SORTED ACCORDING TO STATUS " +
                                        "=================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 5 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getCommunity().compareTo(o2.getCommunity());
                                    }
                                });

                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO COMMUNITY " +
                                        "===============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> c1.getCommunity().compareTo(c2.getCommunity());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO COMMUNITY " +
                                        "===============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 6 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(new Comparator<HealthRecord>() {
                                    @Override
                                    public int compare(HealthRecord o1, HealthRecord o2) {
                                        return o1.getParish().compareTo(o2.getParish());
                                    }
                                });

                                System.out.println();
                                System.out.println("=============================================== SORTED ACCORDING TO PARISH " +
                                        "=================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                Comparator<HealthRecord> comparator = (c1, c2) -> c1.getParish().compareTo(c2.getParish());
                                record.sort(Collections.reverseOrder(comparator));
                                System.out.println();
                                System.out.println("=============================================== SORTED ACCORDING TO PARISH " +
                                        "=================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 7 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(Comparator.comparingDouble(HealthRecord::getLatitude));
                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO LATITUDE " +
                                        "================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                record.sort(Collections.reverseOrder(Comparator.comparingDouble(HealthRecord::getLatitude)));
                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO LATITUDE " +
                                        "================================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 8 -> {
                    do {
                        System.out.println("+============================================================+");
                        System.out.println("| [1] Ascending Order                                        |");
                        System.out.println("| [2] Descending Order                                       |");
                        System.out.println("| [3] Return to SORT MENU                                    |");
                        System.out.println("+============================================================+");

                        myChoice = MainRecords.enterChoice(1, 3);
                        switch (myChoice) {
                            case 1 -> {
                                record.sort(Comparator.comparingDouble(HealthRecord::getLongitude));
                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO LONGITUDE " +
                                        "===============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 2 -> {
                                record.sort(Collections.reverseOrder(Comparator.comparingDouble(HealthRecord::getLongitude)));
                                System.out.println();
                                System.out.println("============================================== SORTED ACCORDING TO LONGITUDE " +
                                        "===============================================");
                                System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                                "%11s   | %11s   |", "CODE", "SEX", "DATE",
                                        "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                                System.out.println("\n---------------------------------------------------------------------------" +
                                        "-------------------------------------------------");
                                for (HealthRecord rec : record) {
                                    System.out.println(rec);
                                }
                                System.out.println("================================================================================" +
                                        "============================================");
                            }

                            case 3 -> sortMenu();
                        }
                        sortMenu();
                    } while (myChoice != 3);
                }

                case 9 -> MainRecords.mainMenu();
            }
            MainRecords.continueProgram();
        } while (myChoice != 9);
    }

    public static void searchMenu() throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"));
        ArrayList<HealthRecord> record = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        int myChoice;
        do {
            MainRecords.showSearchSubmenu();
            myChoice = MainRecords.enterChoice(1, 6);
            switch (myChoice) {
                case 1 -> {
                    System.out.println("=============================================== SEARCH BY CHIKUNGUNYA CODE " +
                            "=================================================");
                    System.out.print("Enter the Chikungunya code: ");
                    int chikungunyaCode = Integer.parseInt(keyboard.nextLine());
                    System.out.println("====================================================== RECORD FOUND " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(chikungunyaCode, code)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                            for (HealthRecord rec : record) {
                                System.out.println(rec);
                            }
                        }
                    }
                    if (record.isEmpty()) {
                        System.out.printf("|%85s%39s" , "There is no Chikungunya Code " +chikungunyaCode+ " found in the record.", "|\n");
                    }
                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 2 -> {
                    System.out.println("===================================================== SEARCH BY DATE " +
                            "=======================================================");
                    System.out.println("Type the date in this format : DD/MM/YYYY");
                    System.out.print("Enter the date: ");
                    String dateInput = keyboard.next();
                    LocalDate dt = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("====================================================== RECORD FOUND " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(java.sql.Date.valueOf(dt), date)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()) {
                        System.out.printf("|%80s%44s" , "There is no date " +dateInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("=================================================== SEARCH BY COMMUNITY " +
                            "====================================================");
                    System.out.print(" Enter the community: ");
                    String communityInput = keyboard.nextLine();
                    System.out.println("====================================================== RECORD FOUND " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(communityInput, community)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()) {
                        System.out.printf("|%70s%54s" , "There is no community " +communityInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 4 -> {
                    System.out.println("=================================================== SEARCH BY LATITUDE " +
                            "=====================================================");
                    System.out.print("Enter the latitude: ");
                    Double latitudeInput = Double.parseDouble(keyboard.nextLine());
                    System.out.println("====================================================== RECORD FOUND " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(latitudeInput, latitude)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()){
                        System.out.printf("|%78s%46s" , "There is no latitude " +latitudeInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 5 -> {
                    System.out.println("================================================== SEARCH BY LONGITUDE " +
                            "=====================================================");
                    System.out.print("Enter the longitude: ");
                    Double longitudeInput = Double.parseDouble(keyboard.nextLine());
                    System.out.println("====================================================== RECORD FOUND " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(longitudeInput, longitude)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()){
                        System.out.printf("|%78s%46s" , "There is no longitude " +longitudeInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 6 -> MainRecords.mainMenu();
            }
            MainRecords.mainMenu();
        } while (myChoice != 6);
    }

    public static void filterMenu() throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader("ChikungunyaRecord.csv"));
        ArrayList<HealthRecord> record = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        int myChoice;
        do {
            MainRecords.showFilterSubmenu();
            myChoice = MainRecords.enterChoice(1, 4);
            switch (myChoice) {
                case 1 -> {
                    System.out.println("====================================================== FILTER BY SEX " +
                            "=======================================================");
                    System.out.println(" Kindly type the letter that you wish to filter.");
                    System.out.println(" (M) Male");
                    System.out.println(" (F) Female");
                    System.out.println("---------------------------------------------------------------------------" +
                            "-------------------------------------------------");
                    System.out.print(" Enter the letter: ");
                    String sexRecord = keyboard.nextLine();
                    System.out.println("=================================================== FILTERED RECORD " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(sexRecord, sex)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()) {
                        System.out.printf("|%75s%49s" , "There is no " +sexRecord+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 2 -> {
                    System.out.println("==================================================== FILTER BY STATUS " +
                            "======================================================");
                    System.out.println(" Kindly type the Status that you wish to filter.");
                    System.out.println(" Confirmed");
                    System.out.println(" Suspected");
                    System.out.println("---------------------------------------------------------------------------" +
                            "-------------------------------------------------");
                    System.out.print(" Enter the status: ");
                    String statusInput = keyboard.nextLine();
                    System.out.println("=================================================== FILTERED RECORD " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(statusInput, status)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()) {
                        System.out.printf("|%80s%44s" , "There is no status " +statusInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("==================================================== FILTER BY PARISH " +
                            "======================================================");
                    System.out.println(" Kindly type the parish that you wish to filter.");
                    System.out.println(" Clarendon");
                    System.out.println(" Hanover");
                    System.out.println(" Kingston");
                    System.out.println(" Manchester");
                    System.out.println(" Portland");
                    System.out.println(" Saint Andrew");
                    System.out.println(" Saint Ann");
                    System.out.println(" Saint Catherine");
                    System.out.println(" Saint Elizabeth");
                    System.out.println(" Saint James");
                    System.out.println(" Saint Marry");
                    System.out.println(" Saint Thomas");
                    System.out.println(" Trelawny");
                    System.out.println(" Westmoreland");
                    System.out.println("---------------------------------------------------------------------------" +
                            "-------------------------------------------------");
                    System.out.print(" Enter the Parish: ");
                    String parishInput = keyboard.nextLine();
                    System.out.println("=================================================== FILTERED RECORD " +
                            "========================================================");
                    System.out.printf("| %5s | %3s | %7s    | %8s   | %20s           | %11s     | " +
                                    "%11s   | %11s   |", "CODE", "SEX", "DATE",
                            "STATUS", "COMMUNITY", "PARISH", "LATITUDE", "LONGITUDE");
                    System.out.println("\n---------------------------------------------------------------------------" +
                            "-------------------------------------------------");

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

                        if (Objects.equals(parishInput, parish)) {
                            record.add(new HealthRecord(code, sex, date, status, community, parish, latitude, longitude));
                        }
                    }

                    for (HealthRecord rec : record) {
                        System.out.println(rec);
                    }

                    if (record.isEmpty()) {
                        System.out.printf("|%73s%46s" , "There is no parish " +parishInput+ " found in the record.", "|\n");
                    }

                    System.out.println("================================================================================" +
                            "============================================");
                    System.out.println();
                }

                case 4 -> MainRecords.mainMenu();

            }
            MainRecords.mainMenu();
        } while (myChoice != 4);
    }
}    