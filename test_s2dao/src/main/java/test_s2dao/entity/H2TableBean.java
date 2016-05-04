package test_s2dao.entity;

import org.seasar.dao.annotation.tiger.Bean;

@Bean(table="h2schema.h2table")//２．４の書き方
public class H2TableBean {
	
	//public static final String TABLE = "h2schema.h2table";//２．３の書き方

	private Integer Id;
	private String text;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
