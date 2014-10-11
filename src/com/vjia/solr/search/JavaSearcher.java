package com.vjia.solr.search;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.vjia.solr.entity.JavaEntity;
import com.vjia.util.Util;

public class JavaSearcher {

	/**
	 * search index using a CopyField : java_all
	 * @param inputKey
	 * @return
	 */
	public Collection searchAllByKey(String inputKey) {
		try {
			Collection<JavaEntity> entities = new LinkedList<>();
			SolrServer server = Util.SERVER;
			SolrQuery query = new SolrQuery();
			// java_all is the solr field that copy all other fields' value
			query.setQuery("java_all:*"+inputKey+"*");
			QueryResponse resp=server.query(query);
			SolrDocumentList docs = resp.getResults();
			Iterator<SolrDocument> iter = docs.listIterator();
			while(iter.hasNext()){
				SolrDocument doc = iter.next();
				// doc's fields : id, fileName, filePath, fileContent
				Collection fnames = doc.getFieldNames();
				String id = (String)doc.getFieldValue("id");
				String fileName = (String) doc.getFieldValue("name");
				String filePath = (String) doc.getFieldValue("filePath");
				String fileContent = (String) doc.getFieldValue("fileContent");
				JavaEntity entity = new JavaEntity(id, fileName, filePath,fileContent);
				entities.add(entity);
			}
			return entities;
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
