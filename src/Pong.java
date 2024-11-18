import processing.core.PApplet;

public class Pong extends PApplet{

    private Ball ball;
    private Paddle paddle;

    public static void main(String[] args)
    {
        PApplet.main(new String[]{"Pong"});
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        background(0, 0 ,0);
        ball = new Ball(this.width * .2f, this.height * 0.3f, 3, 6, 10, this);
        paddle = new Paddle(this);
    }

    public void draw()
    {
        background(0, 0, 0);

        ball.move();
        paddle.move();

        ball.checkGameOver(paddle);
        ball.checkCollision(paddle);

        text(ball.getScore(), 0, 10);
        paddle.display();
        ball.display();
    }
}