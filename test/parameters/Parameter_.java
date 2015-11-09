package parameters;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class Parameter_ {

    @Test
    public void testName() throws Exception {
        Parameter parameter = new Parameter();
        parameter.add(5).to("player1");
        parameter.add(8).to("player2");
        parameter.add(2).to("player1");
        assertThat(parameter.get("player1"), is(7));
        assertThat(parameter.get("player2"), is(8));
    }

    @Test
    public void when_inserting_1MRolls_should_register_in_less_than_one_second() throws Exception {
        long start = System.nanoTime();
        Parameter parameter = new Parameter();
        for (int i = 0; i < 1e7; i++) {
            parameter.add(1).to("player1");
            //parameter.add(1, "player1");
        }
        long finish = System.nanoTime();
        assertThat("Inserting 10MRolls in less than one second",(double)finish-start,is(lessThan(1e9)));
    }
}
