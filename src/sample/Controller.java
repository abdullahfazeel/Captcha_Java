package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Invalidate implements Score , SimpleCaptcha{
    private Stage stage;
    private Scene scene;
    private Parent root;


// fx ids of Anchorpane being used
    @FXML
    private AnchorPane AP1;

//fx ids of ImageViews
    @FXML
    private ImageView ImageV1 ;
    @FXML
    private ImageView ImageV2 ;
    @FXML
    private ImageView ImageV3 ;
    @FXML
    private ImageView ImageV4 ;
    @FXML
    private ImageView ImageV5 ;
    @FXML
    private ImageView ImageV6 ;
    @FXML
    private ImageView ImageV7 ;
    @FXML
    private ImageView ImageV8 ;
    @FXML
    private ImageView ImageV9 ;
    @FXML
    private ImageView InstructionImage1;

//fx ids of check boxes
    @FXML
    private CheckBox CB1;
    @FXML
    private CheckBox CB2;
    @FXML
    private CheckBox CB3;
    @FXML
    private CheckBox CB4;
    @FXML
    private CheckBox CB5;
    @FXML
    private CheckBox CB6;
    @FXML
    private CheckBox CB7;
    @FXML
    private CheckBox CB8;
    @FXML
    private CheckBox CB9;

    // fx ids of Labels
   @FXML
   private Label toSelectLbl;
   @FXML
   private Label readyToPlayLbl;
   @FXML
   private Label rightLbl;
   @FXML
   private Label wrongLbl;
   @FXML
   private Label scoreLbl;
   @FXML
   private Label totalWrongLbl;
   @FXML
   private Label finalScore;
   @FXML
   private Label captchaLbl;
   @FXML
   private Label captchaCheckLbl;

    // fx ids of Buttons
   @FXML
   private Button go;
   @FXML
   private Button readInstructionBTN;
   @FXML
   private Button InstMenu;
   @FXML
    private Button modeBTN;
    @FXML
    private Button submitBTN;
    @FXML
    private Button buttonNew;
    @FXML
    private Button showScoreBTN;
    @FXML
    private Button endMenu;

    // fx ids of Text Areas
   @FXML
   private TextArea InstructionTA;
    @FXML
    private TextArea  InstructionDarkTA;
    @FXML
    private TextArea aboutDarkTA;
    @FXML
    private TextArea highScoreTA;
    @FXML
    private TextArea AboutTA;
    @FXML
    private TextArea highScoreDarkTA;

    // fx ids of Text Field
    @FXML
    private TextField TFCaptcha;


    public int[] displayImagesNames = new int[9]; // it'll store the names of images being displayed on screen.
    private String catToSelect; // It'll store the pictures category to select.

    private static int score ; // It'll store the score
    private static int totalWrong;// It'll store the total wrong images selected by user.
    private static String mode = "light";// It'll used to store which mode is being used.

    public String getCatToSelect() { // getter for catToSelect
        return catToSelect;
    }

    public void setCatToSelect(String catToSelect) { //setter  for catToSelect
        this.catToSelect = catToSelect;
    }

    public static int getScore() { //getter for Score
        return score;
    }

    public static void setScore(int score) { //setter for score
        Controller.score = score;
    }

    public static int getTotalWrong() {//getter for totalWrong
        return totalWrong;
    }

    public static void setTotalWrong(int totalWrong) { //setter for totalWrong
        Controller.totalWrong = totalWrong;
    }

    public static String getMode() { //getter for mode
        return mode;
    }

    public static void setMode(String mode) { //setter for mode
        Controller.mode = mode;
    }


    //This method will give the number of images selected by the user
    public int getNumOfSelectedImgs(){
        int count = 0;
        if(CB1.isSelected())
            count++;
        if(CB2.isSelected())
            count++;
        if(CB3.isSelected())
            count++;
        if(CB4.isSelected())
            count++;
        if(CB5.isSelected())
            count++;
        if(CB6.isSelected())
            count++;
        if(CB7.isSelected())
            count++;
        if(CB8.isSelected())
            count++;
        if(CB9.isSelected())
            count++;

        return count;
    }


    // This method will give the name of selected image.
    @FXML
    public int[] getSelectedImages( int[] displayImagesNames ){


        int number = getNumOfSelectedImgs(); // storing number of selected images

        int[] selectedImagesNames = new int[number];

        // Checking which check box are selected and then getting the name of the images being shown on the respective
        //image view and store it in the selectedImagesNames array.
        for (int i = 0; i < number; i++) {
            if (CB1.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[0])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[0];
            }
            if (CB2.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[1])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[1];
            }
            if (CB3.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[2])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[2];
            }
            if (CB4.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[3])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[3];
            }
            if (CB5.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[4])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[4];
            }
            if (CB6.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[5])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[5];
            }
            if (CB7.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[6])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[6];
            }
            if (CB8.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[7])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[7];
            }
            if (CB9.isSelected())
            {
                int check = 0;
                for (int j = 0; j < number ; j++) {
                    if(selectedImagesNames[j] == displayImagesNames[8])
                        check = 1;
                }
                if(check == 0)
                    selectedImagesNames[i] = displayImagesNames[8];
            }

        }
        return selectedImagesNames;
    }


    // This function will display the images in image views
    @FXML
    public void displayImages(ActionEvent event) throws Exception {

        submitBTN.setVisible(true);
        Random random = new Random();
        int category = random.nextInt(45); // storing a random number in category variable to ask user to select the images
                                                    // that category.


        String[] imageCatalog = getImageCatalog(); // Storing the category of all the images.

        setCatToSelect(imageCatalog[category]);
        toSelectLbl.setText(getCatToSelect().toUpperCase(Locale.ROOT));

        generateRandomNumber(displayImagesNames); // Generating 9 randoms number to choose the images to be displayed.

        //Setting the images on respective Image view.
        for (int i = 0; i < 9; i++) {
            String name =  String.valueOf(displayImagesNames[i]); // storing the name of images to display them on image view

            //Creating image object
            Image img = new Image(getClass().getResourceAsStream("img/" + name + ".jpg"));

            if(i == 0) {
                ImageV1.setImage(img);
                CB1.setSelected(false);
            }
            else if(i == 1){
                ImageV2.setImage(img);
                CB2.setSelected(false);
            }
            else if(i == 2){
                ImageV3.setImage(img);
                CB3.setSelected(false);
            }
            else if(i == 3){
                ImageV4.setImage(img);
                CB4.setSelected(false);
            }
            else if(i == 4){
                ImageV5.setImage(img);
                CB5.setSelected(false);
            }
            else if(i == 5){
                ImageV6.setImage(img);
                CB6.setSelected(false);
            }
            else if(i == 6){
                ImageV7.setImage(img);
                CB7.setSelected(false);
            }
            else if(i == 7){
                ImageV8.setImage(img);
                CB8.setSelected(false);
            }
            else if(i == 8){
                ImageV9.setImage(img);
                CB9.setSelected(false);
            }
        }

        readyToPlayLbl.setVisible(false);
        go.setVisible(false);

    }


    // This method will check that how much images user has selected correct.
    @FXML
    public void submit(ActionEvent event) throws Exception {

        int[] selectedImagesNames =  getSelectedImages(displayImagesNames); // Getting the names of selected images.

        int right = check(getCatToSelect() , selectedImagesNames);//Getting the number of images that are selected correct.
        rightLbl.setText(String.valueOf(right));

        int wrong = getNumOfSelectedImgs() - right; // Determining the images that are wrong selected.
        wrongLbl.setText(String.valueOf(wrong));

        setScore(getScore() + (right*5) - (wrong*3)); // Setting the score.
        scoreLbl.setText(String.valueOf(getScore()));
        setTotalWrong(getTotalWrong() + wrong);

        totalWrongLbl.setText(String.valueOf(getTotalWrong()));

        gameEnd(event);
        displayImages(event);
    }


    // Checking if the number of wrong selections become 5 or more.
    @FXML
    public void gameEnd(ActionEvent event) throws Exception {
        if(getTotalWrong() >= 5)
        {
            switchToGameEnd(event);
        }
    }


    @FXML
    public void changeMode(ActionEvent event) throws IOException {

        if(modeBTN.getText().equals("Dark Mode")){
            setMode("dark");
            modeBTN.setText("Light Mode");
        }
        else if(modeBTN.getText().equals("Light Mode") ){
            setMode("light");
            modeBTN.setText("Dark Mode");
        }

        switchToMenu(event);

    }

    @FXML
    public void switchToGameFX(ActionEvent event) throws IOException {
        Parent root ;
        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("gameDarkFX.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("gameFX.fxml"));

        }
        System.out.println("Changing scnene.....");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setY(5);
        stage.setX(400);
        stage.show();

        setScore(0);
        setTotalWrong(0);
    }



    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root ;
        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("menuDarkFX.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("menuFX.fxml"));

        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setY(18);
        stage.setX(400);
        stage.show();
    }


    @FXML
    public void switchToInstruction(ActionEvent event) throws Exception {
        System.out.println("Changing scnene.....");
        Parent root ;
        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("InstructionDarkFX.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("InstructionFX.fxml"));

        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToGameEnd(ActionEvent event) throws Exception {
        System.out.println("Changing scnene.....");
        Parent root = FXMLLoader.load(getClass().getResource("gameEndFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAboutUs(ActionEvent event) throws Exception {
        System.out.println("Changing scnene.....");
        Parent root ;

        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("aboutDarkFX.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("aboutFX.fxml"));
        }
//        Parent root = FXMLLoader.load(getClass().getResource("aboutFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToHighScore(ActionEvent event) throws IOException {
        System.out.println("Changing scnene.....");
        Parent root ;
        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("highScoreDark.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("highScore.fxml"));
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }





    @FXML
    public void switchToSelectGame(ActionEvent event) throws IOException {
        System.out.println("Changing scnene.....");
        Parent root;
        if(getMode().equals("dark")){
            System.out.println("Changing to dark");
            root = FXMLLoader.load(getClass().getResource("selectGameDark.fxml"));
        }
        else{
            System.out.println("Changing to light");
            root = FXMLLoader.load(getClass().getResource("selectGame.fxml"));
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setX(450);
        stage.setY(200);
        stage.show();
    }

    @FXML
    public void switchScene(ActionEvent event ) throws IOException {
        System.out.println("Changing scnene.....");
        Parent root = FXMLLoader.load(getClass().getResource("xyz.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSimpleCaptcha(ActionEvent event ) throws IOException {
        System.out.println("Changing scnene.....");
        Parent window = FXMLLoader.load(getClass().getResource("simpleCaptchaFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(window);
        stage.setScene(scene);
        stage.setY(150);
        stage.show();
    }



    //Reading instructions from text file
    @FXML
    public void getInstructions() throws Exception {
        readInstructionBTN.setVisible(false);
        InstructionImage1.setVisible(false);

        File myFile = new File("instructions.txt"); // creating a file object
        Scanner reader = new Scanner(myFile); //  creating a scanner
        String[] data = new String[200];
        String fullData = new String();

        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();// reading file line by line
            fullData += data[counter] + System.lineSeparator();// storing all the lines in one string
            counter++;
        }
        if(getMode().equals("light"))
            InstructionTA.setText(fullData);
        else
            InstructionDarkTA.setText(fullData);

    }



    // Saving score in file
    @FXML
    public void saveScore() throws FileNotFoundException {

        int[] allScore = new int[10];
        File binaryFile = new File("score.txt"); // creating file obj.
        Scanner reader = new Scanner(binaryFile); // creating scanner
        String[] data = new String[10];

        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();
            counter++;

        }
        for (int i = 0; i < 10 ; i++) {
            allScore[i] = Integer.parseInt(data[i]); // Converting string to int.
        }

        descendingSort(allScore);// sorting array
        if(getScore() > allScore[9]){
            allScore[9] = getScore(); //checking if the the current score of user is greater than the lowest stored score
            descendingSort(allScore); // sorting array
        }

        //Writing the sorted array back in file
        try {
            FileWriter Writer = new FileWriter("score.txt");
            for (int i = 0; i < 10; i++) {
                Writer.write(String.valueOf(allScore[i])+ System.lineSeparator());
            }
            Writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    public void showScore() throws FileNotFoundException {
        finalScore.setText(String.valueOf(getScore()));
        showScoreBTN.setVisible(false);
        endMenu.setVisible(true);
        saveScore();
    }

    @FXML
    public void showHighScore(ActionEvent event) throws IOException {

        File binaryFile = new File("score.txt");
        Scanner reader = new Scanner(binaryFile);
        String[] data = new String[10];
        String fullData = new String();

        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();
            fullData += data[counter] + System.lineSeparator();
            counter++;


        }
        if(getMode().equals("light"))
            highScoreTA.setText(fullData);
        else if(getMode().equals("dark"))
            highScoreDarkTA.setText(fullData);

    }


    public static void descendingSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] < a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    @Override
    public void checkCaptcha(){
        if(captchaLbl.getText().equals(TFCaptcha.getText())  && captchaLbl.getText().length() == TFCaptcha.getText().length())
        {
            TFCaptcha.clear();
            captchaCheckLbl.setText("Right");
        }
        else
            captchaCheckLbl.setText("Wrong");
    }

    public void loadSimpleCaptcha(){
        captchaLbl.setText(generateCaptcha());
    }

    @Override
    public String generateCaptcha() {
        {
            String captchaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            String captcha = "";
            for (int i = 0; i < 7; i++) {
                int index = (int) (Math.random() * captchaString.length());
                captcha = captcha + captchaString.charAt(index);
            }
            return captcha;
        }
    }

    // Method to be used with exit button
    Stage stagex;
    public void exit(ActionEvent event){

        stagex = (Stage) AP1.getScene().getWindow();

        stagex.close();
    }
}
