/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.tables.records.FollowRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class Follow extends TableImpl<FollowRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.follow</code>
     */
    public static final Follow FOLLOW = new Follow();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FollowRecord> getRecordType() {
        return FollowRecord.class;
    }

    /**
     * The column <code>public.follow.author</code>.
     */
    public final TableField<FollowRecord, Integer> AUTHOR = createField(DSL.name("author"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.follow.follower</code>.
     */
    public final TableField<FollowRecord, Integer> FOLLOWER = createField(DSL.name("follower"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.follow.followed_at</code>.
     */
    public final TableField<FollowRecord, LocalDateTime> FOLLOWED_AT = createField(DSL.name("followed_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private Follow(Name alias, Table<FollowRecord> aliased) {
        this(alias, aliased, null);
    }

    private Follow(Name alias, Table<FollowRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.follow</code> table reference
     */
    public Follow(String alias) {
        this(DSL.name(alias), FOLLOW);
    }

    /**
     * Create an aliased <code>public.follow</code> table reference
     */
    public Follow(Name alias) {
        this(alias, FOLLOW);
    }

    /**
     * Create a <code>public.follow</code> table reference
     */
    public Follow() {
        this(DSL.name("follow"), null);
    }

    public <O extends Record> Follow(Table<O> child, ForeignKey<O, FollowRecord> key) {
        super(child, key, FOLLOW);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<FollowRecord> getPrimaryKey() {
        return Keys.FOLLOW_PKEY;
    }

    @Override
    public List<UniqueKey<FollowRecord>> getKeys() {
        return Arrays.<UniqueKey<FollowRecord>>asList(Keys.FOLLOW_PKEY);
    }

    @Override
    public List<ForeignKey<FollowRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FollowRecord, ?>>asList(Keys.FOLLOW__FOLLOW_AUTHOR_FKEY, Keys.FOLLOW__FOLLOW_FOLLOWER_FKEY);
    }

    private transient Account _followAuthorFkey;
    private transient Account _followFollowerFkey;

    public Account followAuthorFkey() {
        if (_followAuthorFkey == null)
            _followAuthorFkey = new Account(this, Keys.FOLLOW__FOLLOW_AUTHOR_FKEY);

        return _followAuthorFkey;
    }

    public Account followFollowerFkey() {
        if (_followFollowerFkey == null)
            _followFollowerFkey = new Account(this, Keys.FOLLOW__FOLLOW_FOLLOWER_FKEY);

        return _followFollowerFkey;
    }

    @Override
    public Follow as(String alias) {
        return new Follow(DSL.name(alias), this);
    }

    @Override
    public Follow as(Name alias) {
        return new Follow(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Follow rename(String name) {
        return new Follow(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Follow rename(Name name) {
        return new Follow(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
