package org.example;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ITuesMoviePlayer {
    PageDownloader downloader = new PageDownloader();


     void playMovie(String searchRequest ) throws IOException {
        String url = buildUrl(searchRequest);
        String page = downloader.downloadWebPage(url);
         int count = 0;
        String movieName = getTag(page, "trackName");
        String previewUrl = getTag(page, "previewUrl");
        // System.out.println(page);
        System.out.println(movieName);
        String fileExtensions = previewUrl.substring(previewUrl.length()-12);
        String fileName = movieName + "." + fileExtensions;
         count++;
        try (InputStream in = new URL(previewUrl).openStream()){

            Files.copy(in, Paths.get(fileName));

        }
        System.out.println("Готово!");

       /* if (!Desktop.isDesktopSupported()) {
            System.out.println("Файл не доступен для воспроизведения");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File(fileName);
        desktop.open(file);
 */
    }

    private String getTag(String page, String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"", start);
        String value = page.substring(start, end);
        return value;
    }

    private static String buildUrl(String term) {
        int limit = 50;
        String termWithoutSpaces = term.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=" + limit;
        String mediaParam = "&media=movie";
        StringBuilder builder = new StringBuilder();
        builder.append(itunesApi);
        builder.append(termWithoutSpaces);
        builder.append(limitParam);
        builder.append(mediaParam);
        // String url = itunesApi + termWithoutSpaces + limitParam;
        return builder.toString();
    }
    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();

    }
}
