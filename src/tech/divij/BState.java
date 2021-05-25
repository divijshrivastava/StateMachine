package tech.divij;

public class BState extends State{


    public BState() {
        super("B", 'b');
    }

    @Override
    public void setOtherState(State otherState) {
        this.otherState = otherState;
    }
}
