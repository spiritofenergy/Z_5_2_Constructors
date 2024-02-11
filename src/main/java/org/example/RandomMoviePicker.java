package org.example;

public class RandomMoviePicker {
    PageDownloader downloader = new PageDownloader();
    Movie [] getRandMovieNames(){
        String url = "https://randommer.io/random-movies";
        String page = this.downloader.downloadWebPage(url);
        Movie movies[] = new Movie[5];
        int endIndex = 0;
        for(int i = 0; i < 5; i++){
            int captionIndex = page.indexOf("div class=\"caption\"", endIndex);
            int startIndex = captionIndex + 51;
            endIndex = page.indexOf("</p>", startIndex - 18);

            String movieName = page.substring(startIndex, endIndex);
            String nameWithoutYear = movieName.substring(0, movieName.length()-6);
         //   System.out.println(page.substring(startIndex, endIndex));
            String yar = page.substring(movieName.length()-5, movieName.length()-1);
            movies[i] = new Movie(nameWithoutYear, yar);
        }
        return movies;
    }
}
