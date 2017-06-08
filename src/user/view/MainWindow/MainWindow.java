package user.view.MainWindow;

import connection.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{                                 //Точка входу в програму
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));     //Відрисовка вікна
        primaryStage.setTitle("getTaxi");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
        Connection connection;          //встановлення з'єднання з сервером
        connection = new Connection();
        connection.connection();
    }


}
