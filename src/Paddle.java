import processing.core.PApplet;

public class Paddle {
    public float x, y;
    final float paddleHeight, paddleWidth, percentDistancePerFrame;
    private final PApplet PARENT;

    public Paddle(PApplet parent){
        PARENT = parent;
        x = PARENT.width / 2f;
        y = PARENT.height - (PARENT.height * 0.1f);
        paddleHeight = PARENT.height * 0.02f;
        paddleWidth = PARENT.width * 0.1f;
        percentDistancePerFrame = 0.01f;
    }

    public Paddle(float paddleWidth, float paddleHeight, float percentDistancePerFrame, PApplet parent){
        PARENT = parent;
        x = PARENT.width / 2f;
        y = PARENT.height - (PARENT.height * 0.1f);
        this.paddleHeight = paddleHeight;
        this.paddleWidth = paddleWidth;
        this.percentDistancePerFrame = percentDistancePerFrame;
    }

    public void display(){
        PARENT.rect(x, y, paddleWidth, paddleHeight);
    }

    public void move(){
        if(PARENT.key == 'a' && PARENT.keyPressed && x >= 0){
            x -= PARENT.width * percentDistancePerFrame;
        }
        if(PARENT.key == 'd' && PARENT.keyPressed && x <= PARENT.width - paddleWidth){
            x += PARENT.width * percentDistancePerFrame;
        }
    }

    public float getX(){
        return x + paddleWidth / 2f;
    }

    public float getY(){
        return y;
    }

    public float getWidth(){
        return paddleWidth;
    }
}
