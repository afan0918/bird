package afan.bird;

import java.util.Random;

import static afan.bird.Vector2d.subtract;

public class Bird {
    double learn_rate = 0.05;
    double max_speed = 2;
    double birdVision = 30;
    double alignmentFactor = 1;
    double cohesionFactor = 0.1;
    double seperationFactor = 1.5;
    double angle = 0;

    double width;
    double height;

    Vector2d position;
    Vector2d velocity;
    Vector2d acceleration;

    Bird(int width, int height) {
        this.width = width;
        this.height = height;

        Random rand = new Random();
        position = new Vector2d(rand.nextDouble(width), rand.nextDouble(height));
        velocity = new Vector2d(rand.nextDouble(-max_speed, max_speed), rand.nextDouble(-max_speed, max_speed));
        acceleration = new Vector2d(0, 0);
    }

    void update() {
        if (velocity.getLength() > max_speed) {
            velocity = velocity.getNormalized().getMultiplied(max_speed);
        }

        position.add(velocity);
        velocity.add(acceleration.getMultiplied(learn_rate));

        if (position.x < 0) position.x += width;
        else if (position.x > width) position.x -= width;
        if (position.y < 0) position.y += height;
        else if (position.y > height) position.y -= height;

        angle = velocity.getAngle();
    }

    Vector2d getForceToBird(Bird bird) {
        Vector2d vector = subtract(bird.position, this.position);
        if (vector.x > width / 2) vector.x -= width;
        else if (vector.x < -width / 2) vector.x += width;
        if (vector.y > height / 2) vector.y -= height;
        else if (vector.y < -height / 2) vector.y += height;
        return vector;
    }

    void getClusterForce(Bird[] birds) {
        Vector2d alignmentTotal = new Vector2d(0, 0);
        Vector2d cohesionTotal = new Vector2d(0, 0);
        Vector2d seperationTotal = new Vector2d(0, 0);
        int total = 0;

        for (Bird bird : birds) {
            if (bird == this) continue;

            Vector2d vector = this.getForceToBird(bird);
            double distance = vector.getLength();

            if (distance < birdVision) {
                ++total;
                alignmentTotal.add(bird.velocity);
                cohesionTotal.add(vector);

                double seperationScale = distance / birdVision;
                seperationTotal.subtract(vector.getDivided(distance * seperationScale));
            }
        }

        if (total > 0) {
            Vector2d force = new Vector2d(0, 0);

            force.add(alignmentTotal.getDivided(total / alignmentFactor));
            force.add(cohesionTotal.getDivided(total / cohesionFactor));
            force.add(seperationTotal.getMultiplied(seperationFactor));

            acceleration.add(force);
        } else {
            acceleration.setZero();
        }
    }

}