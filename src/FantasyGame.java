import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FantasyGame {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Katerina");
        Player secondPlayer = new Player("Dimitris");
        List<Player> playerList = List.of(firstPlayer, secondPlayer);

        playerList.forEach(player ->
                System.out.println(player.getPlayerName() +
                        " Initial Player Stats : "
                        + player.playerStats())
        );
        RingOfHealth ringOfHealth = new RingOfHealth();
        FlimsyLeatherArmor flimsyLeatherArmor = new FlimsyLeatherArmor();
        RelicOfTheAncients relicOfAncients = new RelicOfTheAncients();
        WristbandOfMana wristbandOfMana = new WristbandOfMana();
        List<Item> listOfItems = List.of(ringOfHealth, flimsyLeatherArmor, relicOfAncients, wristbandOfMana);
        listOfItems.forEach(item -> {
            if(listOfItems.indexOf(item) % 2 != 0)
            firstPlayer.pickUp(item);
            else
            secondPlayer.pickUp(item);});
        for (Player player : playerList) {
            for (Item elem : player.getInventory()) {
                if (elem instanceof Equippable) {
                    Slot slot = null;
                    for (Slot x : player.getPlayerSlotList()) {
                        if (x.getSlotType() == ((Equippable) elem).getSlotType()) {
                            slot = x;
                            break;
                        }
                    }
                    if (slot != null) {
                        slot.equip(elem);
                    }
                }
            }
        }


        playerList.forEach(player -> {
            System.out.println(player.getPlayerName() + " Stats After Equip " + player.playerStats());
            player.printInventory();
            System.out.println(player.getPlayerName() + " Starting Level " + player.getLevel(player.getExperiencePoints())+". Initial Stats are:"+player.playerStats());
            while (player.getLevel(player.getExperiencePoints()) < 5) {
                int experiencePoints = ThreadLocalRandom.current().nextInt(200, 1000 + 1);
                System.out.println(player.getPlayerName() + " Gained " + experiencePoints + " XP");
                player.addXP(experiencePoints);
                System.out.println(player.getPlayerName() + " is now level "
                        + player.getLevel(player.getExperiencePoints()) + ". Her/His/Them stats are :" + player.playerStats());

            }
        });
    }
}
