/**
 *
 */
package com.lexst.sql.index.range;

import com.lexst.sql.*;

public final class LongIndexRange extends IndexRange {

	private static final long serialVersionUID = -3517827699280024030L;

	private long begin, end;

	/**
	 *
	 */
	public LongIndexRange() {
		super(Type.LONG_INDEX);
		begin = end = 0L;
	}

	/**
	 * @param index
	 */
	public LongIndexRange(LongIndexRange index) {
		super(index);
		this.begin = index.begin;
		this.end = index.end;
	}

	/**
	 * 
	 * @param chunkId
	 * @param columnId
	 */
	public LongIndexRange(long chunkId, short columnId) {
		super(Type.LONG_INDEX, chunkId, columnId);
		begin = end = 0;
	}

	/**
	 * @param chunkId
	 * @param columnId
	 * @param begin
	 * @param end
	 */
	public LongIndexRange(long chunkId, short columnId, long begin, long end) {
		this(chunkId, columnId);
		this.setRange(begin, end);
	}

	public void setRange(long begin, long end) {
		if (begin > end) {
			throw new IllegalArgumentException(String.format(
					"invalid long range (%x - %x)", begin, end));
		}
		this.begin = begin;
		this.end = end;
	}

	public long getBegin() {
		return this.begin;
	}

	public long getEnd() {
		return this.end;
	}

	public boolean inside(long value) {
		return begin <= value && value <= end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		return new LongIndexRange(this);
	}
}
