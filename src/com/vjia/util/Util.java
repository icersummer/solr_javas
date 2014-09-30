package com.vjia.util;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;

public class Util {

	public static final int INDEX_SUCCESS = 1;

	public static final int INDEX_FAIL = 0;

	public static final String SOLR_SERVER_URL = "http://localhost:8180/solr";

	public static final SolrServer SERVER = new HttpSolrServer(SOLR_SERVER_URL);

	public static final String SCHEMA_NAME = "name";
	public static final String SCHEMA_ADDRESS = "address";
	public static final String SCHEMA_PHONE = "Phone";
	public static final String SCHEMA_EMAIL_ADDRESS = "EmailAddress";
	public static final String SCHEMA_USERNAME = "Username";
	public static final String SCHEMA_PASSWORD = "Password";
	public static final String SCHEMA_BIRTHDAY = "Birthday";
	public static final String SCHEMA_MASTER_CARD = "MasterCard";
	public static final String SCHEMA_EXPIRES = "Expires";

	public static final String FIELD_MASTER_CARD = "fn_master_card";
	public static final String FIELD_EXPIRE_DATE = "fn_expire_date";
	public static final String FIELD_BIRTHDAY = "fn_birthday";
	public static final String FIELD_PASSWORD = "fn_password";
	public static final String FIELD_USERNAME = "fn_username";
	public static final String FIELD_EMAIL_ADDRESS = "fn_email_address";
	public static final String FIELD_PHONE = "fn_phone";
	public static final String FIELD_ADDRESS = "fn_address";
	public static final String FIELD_NAME = "fn_name";
	public static final String FIELD_ID = "id";
	
	public static Set<String> fieldsSet = new TreeSet<String>();
	static {
		fieldsSet.add(  FIELD_MASTER_CARD );
		fieldsSet.add( FIELD_EXPIRE_DATE  );
		fieldsSet.add(  FIELD_BIRTHDAY );
		fieldsSet.add(  FIELD_PASSWORD );
		fieldsSet.add(  FIELD_USERNAME );
		fieldsSet.add(  FIELD_EMAIL_ADDRESS );
		fieldsSet.add(  FIELD_PHONE );
		fieldsSet.add(   FIELD_ADDRESS);
		fieldsSet.add(  FIELD_NAME );
		fieldsSet.add(  FIELD_ID );
	}
	
	public static void deleteAllExistingIndex() {
		UpdateResponse ursp;
		try {
			ursp = SERVER.deleteByQuery("*:*");
			SERVER.commit();
			System.out.println(String.format("delete status is %d", ursp.getStatus()));
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}

	public static Integer getUniqueIncrementId() {
		// TODO Auto-generated method stub
		return SQLiteUtil.getUniqueIncrementId();
	}

}
