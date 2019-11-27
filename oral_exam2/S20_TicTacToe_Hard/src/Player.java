public class Player extends Board{
    public Player(){
    }

    public void start(){
        while(!isFull())
        player1.play();
        player2.play();
    }

    private boolean isFull(){
        for(int i = 0; i < Buttons.size(); i++){
            if(Buttons.get(i).getText().contains("")){
                return false;
            }
        }
        return true;
    }
}
