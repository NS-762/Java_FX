package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private TextArea chat;
    @FXML
    private TextArea entryField;

    public void btnClick(MouseEvent mouseEvent) { // отправка кнопкой
        if (!entryField.getText().isEmpty()) {
            String message = entryField.getText();
            chat.appendText("Вы: " + message + "\n");
            entryField.clear();
        }
    }

    public void enterPressed(KeyEvent event) { // отправка через enter
        if (event.getCode().equals(KeyCode.ENTER) && entryField.getText().isEmpty()) {
            event.consume(); // чтобы не делалася перенос при нажатии на enter
            // и не отправлялось пустое сообщение
        }
        if (event.getCode().equals(KeyCode.ENTER) && !entryField.getText().isEmpty()) {
            String message = entryField.getText();
            chat.appendText("Вы: " + message + "\n");
            entryField.clear();
            event.consume();
        }
    }
}
