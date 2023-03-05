package com.steps;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

public class YouTubeSearch {
    public static void main(String[] args) {
        try {
            // Create a URI for the YouTube search
            String searchString = "Romeo Santos";
            String encodedSearchString = URLEncoder.encode(searchString, "UTF-8");
            URI searchUri = new URI("https://www.youtube.com/results?search_query=" + encodedSearchString);

            // Open the YouTube search in the default web browser
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(searchUri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

