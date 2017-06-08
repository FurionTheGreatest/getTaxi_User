package user.view.MainWindow;


import connection.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller{

    ObservableList<String> taxiClass = FXCollections.observableArrayList("Звичайне таксі","Бізнес-Клас");   //встановлення елементів випадаючого списку
    //прив'язка розмітки в FXML таблиці до змінних
    @FXML
    private TextField name_text;
    @FXML
    private TextField number_text;
    @FXML
    private TextField street_text;
    @FXML
    private TextField housenumber_text;
    @FXML
    private TextField podezd_text;
    @FXML
    private TextArea comment;
    @FXML
    private Label msg;
    @FXML
    private ChoiceBox choiceBox;

    public static String NAME;
    public static String NUMBER;
    public static String STREET;
    public static String HOUSENUMBER;
    public static String PODEZD;
    public static String TAXI_CLASS;
    public static String COMMENT;
    @FXML
    public void initialize(){ //ініціалізація елементів випадного списку
        choiceBox.setItems(taxiClass);
        choiceBox.setValue("Виберіть варіант");
    }
    public void init() { //метод для відправки на сервер після натиснення кнопки ВІДПРАВИТИ

        NAME = (name_text.getText());
        NUMBER = (number_text.getText());
        STREET = (street_text.getText());
        HOUSENUMBER = (housenumber_text.getText());
        PODEZD = (podezd_text.getText());
        TAXI_CLASS = (choiceBox.getSelectionModel().getSelectedItem().toString());
        COMMENT = (comment.getText());
        if(NUMBER.isEmpty() || STREET.isEmpty() || HOUSENUMBER.isEmpty() || TAXI_CLASS.isEmpty()) {
            msg.setText("Ви не заповнили всі необхідні поля");
        }
        else {
            msg.setText("Зачекайте будь-ласка. Ми підберемо для вас водія");
            Connection connection = new Connection();
            connection.send(NAME, NUMBER, STREET, HOUSENUMBER, PODEZD, TAXI_CLASS, COMMENT);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Заявка");
            alert.setContentText("Ваша заявка знаходиться в черзі");
            alert.showAndWait();
        }
    }

}
