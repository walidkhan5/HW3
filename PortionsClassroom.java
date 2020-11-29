
package HW3;

import java.util.Scanner;

public class PortionsClassroom extends School 
{
    Character ch;

    PortionsClassroom(Character ch) 
    {
        super("Potions Classroom", "East", "Professor Snape", ch);
        System.out.println("You have entered the Potions Classroom");
        this.ch = ch;

        Scanner object = new Scanner(System.in);
        String x = object.nextLine();

        while ( !( x.contains("look") ) ) 
        {
            System.out.println("Invalid option entered. Try again:");
            x = object.nextLine();
        }
        
        place();

    }

    @Override
    void potionsProcedure() 
    {
        System.out.println("You saved yourself�now you can now use the cauldron and ingredients to make the\n" +
                "Polyjuice potion or the invisibility potion to proceed without anyone recognizing you�");
        Scanner object = new Scanner(System.in);
        boolean status = false;
        while (!status) {
            String x = object.nextLine();
            
            if(x.startsWith("make")) 
            {
                String potion = x.substring(5);
                
                if (potion.equals("Polyjuice potion")) 
                {
                    if (ch.polyPotion == false) 
                    {


                        new PolyjuicePotion().preparePotion("fluxweed and lacewings", "4 times clockwise", "high");
                        ch.polyPotion = true;
                    } else {
                        System.out.println("You already have a Polyjuice potion");
                    }
                } else if (potion.equals("Invisibility potion")) {

                    if (ch.invisibilePotion == false) {
                        new InvisibilityPotion().preparePotion("cherries and spiders", "3 times anticlockwise", "high");
                        ch.invisibilePotion = true;
                    } else {
                        System.out.println("You already have an Invisible potion");
                    }
                } else {
                    System.out.println("Invalid option try again: ");
                }
            } else
            {
                System.out.println("Invalid option try again: ");
            }
            if(ch.polyPotion && ch.invisibilePotion){
                status = true;
            }

        }
    }

    @Override
    void look() {
        System.out.println("Potions is one of the core subjects that first year students are required to study. In the\n" +
                "potions class there is Professor Snape who teaches the subject. He does not seem very happy\n" +
                "to see you and starts attacking you!");
    }

    @Override
    void next() {

        //System.out.println("Where to next (Library west or Dining Hall north): ");
        Scanner object = new Scanner(System.in);
        boolean status = false;
        while (!status) {
            String c = object.nextLine();
            if (c.contains("library") ||  c.contains("west")) {
                status = true;
               // System.out.println("Leaving the room...");
                ch.setLocation("Library");
                new Library(ch);
            } else if (c.contains("dining") || c.contains("north")) {
                status = true;
              //  System.out.println("Leaving the room...");
                ch.setLocation("Dining Hall");
                new DiningHall(ch);
            } else {
                System.out.println("Invalid option entered. Try again:");
            }

        }

    }
}

