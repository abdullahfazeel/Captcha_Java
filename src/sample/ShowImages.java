package sample;

import javafx.event.ActionEvent;

import java.util.Random;

public abstract class ShowImages{




    public String[] getImageCatalog(){

        String[] names = new String[46];
        for (int i = 0; i <= 45 ; i++) {
            if(i <= 5)
                names[i] = "bike";
            else if(i <= 10)
                names[i] = "book";
            else if(i <= 15)
                names[i] = "bridge";
            else if(i <= 20)
                names[i] = "car";
            else if(i <= 25)
                names[i] = "flower";
            else if(i <= 30)
                names[i] = "house";
            else if(i <= 35)
                names[i] = "road";
            else if(i <= 40)
                names[i] = "shop";
            else if(i <= 45)
                names[i] = "stationary";
        }
        return names;
    }


    public void generateRandomNumber(int[] randNums) {
        Random ran = new Random();
        int rnum;
        for (int i = 0; i < 9; ) {
            int flag = 0;
            rnum = ran.nextInt(45);
            for (int j = 0; j < 9; j++) {
                if (randNums[j] == rnum)
                    flag = 1;
            }
            if (flag == 0) {
                randNums[i] = rnum;
                i++;

            }

        }
    }

    public abstract void displayImages(ActionEvent event) throws Exception;
}
