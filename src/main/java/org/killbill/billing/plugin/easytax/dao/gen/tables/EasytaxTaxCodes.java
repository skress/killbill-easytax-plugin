/*
 * This file is generated by jOOQ.
 */
package org.killbill.billing.plugin.easytax.dao.gen.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.killbill.billing.plugin.easytax.dao.gen.Indexes;
import org.killbill.billing.plugin.easytax.dao.gen.Keys;
import org.killbill.billing.plugin.easytax.dao.gen.Public;
import org.killbill.billing.plugin.easytax.dao.gen.tables.records.EasytaxTaxCodesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EasytaxTaxCodes extends TableImpl<EasytaxTaxCodesRecord> {

    private static final long serialVersionUID = -937571237;

    /**
     * The reference instance of <code>public.easytax_tax_codes</code>
     */
    public static final EasytaxTaxCodes EASYTAX_TAX_CODES = new EasytaxTaxCodes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EasytaxTaxCodesRecord> getRecordType() {
        return EasytaxTaxCodesRecord.class;
    }

    /**
     * The column <code>public.easytax_tax_codes.record_id</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, Long> RECORD_ID = createField(DSL.name("record_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('easytax_tax_codes_record_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.easytax_tax_codes.kb_tenant_id</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, String> KB_TENANT_ID = createField(DSL.name("kb_tenant_id"), org.jooq.impl.SQLDataType.CHAR(36).nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.tax_zone</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, String> TAX_ZONE = createField(DSL.name("tax_zone"), org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.product_name</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, String> PRODUCT_NAME = createField(DSL.name("product_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.tax_code</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, String> TAX_CODE = createField(DSL.name("tax_code"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.tax_rate</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, BigDecimal> TAX_RATE = createField(DSL.name("tax_rate"), org.jooq.impl.SQLDataType.NUMERIC(15, 9).nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.valid_from_date</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, LocalDateTime> VALID_FROM_DATE = createField(DSL.name("valid_from_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>public.easytax_tax_codes.valid_to_date</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, LocalDateTime> VALID_TO_DATE = createField(DSL.name("valid_to_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.easytax_tax_codes.created_date</code>.
     */
    public final TableField<EasytaxTaxCodesRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * Create a <code>public.easytax_tax_codes</code> table reference
     */
    public EasytaxTaxCodes() {
        this(DSL.name("easytax_tax_codes"), null);
    }

    /**
     * Create an aliased <code>public.easytax_tax_codes</code> table reference
     */
    public EasytaxTaxCodes(String alias) {
        this(DSL.name(alias), EASYTAX_TAX_CODES);
    }

    /**
     * Create an aliased <code>public.easytax_tax_codes</code> table reference
     */
    public EasytaxTaxCodes(Name alias) {
        this(alias, EASYTAX_TAX_CODES);
    }

    private EasytaxTaxCodes(Name alias, Table<EasytaxTaxCodesRecord> aliased) {
        this(alias, aliased, null);
    }

    private EasytaxTaxCodes(Name alias, Table<EasytaxTaxCodesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> EasytaxTaxCodes(Table<O> child, ForeignKey<O, EasytaxTaxCodesRecord> key) {
        super(child, key, EASYTAX_TAX_CODES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EASYTAX_TAX_CODES_PRODUCT_IDX);
    }

    @Override
    public Identity<EasytaxTaxCodesRecord, Long> getIdentity() {
        return Keys.IDENTITY_EASYTAX_TAX_CODES;
    }

    @Override
    public UniqueKey<EasytaxTaxCodesRecord> getPrimaryKey() {
        return Keys.EASYTAX_TAX_CODES_PKEY;
    }

    @Override
    public List<UniqueKey<EasytaxTaxCodesRecord>> getKeys() {
        return Arrays.<UniqueKey<EasytaxTaxCodesRecord>>asList(Keys.EASYTAX_TAX_CODES_PKEY);
    }

    @Override
    public EasytaxTaxCodes as(String alias) {
        return new EasytaxTaxCodes(DSL.name(alias), this);
    }

    @Override
    public EasytaxTaxCodes as(Name alias) {
        return new EasytaxTaxCodes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EasytaxTaxCodes rename(String name) {
        return new EasytaxTaxCodes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EasytaxTaxCodes rename(Name name) {
        return new EasytaxTaxCodes(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, String, BigDecimal, LocalDateTime, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
