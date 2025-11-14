package dev.soncastro.javafxparticle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.List;

public class Explosao extends GameObject {

    private List<Particle> todasParticulas = new ArrayList<>();

    private boolean finished = false;

    private AudioClip soundExplosion = new AudioClip(getClass().getResource("/explosion.wav").toExternalForm());

    private boolean firstUpdate = true;

    public Explosao(double x, double y) {
        super(x, y);
        for (int i = 0; i < 100; i++) {
            this.todasParticulas.add(new Particle(x, y));
        }
    }

    public boolean isFinished() {
        return this.finished;
    }

    @Override
    public void update() {
        if (this.firstUpdate) {
            this.soundExplosion.play();
            this.firstUpdate = false;
        }
        boolean isFinishedAll = true;
        for (Particle p : this.todasParticulas) {
            p.update();
            if (!p.isFinished()) {
                isFinishedAll = false;
            }
        }
        this.finished = isFinishedAll;
    }

    @Override
    public void render(GraphicsContext gc) {
        for (Particle p : this.todasParticulas) {
            p.render(gc);
        }
    }

}
