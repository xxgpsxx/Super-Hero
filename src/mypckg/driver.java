package mypckg;

import java.util.ArrayList;
public class driver
{
    String[] first = {"George", "Bryan", "Jeremy", "Alvin", "Ethan", "Andrew", "Brian", "John", "Franklin", "James"};
    String[] last = {"Sheng", "Liu", "Chen", "Peng", "Ju", "Wang", "Yin", "Wong", "Zhang", "Zhou"};
    public driver()
    {
        Bad xa = new Bad(randName(), "Bass Player", 100, 10, 10, "Inconvenient Rehearsal", false, 3, "You, me, tomorrow night, in this room");
        xa.laugh();
        int good = randint(0, 48);
        int bad = randint(0, 49);
        int[] count = new int[3];
        ArrayList <Person> street = new ArrayList <Person>();
        for(int i = 0; i < 48; i++)
            street.add(new Person(randName(), "McDonald's Cashier", randint(50, 101), randint(0, 10), randint(0, 11)));
        street.add(good, new Good(randName(), "Red-Orange Lantern", 100, 23, 10, "[Undefined]", false, 5, "I liek rice", "Chinky"));
        street.add(bad, new Bad(randName(), "Bass Player", 100, 10, 10, "Inconvenient Rehearsal", false, 3, "You, me, tomorrow night, in this room"));
        print(street);

        ArrayList <Person> safe = new ArrayList <Person>();
        ArrayList <Person> wounded = new ArrayList <Person>();

        while(true)
        {
            if(bad != 0 && bad != 49)
            {
                if(street.get(bad + 1) instanceof Good)
                {
                    wounded.add(street.remove(bad -1));
                    bad--;
                }
                else if(street.get(bad - 1) instanceof Good)
                    wounded.add(street.remove(bad + 1));
                else
                {
                    int x = ((int)(Math.random() * 2) * 2) - 1;
                    wounded.add(street.remove(bad + x));
                    if(bad + x < bad)
                        bad += x;
                }
            }
            else if(bad == 0)
                wounded.add(street.remove(1));
            else
            {
                bad = 48;
                wounded.add(street.remove(48));
            }
            while(true)
            {
                int temp = randint(0, street.size() - 1);
                if(!(street.get(temp) instanceof Special))
                {
                    safe.add(street.remove(randint(0, street.size() - 1)));
                    break;
                }
            }
            System.out.println("\n\n\n");
            System.out.println("New Street: ");
            print(street);
            break;
        }

    }
    public int randint(int min, int max) { return (int)(Math.random() * (max - min)) + min; }
    public String randName() { return first[randint(0,10)] + " " +  last[randint(0, 10)]; }
    public void print(ArrayList <Person> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).name());
            if(list.get(i) instanceof Bad)
                System.out.println("  (Bad Guy)");
            else if(list.get(i) instanceof Good)
                System.out.println("  (Good Guy)");
            else
                System.out.println();
        }
    }
    public int indexGood(ArrayList <Person> street)
    {
        for(int i = 0; i < street.size(); i++)
            if(street.get(i) instanceof Good)
                return i;
        return -1;
    }
    public int indexBad(ArrayList <Person> street)
    {
        for(int i = 0; i < street.size(); i++)
            if(street.get(i) instanceof Bad)
                return i;
        return -1;
    }
    public static void main(String args[])
    {
        driver app = new driver();
    }
}
