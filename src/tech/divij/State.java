package tech.divij;

public abstract class State {
   protected String name;
   protected Character c;
   protected State otherState;

   public State(String name, Character c){
       this.name = name;
       this.c = c;
   }
     public String stateName(){
         return "State is "+this.name;
     }


   public State input(Character inputChar){
       if(inputChar == c){
           return this;
       }else if(inputChar == otherState.c){
           System.out.println("Switching state.");
           return otherState;

       }else{
           throw new RuntimeException("Invalid input.");
       }
  }
   public abstract void setOtherState(State otherState);
}
