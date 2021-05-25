package tech.divij;

public class AState extends State{

    public AState() {
        super("A", 'a');
    }

    @Override
    public void setOtherState(State otherState) {
        this.otherState = otherState;
    }
}
