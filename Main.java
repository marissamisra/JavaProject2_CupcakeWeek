import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
            ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
            String priceText;
            Double price;
            Cupcake cupcake = new Cupcake();
            RedVelvet redVelvet = new RedVelvet();
            Chocolate chocolate = new Chocolate();
            Drink water = new Drink();
            Soda soda = new Soda();
            Milk milk = new Milk();

            //CUPCAKES
            System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing. We are deciding on the price for our standard cupcake. Here is the description: \n");
            cupcake.type();

            System.out.println("\nHow much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            cupcake.setPrice(price);

            System.out.println("How much would you like to charge for the redVelvet cupcake? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            redVelvet.setPrice(price);
            redVelvet.getPrice();

            System.out.println("How much would you like to charge for the chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            chocolate.setPrice(price);
        
            cupcakeMenu.add(cupcake);
            cupcakeMenu.add(redVelvet);
            cupcakeMenu.add(chocolate);

            //DRINKS
            System.out.println("\n\nWe are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing. We are deciding on the price for our bottled water. Here is the description: \n");
            water.type();

            System.out.println("How much would you like to charge for the water? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            water.setPrice(price);
            water.getPrice();

            System.out.println("How much would you like to charge for the soda? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            soda.setPrice(price);

            System.out.println("How much would you like to charge for the milk? (Input a numerical number taken to 2 decimal places)");
            priceText = scan.nextLine();
            price = Double.parseDouble(priceText);
            milk.setPrice(price);
        
            drinkMenu.add(water);
            drinkMenu.add(soda);
            drinkMenu.add(milk);

            //CUSTOMER SERVICE
            new Order(cupcakeMenu, drinkMenu);

            scan.close();
    }
}

class Cupcake{
        public double price;

        public double getPrice(){
            return price;
        }

        public void setPrice(double price){
        this.price = price;
        }

        public void type(){
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }
    }

    class RedVelvet extends Cupcake
{
    public void type(){
        System.out.println("A red velvet based cupcake, with cream cheese frosting");
    }
}

class Chocolate extends Cupcake
{
    public void type()
    {
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

class Drink{
    public double price;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

        public void type(){
        System.out.println("A bottle of water");
    }
}

class Soda extends Drink{

    public void type(){
        System.out.println("A bottle of soda");
    }
}

class Milk extends Drink{
    public void type(){
        System.out.println("A bottle of milk");
    }
}
