package mypckg;

public class Good extends Special
{
    private String phrase = "";
    private String heroName = "";
    public Good(String name, String job, int hp, int maxDmg, int defense, String power, Boolean cape, int level, String phrase, String heroName)
    {
        super(name, job, hp, maxDmg, defense, power, cape, level);
        this.phrase = phrase;
        this.heroName = heroName;
    }
    public void phrase() { System.out.println(phrase); }
    public String heroName() { return heroName; }
    public void setLevel() { setLevel(super.level() + (int)(Math.random() * 10) + 1); }
    public String toString()
    {
        return super.toString() + "\tPhrase: " + extend(phrase);
    }
}
