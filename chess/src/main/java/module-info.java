module chess {
    requires javafx.fxml;
    requires javafx.controls;
    opens ru.job4j.chess to javafx.fxml;
    exports ru.job4j.chess;
    opens ru.job4j.chess.firuges to javafx.fxml;
    exports ru.job4j.chess.firuges;
}