package mypckg;

public class Person
{
    private String name = "";
    private String job = "";
    private int hp = 0;
    private int maxDmg = 0;
    private int defense = 0;
    public Person(String name, String job, int hp, int maxDmg, int defense)
    {
        this.hp = hp;
        this.maxDmg = maxDmg;
        this.defense = defense;
        this.name = name;
        this.job = job;
    }
    public String name() { return name; }
    public String job() { return job; }
    public int hp() { return hp; }
    public int maxDmg() { return maxDmg; }
    public int defense() { return defense; }
    public void reduceHp(int x) { this.hp -= x; }
    public String toString() { return "Name: " + extend(name) + "\tJob: " + extend(job); }
    public String extend(String word)
    {
        int length = word.length();
        String output = word;
        if(length >= 12)
        {
            for(int i = 0; i < 4 - length % 4; i++)
                output += " ";
        }
        else if(length >= 8)
        {
            for(int i  = 0; i < 8 - length % 4; i++)
                output += " ";
        }
        else if(length > 4)
        {
            for(int i = 0; i < 12 - length %4; i++)
                output += " ";
        }
        else
        {
            for(int i = 0; i < 16 - length; i++)
                output += " ";
        }
        return output;
    }
}
