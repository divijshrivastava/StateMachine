package tech.divij;

import java.util.stream.IntStream;

public class StateManagement {

    private static State currentState;

    public static void main(String[] args) {

        char[] inputs = new char[]{'a', 'b', 'b', 'a', 'a', 'b'};
        State a = new AState();
        State b = new BState();
        a.setOtherState(b);
        b.setOtherState(a);
        currentState = a;

        IntStream.range(0, inputs.length).mapToObj(i -> inputs[i] ).forEach( i -> {
            System.out.println("Input is "+i);
            currentState = currentState.input(i);
           System.out.println(currentState.stateName());
        });
    }
}
