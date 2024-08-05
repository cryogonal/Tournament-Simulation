import java.util.Random;
public class Match {
    private Team team1;
    private Team team2;
    private int mapsToWin;

    public Match(Team team1, Team team2, int mapsToWin) { // initializes teams in the present match
        this.team1 = team1;
        this.team2 = team2;
        this.mapsToWin = mapsToWin;
    }

    public Team bestOfThree() {
        int team1Maps = 0;
        int team2Maps = 0;
        Random random = new Random();

        while (team1Maps < mapsToWin && team2Maps < mapsToWin) { // if both teams have not yet reached map wins
            int team1Rounds = 0;
            int team2Rounds = 0;

            while (true) {
                if (random.nextBoolean()) { // random gives team1 or team2 wins
                    team1Rounds++;
                    System.out.println(team1.getName() + " won the round. Total rounds: " + team1Rounds);
                }

                else {
                    team2Rounds++;
                    System.out.println(team2.getName() + " won the round. Total rounds: " + team2Rounds);
                }

                try { // timer between each round win
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted, failed to complete operation.");
                }

                if (team1Rounds >= 13 || team2Rounds >= 13) { // win by 2 requirement
                    if (Math.abs(team1Rounds - team2Rounds) >= 2) {
                        break;
                    }
                }
            }

            if (team1Rounds > team2Rounds) {
                team1Maps++;
                System.out.println(team1.getName() + " won the map. \n" + team1.getName() + " rounds: " + team1Rounds + "\n" +
                                    team2.getName() + " rounds: " + team2Rounds + "\n" +
                                    team1.getName() + " maps: " + team1Maps + "\n" +
                                    team2.getName() + " maps: " + team2Maps);
            }
            else {
                team2Maps++;
                System.out.println(team2.getName() + " won the map. \n" + team1.getName() + " rounds: " + team1Rounds + "\n" +
                                    team2.getName() + " rounds: " + team2Rounds + "\n" +
                                    team1.getName() + " maps: " + team1Maps + "\n" +
                                    team2.getName() + " maps: " + team2Maps);
            }
        }
        
        if (team1Maps == mapsToWin) {
            System.out.println(team1.getName() + " wins the game " + team1Maps + " to " + team2Maps + ".");
            return team1;
        }
        else {
            System.out.println(team2.getName() + " wins the game " + team2Maps + " to " + team1Maps + ".");
            return team2;
        }
    }

    public Team playMatch() {
        return bestOfThree();
    }
}
