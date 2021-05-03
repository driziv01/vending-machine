package com.techelevator;

import com.techelevator.products.*;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.PrintWriter;

public class VendingMachineCLI {


    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private static final String[] PURCHASE_MENU_OPTIONS = {"FEED MONEY", "SELECT PRODUCT", "FINISH TRANSACTION"};

    private static final String[] MONEY_OPTIONS = {"$1", "$2", "$5", "$10", "$20", "BACK"};

//    private static final String[] PRODUCT_OPTIONS = {};

    private Menu menu;

    List<Item> item = new ArrayList<Item>();
    Balance currentBalance = new Balance();  // addMOney



    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }



//	//test  ***REMOVE

//	//test


    public void run() {

        loadVendingMachine();


        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


            System.out.println("THE CHOICE SELECTED FROM THE 1ST LEVEL IS:   -" + choice);


            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				File inputFile = new File ("vendingmachine.csv");
                // display vending machine items
                // TODO 2: Loop through items and print out every item.


                for (int i = 0; i < item.size(); i++) {
                    System.out.println(item.get(i).getSlot() + ")   "
                            + item.get(i).getName() + "   "
                            + item.get(i).getPrice() + "  " + item.get(i).getType() + "     "
                            + item.get(i).getQuantity() + " LEFT");


                }


            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                handlePurchaseOptions();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                // do purchase
                System.exit(0);
            }
        }
    }

    public void loadVendingMachine() {

        // TODO 1: Read through the file, and
        // each time we loop through we create an object
        // of type Item.
        // We add the object to the list items
        File inputFile = new File("vendingmachine.csv"); //grabbed file and have it

        try {
            Scanner fileScanner = new Scanner(inputFile); //read through it

            while (fileScanner.hasNext()) {
                String lineOfData = fileScanner.nextLine();
                String[] arr = lineOfData.split("\\|");

                String slot = arr[0];
                String name = arr[1];
                BigDecimal price = new BigDecimal(arr[2]);
                String type = arr[3];


                if (type.equals("Chip")) {
                    Chips createItem = new Chips(type, name, price, slot);
                    item.add(createItem);                                  // ***maybe***
                } else if (type.equals("Candy")) {
                    Candy createItem = new Candy(type, name, price, slot);
                    item.add(createItem);
                } else if (type.equals("Gum")) {
                    Gum createItem = new Gum(type, name, price, slot);
                    item.add(createItem);
                } else if (type.equals("Drink")) {
                    Drink createItem = new Drink(type, name, price, slot);
                    item.add(createItem);
                }


            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }


    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


    public void handlePurchaseOptions() {

        boolean stay = true;
        while (stay) {

            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals("FEED MONEY")) {
                System.out.println(" feeding.... money....");
                handleFeedMoney();
            } else if (choice.equals("SELECT PRODUCT")) {
                System.out.println(" selecting.... product...");

                for (int i = 0; i < item.size(); i++) {
                    System.out.println(item.get(i).getSlot() + ")   "
                            + item.get(i).getName() + "  "
                            + item.get(i).getPrice() + "  " + item.get(i).getType() + "     "
                            + item.get(i).getQuantity() + " LEFT");
                }

                System.out.println(" CHOSE ITEM SLOT   IE: B3");
                Scanner userInput = new Scanner(System.in);    // customer product selection
                String input = userInput.nextLine();
                // test
                productPurchase(input.toUpperCase(Locale.ROOT));

            } else if (choice.equals("FINISH TRANSACTION")) {
                getChange();

//                stay = false;
            }

        }

    }

    public void logger(Item item) {

        try {

//            LocalDate localDate = LocalDate.of(2021, 03, 27);
//            LocalTime localTime = LocalTime.of(03, 58, 00);

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

            File file = new File("log.txt"); // created the file prior
            FileOutputStream outputStream = new FileOutputStream(file, true);
            PrintWriter printWriter = new PrintWriter(outputStream);

//            printWriter.append(localDate.getMonthValue() +
//                    "/" + localDate.getDayOfMonth() +
//                    "/" + localDate.getYear() + localTime.getHour() +
//                    ":" + localTime.getMinute() +
//                    ":" + localTime.getSecond()
//                    + getClass().getName() ) ;  //change  item.getname + item.get price --> written on file

            printWriter.append( " > "+currentDateTime.format(targetFormat) + " " + item.getName() + " " + item.getSlot() + " " + item.getPrice() + " " + currentBalance.getBalance() + "\n");

            printWriter.flush();
            printWriter.close();

        } catch(FileNotFoundException e) {
            System.out.println("Problem Reading File");
        }
    }


    public void productPurchase(String selection) {



        for (Item object : item) {
            double withdrawTest = Double.parseDouble(String.valueOf(object.getPrice()));
                double totalMoneyTest = Double.parseDouble(String.valueOf(currentBalance.getBalance()));

            if (object.getSlot().equals(selection) && withdrawTest <=totalMoneyTest) {
//                // selection == slot
//                double withdrawTest = Double.parseDouble(String.valueOf(object.getPrice()));
//                double totalMoneyTest = Double.parseDouble(String.valueOf(currentBalance));
//                if(totalMoneyTest<withdrawTest){
//                    System.out.println(" no money ");
//
                if (object.getQuantity() > 0) {
                    }

                    currentBalance.purchaseItem(object.getPrice()); // balance subtracted by selection SLot price

                    object.setQuantity(object.getQuantity() - 1); // set quantity to quantity minus 1
                    //

                    System.out.println(" TOTAL MONEY:  " + currentBalance.getBalance());
                    System.out.println(" YOU BOUGHT - " + object.getName() + " - " + object.getPrice());
                    if (object.getType().equals("Chip")) {
                        System.out.println("Crunch Crunch, Yum!");

                    } else if (object.getType().equals("Candy")) {
                        System.out.println("Munch Munch, Yum!");

                    } else if (object.getType().equals("Drink")) {
                        System.out.println("Glug Glug, Yum!");

                    } else if (object.getType().equals("Gum")) {
                        System.out.println("Chew Chew, Yum!");

                    }
                    logger(object);
                } else if (object.getQuantity() == 0) {
                    System.out.println("SOLD OUT");
                }
            }


        }


    public void handleFeedMoney() {
        boolean stay = true;
        while (stay) {
            System.out.println(" TOTAL MONEY:  " + currentBalance.getBalance());

            String choice = (String) menu.getChoiceFromOptions(MONEY_OPTIONS);
            if (choice.equals("$1")) {
                System.out.println(" You've inserted $1 ");
                BigDecimal amount = new BigDecimal(1.00);
                currentBalance.addMoney(amount);
                currentBalance.getBalance();  // string

            } else if (choice.equals("$2")) {
                System.out.println(" You've inserted $2");
                BigDecimal amount = new BigDecimal(2.00);
                currentBalance.addMoney(amount);
                currentBalance.getBalance();

            } else if (choice.equals("$5")) {
                System.out.println(" You've inserted $5");
                BigDecimal amount = new BigDecimal(5.00);
                currentBalance.addMoney(amount);
                currentBalance.getBalance();

            } else if (choice.equals("$10")) {
                System.out.println(" You've inserted $10");
                BigDecimal amount = new BigDecimal(10.00);
                currentBalance.addMoney(amount);
                currentBalance.getBalance();

            } else if (choice.equals("$20")) {
                System.out.println(" You've inserted $20");
                BigDecimal amount = new BigDecimal(20.00);
                currentBalance.addMoney(amount);
                currentBalance.getBalance();

            } else if (choice.equals("BACK")) {

                stay = false;


            }
            //balance get method
            currentBalance.getBalance();

        }
    }

    public void getChange() {

        double cents = new BigDecimal(currentBalance.getBalance().toString()).doubleValue();
        cents = cents * 100;
        int balanceCents = (int) cents;
        System.out.println(balanceCents);
//        System.out.println(cents);

//        BigDecimal quarters = new BigDecimal(0.25);
//        BigDecimal dimes = new BigDecimal(0.10);
//        BigDecimal nickels = new BigDecimal(0.05);
        //            System.out.println( " NO CHANGE DISPENSED");


        while (balanceCents > 0) {
            if (balanceCents >= 25) {
                int numberQuarter = balanceCents / 25;
                System.out.println("YOUR NUMBER OF QUARTERS DISPENSED IS : " + numberQuarter);
                balanceCents = balanceCents - (numberQuarter * 25);

            } else if (balanceCents >= 10) {
                int numberDime = balanceCents / 10;
                System.out.println("YOUR NUMBER OF DIMES DISPENSED IS : " + numberDime);
                balanceCents = balanceCents - (numberDime * 10);
            } else if (balanceCents >= 5) {
                int numberNickel = balanceCents / 5;
                System.out.println("YOUR NUMBER OF NICKELZ DISPENSED IS : " + numberNickel);
                balanceCents = balanceCents - (numberNickel * 5);
            }

            currentBalance.zeroBalance();
//            BigDecimal zero = new BigDecimal(String.valueOf(currentBalance.getBalance()));
//            zero = currentBalance.getBalance().subtract(currentBalance.getBalance());
//            currentBalance.getBalance() = currentBalance.getBalance().subtract(currentBalance.getBalance());

//            Balance currentBalance = new Balance();
//            currentBalance = currentBalance.getBalance().subtract(currentBalance.getBalance());
            System.out.println("BALANCE IS NOW :      " + currentBalance.getBalance() + " USD");
            run();


        }

    }
}
