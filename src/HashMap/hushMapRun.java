package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class hushMapRun {

    /**
     * HASH MAP
     * Implementation: Table/buckets
     * Access/Search Speed: O(1)
     * Order = No natural order
     *
     * TREEMAP
     * Implementation: Red Black Tree
     * Access/Search Speed: O(log(n))
     * Order = Natural order of keys --> Use this if you need natural ordering
     *
     * LINKED HASHMAP
     * Implementation: Red Black Tree
     * Access/Search Speed: O(1)
     * Order = Order of insertion (more memory than HashMap)
     * */
    public static void main(String [] args){



//        Scanner scan = new Scanner(System.in);

        boolean moreDessert = false;
        int I = 0;
        Map<String, Integer> DessMap = new HashMap<String, Integer>();
        do{
            //Prompt user to enter
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your favorite Dessert ");
            String dessert = scan.nextLine().toUpperCase();

//            if(!DessMap.containsKey(dessert)){
//                DessMap.put(dessert, 1);
//            } else {
////                int Increment = DessMap.get(dessert) + 1;
//                DessMap.put(dessert, (DessMap.get(dessert) + 1));
//            }


//            //We can achieve the above if else code with
//           DessMap.putIfAbsent(dessert, 1);
//           DessMap.compute(dessert, (key, value)-> value+1);

            //more ways
            DessMap.computeIfPresent(dessert, (key, value)-> ++value);
            DessMap.computeIfAbsent(dessert, (key)-> 1);


            System.out.println("Would you like to add another dessert? ");
            moreDessert = scan.next().toUpperCase().charAt(0) == 'Y';

        } while(moreDessert);

        System.out.println("\n Print them all : \n");

        for(String J : DessMap.keySet()){
          System.out.printf(" \t%s was chosen %s times \n ", J, DessMap.get(J));
        }

        //Another way to print everything
        DessMap.forEach((key, value) -> System.out.printf(" \t%s was chosen %s times \n ", key, value));
    }
}
