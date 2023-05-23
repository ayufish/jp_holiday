package com.windyu;

import com.windyu.jooq.model.tables.JpHoliday;
import com.windyu.jooq.model.tables.records.JpHolidayRecord;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        var dslCtx = DBAccess.getDSLContext();
        var holList = new ArrayList<JpHolidayRecord>();

        // ignore first line
        s.next();
        while (s.hasNext()){
            String[] line = s.next().split(",");
            LocalDate date = LocalDate.parse(line[0], DateTimeFormatter.ofPattern("yyyy/M/d"));
            var name = line[1];

            var hol = dslCtx.newRecord(JpHoliday.JP_HOLIDAY);
            hol.setHolDate(date);
            hol.setHolName(name);
            holList.add(hol);
        }

        dslCtx.batchStore(holList).execute();
    }
}
