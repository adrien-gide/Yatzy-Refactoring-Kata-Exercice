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
        Yatzy yatzy = new Yatzy(3,4,3,5,6);
        assertEquals(6, yatzy.single_pair());

        yatzy.setDice(5,3,3,3,5);
        assertEquals(10, yatzy.single_pair());
    }

    @Test
    public void two_Pair() {
        Yatzy yatzy = new Yatzy(3,3,5,4,5);
        assertEquals(16, yatzy.two_pairs());

        yatzy.setDice(3,3,5,5,5);
        assertEquals(16, yatzy.two_pairs());
    }

    @Test
    public void test_three_of_a_kind()
    {
        Yatzy yatzy = new Yatzy(3,3,3,4,5);
        assertEquals(9, yatzy.three_of_a_kind());

        yatzy.setDice(5,3,5,4,5);
        assertEquals(15, yatzy.three_of_a_kind());
    }

    @Test
    public void test_four_of_a_knd() {
        Yatzy yatzy = new Yatzy(3,3,3,3,5);
        assertEquals(12, yatzy.four_of_a_kind());

        yatzy.setDice(5,5,5,4,5);
        assertEquals(20, yatzy.four_of_a_kind());
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
        Yatzy yatzy = new Yatzy(6,2,2,2,6);
        assertEquals(18, yatzy.fullHouse());

        yatzy.setDice(2,3,4,5,6);
        assertEquals(0, yatzy.fullHouse());
    }
}
