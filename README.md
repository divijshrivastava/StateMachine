<h1>StateMachine</h1>
<p>Welcome to StateMachine, a simple deterministic finite state machine implementation in Java.</p>
<h2>Description</h2>
<p>The StateMachine project provides an implementation of two states: <code>AState</code> and <code>BState</code>. The state machine can handle inputs 'a' and 'b' to transition between these states. The behavior of the state machine is as follows:</p>
<ul>
   <li>
      <p>When the input 'a' is received:</p>
      <ul>
         <li><code>AState</code> remains in the same state.</li>
         <li><code>BState</code> transitions to <code>AState</code>.</li>
      </ul>
   </li>
   <li>
      <p>When the input 'b' is received:</p>
      <ul>
         <li><code>AState</code> transitions to <code>BState</code>.</li>
         <li><code>BState</code> remains in the same state.</li>
      </ul>
   </li>
</ul>
<h2>Code Samples</h2>
<p>Here are the code snippets for the classes involved in the StateMachine project:</p>
<h3>AState.java</h3>

```java

package tech.divij;

public class AState extends State {

    public AState() {
        super("A", 'a');
    }

    @Override
    public void setOtherState(State otherState) {
        this.otherState = otherState;
    }
}

```

<h3>BState.java</h3>

```java
package tech.divij;

public class BState extends State {

    public BState() {
        super("B", 'b');
    }

    @Override
    public void setOtherState(State otherState) {
        this.otherState = otherState;
    }
}

```

<h3>State.java</h3>

```java

package tech.divij;

public abstract class State {
    protected String name;
    protected Character c;
    protected State otherState;

    public State(String name, Character c) {
        this.name = name;
        this.c = c;
    }

    public String stateName() {
        return "State is " + this.name;
    }

    public State input(Character inputChar) {
        if (inputChar == c) {
            return this;
        } else if (inputChar == otherState.c) {
            System.out.println("Switching state.");
            return otherState;
        } else {
            throw new RuntimeException("Invalid input.");
        }
    }

    public abstract void setOtherState(State otherState);
}

```

<h3>StateManagement.java</h3>

```java

package tech.divij;

import java.util.stream.IntStream;

public class StateManagement {

    private static State currentState;

    public static void main(String[] args) {
        char[] inputs = new char[]{'b', 'b', 'a', 'b', 'a', 'b'};
        State a = new AState();
        State b = new BState();
        a.setOtherState(b);
        b.setOtherState(a);
        currentState = a;

        IntStream.range(0, inputs.length).mapToObj(i -> inputs[i]).forEach(i -> {
            currentState = currentState.input(i);
            System.out.println(currentState.stateName());
        });
    }
}

```

<h2>Getting Started</h2>
<p>To run the StateMachine project locally, follow these steps:</p>
<ol>
   <li>
      <p>Clone this repository to your local machine using the following command:</p>
      <pre><div class="bg-black rounded-md mb-4"><div class="p-4 overflow-y-auto"><code class="!whitespace-pre hljs language-bash">git <span class="hljs-built_in">clone</span> https://github.com/divijshrivastava/state-machine.git
</code></div></div></pre>
   </li>
   <li>
      <p>Open the project in your preferred Java IDE.</p>
   </li>
   <li>
      <p>Navigate to the <code>tech.divij</code> package.</p>
   </li>
   <li>
      <p>Review the implementations of <code>AState.java</code>, <code>BState.java</code>, <code>State.java</code>, and <code>StateManagement.java</code>.</p>
   </li>
   <li>
      <p>Run the <code>StateManagement.java</code> file, which contains the <code>main</code> method.</p>
      <p>You should see the output of state transitions printed on the console based on the provided inputs.</p>
   </li>
</ol>
<p>Feel free to explore and modify the StateMachine implementation</p>
</div>
