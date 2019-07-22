import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {

    @Test
    public void probabilityCheck_shouldBeTrue_whenPassedTwoIndependentProbabilities() {
        Probability probability1 = new Probability(.5);
        Probability probability2 = new Probability(.5);

        assertEquals(probability1, probability2);
    }

    @Test
    public void compare_shouldBePositive1_whenFirstProbabilityGreaterThanSecond() {
        Probability probability1 = new Probability(.6);
        Probability probability2 = new Probability(.5);

        int result = probability1.compare(probability2);

        assertEquals(1, result);
    }

    @Test
    public void compare_shouldBeNegative1_whenFirstProbabilityLesserThanSecond() {
        Probability probability1 = new Probability(.4);
        Probability probability2 = new Probability(.5);

        int result = probability1.compare(probability2);

        assertEquals(-1, result);
    }

    @Test
    public void compare_shouldBe0_whenPassedTwoEqualProbablities() {
        Probability probability1 = new Probability(.5);
        Probability probability2 = new Probability(.5);

        int result = probability1.compare(probability2);

        assertEquals(0, result);
    }

    @Test
    public void and_shouldBePoint25_whenProbabilitiesArePoint5() {
        Probability probability1 = new Probability(.5);
        Probability probability2 = new Probability(.5);
        Probability expectedProbability = new Probability(.25);

        Probability combinedProbability = probability1.and(probability2);

        assertEquals(expectedProbability, combinedProbability);

    }

    @Test
    public void not_ShouldBePoint6_whenProbabilityIsPoint4() {
        Probability probability1 = new Probability(.4);
        Probability expectedProbability = new Probability(.6);

        Probability result = probability1.not();

        assertEquals(expectedProbability, result);
    }

    @Test
    public void or_shouldBePoint76_WhenProbabilitiesArePoint6AndPoint4() {
        Probability probability1 = new Probability(.6);
        Probability probability2 = new Probability(.4);
        Probability expectedProbability = new Probability(.76);

        Probability result = probability1.or(probability2);

        assertEquals(expectedProbability, result);
    }

}