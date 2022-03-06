package com.example.apartments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class LoginPageController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private  TextField password;

    @FXML
    private Button loginbtn;

    @FXML
    private ComboBox<String> comp;


    @FXML
    public void onButtonClicked(ActionEvent e) throws Exception{


        if(e.getSource().equals(loginbtn)) login();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // no thing
    }



    public void login(){

        String Username = username.getText();
        String Password = password.getText();
        String tybe = (String) comp.getValue();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        String sql = "SELECT * FROM login WHERE username = ? AND password = ? AND user_tybe = ? ";

        try{
            preparedStatement = DBUtil.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
            preparedStatement.setString(3, tybe);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                if (tybe.equals("admin")){

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                        Stage stage = (Stage) loginbtn.getScene().getWindow();
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                    }catch (IOException io){
                        io.printStackTrace();
                    }

                }else if (tybe.equals("user")){

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
                        Stage stage = (Stage) loginbtn.getScene().getWindow();
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                    }catch (IOException io){
                        io.printStackTrace();
                    }

                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }



}
