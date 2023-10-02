package afan.bird;

import static afan.bird.Vector2d.subtract;

public class Shark {
    Vector2d position = new Vector2d();
    Vector2d velocity = new Vector2d();
    Vector2d acceleration = new Vector2d();
    double max_speed;

    double width;
    double height;

    Shark() {
        max_speed = 5;
    }

    Shark(double width, double height,
          double x, double y, double max_speed) {
        position.x = x;
        position.y = y;
        this.width = width;
        this.height = height;
        this.max_speed = max_speed;
    }

    Vector2d getPosition() {
        Vector2d vector = position;
        if (vector.x > width) vector.x -= width;
        else if (vector.x < 0) vector.x += width;
        if (vector.y > height) vector.y -= height;
        else if (vector.y < 0) vector.y += height;
        return vector;
    }

    void move(Vector2d direction) {
        acceleration.add(direction);
        if (acceleration.getLength() > max_speed) {
            acceleration = acceleration.getNormalized().getMultiplied(max_speed);
        }
    }

    void update() {
        velocity.add(acceleration.getMultiplied(0.5));
        if (velocity.getLength() > max_speed) {
            velocity = velocity.getNormalized().getMultiplied(max_speed);
        }

        position.add(velocity);
        position = getPosition();
    }
}
