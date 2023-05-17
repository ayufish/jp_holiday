package com.windyu;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    private static final String charSetJapanese = "Shift_JIS";
    public static void main(String[] args) throws Exception {
        downloadJpHol();
    }

    static void downloadJpHol() throws Exception {
        // read csv from url
        URL url = new URL("https://www8.cao.go.jp/chosei/shukujitsu/syukujitsu.csv");
        Scanner s = new Scanner(url.openStream(), "Shift_JIS");
        while (s.hasNext()){
            System.out.println(s.next());
        }
    }
}
