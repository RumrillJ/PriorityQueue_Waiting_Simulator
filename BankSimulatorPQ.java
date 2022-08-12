import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;


//customer constructor
class Customer implements Comparable<Customer>{
    int queue;
    String name;
    public Customer(String name, int queue) {
        this.queue = queue;
        this.name = name;
    }
    //override Comparator
    @Override
    public int compareTo(Customer c) {
        if(queue < c.queue)
            return -1;
        else if(queue > c.queue)
            return 1;
        return 0;
    }
    //toString Method
    @Override
    public String toString(){
        String result = name + ", " + queue;
        return result;
    }

}

public class BankSimulator {
    public static void main(String[] args)
    {
        PriorityQueue<Customer> CustomerQ = new PriorityQueue<>();

        //add queue list
        CustomerQ.add(new Customer("Customer", 1));
        CustomerQ.add(new Customer("Customer", 2));
        CustomerQ.add(new Customer("Customer", 3));
        CustomerQ.add(new Customer("Customer", 4));
        CustomerQ.add(new Customer("Customer", 5));


        //print lines to start
        System.out.println("Bank Simulation To Represent Customers Entering/Leaving");
        System.out.println("");
        System.out.println("Bank Day Starting");
        System.out.println("Current Bank Queue List:");
        Iterator<Customer> it = CustomerQ.iterator();

        //calculation values
        int total = 0;
        int i= 0;
        int avg = 1;
        Random rand = new Random();
        int r = rand.nextInt(101) + 1;
        while(it.hasNext()){
            int tick = rand.nextInt(10) + 1;

            //50 or less RNG for Event
            if(r <= 50){
                System.out.println("");
                CustomerQ.add(new Customer("Customer", 1));
                System.out.println(CustomerQ.peek() + " Joins The Bank Line ");
                it.hasNext();
                r = rand.nextInt(101) + 1;

            }
            //51 or greater RNG for Event
            else if (r >= 51){
                System.out.println("");
                System.out.println(CustomerQ.poll().toString() + " Leaves The Teller: " + tick + " Minutes (Ticks)" );
                System.out.println("Number of Customers in Line: " + CustomerQ.size());

                //calculation for leaving
                i++;
                total += tick;
                r = rand.nextInt(101) + 1;
                avg = total / i;
                System.out.println("Current Wait Time Average is: " + avg + " Minutes (ticks");
            }

        }
        System.out.println("Bank Day Over");
        //average calculation
        double average = total / i;
        System.out.println("Average Wait Time Today Was: " + average + " Minutes (ticks)");
        System.out.println("Total Wait Time Today WAs: " + total + " Minutes (ticks)");
    }
}

