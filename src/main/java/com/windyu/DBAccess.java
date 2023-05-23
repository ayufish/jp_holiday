package com.windyu;

import com.windyu.jooq.model.tables.JpHoliday;
import com.windyu.jooq.model.tables.records.JpHolidayRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBAccess {
    static DSLContext getDSLContext() throws SQLException {
        String userName = "yuguanhua";
        String password = "";
        String url = "jdbc:postgresql://localhost:5432/yuguanhua";
        Connection conn = DriverManager.getConnection(url, userName, password);

        // entry point for JOOQ
        return DSL.using(conn, SQLDialect.POSTGRES);
    }
}
