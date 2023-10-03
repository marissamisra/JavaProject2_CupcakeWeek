import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;


public class Order {

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu)
    {

        Scanner scan = new Scanner(System.in);
        String placeOrder;
        Double subTotal = 0.00;
        ArrayList<Object> order = new ArrayList<Object>();
        Boolean ordering = true;
        int orderChoice = 0;
        new CreateFile();
        new WriteToFile(order);

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        placeOrder = scan.nextLine();
        
        if (placeOrder.equalsIgnoreCase("Y")){
            order.add(LocalDate.now());
            order.add(LocalTime.now());

            System.out.println("~Menu~ \n\n CUPCAKES:");

            //DISPLAY CUPCAKE MENU
            for(int i = 0; i < cupcakeMenu.size(); i++){

                System.out.println("\n" + (i+1) + ". ");
                cupcakeMenu.get(i).type();
                System.out.print("$" + cupcakeMenu.get(i).getPrice() + "\n");

            }

            System.out.println("\n\nDRINKS:");

            //DISPLAY DRINK MENU
            for(int i = 0; i < drinkMenu.size(); i++){

                System.out.println("\n" + (i+4) + ". ");
                drinkMenu.get(i).type();
                System.out.print("$" + drinkMenu.get(i).getPrice() + "\n");

            }
        }
        else{
            System.out.println("Have a nice day!");
        }

        //getting the order
        while (ordering){
            System.out.println("\nWhich item would you like to order? Please use the number associated with each item to order.");
            orderChoice = scan.nextInt();
            scan.nextLine();

            //adding menu item to order
            if (orderChoice == 1){
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            }
            else if (orderChoice == 2){
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            }
            else if (orderChoice == 3){
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            }
            else if (orderChoice == 4){
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            }
            else if (orderChoice == 5){
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            }
            else if (orderChoice == 6){
                order.add(drinkMenu.get(3));
                System.out.println("\nItem added to order");
            }
            else{
                System.out.println("Sorry! We are no longer serving that item.");
            }

            //user input, add more to order
            System.out.println("Is there anything else I can get for you? (Y/N)\n");
            placeOrder = scan.nextLine();
            if (placeOrder.equalsIgnoreCase("Y")){
                //ordering stays true and loop continues
            }
            else{
                System.out.println("Have a nice day!");
                ordering = false;
            }
        }

        //Receipt
        System.out.println("\n\n" + order.get(0) + "\n" + order.get(1) + "\n");

        for (int i = 2; i < order.size(); i++){

            if (order.get(i).equals(cupcakeMenu.get(0))){
                cupcakeMenu.get(0).type();
                System.out.println("$" + cupcakeMenu.get(0).getPrice());

                subTotal = subTotal + cupcakeMenu.get(0).getPrice();
            }
            else if (order.get(i).equals(cupcakeMenu.get(1))){
                cupcakeMenu.get(1).type();
                System.out.println("$" + cupcakeMenu.get(1).getPrice());

                subTotal = subTotal + cupcakeMenu.get(1).getPrice();
            }
            else if (order.get(i).equals(cupcakeMenu.get(2))){
                cupcakeMenu.get(2).type();
                System.out.println("$" + cupcakeMenu.get(2).getPrice());

                subTotal = subTotal + cupcakeMenu.get(2).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(0))){
                drinkMenu.get(0).type();
                System.out.println("$" + drinkMenu.get(0).getPrice());

                subTotal = subTotal + drinkMenu.get(0).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(1))){
                drinkMenu.get(1).type();
                System.out.println("$" + drinkMenu.get(1).getPrice());

                subTotal = subTotal + drinkMenu.get(1).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(2))){
                drinkMenu.get(2).type();
                System.out.println("$" + drinkMenu.get(2).getPrice());

                subTotal = subTotal + drinkMenu.get(2).getPrice();
            }
        }

        System.out.println("TOTAL: $" + subTotal + "\n");

        //
        new CreateFile();
        new WriteToFile(order);
    }

    class CreateFile{
        public CreateFile(){

            try{
                File salesData = new File("salesData.txt");
                if (salesData.createNewFile()){
                    System.out.println("File created: " + salesData.getName());
                }
                else{
                    System.out.println("File already exists");
                }
            }
            catch (IOException e){
                System.out.println("An error occurred");
            }
        }
    }

    class WriteToFile{
        public WriteToFile(ArrayList<Object> order){
            
            try{
                FileWriter fw = new FileWriter("salesData.txt", true);
                PrintWriter salesWriter = new PrintWriter(fw);

                // Print order
                for (int i = 0; i < order.size(); i++){
                    salesWriter.println(order.get(i));
                }
                System.out.println("Successfully wrote to the file");
                salesWriter.close();
            }
            catch (IOException e){
                System.out.println("An error occurred");
            }
        }
    }
}