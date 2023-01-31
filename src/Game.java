import javax.swing.*;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoş geldiniz.");
        System.out.print("Lütfen isim girin.");
        //String playerName=input.nextLine();
        Player player = new Player("natsu");
        System.out.println(player.getName() + " Hoş geldiniz.");
        System.out.println("Bir Karakter Seçin :");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("Bölgeler :");
            System.out.println("1 Güvenli ev");
            System.out.println("2 Mağaza");
            System.out.println("3 Mağara -->Ödül <Yemek> Zombi çıkabilir.");
            System.out.println("4 Orman  -->Ödül <Odun> Vampir çıkabilir");
            System.out.println("5 Nehir  -->Ödül <Su> Ayı çıkabilir");
            System.out.println("0 Çıkış yap > Oyunu sonlandır.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz :");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz.");
            }
            if (location==null){
                System.out.println("Oyun bitti. Yine bekleriz.");
                break;
            }

            System.out.println(location.getName());
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}
