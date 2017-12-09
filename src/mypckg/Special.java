package mypckg;

public class Special extends Person
{
    private String power = "";
    private Boolean cape = false;
    private int level = 0;
    private String specialName = "";
    public Special(String name, String job, int hp, int maxDmg, int defense, String power, Boolean cape, int level, String specialName)
    {
        super(name, job, hp, maxDmg, defense);
        this.specialName = specialName;
        this.power = power;
        this.cape = cape;
        this.level = level;
    }
    public String power() { return power; }
    public Boolean cape() { return cape; }
    public String specialName() { return specialName(); }
    public int level() { return level; }
    public void setLevel(int level) { this.level = level; }
    public String toString() { return super.toString() + "\tPower: " + extend(power) + "\tCape: " + extend("" + cape) + "\tPower Level: " + extend("" + level); }
}
