/*
 * This file is generated by jOOQ.
*/
package db.tables;


import db.Indexes;
import db.Keys;
import db.Public;
import db.tables.records.SharedUrlRevRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SharedUrlRev extends TableImpl<SharedUrlRevRecord> {

    private static final long serialVersionUID = 852725850;

    /**
     * The reference instance of <code>public.shared_url_rev</code>
     */
    public static final SharedUrlRev SHARED_URL_REV = new SharedUrlRev();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SharedUrlRevRecord> getRecordType() {
        return SharedUrlRevRecord.class;
    }

    /**
     * The column <code>public.shared_url_rev.version</code>.
     */
    public final TableField<SharedUrlRevRecord, Integer> VERSION = createField("version", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.shared_url_rev.description</code>.
     */
    public final TableField<SharedUrlRevRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.shared_url_rev.created_on</code>.
     */
    public final TableField<SharedUrlRevRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>public.shared_url_rev</code> table reference
     */
    public SharedUrlRev() {
        this(DSL.name("shared_url_rev"), null);
    }

    /**
     * Create an aliased <code>public.shared_url_rev</code> table reference
     */
    public SharedUrlRev(String alias) {
        this(DSL.name(alias), SHARED_URL_REV);
    }

    /**
     * Create an aliased <code>public.shared_url_rev</code> table reference
     */
    public SharedUrlRev(Name alias) {
        this(alias, SHARED_URL_REV);
    }

    private SharedUrlRev(Name alias, Table<SharedUrlRevRecord> aliased) {
        this(alias, aliased, null);
    }

    private SharedUrlRev(Name alias, Table<SharedUrlRevRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SHARED_URL_REV_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SharedUrlRevRecord> getPrimaryKey() {
        return Keys.SHARED_URL_REV_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SharedUrlRevRecord>> getKeys() {
        return Arrays.<UniqueKey<SharedUrlRevRecord>>asList(Keys.SHARED_URL_REV_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SharedUrlRev as(String alias) {
        return new SharedUrlRev(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SharedUrlRev as(Name alias) {
        return new SharedUrlRev(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SharedUrlRev rename(String name) {
        return new SharedUrlRev(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SharedUrlRev rename(Name name) {
        return new SharedUrlRev(name, null);
    }
}