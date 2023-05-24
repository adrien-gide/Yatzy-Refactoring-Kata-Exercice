import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void test_chance_score() {
        int expected = 15;
        Yatzy yatzy = new Yatzy(2,3,4,5,1);

        int actual = yatzy.chance();
        assertEquals(expected, actual);
    }

    @Test public void test_yatzy_50() {
        Yatzy yatzy = new Yatzy(4,4,4,4,4);
        assertEquals(50, yatzy.yatzy());
    }
    @Test public void test_yatzy_0() {
        Yatzy yatzy = new Yatzy(1,4,4,4,5);
        assertEquals(0, yatzy.yatzy());
    }

    @Test public void test_ones() {
        Yatzy yatzy = new Yatzy(1,4,4,4,5);

        assertEquals(1, yatzy.ones());

        yatzy.setDice(1,2,1,4,5);
        assertEquals(2, yatzy.ones());
    }

    @Test
    public void test_twos() {
        Yatzy yatzy = new Yatzy(1,2,3,2,6);
        assertEquals(4, yatzy.twos());

        yatzy.setDice(2,2,2,2,2);
        assertEquals(10, yatzy.twos());
    }

    @Test
    public void test_threes() {
        Yatzy yatzy = new Yatzy(1,2,3,2,3);
        assertEquals(6, yatzy.threes());

        yatzy.setDice(2,3,3,3,3);
        assertEquals(12, yatzy.threes());
    }

    @Test
    public void test_fours()
    {
        Yatzy yatzy = new Yatzy(4,4,4,5,5);
        assertEquals(12, yatzy.fours());

        yatzy.setDice(4,4,5,5,5);
        assertEquals(8, yatzy.fours());
    }

    @Test
    public void test_fives() {
        Yatzy yatzy = new Yatzy(4,4,4,5,5);
        assertEquals(10, yatzy.fives());

        yatzy.setDice(4,4,5,5,5);
        assertEquals(15, yatzy.fives());
    }

    @Test
    public void test_sixes() {
        Yatzy yatzy = new Yatzy(4,4,4,5,5);
        assertEquals(0, yatzy.sixes());

        yatzy.setDice(4,4,5,6,6);
        assertEquals(12, yatzy.sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
        assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
        assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
