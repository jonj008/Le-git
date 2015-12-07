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
import javafx.scene.control.TableCell;
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
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import javafx.event.Event;

public class GameGoGUI extends Application implements EventHandler<ActionEvent> {
    
    Stage window;

    double overAllTotal;
    final double tax =   0.115;
    int x = 0;
    int i;
    
    double priceBtn1 = 69.99, priceBtn3 = 69.99, priceBtn7 = 99.99, priceBtn14 = 299.99, priceBtn15 = 249.99;
    double priceBtn2 = 59.99, priceBtn6 = 59.99, priceBtn8 = 9.99, priceBtn10 = 59.99, priceBtn12 = 299.99;
    double priceBtn4 = 49.99, priceBtn5 = 49.99, priceBtn9 = 29.99, priceBtn11 = 299.99, priceBtn13 = 399.99;
    

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15;
    
    Button removeAllBtn, removeBtn, discountBtn;
    
    TextField totalField, itemNumField;

    //Images to be shown in the GameWindow.
    Image titanfallImg, battlefrontImg, mariokart8Img, nfsImg, halo5Img ;
    ImageView titanfallView, battlefrontView, mariokart8View, nfsView,halo5View;
    
    Image acc1Img, acc2Img, acc3Img, acc4Img, acc5Img;
    ImageView acc1View, acc2View, acc3View, acc4View, acc5View;
    
    Image bundle1Img, bundle2Img, bundle3Img, bundle4Img, bundle5Img;
    ImageView bundle1View, bundle2View, bundle3View, bundle4View, bundle5View;
    
    Image ps4Logo, xboxLogo, wiiLogo;
    ImageView ps4View, xboxView, wiiView;
    
    TableView tableList = new TableView();
    
    TableColumn gameColumn;
    TableColumn priceColumn;
    TableColumn numberColumn;
    TableColumn<GamesList,Boolean> checkBoxColumn = new TableColumn<>(" ");
    
    Rectangle titleBox;
    
    Text title1 = new Text("Game");
    Text title2 = new Text(" Go");
    
    ObservableList<GamesList> data = FXCollections.observableArrayList();
 
    public static void main(String[] args) {
        launch(args);   
    }

    @Override
    public void start(Stage window) {
        
        window.setWidth(1250);
        window.setHeight(750);
        window.setMinWidth(1250);
        window.setMinHeight(750);
        window.setResizable(false);
        window.setTitle("GameGo");
        window.show();

        titanfallImg = new Image(getClass().getResourceAsStream("/titanfall.jpg"), 90, 100,true,true);
        titanfallView = new ImageView(titanfallImg);
        
        battlefrontImg = new Image(getClass().getResourceAsStream("/BattleFront.png"), 90, 100,true,true);
        battlefrontView = new ImageView(battlefrontImg);
        
        mariokart8Img = new Image(getClass().getResourceAsStream("/mariokart8.jpg"), 90, 100,true,true);
        mariokart8View = new ImageView(mariokart8Img);
        
        nfsImg = new Image(getClass().getResourceAsStream("/needforspeed.jpg"), 90, 100,true,true);
        nfsView = new ImageView(nfsImg);
        
        halo5Img = new Image(getClass().getResourceAsStream("/halo.jpg"), 90, 100,true,true);
        halo5View = new ImageView(halo5Img);
        
        acc1Img = new Image(getClass().getResourceAsStream("/PS4 Controller.jpg"), 90, 100,true,true);
        acc1View = new ImageView(acc1Img);
        
        acc2Img = new Image(getClass().getResourceAsStream("/PS4 Headset.jpg"),80, 90,true,true);
        acc2View = new ImageView(acc2Img);
        
        acc3Img = new Image(getClass().getResourceAsStream("/Wii U Wheel.jpg"), 80, 90,true,true);
        acc3View = new ImageView(acc3Img);
        
        acc4Img = new Image(getClass().getResourceAsStream("Xbox One Headset.jpg"), 80, 90,true,true);
        acc4View = new ImageView(acc4Img);
        
        acc5Img = new Image(getClass().getResourceAsStream("/Xbox One Controller.jpg"), 90, 100,true,true);
        acc5View = new ImageView(acc5Img);
        
        bundle1Img = new Image(getClass().getResourceAsStream("/mario3dbundle.jpg"), 90, 95,true,true);
        bundle1View = new ImageView(bundle1Img);
        
        bundle2Img = new Image(getClass().getResourceAsStream("/mariobundle.jpg"), 90, 95,true,true);
        bundle2View = new ImageView(bundle2Img);
        
        bundle3Img = new Image(getClass().getResourceAsStream("/bo3bundle.jpg"), 90, 95,true,true);
        bundle3View = new ImageView(bundle3Img);
        
        bundle4Img = new Image(getClass().getResourceAsStream("/ps4.jpg"), 90, 95,true,true);
        bundle4View = new ImageView(bundle4Img);
        
        bundle5Img = new Image(getClass().getResourceAsStream("/wii.jpg"), 90, 95,true,true);
        bundle5View = new ImageView(bundle5Img);
        
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

        //mainPane.setGridLinesVisible(true);
        
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
        discountBtn = new Button("TAX DISCOUNT");

        removeAllBtn.setMinSize(100, 20);
                
        GridPane.setConstraints(btn1, 25, 29);
        GridPane.setConstraints(titanfallView, 23, 7, 25, 23);
        GridPane.setConstraints(btn2, 35, 29);
        GridPane.setConstraints(battlefrontView, 33, 7, 25, 23);
        GridPane.setConstraints(btn3, 45, 29);
        GridPane.setConstraints(mariokart8View, 43, 7, 25, 23);
        GridPane.setConstraints(btn4, 55, 29);
        GridPane.setConstraints(nfsView, 53, 7, 25, 23);
        GridPane.setConstraints(btn5, 65, 29);
        GridPane.setConstraints(halo5View, 63, 7, 25, 23);
        GridPane.setConstraints(btn6, 25, 48);
        GridPane.setConstraints(acc1View, 23, 28, 25, 23);
        GridPane.setConstraints(btn7, 35, 48);
        GridPane.setConstraints(acc2View, 33, 28, 25, 23);
        GridPane.setConstraints(btn8, 45, 48);
        GridPane.setConstraints(acc3View, 43, 28, 25, 23);
        GridPane.setConstraints(btn9, 55, 48);
        GridPane.setConstraints(acc4View, 53, 28, 25, 23);
        GridPane.setConstraints(btn10, 65, 48);
        GridPane.setConstraints(acc5View, 63, 28, 25, 23);
        GridPane.setConstraints(btn11, 25, 60);
        GridPane.setConstraints(bundle1View, 23, 43, 25, 24);
        GridPane.setConstraints(btn12, 35, 60);
        GridPane.setConstraints(bundle2View, 33, 43, 25, 24);
        GridPane.setConstraints(btn13, 45, 60);
        GridPane.setConstraints(bundle3View, 43, 43, 25, 24);
        GridPane.setConstraints(btn14, 55, 60);
        GridPane.setConstraints(bundle4View, 53, 43, 25, 24);
        GridPane.setConstraints(btn15, 65, 60);
        GridPane.setConstraints(bundle5View, 63, 43, 25, 24);
        
        GridPane.setConstraints(ps4View, 1, 9, 40, 20);
        GridPane.setConstraints(xboxView, 1, 23, 40, 30);
        GridPane.setConstraints(wiiView, 1, 41, 40, 30);
        
        
        GridPane.setConstraints(removeAllBtn, 80, 52);
        GridPane.setConstraints(removeBtn, 81, 52);
        GridPane.setConstraints(discountBtn, 80, 53, 1, 1);
        
        Label pricesLabel1 = new Label("$69.99");
        Label pricesLabel2 = new Label("$59.99");
        Label pricesLabel3 = new Label("$69.99");
        Label pricesLabel4 = new Label("$49.99");
        Label pricesLabel5 = new Label("$49.99");
        Label pricesLabel6 = new Label("$59.99");
        Label pricesLabel7 = new Label("$99.99");
        Label pricesLabel8 = new Label("$9.99");
        Label pricesLabel9 = new Label("$29.99");
        Label pricesLabel10 = new Label("$59.99");
        Label pricesLabel11 = new Label("$299.99");
        Label pricesLabel12 = new Label("$299.99");
        Label pricesLabel13 = new Label("$399.99");
        Label pricesLabel14 = new Label("$299.99");
        Label pricesLabel15 = new Label("$249.99");

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
        GridPane.setConstraints(pricesLabel11, 25, 59, 2, 1);
        pricesLabel11.setFont(new Font("Courier Bold", 12));
        GridPane.setConstraints(pricesLabel12, 35, 59, 2, 1);
        pricesLabel12.setFont(new Font("Courier Bold", 12));
        GridPane.setConstraints(pricesLabel13, 45, 59);
        pricesLabel13.setFont(new Font("Courier Bold", 12));
        GridPane.setConstraints(pricesLabel14, 55, 59);
        pricesLabel14.setFont(new Font("Courier Bold", 12));
        GridPane.setConstraints(pricesLabel15, 65, 59);
        pricesLabel15.setFont(new Font("Courier Bold", 12));

        Label totalLabel = new Label("     TOTAL:");
        totalLabel.setFont(new Font("Courier Bold", 16));
        
        GridPane.setConstraints(totalLabel, 80, 57);
        
        totalField = new TextField("$0.00");
        totalField.setFont(new Font("Courier", 14));
        totalField.setStyle("-fx-background-color: darkgrey");
        totalField.setEditable(false);
        
        GridPane.setConstraints(totalField, 81, 57);

        itemNumField = new TextField();

        itemNumField.setMinWidth(30);
        itemNumField.setMaxWidth(30);
        itemNumField.setFont(new Font("Courier", 14));
        itemNumField.setStyle("-fx-background-color: darkgrey");
        itemNumField.setEditable(true);

        GridPane.setConstraints(itemNumField, 82, 52);

        gameColumn = new TableColumn("GAME");
        priceColumn = new TableColumn("PRICE + TAX");
        numberColumn = new TableColumn("#");
        
        numberColumn.setCellValueFactory(new Callback<CellDataFeatures<GamesList, GamesList>, ObservableValue<GamesList>>() {
            @Override public ObservableValue<GamesList> call(CellDataFeatures<GamesList, GamesList> p) {
                return new ReadOnlyObjectWrapper(p.getValue());
            }
        });

        numberColumn.setCellFactory(new Callback<TableColumn<GamesList, GamesList>, TableCell<GamesList, GamesList>>() {
            @Override public TableCell<GamesList, GamesList> call(TableColumn<GamesList, GamesList> param) {
                return new TableCell<GamesList, GamesList>() {
                    @Override protected void updateItem(GamesList item, boolean empty) {
                        super.updateItem(item, empty);

                        if (this.getTableRow() != null && item != null) {
                            setText(this.getTableRow().getIndex() + "");
                        } else {
                            setText("");
                        }
                    }
                };
            }
        });

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

        numberColumn.setSortable(false);
        numberColumn.setMinWidth(30);
        numberColumn.setMaxWidth(30);
        numberColumn.setResizable(false);

        checkBoxColumn.setVisible(true);
        checkBoxColumn.setEditable(true);
        checkBoxColumn.setMinWidth(30);
        checkBoxColumn.setMaxWidth(30);
        checkBoxColumn.setResizable(false);
        
        gameColumn.setResizable(false);
        gameColumn.setMinWidth(148);
        
        priceColumn.setMinWidth(135);
        priceColumn.setResizable(false);

        tableList.setMinSize(345, 400);
        tableList.setMaxSize(345, 400);
        tableList.setEditable(true);

        Label tableLabel = new Label("GameGo");
        tableLabel.setFont(new Font("Courier", 40));
        tableList.setPlaceholder(tableLabel);
        tableList.setStyle("-fx-background-color: darkgrey");

        tableList.getColumns().addAll(numberColumn, checkBoxColumn, gameColumn, priceColumn);
 
        GridPane.setConstraints(tableList, 80, 5, 8, 45);
   
        mainPane.getChildren().add(tableList);

        mainPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, 
                                      btn6, btn7, btn8, btn9, btn10,
                                      btn11, btn12, btn13, btn14, btn15);
        
        mainPane.getChildren().addAll(pricesLabel1, pricesLabel2, pricesLabel3, pricesLabel4, pricesLabel5, 
                                      pricesLabel6, pricesLabel7, pricesLabel8, pricesLabel9, pricesLabel10, 
                                      pricesLabel11, pricesLabel12, pricesLabel13, pricesLabel14, pricesLabel15);
 
        mainPane.getChildren().addAll(totalField, totalLabel, removeAllBtn, removeBtn, itemNumField, discountBtn);

        mainPane.getChildren().addAll(titanfallView, battlefrontView, mariokart8View, nfsView, halo5View);
        mainPane.getChildren().addAll(acc1View, acc2View, acc3View, acc4View, acc5View);
        mainPane.getChildren().addAll(bundle1View, bundle2View, bundle3View, bundle4View, bundle5View);
        
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
        discountBtn.setOnAction(this);

    
    }
    
    @Override
    public void handle(ActionEvent event){
        
        if(event.getSource() == btn1){
            
            addItemstoList("Titanfall","$" + priceBtn1 + " + $" + String.format("%.2f", (priceBtn1 * tax)), false, priceBtn1);
            overAllTotal += priceBtn1; 
            updateTotal();
        }
        else if(event.getSource() == btn2){
            
            addItemstoList("Battlefront","$" + priceBtn2 + " + $" + String.format("%.2f", (priceBtn2 * tax)), false, priceBtn2);
           
            overAllTotal += priceBtn2; 
            updateTotal();
        }
        else if(event.getSource() == btn3){
            
            addItemstoList("Mario Kart 8","$" + priceBtn3 + " + $" + String.format("%.2f", (priceBtn3 * tax)), false, priceBtn3);
           
            overAllTotal += priceBtn3; 
            updateTotal();
        }
        else if(event.getSource() == btn4){
            
            addItemstoList("Need For Speed","$" + priceBtn4 + " + $" + String.format("%.2f", (priceBtn4 * tax)), false, priceBtn4);
            
            overAllTotal += priceBtn4; 
            updateTotal();
        }
        else if(event.getSource() == btn5){
            
            addItemstoList("Halo 5","$" + priceBtn5 + " + $" + String.format("%.2f", (priceBtn5 * tax)), false, priceBtn5);
           
            overAllTotal += priceBtn5; 
            updateTotal();
        }
        else if(event.getSource() == btn6){
            
            addItemstoList("PS4 Controller","$" + priceBtn6 + " + $" + String.format("%.2f", (priceBtn6 * tax)), false, priceBtn6);
            
            overAllTotal += priceBtn6; 
            updateTotal();
        }
        else if(event.getSource() == btn7){
            
            addItemstoList("PS4 Headset","$" + priceBtn7 + " + $" + String.format("%.2f", (priceBtn7 * tax)), false, priceBtn7);
           
            overAllTotal += priceBtn7; 
            updateTotal();
        }
        else if(event.getSource() == btn8){
            
            addItemstoList("Wii U Wheel","$" + priceBtn8 + " + $" + String.format("%.2f", (priceBtn8 * tax)), false, priceBtn8);
            
            overAllTotal += priceBtn8; 
            updateTotal();
        }
        else if(event.getSource() == btn9){
            
            addItemstoList("Xbox One Headset","$" + priceBtn9 + " + $" + String.format("%.2f", (priceBtn9 * tax)), false, priceBtn9);
            
            overAllTotal += priceBtn9; 
            updateTotal();
        }
        else if(event.getSource() == btn10){
            
            addItemstoList("Xbox One Controller","$" + priceBtn10 + " + $" + String.format("%.2f", (priceBtn10 * tax)), false, priceBtn10);
         
            overAllTotal += priceBtn10; 
            updateTotal();
        }
        else if(event.getSource() == btn11){
            
            addItemstoList("Mario 3D World Bundle","$" + priceBtn11 + " + $" + String.format("%.2f", (priceBtn11 * tax)), false, priceBtn11);
           
            overAllTotal += priceBtn11; 
            updateTotal();
        }
        else if(event.getSource() == btn12){
            
            addItemstoList("Mario Kart 8 Bundle","$" + priceBtn12 + " + $" + String.format("%.2f", (priceBtn12 * tax)), false, priceBtn12);
            
            overAllTotal += priceBtn12; 
            updateTotal();
        }
        else if(event.getSource() == btn13){
            
            addItemstoList("Black Ops III Bundle","$" + priceBtn13 + " + $" + String.format("%.2f", (priceBtn13 * tax)), false, priceBtn13);
           
            overAllTotal += priceBtn13; 
            updateTotal();
        }
        else if(event.getSource() == btn14){
            
            addItemstoList("Playstation 4","$" + priceBtn14 + " + $" + String.format("%.2f", (priceBtn14 * tax)), false, priceBtn14);
          
            overAllTotal += priceBtn14; 
            updateTotal();
        }
        else if(event.getSource() == btn15){
            
            addItemstoList("Wii U","$" + priceBtn15 + " + $" + String.format("%.2f", (priceBtn15 * tax)), false, priceBtn15);
           
            overAllTotal += priceBtn15; 
            updateTotal();
        }
        else if(event.getSource() == removeAllBtn){
            removeAllList();
            overAllTotal = 0; 
            totalField.setText("$0.00");
        }
        else if(event.getSource() == discountBtn){
            
            totalField.setText("$" + String.format("%.2f", overAllTotal));
            
        }
        // else if(event.getSource() == discountBtn){
            
        //     totalField.setText("$" + String.format("%.2f", overAllTotal));
            
        // }
        else if(event.getSource() == removeBtn){
            
            if(itemNumField.getText().isEmpty()){
            removeAnItem();
            }

            else{
                
                int i = Integer.parseInt(itemNumField.getText());
                
                overAllTotal -= data.remove(i).getRealPrice();
                
                updateTotal();
                
                itemNumField.clear();
                
                if(data.isEmpty()){
                   totalField.setText("$0.00");
                    }

                }
        }
}
    
public void addItemstoList(String item, String price, boolean check, double realPrice){
    
     data.add( new GamesList(item, price, check, realPrice));
    tableList.setItems(data);
}

public void removeAllList(){
    data.removeAll(data);
    
}

public void removeAnItem(){
    
    for (int i = 0; i < data.size(); i++){
     if(data.get(i).isCheckBox()){
         overAllTotal -= data.remove(i).getRealPrice();
         updateTotal();
         if(data.isEmpty()){
                   totalField.setText("$0.00");
               }
     }   
    }   
}

public void updateTotal(){
    totalField.setText("$" + String.format("%.2f", overAllTotal + (overAllTotal * tax)));
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
    public GamesList(String gameName, String gamePrice, boolean checkBox ){
        this.gameName = new SimpleStringProperty(gameName);
        this.gamePrice = new SimpleStringProperty(gamePrice);
        this.checkBox = new SimpleBooleanProperty(false);  
        
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
