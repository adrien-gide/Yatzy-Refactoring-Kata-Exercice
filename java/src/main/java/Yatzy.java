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
        return this.count_frequency(value) * value;
    }

    /**
     * Private couting occurencies of specific die value
     * @param value die value
     * @return occurences
     */
    private int count_frequency(int value) {
        return Collections.frequency(dice, value);
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

    private int calculate_matching_dices(int occurences) {
        for(int i = 6; i > 0; i--) {
            if (this.count_frequency(i) == 2) {
                return i * occurences;
            }
        }
        return 0;
    }

    public int single_pair()
    {
        return this.calculate_matching_dices(2);
    }

    public int two_pair()
    {

        for(int i = 6; i > 0; i--) {
            if (this.count_frequency(i) == 2) {
                return i * occurences;
            }
        }
        return 0;
    }

    public  int three_of_a_kind()
    {
        return this.calculate_matching_dices(3);
    }

    public  int four_of_a_kind()
    {
        return this.calculate_matching_dices(4);
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

    public int fullHouse()
    {
        int pair = this.calculate_matching_dices(2);
        int three_of_kind = this.calculate_matching_dices(3);

        if (pair == 0 || three_of_kind == 0)
            return 0;
        // check if all dice aren't a match
        if (this.yatzy() == 50)
            return 0;
        else return pair + three_of_kind;
    }
}



