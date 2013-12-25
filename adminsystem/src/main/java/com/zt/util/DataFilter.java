/**
 * name:DataFilter.java
 * description:数据查询过滤
 * author:zot
 * data:2013/11/15
 */
package com.zt.util;

public class DataFilter {
	public String type;
	public String value;
	public String field;
	public String comparison;

	public DataFilter() {
	};

	public DataFilter(String field, String type, String value) {
		this.type = type;
		this.value = value;
		this.field = field;
	};

	public DataFilter(String field, String type, String value, String comparison) {
		this.type = type;
		this.value = value;
		this.field = field;
		this.comparison = comparison;
	};

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getComparison() {
		return comparison;
	}

	public void setComparison(String comparison) {
		this.comparison = comparison;
	}
}
