module jogo.dados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens jogo.dados.controller to javafx.fxml;
    exports jogo.dados;
}
