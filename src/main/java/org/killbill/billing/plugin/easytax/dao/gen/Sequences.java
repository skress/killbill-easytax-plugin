/*
 * This file is generated by jOOQ.
 */
package org.killbill.billing.plugin.easytax.dao.gen;


import org.jooq.Sequence;
import org.jooq.impl.Internal;


/**
 * Convenience access to all sequences in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.easytax_tax_codes_record_id_seq</code>
     */
    public static final Sequence<Integer> EASYTAX_TAX_CODES_RECORD_ID_SEQ = Internal.createSequence("easytax_tax_codes_record_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.easytax_taxations_record_id_seq</code>
     */
    public static final Sequence<Integer> EASYTAX_TAXATIONS_RECORD_ID_SEQ = Internal.createSequence("easytax_taxations_record_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
