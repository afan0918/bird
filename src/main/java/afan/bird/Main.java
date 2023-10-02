package afan.bird;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {
    int width = 1000;
    int height = 600;
    float scale = 5f;

    PImage sharkImg;
    List<Bird> birds = new ArrayList<>();
    Shark shark = new Shark(width, height, (double) width / 2, (double) height / 2, 4);

    int money = 0;

    @Override
    public void settings() {
        size(width, height);
        sharkImg = loadImage("/Users/afan/Documents/code/idea/bird/src/main/java/afan/bird/img/shark-modified.png");
    }

    @Override
    public void keyPressed() {
        if (key == 'W' || key == 'w') {
            shark.move(new Vector2d(0, -1));
        } else if (key == 'S' || key == 's') {
            shark.move(new Vector2d(0, 1));
        } else if (key == 'D' || key == 'd') {
            shark.move(new Vector2d(1, 0));
        } else if (key == 'A' || key == 'a') {
            shark.move(new Vector2d(-1, 0));
        }
    }

    @Override
    public void start() {
        noStroke();
        frameRate(30);

        for (int i = 0; i < 100; i++) {
            birds.add(new Bird(width, height));
        }
    }

    @Override
    public void draw() {
        background(137, 207, 240);
        text(String.valueOf(money), width - 100, 50);

        for (Bird bird : birds) {
            bird.getClusterForce(birds, shark);
            bird.update();
        }

        for (int i = 0; i < birds.size(); i++) {
            float angle = (float) birds.get(i).angle;
            triangle((float) birds.get(i).position.x + 2 * cos(angle) * scale, (float) birds.get(i).position.y + 2 * sin(angle) * scale,
                    (float) birds.get(i).position.x - cos(angle + 20) * scale, (float) birds.get(i).position.y - sin(angle + 20) * scale,
                    (float) birds.get(i).position.x - cos(angle - 20) * scale, (float) birds.get(i).position.y - sin(angle - 20) * scale);

            if (birds.get(i).position.distance(shark.position) < 30) {
                birds.remove(i);
                money += 500;
                i -= 1;
            }
        }

        shark.update();
        float angle = (float) shark.velocity.getAngle();
        translate((float) shark.position.x, (float) shark.position.y);
        rotate(angle);
        int size = 100;
        image(sharkImg, -size / 2, -size / 2,
                size, size);
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"afan.bird.Main"};
        PApplet.main(appletArgs);
    }
}