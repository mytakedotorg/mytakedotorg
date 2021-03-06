/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.bindings.PostgresInetBinding;
import db.tables.records.TakerevisionRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
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
public class Takerevision extends TableImpl<TakerevisionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.takerevision</code>
     */
    public static final Takerevision TAKEREVISION = new Takerevision();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TakerevisionRecord> getRecordType() {
        return TakerevisionRecord.class;
    }

    /**
     * The column <code>public.takerevision.id</code>.
     */
    public final TableField<TakerevisionRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.takerevision.parent_id</code>.
     */
    public final TableField<TakerevisionRecord, Integer> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.takerevision.created_at</code>.
     */
    public final TableField<TakerevisionRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.takerevision.created_ip</code>.
     */
    public final TableField<TakerevisionRecord, String> CREATED_IP = createField(DSL.name("created_ip"), org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"inet\"").nullable(false), this, "", new PostgresInetBinding());

    /**
     * The column <code>public.takerevision.title</code>.
     */
    public final TableField<TakerevisionRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.takerevision.blocks</code>.
     */
    public final TableField<TakerevisionRecord, JSONB> BLOCKS = createField(DSL.name("blocks"), SQLDataType.JSONB.nullable(false), this, "");

    private Takerevision(Name alias, Table<TakerevisionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Takerevision(Name alias, Table<TakerevisionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.takerevision</code> table reference
     */
    public Takerevision(String alias) {
        this(DSL.name(alias), TAKEREVISION);
    }

    /**
     * Create an aliased <code>public.takerevision</code> table reference
     */
    public Takerevision(Name alias) {
        this(alias, TAKEREVISION);
    }

    /**
     * Create a <code>public.takerevision</code> table reference
     */
    public Takerevision() {
        this(DSL.name("takerevision"), null);
    }

    public <O extends Record> Takerevision(Table<O> child, ForeignKey<O, TakerevisionRecord> key) {
        super(child, key, TAKEREVISION);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TakerevisionRecord, Integer> getIdentity() {
        return (Identity<TakerevisionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TakerevisionRecord> getPrimaryKey() {
        return Keys.TAKEREVISION_PKEY;
    }

    @Override
    public List<UniqueKey<TakerevisionRecord>> getKeys() {
        return Arrays.<UniqueKey<TakerevisionRecord>>asList(Keys.TAKEREVISION_PKEY);
    }

    @Override
    public List<ForeignKey<TakerevisionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TakerevisionRecord, ?>>asList(Keys.TAKEREVISION__TAKEREVISION_PARENT_ID_FKEY);
    }

    private transient Takerevision _takerevision;

    public Takerevision takerevision() {
        if (_takerevision == null)
            _takerevision = new Takerevision(this, Keys.TAKEREVISION__TAKEREVISION_PARENT_ID_FKEY);

        return _takerevision;
    }

    @Override
    public Takerevision as(String alias) {
        return new Takerevision(DSL.name(alias), this);
    }

    @Override
    public Takerevision as(Name alias) {
        return new Takerevision(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Takerevision rename(String name) {
        return new Takerevision(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Takerevision rename(Name name) {
        return new Takerevision(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, LocalDateTime, String, String, JSONB> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
