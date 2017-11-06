package com.test.springbatch.SpringBatch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.test.springbatch.SpringBatch.Product;

public class ProductMapper implements FieldSetMapper<Product>{

	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Product product = new Product();
		
		product.setDescription(fieldSet.readString("DESCRIPTION"));
		product.setProductId(fieldSet.readInt("PRODUCT_ID"));
		product.setProductName(fieldSet.readString("PRODUCT_NAME"));
		product.setProductPrice(fieldSet.readBigDecimal("PRODUCT_PRICE"));
		return product;
	}
}
