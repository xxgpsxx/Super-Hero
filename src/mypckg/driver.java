import java.util.ArrayList;
public class driver
{
    String[] first = {"George", "Bryan", "Jeremy", "Alvin", "Ethan", "Andrew", "Brian", "John", "Franklin", "James", "Mark"};
    String[] last = {"Sheng", "Liu", "Chen", "Peng", "Ju", "Wang", "Yin", "Wong", "Zhang", "Zhou", "Lalumia", "Lalu"};
	ArrayList <Person> street = new ArrayList <Person>();
    public driver()
    {
        for(int i = 0; i < 48; i++)
            street.add(new Person(randName(), "McDonald's Cashier", randint(50, 101), randint(0, 10), randint(0, 11)));
        street.add(randint(0, 48), new Good(randName(), "Red-Orange Lantern", 100, 23, 10, "[Undefined]", false, 5, "I liek rice", "Chinky"));
        street.add(randint(0, 49), new Bad(randName(), "Bass Player", 100, 10, 10, "Inconvenient Rehearsal", false, 3, "You, me, tomorrow night, in this room"));
        print(street);

        ArrayList <Person> safe = new ArrayList <Person>();
        ArrayList <Person> wounded = new ArrayList <Person>();


		//Removing the normal people
        while(true)
        {
			int bad = indexBad(street);
			int good = indexGood(street);
			Boolean remove = false;
            if(bad != 0 && bad != street.size() - 1)
            {
                if(street.get(bad + 1) instanceof Good)
					wounded.add(street.remove(bad - 1));


                else if(street.get(bad - 1) instanceof Good)
                    wounded.add(street.remove(bad + 1));

                else
                    wounded.add(street.remove(bad + ((int)(Math.random() * 2) * 2) - 1));
				remove = true;
            }
            else if(bad == 0 && good != 1)
            {
                wounded.add(street.remove(1));
                remove = true;
			}

            else if(bad == street.size() - 1 && good != street.size() - 2)
            {
                wounded.add(street.remove(street.size() - 2));
                remove = true;
			}
			if(remove)
			{
				System.out.println(badGuy().name() + " has wounded " + wounded.get(wounded.size() - 1).name());
				Bad temp = (Bad)(street.get(indexBad(street)));
				temp.laugh();
				Good gd = (Good)(street.get(indexGood(street)));
				gd.phrase();
			}

            while(street.size() > 2)
            {
                int temp = randint(0, street.size());
                if(!(street.get(temp) instanceof Special))
                {
                    System.out.println(street.get(indexGood(street)).name() + " has saved " + street.get(temp).name());
                    safe.add(street.remove(temp));
                    break;
                }
            }
            street.add(randint(0, street.size() - 2), street.remove(indexGood(street)));

            System.out.println("\n\n");
            print(street);
            if(street.size() == 2)
            	break;
        }

        Person[] order = new Person[2];
        order[0] = street.remove(randint(0, 2));
        order[1] = street.remove(0);

        int turn = 0;
        //Combat
        while(true)
        {
			Person attacker = order[turn];
			Person defender = order[1 - turn];
			System.out.println(attacker.name() + " is attacking " + defender.name());
			int damage = randint(0, attacker.maxDmg());
			int defense = randint(0, defender.defense());
			System.out.println(attacker.name() + ": " + damage + " Damage\n" + defender.name() + ": " + defense + " Defense");
			if(!(damage - defense < 0))
			{
				defender.reduceHp(damage - defense);
				System.out.println(defender.name() + "'s Health points have been reduced to " + defender.hp() + "!");
			}
			else
				System.out.println(defender.name() + "'s Defense was too high!");

			if(defender.hp() < 0)
			{
				System.out.println(attacker.name() + " has defeated " + defender.name() + "!");
				break;
			}
			turn = 1 - turn;
		}




    }
    public int randint(int min, int max) { return (int)(Math.random() * (max - min)) + min; }
    public String randName() { return first[randint(0,first.length)] + " " +  last[randint(0, last.length)]; }
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
    public Bad badGuy() {  return (Bad)(street.get(indexBad(street)));  }
    public Good goodGuy() {  return (Good)(street.get(indexGood(street))); }

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
