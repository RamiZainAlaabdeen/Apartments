package com.example.apartments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {



    @FXML
    private TextField txtId1;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtPrice;

    @FXML
    private ComboBox<String> comp;

    @FXML
    private Button btnAddApartment;

    @FXML
    private Button btnUpdateApartment1;

    @FXML
    private Button btnDeleteApartment11;





    @FXML
    private TableView<Apartments> tableView;

    @FXML
    private TableColumn<Apartments, Integer> idCol;
    @FXML
    private TableColumn<Apartments, String> AddressCol;
    @FXML
    private TableColumn<Apartments, Double> PricelCol;
    @FXML
    private TableColumn<Apartments, String> StatusCol;



    @FXML
    private TextField txtid2;

    @FXML
    private TextField txtApartmentAdress;

    @FXML
    private TextField txtApartmentPrice;

    @FXML
    private TextField txtid21;


    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private ComboBox<String> comp2;


    @FXML
    private Button btnAcept;

    @FXML
    private Button btnUbdate1;

    @FXML
    private Button btndelete1;





    @FXML
    private TextField txtid22;

    @FXML
    private TextField txtDeposit;


    @FXML
    private TextField txtRemining;


    @FXML
    private Button aceptPayment;

    @FXML
    private Button clearPayment;



    @FXML
    private TableView<Customers> tableView2;

    @FXML
    private TableColumn<Customers, Integer> idCol1;

    @FXML
    private TableColumn<Customers, String> first_namecol;
    @FXML
    private TableColumn<Customers, String> last_namecol;
    @FXML
    private TableColumn<Customers, Integer> idCol11;
    @FXML
    private TableColumn<Customers, String> AddressCol1;
    @FXML
    private TableColumn<Customers, Double> PricelCol1;

    @FXML
    private TableColumn<Customers, String> StatusCol1;

    @FXML
    private TableColumn<Customers, Double> Depositcol;
    @FXML
    private TableColumn<Customers, Double> Reminingcol;


    @FXML
    private TextArea txtReport;

    @FXML
    private Label lblRented;

    @FXML
    private Label lblnotRented;



    @FXML
    public void onButtonClicked(ActionEvent e) throws Exception {

        if (e.getSource().equals(btnAddApartment)) {


            insertRecord();
            System.out.println("hello");

//            Employee_Id.clear();
//            Employee_Name.clear();
//            Email.clear();
//            Salary.clear();
//            Bounus.clear();
        }else if (e.getSource().equals(btnUpdateApartment1)){

            updateRecord();
//
//            Employee_Id.clear();
//            Employee_Name.clear();
//            Email.clear();
//            Salary.clear();
//            Bounus.clear();

        }else if (e.getSource().equals(btnDeleteApartment11)){


            deleteRecord();


        }else if (e.getSource().equals(btnAcept)){


            insertCustomer();

        }

        else if (e.getSource().equals(btnUbdate1)){


            updateCustomer();


        }else if (e.getSource().equals(btndelete1)){

            deleteCustomer();


        }else if (e.getSource().equals(aceptPayment)){

            AddPayment();

            showCustomersReport();


        }else if (e.getSource().equals(clearPayment)){

             txtid22.clear();

             txtDeposit.clear();

             txtRemining.clear();

             txtReport.clear();


        }






    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showApartments();
        showCustomers();
        showCustomersStatusRented();
        showCustomersStatusNotRented();
    }



    public ObservableList<Apartments> getApartmentsList(){

        ObservableList<Apartments> apartmentsList= FXCollections.observableArrayList();
        Connection conn= DBUtil.getConnection();
        String query= "SELECT * FROM Apartments";
        Statement st=null;
        ResultSet rs= null;

        try {
            st= conn.createStatement();
            rs= st.executeQuery(query);
            Apartments apartments;
            while (rs.next()){

                apartments= new Apartments(rs.getInt("Apartment_id"),rs.getString("address")
                        ,rs.getDouble("price"),
                        rs.getString("status"));

                apartmentsList.add(apartments);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return apartmentsList;

    }

    public void showApartments(){

        ObservableList<Apartments> list=  getApartmentsList();



        idCol.setCellValueFactory(new PropertyValueFactory<Apartments, Integer>("Apartment_id"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<Apartments, String>("address"));
        PricelCol.setCellValueFactory(new PropertyValueFactory<Apartments, Double>("price"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<Apartments, String>("status"));

        tableView.setItems(list);

    }




    private void insertRecord(){


        String id= txtId1.getText();
        String address= txtAdress.getText();
        String price= txtPrice.getText();
        String status= (String) comp.getValue();


        String query= " insert into Apartments values (" + id + ",'" +
                address + "'," + price + ",'" + status + "'" + ") ";
        executeQuery(query);
        showApartments();
        showCustomersStatusRented();
        showCustomersStatusNotRented();

    }


    private void updateRecord(){

        String id= txtId1.getText();
        String address= txtAdress.getText();
        String price= txtPrice.getText();
        String status= (String) comp.getValue();


        String query= " update Apartments Set address = '" +
                address + "', price = " + price + " , status = ' " + status + "'" + " WHERE Apartment_id = " + id + "" ;

        executeQuery(query);
        showApartments();

    }



    private void deleteRecord(){

        String id= txtId1.getText();
        String address= txtAdress.getText();
        String price= txtPrice.getText();
        String status= (String) comp.getValue();


        String query= " DELETE FROM Apartments WHERE Apartment_id = " + id + "" ;

        executeQuery(query);
        showApartments();

    }




    public ObservableList<Customers> getCustomersList(){

        ObservableList<Customers> customersList= FXCollections.observableArrayList();
        Connection conn= DBUtil.getConnection();
        String query= "SELECT * FROM Customers";
        Statement st=null;
        ResultSet rs= null;

        try {
            st= conn.createStatement();
            rs= st.executeQuery(query);
            Customers customers;
            while (rs.next()){

                customers= new Customers(rs.getInt("customer_id")
                        ,rs.getString("first_name"),
                        rs.getString("last_name")
                        ,rs.getInt("Apartment_id"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getString("status")
                      //  ,rs.getDouble("deposit")
                        ,rs.getDouble("remining"));

                customersList.add(customers);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return customersList;

    }

    public void showCustomers(){

        ObservableList<Customers> list=  getCustomersList();

        idCol1.setCellValueFactory(new PropertyValueFactory<Customers, Integer>("customer_id"));
        first_namecol.setCellValueFactory(new PropertyValueFactory<Customers, String>("first_name"));
        last_namecol.setCellValueFactory(new PropertyValueFactory<Customers, String>("last_name"));
        idCol11.setCellValueFactory(new PropertyValueFactory<Customers, Integer>("Apartment_id"));
        AddressCol1.setCellValueFactory(new PropertyValueFactory<Customers, String>("address"));
        PricelCol1.setCellValueFactory(new PropertyValueFactory<Customers, Double>("price"));
        StatusCol1.setCellValueFactory(new PropertyValueFactory<Customers, String>("status"));
       // Depositcol.setCellValueFactory(new PropertyValueFactory<Customers, Double>("deposit"));
        Reminingcol.setCellValueFactory(new PropertyValueFactory<Customers, Double>("remining"));


        tableView2.setItems(list);

    }








    private void insertCustomer(){

        String query= " insert into Customers values (" + txtid2.getText() + ",'" + txtFirstName.getText() + "','" +
               txtLastName.getText() + "'," + txtid21.getText() + ",'" + txtApartmentAdress.getText() + "',"
             + txtApartmentPrice.getText()  + ",'"  + (String) comp2.getValue() +
                "'," + txtApartmentPrice.getText() + ") ";


        executeQuery(query);
        showCustomers();
        updateStatus();
        showCustomersStatusRented();
        showCustomersStatusNotRented();

    }


    private void updateCustomer(){

        String query= " update Customers Set first_name = '" +
                txtFirstName.getText() +
                "', last_name =' " + txtLastName.getText() +
                " ', Apartment_id = " + txtid21.getText() +
                ", address = '" + txtApartmentAdress.getText() +
                "', price = " + txtApartmentPrice.getText() +
                ", status = '" + (String) comp2.getValue() +
                ", remining = " + txtRemining.getText() +
                " WHERE customer_id = " + txtid2.getText() +
                "" ;

        executeQuery(query);
        System.out.println(query);
        showCustomers();

    }


    private void deleteCustomer(){

        String query= " DELETE FROM Customers WHERE customer_id = " + txtid2.getText() + "" ;

        executeQuery(query);
        System.out.println(query);
        showCustomers();

    }



    private void executeQuery(String query){

        Connection conn= DBUtil.getConnection();
        Statement st;

        try {
            st= conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void AddPayment(){

        String id= txtid22.getText();
        String deposit= txtDeposit.getText();

        String query= " update Customers Set  remining = " + "remining" + "-" + deposit + " WHERE customer_id = " + id + "" ;


        executeQuery(query);


        System.out.println(query);


        showCustomers();
        showCustomersRemining();

    }



    public Customers getCustomersReminig() {


        Connection conn = DBUtil.getConnection();
        String query = "SELECT remining FROM Customers WHERE customer_id = " + txtid22.getText() + " ";
        Statement st = null;
        ResultSet rs = null;

        Customers customers = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                customers = new Customers(rs.getDouble("remining"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;

    }

    public void showCustomersRemining(){

        Customers c =  getCustomersReminig();
        txtRemining.setText(c.toStringr());

    }



    public Integer  getCustomersStatusNotRented() {



//        SELECT COUNT(status) FROM Apartments WHERE status = 'Rented';

        Connection conn = DBUtil.getConnection();
        String query = "SELECT COUNT(status) FROM Apartments WHERE status = 'Rented'";
        Statement st = null;
        ResultSet rs = null;

        int count=0;
        Customers customers = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

               count= rs.getInt(1);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;

    }



    public void showCustomersStatusRented(){

        lblRented.setText(String.valueOf(getCustomersStatusRented()));


    }



    public Integer  getCustomersStatusRented() {


        Connection conn = DBUtil.getConnection();
        String query = "SELECT COUNT(status) FROM Apartments WHERE status = 'Not Rented'";
        Statement st = null;
        ResultSet rs = null;

        int count = 0;
        Customers customers = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                count= rs.getInt(1);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;

    }

    public void showCustomersStatusNotRented(){


        lblnotRented.setText(String.valueOf(getCustomersStatusNotRented()));


    }



    private void updateStatus(){

        String query= " update Apartments Set  status = 'Rented' WHERE Apartment_id = " + txtid21.getText() + "" ;

        executeQuery(query);
        showApartments();

    }



    public Customers getCustomersReport() {

        // ObservableList<Customers> customersList= FXCollections.observableArrayList();
        Connection conn = DBUtil.getConnection();
        String query = "SELECT * FROM Customers where customer_id = " + txtid22.getText() + "";
        Statement st = null;
        ResultSet rs = null;

        Customers customers = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                customers = new Customers(rs.getInt("customer_id")
                        , rs.getString("first_name"),
                        rs.getString("last_name")
                        , rs.getInt("Apartment_id"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getString("status")
                        , rs.getDouble("remining"));

                //    customersList.add(customers);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;

    }

    public void showCustomersReport(){

        Customers c = getCustomersReport();
        StringBuilder sb=new StringBuilder(c.toString());
        sb.append("Deposit =  ");
        sb.append(txtDeposit.getText());
        sb.append("  $");
        sb.append("\n");
        sb.append("Remining =  ");
        sb.append(c.toStringr());
        txtReport.setText(String.valueOf(sb));
    }


}