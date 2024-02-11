package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomMoviePicker moviePicker = new RandomMoviePicker();
        Movie [] movies = moviePicker.getRandMovieNames();

        for (int i = 0; i < movies.length; i++){
            int number = i + 1;
            System.out.println(number + ": " + movies[i].name + "(" + movies[i].yar + ") ");
        }
        System.out.println("Выберите номер фильма: ");
        Scanner sc = new Scanner(System.in);
        int choseNumber = sc.nextInt();
        int choseIndex = choseNumber -1;
        ITuesMoviePlayer player = new ITuesMoviePlayer();
        player.playMovie(movies[choseIndex].name);



    }
}


/*ITuesMoviePlayer player = new ITuesMoviePlayer();
       player.playMovie("Terminator");*/

/* Printer printer = new Printer("Hp", 100);
        FileInformation fileInformation = new FileInformation("text.txt", "C:/", 1000);
        Cat cat = new Cat("Vasya", 3);
*/