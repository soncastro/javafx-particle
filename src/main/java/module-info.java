module dev.soncastro.javafxparticle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    
    opens dev.soncastro.javafxparticle to javafx.fxml;
    exports dev.soncastro.javafxparticle;
}