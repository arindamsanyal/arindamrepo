package com.test.springbatch.SpringBatch;

import java.sql.Types;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductWriter implements ItemWriter<Product>{
    
	@Autowired
	private JdbcTemplate template;
	
	private static final String UPDATE_SQL = "UPDATE PRODUCTS SET PRODUCT_NAME=?"
			+ ",DESCRIPTION=?,PRODUCT_PRICE=? WHERE PRODUCT_ID=?";
	private static final String INSERT_SQL = "INSERT INTO PRODUCTS VALUES(?,?,?,?)";

	
	public void write(List<? extends Product> items) throws Exception {
		
		for(Product product : items){
			Object param [] = new Object[4];
			param[0] = product.getProductName();
			param[1] = product.getDescription();
			param[2] = product.getProductPrice();
			param[3] = product.getProductId();
			int update = template.update(UPDATE_SQL,param , new int[]{Types.VARCHAR,Types.VARCHAR,Types.NUMERIC,Types.BIGINT});
		    if(update==0){
		       
		    	param[0] = product.getProductId();
				param[1] = product.getProductName();
				param[2] = product.getDescription();
				param[3] = product.getProductPrice();
			   update = template.update(INSERT_SQL,param , new int[]{Types.NUMERIC,Types.VARCHAR,Types.VARCHAR,Types.BIGINT});
	
		    }
		}

	}

}
