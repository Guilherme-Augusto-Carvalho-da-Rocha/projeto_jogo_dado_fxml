module jogo.dados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires com.jfoenix;

    opens jogo.dados.controller to javafx.fxml;

    exports jogo.dados;
}
