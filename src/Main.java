import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Sentinels")); // these are all the teams that qualified to Valorant Champions 2024, but
        teams.add(new Team("Gen.G"));     // can be changed to anything
        teams.add(new Team("FunPlus Phoenix"));
        teams.add(new Team("Team Heretics"));
        teams.add(new Team("FNATIC"));
        teams.add(new Team("Paper Rex"));
        teams.add(new Team("Talon Esports"));
        teams.add(new Team("DRX"));
        teams.add(new Team("G2 Esports"));
        teams.add(new Team("FUT Esports"));
        teams.add(new Team("Team Vitality"));
        teams.add(new Team("KRU Esports"));
        teams.add(new Team("LEVIATAN"));
        teams.add(new Team("Bilibili Gaming"));
        teams.add(new Team("Trace Esports"));
        teams.add(new Team("EDward Gaming"));
        
        Tournament tournament = new Tournament(teams);
        tournament.startTournament();
    }
}
