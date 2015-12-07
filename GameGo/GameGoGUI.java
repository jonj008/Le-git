/*
 * Author: Jonathan Montanez
 * Created: November 25, 2015
 * Updated: November 5, 2015
 * Description: 
 */
//package gamegogui;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class GameGoGUI extends Application implements EventHandler<ActionEvent> {
    
    Stage window;

    double overAllTotal = 0;
    int x = 0;
    int i;
    
    double priceBtn1 = 69.99, priceBtn3 = 69.99, priceBtn7 = 69.99, priceBtn14 = 69.99, priceBtn15 = 69.99;
    double priceBtn2 = 59.99, priceBtn6 = 59.99, priceBtn8 = 59.99, priceBtn10 = 59.99, priceBtn12 = 59.99;
    double priceBtn4 = 49.99, priceBtn5 = 49.99, priceBtn9 = 49.99, priceBtn11 = 49.99, priceBtn13 = 49.99;
    

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15;
    
    Button removeAllBtn, removeBtn;
    
    TextField totalField;

    //Images to be shown in the GameWindow.
    Image destinyImg, battlefrontImg, codbo3Img, nfsImg, falloutImg ;
    ImageView destinyView, battlefrontView, codbo3View, nfsView,falloutView;
    
    Image acc1kombatImg, acc2Img, acc3Img, acc4Img, acc5Img;
    ImageView acc1View, acc2View, acc3View, acc4View, acc5View;
    
    Image zeldaImg, mariokartImg, mariopartyImg, smashbroImg,mariotennisImg;
    ImageView zeldaView, mariokartView, mariopartyView, smashbroView,mariotennisView;
    
    Image ps4Logo, xboxLogo, wiiLogo;
    ImageView ps4View, xboxView, wiiView;
    
    TableView tableList = new TableView();
    
    TableColumn gameColumn;
    TableColumn priceColumn;
    TableColumn<GamesList,Boolean> checkBoxColumn = new TableColumn<>(" ");
    
    Rectangle titleBox;
    
    Text title1 = new Text("Game");
    Text title2 = new Text(" Go");
    
    ObservableList<GamesList> data = FXCollections.observableArrayList();
 
    public static void main(String[] args) {
        launch(args);   
    }

    @Override
    public void start(Stage gameStage) {
        window = gameStage;
        window.setWidth(1250);
        window.setHeight(750);
        window.setMinWidth(1250);
        window.setMinHeight(750);
        window.setResizable(false);
        window.setTitle("GameGo");
        window.show();

        titanfallImg = new Image(getClass().getResourceAsStream("/titanfall.jpg"), 90, 100,true,true);
        destinyView = new ImageView(destinyImg);
        
        battlefrontImg = new Image(getClass().getResourceAsStream("/BattleFront.png"), 90, 100,true,true);
        battlefrontView = new ImageView(battlefrontImg);
        
        codbo3Img = new Image(getClass().getResourceAsStream("/mariokart8.jpg"), 90, 100,true,true);
        codbo3View = new ImageView(codbo3Img);
        
        nfsImg = new Image(getClass().getResourceAsStream("/needforspeed.jpg"), 90, 100,true,true);
        nfsView = new ImageView(nfsImg);
        
        falloutImg = new Image(getClass().getResourceAsStream("/halo.jpg"), 90, 100,true,true);
        falloutView = new ImageView(falloutImg);
        
        mortalkombatImg = new Image(getClass().getResourceAsStream("/PS4 Controller.jpg"), 90, 100,true,true);
        mortalkombatView = new ImageView(mortalkombatImg);
        
        forzaImg = new Image(getClass().getResourceAsStream("/PS4 Headset.jpg"),80, 90,true,true);
        forzaView = new ImageView(forzaImg);
        
        gowImg = new Image(getClass().getResourceAsStream("/Wii U Wheel.jpg"), 80, 90,true,true);
        gowView = new ImageView(gowImg);
        
        halo5Img = new Image(getClass().getResourceAsStream("Xbox One Headset.jpg"), 80, 90,true,true);
        halo5View = new ImageView(halo5Img);
        
        acc5Img = new Image(getClass().getResourceAsStream("/Xbox One Controller.jpg"), 90, 100,true,true);
        acc5View = new ImageView(acc5Img);
        
        zeldaImg = new Image(getClass().getResourceAsStream("/mario3dbundle.jpg"), 90, 95,true,true);
        zeldaView = new ImageView(zeldaImg);
        
        mariokartImg = new Image(getClass().getResourceAsStream("/mariobundle.jpg"), 90, 95,true,true);
        mariokartView = new ImageView(mariokartImg);
        
        mariopartyImg = new Image(getClass().getResourceAsStream("/bo3bundle.jpg"), 90, 95,true,true);
        mariopartyView = new ImageView(mariopartyImg);
        
        smashbroImg = new Image(getClass().getResourceAsStream("/ps4.jpg"), 90, 95,true,true);
        smashbroView = new ImageView(smashbroImg);
        
        mariotennisImg = new Image(getClass().getResourceAsStream("/wii.jpg"), 90, 95,true,true);
        mariotennisView = new ImageView(mariotennisImg);
        
        xboxLogo = new Image(getClass().getResourceAsStream("/XboxLogo.jpg"), 150, 300,true,true);
        xboxView = new ImageView(xboxLogo);
        
        ps4Logo = new Image(getClass().getResourceAsStream("/ps4-logo.jpg"), 150, 300,true,true);
        ps4View = new ImageView(ps4Logo);
        
        wiiLogo = new Image(getClass().getResourceAsStream("/Wii_U_logo.png"), 150, 300,true,true);
        wiiView = new ImageView(wiiLogo);
       
        titleBox = new Rectangle();
        titleBox.setWidth(375);
        titleBox.setHeight(75);
        titleBox.setArcWidth(20);
        titleBox.setArcHeight(20);
        titleBox.setFill(Color.BLACK);
        
        title1.setFill(Color.WHITE);
        title1.setFont(new Font("Courier", 40));
        
        title2.setFill(Color.GREEN);
        title2.setFont(new Font("Courier", 40));
        
        GridPane.setConstraints(titleBox, 27, 3, 40, 10);
        GridPane.setConstraints(title1, 36, 3, 37, 10);
        GridPane.setConstraints(title2, 45, 3, 45, 10);
        
        GridPane mainPane = new GridPane();
        
        mainPane.setPadding(new Insets(8,8,8,8));
        mainPane.setVgap(8);
        mainPane.setHgap(8);
        mainPane.setStyle("-fx-background-color: darkorange");
        
        mainPane.getChildren().add(titleBox);
        
        mainPane.getChildren().addAll(title1, title2);

        btn1 = new Button("ADD");      
        btn2 = new Button("ADD");       
        btn3 = new Button("ADD");
        btn4 = new Button("ADD");
        btn5 = new Button("ADD");        
        btn6 = new Button("ADD");        
        btn7 = new Button("ADD");        
        btn8 = new Button("ADD");
        btn9 = new Button("ADD");        
        btn10 = new Button("ADD");        
        btn11 = new Button("ADD");        
        btn12 = new Button("ADD");        
        btn13 = new Button("ADD");        
        btn14 = new Button("ADD");        
        btn15 = new Button("ADD");
        
        removeAllBtn = new Button("REMOVE ALL");
        removeBtn = new Button("REMOVE ITEM");
                
        GridPane.setConstraints(btn1, 25, 29);
        GridPane.setConstraints(destinyView, 23, 7, 25, 23);
        GridPane.setConstraints(btn2, 35, 29);
        GridPane.setConstraints(battlefrontView, 33, 7, 25, 23);
        GridPane.setConstraints(btn3, 45, 29);
        GridPane.setConstraints(codbo3View, 43, 7, 25, 23);
        GridPane.setConstraints(btn4, 55, 29);
        GridPane.setConstraints(nfsView, 53, 7, 25, 23);
        GridPane.setConstraints(btn5, 65, 29);
        GridPane.setConstraints(falloutView, 63, 7, 25, 23);
        GridPane.setConstraints(btn6, 25, 48);
        GridPane.setConstraints(mortalkombatView, 23, 28, 25, 23);
        GridPane.setConstraints(btn7, 35, 48);
        GridPane.setConstraints(forzaView, 33, 28, 25, 23);
        GridPane.setConstraints(btn8, 45, 48);
        GridPane.setConstraints(gowView, 43, 28, 25, 23);
        GridPane.setConstraints(btn9, 55, 48);
        GridPane.setConstraints(halo5View, 53, 28, 25, 23);
        GridPane.setConstraints(btn10, 65, 48);
        GridPane.setConstraints(titanfallView, 63, 28, 25, 23);
        GridPane.setConstraints(btn11, 25, 60);
        GridPane.setConstraints(zeldaView, 23, 43, 25, 24);
        GridPane.setConstraints(btn12, 35, 60);
        GridPane.setConstraints(mariokartView, 33, 43, 25, 24);
        GridPane.setConstraints(btn13, 45, 60);
        GridPane.setConstraints(mariopartyView, 43, 43, 25, 24);
        GridPane.setConstraints(btn14, 55, 60);
        GridPane.setConstraints(smashbroView, 53, 43, 25, 24);
        GridPane.setConstraints(btn15, 65, 60);
        GridPane.setConstraints(mariotennisView, 63, 43, 25, 24);
        
        GridPane.setConstraints(ps4View, 1, 9, 40, 20);
        GridPane.setConstraints(xboxView, 1, 23, 40, 30);
        GridPane.setConstraints(wiiView, 1, 41, 40, 30);
        
        
        GridPane.setConstraints(removeAllBtn, 80, 52,12,1);
        GridPane.setConstraints(removeBtn, 90, 52, 3, 1);
        
        Label pricesLabel1 = new Label("$69.99");
        Label pricesLabel2 = new Label("$59.99");
        Label pricesLabel3 = new Label("$69.99");
        Label pricesLabel4 = new Label("$49.99");
        Label pricesLabel5 = new Label("$49.99");
        Label pricesLabel6 = new Label("$59.99");
        Label pricesLabel7 = new Label("$69.99");
        Label pricesLabel8 = new Label("$59.99");
        Label pricesLabel9 = new Label("$49.99");
        Label pricesLabel10 = new Label("$59.99");
        Label pricesLabel11 = new Label("$49.99");
        Label pricesLabel12 = new Label("$59.99");
        Label pricesLabel13 = new Label("$49.99");
        Label pricesLabel14 = new Label("$69.99");
        Label pricesLabel15 = new Label("$69.99");

        GridPane.setConstraints(pricesLabel1, 25, 28);
        GridPane.setConstraints(pricesLabel2, 35, 28);
        GridPane.setConstraints(pricesLabel3, 45, 28);
        GridPane.setConstraints(pricesLabel4, 55, 28);
        GridPane.setConstraints(pricesLabel5, 65, 28);
        GridPane.setConstraints(pricesLabel6, 25, 47);
        GridPane.setConstraints(pricesLabel7, 35, 47);
        GridPane.setConstraints(pricesLabel8, 45, 47);
        GridPane.setConstraints(pricesLabel9, 55, 47);
        GridPane.setConstraints(pricesLabel10, 65, 47);
        GridPane.setConstraints(pricesLabel11, 25, 59);
        GridPane.setConstraints(pricesLabel12, 35, 59);
        GridPane.setConstraints(pricesLabel13, 45, 59);
        GridPane.setConstraints(pricesLabel14, 55, 59);
        GridPane.setConstraints(pricesLabel15, 65, 59);
        
        Label totalLabel = new Label("TOTAL:");
        
        GridPane.setConstraints(totalLabel, 89, 56);
        
        totalField = new TextField("$0.00");
        
        GridPane.setConstraints(totalField, 90, 56);

        gameColumn = new TableColumn("GAME");
        priceColumn = new TableColumn("PRICE");
        
        checkBoxColumn.setVisible(true);
        checkBoxColumn.setEditable(true);
        
        gameColumn.setCellValueFactory(
                new PropertyValueFactory<>("gameName")
        );
        
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("gamePrice")
        );
        checkBoxColumn.setCellValueFactory(
                new PropertyValueFactory<>("checkBox")
        );
        checkBoxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxColumn));

        tableList.setMinSize(totalField.getMinWidth(), 400);
        
        gameColumn.setMinWidth(140);
        
        priceColumn.setMinWidth(140);
        
        checkBoxColumn.setMinWidth(20);
        
        tableList.setEditable(true);

        tableList.getColumns().addAll(checkBoxColumn, gameColumn, priceColumn);
 
        GridPane.setConstraints(tableList, 80, 5, 12, 45);
   
        mainPane.getChildren().add(tableList);

        mainPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, 
                                      btn6, btn7, btn8, btn9, btn10,
                                      btn11, btn12, btn13, btn14, btn15);
        
        mainPane.getChildren().addAll(pricesLabel1, pricesLabel2, pricesLabel3, pricesLabel4, pricesLabel5, 
                                      pricesLabel6, pricesLabel7, pricesLabel8, pricesLabel9, pricesLabel10, 
                                      pricesLabel11, pricesLabel12, pricesLabel13, pricesLabel14, pricesLabel15);
 
        mainPane.getChildren().addAll(totalField, totalLabel, removeAllBtn, removeBtn);

        mainPane.getChildren().addAll(destinyView, battlefrontView, codbo3View, nfsView, falloutView);
        mainPane.getChildren().addAll(mortalkombatView, forzaView, gowView, halo5View, titanfallView);
        mainPane.getChildren().addAll(zeldaView, mariokartView, mariopartyView, smashbroView, mariotennisView);
        
        mainPane.getChildren().addAll(xboxView, ps4View, wiiView);

        Scene mainScene = new Scene(mainPane, 1200, 600);
        
        window.setScene(mainScene);
        
        btn1.setOnAction(this);
        btn2.setOnAction(this);
        btn3.setOnAction(this);
        btn4.setOnAction(this);
        btn5.setOnAction(this);
        btn6.setOnAction(this);
        btn7.setOnAction(this);
        btn8.setOnAction(this);
        btn9.setOnAction(this);
        btn10.setOnAction(this);
        btn11.setOnAction(this);
        btn12.setOnAction(this);
        btn13.setOnAction(this);
        btn14.setOnAction(this);
        btn15.setOnAction(this);
        
        removeAllBtn.setOnAction(this);
        removeBtn.setOnAction(this);
    
    }
    
    @Override
    public void handle(ActionEvent event){
        
        if(event.getSource() == btn1){
            
            addItemstoList("Titanfall","$" + priceBtn1, false, priceBtn1);
            
            overAllTotal += priceBtn1; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn2){
            
            addItemstoList("Battlefront","$" + priceBtn2, false, priceBtn2);
            overAllTotal += priceBtn2; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn3){
            
            addItemstoList("Mario Kart 8","$" + priceBtn3, false, priceBtn3);
            overAllTotal += priceBtn3; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn4){
            
            addItemstoList("Need For Speed","$" + priceBtn4, false, priceBtn4);
            overAllTotal += priceBtn4; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn5){
            
            addItemstoList("Halo 5","$" + priceBtn5, false, priceBtn5);
            overAllTotal += priceBtn5; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn6){
            
            addItemstoList("PS4 Controller","$" + priceBtn6, false, priceBtn6);
            overAllTotal += priceBtn6; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn7){
            
            addItemstoList("PS4 Headset","$" + priceBtn7, false, priceBtn7);
            overAllTotal += priceBtn7; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn8){
            
            addItemstoList("Wii U Wheel","$" + priceBtn8, false, priceBtn8);
            overAllTotal += priceBtn8; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn9){
            
            addItemstoList("Xbox One Headset","$" + priceBtn9, false, priceBtn9);
            overAllTotal += priceBtn9; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn10){
            
            addItemstoList("Xbox One Controller","$" + priceBtn10, false, priceBtn10);
            overAllTotal += priceBtn10; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn11){
            
            addItemstoList("Mario 3D World Bundle","$" + priceBtn11, false, priceBtn11);
            overAllTotal += priceBtn11; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn12){
            
            addItemstoList("Mario Kart 8 Bundle","$" + priceBtn12, false, priceBtn12);
            overAllTotal += priceBtn12; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn13){
            
            addItemstoList("Black Ops III Bundle","$" + priceBtn13, false, priceBtn13);
            overAllTotal += priceBtn13; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn14){
            
            addItemstoList("Playstation 4","$" + priceBtn14, false, priceBtn14);
            overAllTotal += priceBtn14; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == btn15){
            
            addItemstoList("Wii U","$" + priceBtn15, false, priceBtn15);
            overAllTotal += priceBtn15; 
            totalField.setText("$" + String.format("%.2f", overAllTotal));
        }
        else if(event.getSource() == removeAllBtn){
            removeAllList();
            overAllTotal = 0; 
            totalField.setText("$0.00");
        }
        else if(event.getSource() == removeBtn){
            
            removeAnItem();
            
            
        }
    }
    
public void addItemstoList(String item, String price, boolean check, double realPrice){
    
    data.add(new GamesList(item, price, check, realPrice));
    tableList.setItems(data);
}

public void removeAllList(){
    data.removeAll(data);
    
}

public void removeAnItem(){
    for (int i = 0; i < data.size(); i++){
     if(data.get(i).isCheckBox()){
         overAllTotal -= data.remove(i).getRealPrice();
         totalField.setText("$" + String.format("%.2f", overAllTotal));
         if(data.isEmpty()){
                   totalField.setText("$0.00");
               }
     }   
    }   
}


public static class GamesList{
    private final SimpleStringProperty gameName, gamePrice;
    private final  SimpleBooleanProperty checkBox;
    private  double realPrice;
    
    public GamesList(String gameName, String gamePrice, boolean checkBox, double realPrice){
        this.gameName = new SimpleStringProperty(gameName);
        this.gamePrice = new SimpleStringProperty(gamePrice);
        this.checkBox = new SimpleBooleanProperty(false);
        this.realPrice = realPrice;
        
    }
        public String getGameName() {
            return gameName.get();
        }
 
        public void setGameName(String gameName) {
            this.gameName.set(gameName);
        }
        
        public double getRealPrice() {
            return realPrice;
        }
 
        public void setRealPrice(double realPrice) {
            this.realPrice = realPrice;
        }
 
        public String getGamePrice() {
            return gamePrice.get();
        }
 
        public void setGamePrice(String gamePrice) {
            this.gamePrice.set(gamePrice);
        }
        public boolean isCheckBox() {
            return checkBox.get();
        }
        public void setCheckBox(boolean checkBox) {
            this.checkBox.set(checkBox);
        }
        public BooleanProperty checkBoxProperty() {
            return checkBox;
        }
    }
}
