package afan.bird;

import processing.core.PApplet;

public class Main extends PApplet {
    int width = 1000;
    int height = 800;
    float scale = 5f;
    Bird[] birds = new Bird[100];

    @Override
    public void settings() {
        size(width, height);
    }

    @Override
    public void start() {
        noStroke();
        frameRate(30);

        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(width, height);
        }
    }

    @Override
    public void draw() {
        background(255);

        for (Bird bird : birds) {
            bird.getClusterForce(birds);
            bird.update();
        }

        for (Bird bird : birds) {
            float angle = (float) bird.angle;
            triangle((float) bird.position.x + 2 * cos(angle) * scale, (float) bird.position.y + 2 * sin(angle) * scale,
                    (float) bird.position.x - cos(angle + 20) * scale, (float) bird.position.y - sin(angle + 20) * scale,
                    (float) bird.position.x - cos(angle - 20) * scale, (float) bird.position.y - sin(angle - 20) * scale);
        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"afan.bird.Main"};
        PApplet.main(appletArgs);
    }
}