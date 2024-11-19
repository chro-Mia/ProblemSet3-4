import processing.core.PApplet;

public class Pong extends PApplet{

    private Ball ball;
    private Ball ball2;
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
        ball = new Ball(this.width * .2f,
                this.height * 0.3f,
                this.width * 0.006f,
                this.height * 0.012f,
                10,
                this);

        ball2 = new Ball(this.width * .9f,
                this.height * 0.3f,
                this.width * 0.001f,
                this.height * 0.001f,
                10,
                this);
        paddle = new Paddle(this);
    }

    public void draw()
    {
        background(0, 0, 0);

        ball.move();
        ball2.move();
        paddle.move();

        ball.checkGameOver(paddle);
        ball2.checkGameOver(paddle);
        ball.checkCollision(paddle);
        ball2.checkCollision(paddle);

        text(ball.getScore(), 0, 10);
        ball.display();
        ball2.display();
        paddle.display();
    }
}