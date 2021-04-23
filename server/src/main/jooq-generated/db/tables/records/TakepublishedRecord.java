/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Takepublished;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TakepublishedRecord extends UpdatableRecordImpl<TakepublishedRecord> implements Record15<Integer, Integer, String, String, JSONB, LocalDateTime, String, LocalDateTime, String, Integer, Integer, Integer, Integer, Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.takepublished.id</code>.
     */
    public TakepublishedRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.takepublished.user_id</code>.
     */
    public TakepublishedRecord setUserId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.takepublished.title</code>.
     */
    public TakepublishedRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.takepublished.title_slug</code>.
     */
    public TakepublishedRecord setTitleSlug(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.title_slug</code>.
     */
    public String getTitleSlug() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.takepublished.blocks</code>.
     */
    public TakepublishedRecord setBlocks(JSONB value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.blocks</code>.
     */
    public JSONB getBlocks() {
        return (JSONB) get(4);
    }

    /**
     * Setter for <code>public.takepublished.published_at</code>.
     */
    public TakepublishedRecord setPublishedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.published_at</code>.
     */
    public LocalDateTime getPublishedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.takepublished.published_ip</code>.
     */
    public TakepublishedRecord setPublishedIp(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.published_ip</code>.
     */
    public String getPublishedIp() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.takepublished.deleted_at</code>.
     */
    public TakepublishedRecord setDeletedAt(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.deleted_at</code>.
     */
    public LocalDateTime getDeletedAt() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.takepublished.deleted_ip</code>.
     */
    public TakepublishedRecord setDeletedIp(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.deleted_ip</code>.
     */
    public String getDeletedIp() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.takepublished.count_view</code>.
     */
    public TakepublishedRecord setCountView(Integer value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_view</code>.
     */
    public Integer getCountView() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.takepublished.count_like</code>.
     */
    public TakepublishedRecord setCountLike(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_like</code>.
     */
    public Integer getCountLike() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>public.takepublished.count_bookmark</code>.
     */
    public TakepublishedRecord setCountBookmark(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_bookmark</code>.
     */
    public Integer getCountBookmark() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>public.takepublished.count_spam</code>.
     */
    public TakepublishedRecord setCountSpam(Integer value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_spam</code>.
     */
    public Integer getCountSpam() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>public.takepublished.count_illegal</code>.
     */
    public TakepublishedRecord setCountIllegal(Integer value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_illegal</code>.
     */
    public Integer getCountIllegal() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>public.takepublished.image_url</code>.
     */
    public TakepublishedRecord setImageUrl(String value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Integer, Integer, String, String, JSONB, LocalDateTime, String, LocalDateTime, String, Integer, Integer, Integer, Integer, Integer, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Integer, Integer, String, String, JSONB, LocalDateTime, String, LocalDateTime, String, Integer, Integer, Integer, Integer, Integer, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Takepublished.TAKEPUBLISHED.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Takepublished.TAKEPUBLISHED.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return Takepublished.TAKEPUBLISHED.TITLE;
    }

    @Override
    public Field<String> field4() {
        return Takepublished.TAKEPUBLISHED.TITLE_SLUG;
    }

    @Override
    public Field<JSONB> field5() {
        return Takepublished.TAKEPUBLISHED.BLOCKS;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Takepublished.TAKEPUBLISHED.PUBLISHED_AT;
    }

    @Override
    public Field<String> field7() {
        return Takepublished.TAKEPUBLISHED.PUBLISHED_IP;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return Takepublished.TAKEPUBLISHED.DELETED_AT;
    }

    @Override
    public Field<String> field9() {
        return Takepublished.TAKEPUBLISHED.DELETED_IP;
    }

    @Override
    public Field<Integer> field10() {
        return Takepublished.TAKEPUBLISHED.COUNT_VIEW;
    }

    @Override
    public Field<Integer> field11() {
        return Takepublished.TAKEPUBLISHED.COUNT_LIKE;
    }

    @Override
    public Field<Integer> field12() {
        return Takepublished.TAKEPUBLISHED.COUNT_BOOKMARK;
    }

    @Override
    public Field<Integer> field13() {
        return Takepublished.TAKEPUBLISHED.COUNT_SPAM;
    }

    @Override
    public Field<Integer> field14() {
        return Takepublished.TAKEPUBLISHED.COUNT_ILLEGAL;
    }

    @Override
    public Field<String> field15() {
        return Takepublished.TAKEPUBLISHED.IMAGE_URL;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getTitle();
    }

    @Override
    public String component4() {
        return getTitleSlug();
    }

    @Override
    public JSONB component5() {
        return getBlocks();
    }

    @Override
    public LocalDateTime component6() {
        return getPublishedAt();
    }

    @Override
    public String component7() {
        return getPublishedIp();
    }

    @Override
    public LocalDateTime component8() {
        return getDeletedAt();
    }

    @Override
    public String component9() {
        return getDeletedIp();
    }

    @Override
    public Integer component10() {
        return getCountView();
    }

    @Override
    public Integer component11() {
        return getCountLike();
    }

    @Override
    public Integer component12() {
        return getCountBookmark();
    }

    @Override
    public Integer component13() {
        return getCountSpam();
    }

    @Override
    public Integer component14() {
        return getCountIllegal();
    }

    @Override
    public String component15() {
        return getImageUrl();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getTitle();
    }

    @Override
    public String value4() {
        return getTitleSlug();
    }

    @Override
    public JSONB value5() {
        return getBlocks();
    }

    @Override
    public LocalDateTime value6() {
        return getPublishedAt();
    }

    @Override
    public String value7() {
        return getPublishedIp();
    }

    @Override
    public LocalDateTime value8() {
        return getDeletedAt();
    }

    @Override
    public String value9() {
        return getDeletedIp();
    }

    @Override
    public Integer value10() {
        return getCountView();
    }

    @Override
    public Integer value11() {
        return getCountLike();
    }

    @Override
    public Integer value12() {
        return getCountBookmark();
    }

    @Override
    public Integer value13() {
        return getCountSpam();
    }

    @Override
    public Integer value14() {
        return getCountIllegal();
    }

    @Override
    public String value15() {
        return getImageUrl();
    }

    @Override
    public TakepublishedRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TakepublishedRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public TakepublishedRecord value3(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public TakepublishedRecord value4(String value) {
        setTitleSlug(value);
        return this;
    }

    @Override
    public TakepublishedRecord value5(JSONB value) {
        setBlocks(value);
        return this;
    }

    @Override
    public TakepublishedRecord value6(LocalDateTime value) {
        setPublishedAt(value);
        return this;
    }

    @Override
    public TakepublishedRecord value7(String value) {
        setPublishedIp(value);
        return this;
    }

    @Override
    public TakepublishedRecord value8(LocalDateTime value) {
        setDeletedAt(value);
        return this;
    }

    @Override
    public TakepublishedRecord value9(String value) {
        setDeletedIp(value);
        return this;
    }

    @Override
    public TakepublishedRecord value10(Integer value) {
        setCountView(value);
        return this;
    }

    @Override
    public TakepublishedRecord value11(Integer value) {
        setCountLike(value);
        return this;
    }

    @Override
    public TakepublishedRecord value12(Integer value) {
        setCountBookmark(value);
        return this;
    }

    @Override
    public TakepublishedRecord value13(Integer value) {
        setCountSpam(value);
        return this;
    }

    @Override
    public TakepublishedRecord value14(Integer value) {
        setCountIllegal(value);
        return this;
    }

    @Override
    public TakepublishedRecord value15(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public TakepublishedRecord values(Integer value1, Integer value2, String value3, String value4, JSONB value5, LocalDateTime value6, String value7, LocalDateTime value8, String value9, Integer value10, Integer value11, Integer value12, Integer value13, Integer value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TakepublishedRecord
     */
    public TakepublishedRecord() {
        super(Takepublished.TAKEPUBLISHED);
    }

    /**
     * Create a detached, initialised TakepublishedRecord
     */
    public TakepublishedRecord(Integer id, Integer userId, String title, String titleSlug, JSONB blocks, LocalDateTime publishedAt, String publishedIp, LocalDateTime deletedAt, String deletedIp, Integer countView, Integer countLike, Integer countBookmark, Integer countSpam, Integer countIllegal, String imageUrl) {
        super(Takepublished.TAKEPUBLISHED);

        setId(id);
        setUserId(userId);
        setTitle(title);
        setTitleSlug(titleSlug);
        setBlocks(blocks);
        setPublishedAt(publishedAt);
        setPublishedIp(publishedIp);
        setDeletedAt(deletedAt);
        setDeletedIp(deletedIp);
        setCountView(countView);
        setCountLike(countLike);
        setCountBookmark(countBookmark);
        setCountSpam(countSpam);
        setCountIllegal(countIllegal);
        setImageUrl(imageUrl);
    }
}
