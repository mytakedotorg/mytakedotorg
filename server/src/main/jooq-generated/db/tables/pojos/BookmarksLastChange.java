/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookmarksLastChange implements Serializable {

    private static final long serialVersionUID = -548162832;

    private Integer   savedBy;
    private Timestamp lastChange;

    public BookmarksLastChange() {}

    public BookmarksLastChange(BookmarksLastChange value) {
        this.savedBy = value.savedBy;
        this.lastChange = value.lastChange;
    }

    public BookmarksLastChange(
        Integer   savedBy,
        Timestamp lastChange
    ) {
        this.savedBy = savedBy;
        this.lastChange = lastChange;
    }

    public Integer getSavedBy() {
        return this.savedBy;
    }

    public BookmarksLastChange setSavedBy(Integer savedBy) {
        this.savedBy = savedBy;
        return this;
    }

    public Timestamp getLastChange() {
        return this.lastChange;
    }

    public BookmarksLastChange setLastChange(Timestamp lastChange) {
        this.lastChange = lastChange;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BookmarksLastChange (");

        sb.append(savedBy);
        sb.append(", ").append(lastChange);

        sb.append(")");
        return sb.toString();
    }
}