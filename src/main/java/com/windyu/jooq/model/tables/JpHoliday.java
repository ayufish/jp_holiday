/*
 * This file is generated by jOOQ.
 */
package com.windyu.jooq.model.tables;


import com.windyu.jooq.model.Keys;
import com.windyu.jooq.model.Public;
import com.windyu.jooq.model.tables.records.JpHolidayRecord;

import java.time.LocalDate;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JpHoliday extends TableImpl<JpHolidayRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.jp_holiday</code>
     */
    public static final JpHoliday JP_HOLIDAY = new JpHoliday();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JpHolidayRecord> getRecordType() {
        return JpHolidayRecord.class;
    }

    /**
     * The column <code>public.jp_holiday.hol_date</code>.
     */
    public final TableField<JpHolidayRecord, LocalDate> HOL_DATE = createField(DSL.name("hol_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>public.jp_holiday.hol_name</code>.
     */
    public final TableField<JpHolidayRecord, String> HOL_NAME = createField(DSL.name("hol_name"), SQLDataType.VARCHAR(10), this, "");

    private JpHoliday(Name alias, Table<JpHolidayRecord> aliased) {
        this(alias, aliased, null);
    }

    private JpHoliday(Name alias, Table<JpHolidayRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.jp_holiday</code> table reference
     */
    public JpHoliday(String alias) {
        this(DSL.name(alias), JP_HOLIDAY);
    }

    /**
     * Create an aliased <code>public.jp_holiday</code> table reference
     */
    public JpHoliday(Name alias) {
        this(alias, JP_HOLIDAY);
    }

    /**
     * Create a <code>public.jp_holiday</code> table reference
     */
    public JpHoliday() {
        this(DSL.name("jp_holiday"), null);
    }

    public <O extends Record> JpHoliday(Table<O> child, ForeignKey<O, JpHolidayRecord> key) {
        super(child, key, JP_HOLIDAY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<JpHolidayRecord> getPrimaryKey() {
        return Keys.JP_HOLIDAY_PKEY;
    }

    @Override
    public JpHoliday as(String alias) {
        return new JpHoliday(DSL.name(alias), this);
    }

    @Override
    public JpHoliday as(Name alias) {
        return new JpHoliday(alias, this);
    }

    @Override
    public JpHoliday as(Table<?> alias) {
        return new JpHoliday(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JpHoliday rename(String name) {
        return new JpHoliday(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JpHoliday rename(Name name) {
        return new JpHoliday(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JpHoliday rename(Table<?> name) {
        return new JpHoliday(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<LocalDate, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super LocalDate, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super LocalDate, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
