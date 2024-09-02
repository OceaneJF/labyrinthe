package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import vue2D.javafx.Vue;


/**
 * JavaFX MainJavaFX
 */
public class MainJavaFX extends Application {
    private Core core;

    @Override
    public void start(Stage stage) {
        core = new Core();
        core.initLabyrinthe(); // initialisation du labyrinthe
        Vue vue = new vue2D.javafx.Vue(core.labyrinthe); // creation de la vue
        core.initSprites(vue); // creation des sprites dans la vue
        System.out.println("test");
        stage.setScene(vue.scene);
        stage.setTitle("Labyrinthe : " +  System.getProperty("user.name"));
        stage.show();
        
        //rafraichissement de la vue
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                vue.dessiner();
            }
        };
        timer.start();
        
        // boucle principale
        Task<Void> task = new Task<Void>() {
            @Override public Void call() {
                 core.jeu(vue); // go !
                 System.out.println("fin du jeu ...");
                 return null;
            }
        };
        
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
       
    }

    public static void main(String[] args) {
        launch();
    }

}