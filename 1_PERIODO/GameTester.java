public class GameTester {
    public static void main(String[] args) {
        Werewolf wolf = new Werewolf("Jacob", 0, null, false);
        Hero boy = new Hero("Chris", 0);
        Superhero man = new Superhero("Clark", 0);

        wolf.attack(man);
        man.attack(boy);

        man.attack(wolf);
        
        System.out.println(wolf.getStress()); 
        System.out.println(man.getStress()); 
        System.out.println(man.toString()); 
        System.out.println(wolf.toString());
    }
}
