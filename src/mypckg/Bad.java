package mypckg;

public class Bad extends Special
{
    private String phrase = "";
    public Bad(String name, String job, int hp, int maxDmg, int defense, String power, Boolean cape, int level, String phrase)
    {
        super(name, job, hp, maxDmg, defense, power, cape, level);
        this.phrase = phrase;
    }
    public void laugh() { System.out.println(phrase); }
    public String toString()
    {
        return super.toString() + "\tLaugh: " + extend(phrase);
    }
}
