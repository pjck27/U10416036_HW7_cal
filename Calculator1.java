//U10416036
import java.math.BigDecimal;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;



public class Calculator1 extends Application {
        //商
        boolean quo = false ;
        //乘
	boolean cross = false ;
        //加
	boolean add = false ;
        //減
	boolean subtract = false ;
        //餘
	boolean remainder = false;
        //開方
	boolean sq = false; 	
        //倒數
	boolean inverseNumber = false;
	boolean result = false;
        
	boolean isMR = false ;
	boolean mAdd = false;
	boolean mMinus = false;
	double mR = 0;
	double mRAdd = 0;
	double mRMinus = 0;
        double number = 0 ;
	double n = 0;
        TextField tf = new TextField();
        BigDecimal bd1;
	BigDecimal bd2;
        ArrayList<Double> arrayList = new ArrayList<>() ;
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator"); 
    
	GridPane gridpane = new GridPane();

	gridpane.setVgap(5);
        gridpane.setHgap(5);
        
	Group root = new Group();
	Scene scene = new Scene(root, 240, 420);
        
	//set textfield
        tf.setEditable(false);
        tf.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
	gridpane.add(tf, 1,6,5,5);
        tf.setMinSize(220,65);
        
        //set menu
        final Menu m1 = new Menu("檢視(V)");
        MenuItem mt1 = new MenuItem("標準型(T)");
        MenuItem mt2 = new MenuItem("工程型(S)");
        MenuItem mt3 = new MenuItem("程式設計師(P)");
	
        final Menu m2 = new Menu("編輯(E)");
        MenuItem mt4 = new MenuItem("複製(C)");
        MenuItem mt5 = new MenuItem("貼上(P)");
        MenuItem mt6 = new MenuItem("歷程紀錄");
        
        final Menu m3 = new Menu("說明(H)");
        MenuItem mt7 = new MenuItem("檢視說明(V)");
        MenuItem mt8 = new MenuItem("關於小算盤");
         //add menu items
        m1.getItems().add(mt1);
        m1.getItems().add(mt2);
        m1.getItems().add(mt3);
        m2.getItems().add(mt4);
        m2.getItems().add(mt5);
        m2.getItems().add(mt6);
        m3.getItems().add(mt7);
        m3.getItems().add(mt8);
        
        MenuBar menuBar = new MenuBar();
        root.getChildren().add(menuBar);
        menuBar.getMenus().addAll(m1,m2,m3);
        //add buttons
        Button bt1 = new Button("MC");
        gridpane.add(bt1,1,12);
        bt1.setMinSize(42, 45);
        
        Button bt2 = new Button("MR");
        gridpane.add(bt2,2,12);
        bt2.setMinSize(42, 45);
        
        Button bt3 = new Button("MS");
        gridpane.add(bt3,3,12);
        bt3.setMinSize(42, 45);
        
        Button bt4 = new Button("M+");
        gridpane.add(bt4,4,12);
        bt4.setMinSize(42, 45);
        
        Button bt5 = new Button("M-");
        gridpane.add(bt5,5,12);
        bt5.setMinSize(42, 45);
    
        Button bt6 = new Button("←");
        gridpane.add(bt6,1,14);
        bt6.setMinSize(42, 45);
        bt6.setOnAction(e -> {
			tf.selectBackward();
			tf.cut();
		});
        
        //CE
        Button bt7 = new Button("CE");
        gridpane.add(bt7,2,14);
        bt7.setMinSize(42, 45);
        bt7.setOnAction(e -> {
			tf.setText("0");
		});
        
        //C
        Button bt8 = new Button("C");
        gridpane.add(bt8,3,14);
        bt8.setMinSize(42, 45);
        bt8.setOnAction(e -> {
			cross = false ;
			quo = false ;
			sq = false;
			mR = 0;
			number = 0;
                        add = false ;
			subtract = false ;
			remainder = false; 
			n = 0;
			tf.setText("0");
		});
        //+-
        Button bt9 = new Button("+/-");
        gridpane.add(bt9,4,14);
        bt9.setMinSize(42, 45);
        bt9.setOnAction(e -> {
			if(tf.getText(0,1).equals("-")){
				tf.replaceText(0,1,"");
			}else{
				tf.insertText(0,"-");
			}
		});
        //√
        Button bt10 = new Button("√");
        gridpane.add(bt10,5,14);
        bt10.setMinSize(42, 45);
        bt10.setOnAction(e -> {
			sq = true;
			
			n = Double.parseDouble(tf.getText());
			cal();								
			sq = false;
		});
        //7
        Button bt11 = new Button("7");
        gridpane.add(bt11,1,16);
        bt11.setMinSize(42, 45);
        bt11.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("7");
		});

        //8
        Button bt12 = new Button("8");
        gridpane.add(bt12,2,16);
        bt12.setMinSize(42, 45);
        bt12.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("8");
		});
        //9
        Button bt13 = new Button("9");
        gridpane.add(bt13,3,16);
        bt13.setMinSize(42, 45);
        bt13.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("9");
		});
        
        Button bt14 = new Button("/");
        gridpane.add(bt14,4,16);
        bt14.setMinSize(42, 45);
        bt14.setOnAction(e -> {
			sq = false;
			if(number == 0){
				number = Double.parseDouble(tf.getText());
				tf.setText("");
			}else{
				n = Double.parseDouble(tf.getText());
				tf.setText("");			
				cal();	
				
			}
			cross = false ;
			add = false ;
			subtract = false ;
			remainder = false; 
			quo = true ;			 
		});
        //%
        Button bt15 = new Button("%");
        gridpane.add(bt15,5,16);
        bt15.setMinSize(42, 45);
        bt15.setOnAction(e -> {
			sq = false;			
			if(number == 0){
				number = Double.parseDouble(tf.getText());
				tf.setText("");
			}else{
				n = Double.parseDouble(tf.getText());
				tf.setText("");			
				cal();								
			}
			quo = false ;
			cross = false ;
			add = false ;
			subtract = false ;
			remainder = true ;
		});
        
        //4
        Button bt16 = new Button("4");
        gridpane.add(bt16,1,18);
        bt16.setMinSize(42, 45);
        bt16.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("4");
		});
        
        //5
        Button bt17 = new Button("5");
        gridpane.add(bt17,2,18);
        bt17.setMinSize(42, 45);
        bt17.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("5");
		});
        //6
        Button bt18 = new Button("6");
        gridpane.add(bt18,3,18);
        bt18.setMinSize(42, 45);
        bt18.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("6");
		});
        //*
        Button bt19 = new Button("*");
        gridpane.add(bt19,4,18);
        bt19.setMinSize(42, 45);
        bt19.setOnAction(e -> {
			sq = false;			
			if(number == 0){
				number = Double.parseDouble(tf.getText());
				tf.setText("");
			}else{
				n = Double.parseDouble(tf.getText());
				tf.setText("");			
				cal();								
			}
			quo = false ;
			cross = true ;
			add = false ;
			subtract = false ;
			remainder = false ;
		});
        //1/x
        Button bt20 = new Button("1/x");
        gridpane.add(bt20,5,18);
        bt20.setMinSize(42, 45);
        bt20.setOnAction(e -> {
			inverseNumber = true;			
			n = Double.parseDouble(tf.getText());
			cal();								
			inverseNumber = false;
		});
        
        //1
        Button bt21 = new Button("1");
        gridpane.add(bt21,1,20);
        bt21.setMinSize(42, 45);
        bt21.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("1");
		});
        
        //2
        Button bt22 = new Button("2");
        gridpane.add(bt22,2,20);
        bt22.setMinSize(42, 45);
        bt22.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("2");
		});
        //3
        Button bt23 = new Button("3");
        gridpane.add(bt23,3,20);
        bt23.setMinSize(42, 45);
        bt23.setOnAction(e -> {
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			if(result == true || tf.getText().equals("0")){
				tf.setText("");
				result = false;
			}
			tf.appendText("3");
		});
        //-
        Button bt24 = new Button("-");
        gridpane.add(bt24,4,20);
        bt24.setMinSize(42, 45);
        bt24.setOnAction(e -> {
			sq = false;			
			if(number == 0){
				number = Double.parseDouble(tf.getText());
				tf.setText("");
			}else{
				n = Double.parseDouble(tf.getText());
				tf.setText("");			
				cal();								
			}
			cross = false ;
			quo = false ;
                        add = false ;
			subtract = true ;
			remainder = false; 
		});
        
        //=
        Button bt25 = new Button("=");
        gridpane.add(bt25,5,20,1,2);
        bt25.setMinSize(42, 85);
        bt25.setOnAction(e -> {
			sq = false;			
			n = Double.parseDouble(tf.getText());
			tf.setText("");
			cal();
			quo = false ;
			mAdd = false;
			mMinus = false;
			cross = false ;
			add = false ;
			subtract = false ;
			remainder = false;
			
		});
        
        //0
        Button bt26 = new Button("0");
        gridpane.add(bt26,1,21,2,1);
        bt26.setMinSize(88,40);
        bt26.setOnAction(e -> {
                        if(result == true || tf.getText().equals("0")){
                                            tf.setText("");
                                            result = false;
                                    }
			if(result == true && quo == false && remainder == false && subtract == false && add == false && cross == false && sq == false){
				number = 0;
			}
			
			tf.appendText("0");
		});
        
        //.
        Button bt27 = new Button(".");
        gridpane.add(bt27,3,21);
        bt27.setMinSize(42, 40);
        bt27.setOnAction(e -> {
			if(tf.getText().contains(".") == false){
				tf.appendText(".");
			}
		});
        
        //+
        Button bt28 = new Button("+");
        gridpane.add(bt28,4,21);
	bt28.setMinSize(42, 40);
        bt28.setOnAction(e -> {
			sq = false;
			if(number == 0){
				number = Double.parseDouble(tf.getText());
				tf.setText("");
			}else{
				n = Double.parseDouble(tf.getText());
				tf.setText("");			
				cal();								
			}
			cross = false ;
			add = true ;
			subtract = false ;
			remainder = false; 
			quo = false ;
			
		});
        
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        
    }
    public void cal(){
		if(sq == true){
			n = Math.sqrt(n);
			tf.setText(Double.toString(n));
		}else if(inverseNumber == true){
			n = 1/n ;
			
			tf.setText(Double.toString(n));
		}else if(quo == true){
			bd1 = new BigDecimal(number);
			bd2 = new BigDecimal(n);
			number = bd1.divide(bd2).doubleValue();
			tf.setText(Double.toString(number));
		}else if(remainder == true){
			bd1 = new BigDecimal(number);
			bd2 = new BigDecimal(n);
			number = bd1.remainder(bd2).doubleValue() ;
			tf.setText(Double.toString(number));
		}else if(cross == true){
			bd1 = new BigDecimal(number);
			bd2 = new BigDecimal(n);
			number = bd1.multiply(bd2).doubleValue();
			tf.setText(Double.toString(number));
		}else if(subtract == true){
			bd1 = new BigDecimal(number);
			bd2 = new BigDecimal(n);
			number = bd1.subtract(bd2).doubleValue();
			tf.setText(Double.toString(number));
		}else if(add == true){
			bd1 = new BigDecimal(number);
			bd2 = new BigDecimal(n);
			number = bd1.add(bd2).doubleValue();
			tf.setText(Double.toString(number));
		}else if(isMR == true && mAdd == true){
			mRAdd = mR;
			while(arrayList.size()>=1){
				mRAdd = mRAdd + arrayList.get(0);
				arrayList.remove(0);
			}
			number = mRAdd ;
			tf.setText(Double.toString(mRAdd));
		}else if(isMR == true && mMinus == true){
			mRMinus = mR ;
			while(arrayList.size()>=1){
				mRMinus = mRMinus - arrayList.get(0);
				arrayList.remove(0);
			}
			number = mRMinus ; 
			tf.setText(Double.toString(mRMinus));
		}
		result = true ;		
	}
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}