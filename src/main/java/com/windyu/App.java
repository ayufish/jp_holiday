package com.windyu;

import com.windyu.jooq.model.tables.JpHoliday;
import com.windyu.jooq.model.tables.records.JpHolidayRecord;

import java.net.URL;
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

        // get count of holiday table
        int dbCount = dslCtx.fetchCount(JpHoliday.JP_HOLIDAY);
        System.out.println(dbCount);

        // ignore first line
        s.next();
        var count = 0;
        while (s.hasNext()) {
            count++;
            var nextLine = s.next();
            // only insert data which is not in table(by comparing count)
            if (count > dbCount) {
                String[] line = nextLine.split(",");
                LocalDate date = LocalDate.parse(line[0], DateTimeFormatter.ofPattern("yyyy/M/d"));
                var name = line[1];

                var hol = dslCtx.newRecord(JpHoliday.JP_HOLIDAY);
                hol.setHolDate(date);
                hol.setHolName(name);
                holList.add(hol);
            }
        }

        dslCtx.batchStore(holList).execute();
    }
}
