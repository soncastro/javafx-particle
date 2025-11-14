package dev.soncastro.javafxparticle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExplosionApp extends Application {

    private List<Explosao> explosoes = new LinkedList<>();

    @Override
    public void start(Stage stage) throws IOException {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scene scene = new Scene(new StackPane(canvas));

        scene.setOnMouseClicked(e -> {
            explosoes.add(new Explosao(e.getX(), e.getY()));
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render(gc);
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Explosão");
        stage.show();
    }

    private void update() {
        this.explosoes.forEach(Explosao::update);
        this.explosoes.removeIf(Explosao::isFinished);
    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 600);
        for (Explosao exp : this.explosoes) {
            exp.render(gc);
        }
    }
}
