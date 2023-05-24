import java.util.*;

public class Yatzy {
    protected List<Integer> dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5){
        dice = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5));
    }
    public Yatzy(List<Integer> dice){
        this.dice = dice;
    }

    // Setters
    public void setDice(List<Integer> dice) {
        this.dice = dice;
    }

    public void setDice(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5));;
    }

    /**
     * @return sum of all dice
     */
    public int chance()
    {
        return this.dice.stream().reduce(0, Integer::sum);
    }

    /**
     * Checks if all dice are equal and return yatzy score
     *
     * @return 50 if it's a yatzy, else 0
     */
    public int yatzy()
    {
        // Transforming List into a set to ensure all list elements are equal
        // If set size is not 1, it's not a yatzy
        return new HashSet<>(this.dice).size() == 1 ? 50 : 0;
    }


    /**
     * Private method calculating score for occurencies of specific die value
     * @param value die value
     * @return score (occurences * value)
     */
    private int sum_of_specific_value(int value) {
        return Collections.frequency(dice, value) * value;
    }

    public int ones() {
        return this.sum_of_specific_value(1);
    }

    public int twos() {
        return this.sum_of_specific_value(2);
    }

    public int threes() {
        return this.sum_of_specific_value(3);
    }

    public int fours(){
        return this.sum_of_specific_value(4);
    }

    public int fives(){
        return this.sum_of_specific_value(5);
    }

    public int sixes(){
        return this.sum_of_specific_value(6);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



