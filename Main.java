package sample;

import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args)
    {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        VBox rootNode= loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene =new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        //file menu
        Menu fileMenu=new Menu("file");
        MenuItem newMenuItem= new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu item click"));



        SeparatorMenuItem  separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem= new MenuItem("Quit");
             quitMenuItem.setOnAction(event -> {
               Platform.exit();
               System.exit(0);
                     });

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

         //help menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");
             aboutApp.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                    public void handle(ActionEvent event) {
                     aboutapp();
                      }

                     private void aboutapp() {
                         Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
                         alertDialog.setTitle("About app");
                         alertDialog.setHeaderText("Temperature Converter");
                         alertDialog.setContentText("this aplication is used to change the temperature");
                         alertDialog.show();
                 }
        });
        helpMenu.getItems().addAll(aboutApp);

        // menu bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
