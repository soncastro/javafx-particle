package dev.soncastro.javafxparticle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Particle extends GameObject {

    private double dx;
    private double dy;
    private double life = 1.0;

    public Particle(double x, double y) {
        super(x, y);
        dx = Math.random() * 4 - 2;
        dy = Math.random() * 4 - 2;
    }

    public boolean isFinished() {
        return this.life <= 0;
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
        life -= 0.02;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.ORANGE);
        gc.fillOval(x, y, life * 10, life * 10);
    }

}
