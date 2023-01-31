import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samarai(), new Archer(), new Knight()};
        System.out.println("Karakterler ");
        System.out.println("---------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Id :" + gameChar.getId()
                    + "\t Karakter :" + gameChar.getName()
                    + "\t Hasar :" + gameChar.getDamage()
                    + "\t Sağlık :" + gameChar.getHealth()
                    + "\t Para :" + gameChar.getMoney());
        }
        System.out.println("----------------------------------------");
        System.out.println("Bir karakter ID seçiniz .");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samarai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samarai());
        }
        System.out.println("Karakter :" + this.getCharName()
                + "\t\tHasar :" + this.getDamage()
                + "\t\tSağlık :" + this.getHealth()
                + "\t\tPara :" + this.getMoney());
    }
    public void printInfo(){
        System.out.println("silahınız :"+this.getInventory().getWeapon().getName()+
                        "\t\tzırh :"+this.getInventory().getArmor().getName()+
                        "\t\tBlok"+this.getInventory().getArmor().getBlock()+
                        "\t\tHasarınız :" + this.getTotalDamage()+
                        "\t\tSağlık :" + this.getHealth()+
                        "\t\tPara :" + this.getMoney());
    }
    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public  int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
}
