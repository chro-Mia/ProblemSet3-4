import processing.core.PApplet;

public class Ball {
    public float x, y, vX, vY;
    private final PApplet PARENT;
    private float diameter;
    private static int score = 0;

    public Ball(float x, float y, float vX, float vY, float diameter, PApplet parent){
        this.PARENT = parent;
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.diameter = diameter;
    }

    public void move(){
        x += vX;
        y += vY;
        if(x < diameter / 2f || x > PARENT.width - diameter / 2f){
            vX *= -1;
        }
        if(y < diameter / 2f || y > PARENT.height - diameter / 2f){
            vY *= -1;
        }
    }

    public void display(){
        PARENT.ellipse(x, y, diameter, diameter);
    }

    public void checkCollision(Paddle p){
        if(x >= p.x && x <= p.x + p.paddleWidth && y >= p.y && vY > 0){
            vY *= -1;
            score++;
        }
    }

    public int getScore(){
        return score;
    }

    public void checkGameOver(Paddle p){
        if(y >= p.y + p.paddleHeight){
            vX = 0;
            vY = 0;
            PARENT.text("GAME OVER", 250, 250);
        }
    }

}
