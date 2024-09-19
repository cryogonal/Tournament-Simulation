import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Sentinels", 0.52)); // these are all the teams that qualified to Valorant Champions 2024, but
        teams.add(new Team("Gen.G", 0.55));     // can be changed to anything
        teams.add(new Team("FunPlus Phoenix", 0.51));
        teams.add(new Team("Team Heretics", 0.55));
        teams.add(new Team("FNATIC", 0.53));
        teams.add(new Team("Paper Rex", 0.51));
        teams.add(new Team("Talon Esports", 0.45));
        teams.add(new Team("DRX", 0.52));
        teams.add(new Team("G2 Esports", 0.51));
        teams.add(new Team("FUT Esports", 0.48));
        teams.add(new Team("Team Vitality", 0.49));
        teams.add(new Team("KRU Esports", 0.47));
        teams.add(new Team("LEVIATAN", 0.50));
        teams.add(new Team("Bilibili Gaming", 0.47));
        teams.add(new Team("Trace Esports", 0.48));
        teams.add(new Team("EDward Gaming", 0.51));
        
        Tournament tournament = new Tournament(teams);
        tournament.startTournament();
    }
}
