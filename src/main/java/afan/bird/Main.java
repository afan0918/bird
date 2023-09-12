package afan.bird;

import processing.core.PApplet;

public class Main extends PApplet {
    int width = 1000;
    int height = 800;
    Bird[] birds = new Bird[100];

    @Override
    public void settings() {
        size(width, height);
    }

    @Override
    public void start() {
        noStroke();
        frameRate(20);

        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(width, height);
        }
    }

    @Override
    public void draw() {
        background(0);

        for (Bird bird : birds) {
            bird.getClusterForce(birds);
            bird.update();
        }

        for (Bird bird : birds) {
            circle((float) bird.position.x, (float) bird.position.y, 10);
        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"afan.bird.Main"};
        PApplet.main(appletArgs);
    }
}