import java.util.*;

public class Tournament {
    private List<Team> teams;
    private List<List<Team>> groups;
    private Scanner sc;

    public Tournament(List<Team> teams) { // checks if there are 16 teams exactly, like said below lol
        if (teams.size() != 16) {
            throw new IllegalArgumentException("Tournament needs exactly 16 teams");
        }

        this.teams = new ArrayList<>(teams);
        this.groups = new ArrayList<>();
    }

    public void shuffleTeams() { // randomizes teams for group stage
        Collections.shuffle(teams);
    }

    public void createGroups() { // creates 4 groups of 4 random teams
        for (int i = 0; i < 4; i++) {
            groups.add(new ArrayList<>());
        }

        for (int i = 0; i < teams.size(); i++) {
            groups.get(i % 4).add(teams.get(i));
        }
    }

    public void groupStage() { // group stage to qualify to main stage 
        for (int i = 0; i < groups.size(); i++) {
            List<Team> group = groups.get(i);
            System.out.println("Group " + (i + 1) + " matches: ");

            for (int j = 0; j < group.size(); j++) {
                for (int k = j + 1; k < group.size(); k++) {
                    Match match = new Match(group.get(j), group.get(k), 2);
                    Team winner = match.playMatch();
                    winner.addWins(1);

                    if (!askToContinue()) { // user input to continue 
                        return;
                    }
                }
            }
        }
    }

    public void mainStage() { // main stage to determine winner
        List<Team> upperBracket = new ArrayList<>();
        List<Team> lowerBracket = new ArrayList<>();

        for (List<Team> group : groups) { // adds teams to upper or lower depending on their wins
            group.sort((t1, t2) -> t2.getWins() - t1.getWins());
            upperBracket.add(group.get(0));
            lowerBracket.add(group.get(1));
        }

        System.out.println("Main stage matches: ");

        while (upperBracket.size() > 1) { // plays upper bracket
            List<Team> nextRound = new ArrayList<>();
            for (int i = 0; i < upperBracket.size(); i += 2) {
                Match match = new Match(upperBracket.get(i), upperBracket.get(i + 1), 2);
                Team winner = match.playMatch();
                nextRound.add(winner);

                if (!askToContinue()) {
                    return;
                }
            }
            upperBracket = nextRound;
        }

        while (lowerBracket.size() > 1) { // plays lower bracket
            List<Team> nextRound = new ArrayList<>();
            for (int i = 0; i < lowerBracket.size(); i += 2) {
                Match match = new Match(lowerBracket.get(i), lowerBracket.get(i + 1), 2);
                Team winner = match.playMatch();
                nextRound.add(winner);

                if (!askToContinue()) {
                    return;
                }
            }
            lowerBracket = nextRound;
        }

        System.out.println("GRAND FINALS: \n");

        Match finalMatch = new Match(upperBracket.get(0), lowerBracket.get(0), 3); // final bo5 match
        Team winner = finalMatch.playMatch();
        System.out.println("The winner of the tournament is: " + winner.getName());
    }

    private boolean askToContinue() { // user input function to continue
        System.out.println("Do you want to continue to the next match? (Y/N): ");
        String input = sc.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    public void startTournament() { // starts tourney and initializes scanner
        this.sc = new Scanner(System.in);
        shuffleTeams();
        createGroups();
        groupStage();
        mainStage();
    }
}
