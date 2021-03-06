package com.vml.test.supercsv;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.LongCellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

/**
 * 
 * Have implemented my own ParseShort as one does not exist
 * @author yatinmistry
 *
 */
public class ParseShort extends CellProcessorAdaptor implements StringCellProcessor {
	
	/**
	 * Constructs a new <tt>ParseShort</tt> processor, which converts a String to an Short.
	 */
	public ParseShort() {
		super();
	}
	
	/**
	 * Constructs a new <tt>ParseShort</tt> processor, which converts a String to an Short, then calls the next
	 * processor in the chain.
	 * 
	 * @param next
	 *            the next processor in the chain
	 * @throws NullPointerException
	 *             if next is null
	 */
	public ParseShort(final LongCellProcessor next) {
		super(next);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws SuperCsvCellProcessorException
	 *             if value is null, isn't an Short or String, or can't be parsed as an Integer
	 */
	public Object execute(final Object value, final CsvContext context) {
		validateInputNotNull(value, context);
		
		final Short result;
		if( value instanceof Short ) {
			result = (Short) value;
		} else if( value instanceof String ) {
			try {
				result = Short.valueOf((String) value);
			}
			catch(final NumberFormatException e) {
				throw new SuperCsvCellProcessorException(
					String.format("'%s' could not be parsed as an Short", value), context, this, e);
			}
		} else {
			final String actualClassName = value.getClass().getName();
			throw new SuperCsvCellProcessorException(String.format(
				"the input value should be of type Short or String but is of type %s", actualClassName), context,
				this);
		}
		
		return next.execute(result, context);
	}
}

