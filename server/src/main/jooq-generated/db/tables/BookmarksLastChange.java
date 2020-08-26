/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.tables.records.BookmarksLastChangeRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookmarksLastChange extends TableImpl<BookmarksLastChangeRecord> {

    private static final long serialVersionUID = -302722478;

    /**
     * The reference instance of <code>public.bookmarks_last_change</code>
     */
    public static final BookmarksLastChange BOOKMARKS_LAST_CHANGE = new BookmarksLastChange();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookmarksLastChangeRecord> getRecordType() {
        return BookmarksLastChangeRecord.class;
    }

    /**
     * The column <code>public.bookmarks_last_change.saved_by</code>.
     */
    public final TableField<BookmarksLastChangeRecord, Integer> SAVED_BY = createField(DSL.name("saved_by"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.bookmarks_last_change.last_change</code>.
     */
    public final TableField<BookmarksLastChangeRecord, Timestamp> LAST_CHANGE = createField(DSL.name("last_change"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>public.bookmarks_last_change</code> table reference
     */
    public BookmarksLastChange() {
        this(DSL.name("bookmarks_last_change"), null);
    }

    /**
     * Create an aliased <code>public.bookmarks_last_change</code> table reference
     */
    public BookmarksLastChange(String alias) {
        this(DSL.name(alias), BOOKMARKS_LAST_CHANGE);
    }

    /**
     * Create an aliased <code>public.bookmarks_last_change</code> table reference
     */
    public BookmarksLastChange(Name alias) {
        this(alias, BOOKMARKS_LAST_CHANGE);
    }

    private BookmarksLastChange(Name alias, Table<BookmarksLastChangeRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookmarksLastChange(Name alias, Table<BookmarksLastChangeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> BookmarksLastChange(Table<O> child, ForeignKey<O, BookmarksLastChangeRecord> key) {
        super(child, key, BOOKMARKS_LAST_CHANGE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<BookmarksLastChangeRecord> getPrimaryKey() {
        return Keys.BOOKMARKS_LAST_CHANGE_PKEY;
    }

    @Override
    public List<UniqueKey<BookmarksLastChangeRecord>> getKeys() {
        return Arrays.<UniqueKey<BookmarksLastChangeRecord>>asList(Keys.BOOKMARKS_LAST_CHANGE_PKEY);
    }

    @Override
    public List<ForeignKey<BookmarksLastChangeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BookmarksLastChangeRecord, ?>>asList(Keys.BOOKMARKS_LAST_CHANGE__BOOKMARKS_LAST_CHANGE_SAVED_BY_FKEY);
    }

    public Account account() {
        return new Account(this, Keys.BOOKMARKS_LAST_CHANGE__BOOKMARKS_LAST_CHANGE_SAVED_BY_FKEY);
    }

    @Override
    public BookmarksLastChange as(String alias) {
        return new BookmarksLastChange(DSL.name(alias), this);
    }

    @Override
    public BookmarksLastChange as(Name alias) {
        return new BookmarksLastChange(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookmarksLastChange rename(String name) {
        return new BookmarksLastChange(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookmarksLastChange rename(Name name) {
        return new BookmarksLastChange(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Timestamp> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
