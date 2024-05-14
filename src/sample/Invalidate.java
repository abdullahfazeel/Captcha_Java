package sample;

import javafx.event.ActionEvent;


public abstract class Invalidate extends ShowImages{



    public static int check(String catToSelect, int[] selectedImagesNames) {

        int right = 0;
        for (int i = 0; i < selectedImagesNames.length; i++) {

            if (selectedImagesNames[i] >= 0 && selectedImagesNames[i] <= 5 && catToSelect == "bike")
                right++;
            else if (selectedImagesNames[i] >= 6 && selectedImagesNames[i] <= 10 && catToSelect == "book")
                right++;
            else if (selectedImagesNames[i] >= 11 && selectedImagesNames[i] <= 15 && catToSelect == "bridge")
                right++;
            else if (selectedImagesNames[i] >= 16 && selectedImagesNames[i] <= 20 && catToSelect == "car")
                right++;
            else if (selectedImagesNames[i] >= 21 && selectedImagesNames[i] <= 25 && catToSelect == "flower")
                right++;
            else if (selectedImagesNames[i] >= 26 && selectedImagesNames[i] <= 30 && catToSelect == "house")
                right++;
            else if (selectedImagesNames[i] >= 31 && selectedImagesNames[i] <= 35 && catToSelect == "road")
                right++;
            else if (selectedImagesNames[i] >= 36 && selectedImagesNames[i] <= 40 && catToSelect == "shop")
                right++;
            else if (selectedImagesNames[i] >= 41 && selectedImagesNames[i] <= 45 && catToSelect == "stationary")
                right++;
        }
        return right;
    }


    public abstract void submit(ActionEvent event) throws Exception;
    public abstract int getNumOfSelectedImgs();
    public abstract int[] getSelectedImages( int[] displayImagesNames );

}

