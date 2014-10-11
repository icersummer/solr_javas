package com.vjia.solr.index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

import com.vjia.util.Util;

public class JavaIndexer {
	
	Logger logger = Logger.getLogger(JavaIndexer.class);
	public SolrServer server = null;
	
	/**
	 * format : D:/a/a.java, C:/b/b.java
	 */
	List<String> javaFiles = new LinkedList<String>();
	
	public JavaIndexer() {

		server = Util.SERVER;
		
	}
	
	public void index(String filePath) {

		File file = new File(filePath);
		if (!file.isDirectory()) {
//			System.out.println(" !! ERROR , NEED A FOLDER !!");
			logger.error(" !! ERROR , NEED A FOLDER !!");
		}
		loopJavaFolder(filePath);
	}

	private void loopJavaFolder(String file_) {
		File file = new File(file_);
		String folderpath = "";
		if(file.isDirectory()) {
			folderpath = file_;
		} else if(file.isFile()) {
			folderpath = file_.substring(0, file_.lastIndexOf(File.separator));
		}
		
		
		String[] subFiles = file.list(new FilenameFilter(){
			@Override
			public boolean accept(File arg0, String arg1) {
				// only PROCESS java files for now
				if(arg1.endsWith(".java")){
					return true;
				}
				return false;
			}
		});
//		System.out.println("subFiles = " + subFiles);
		logger.debug("subFiles = " + subFiles);
		
		if(subFiles == null) {
			return;
		}
		for(String filename : subFiles) {
			filename = folderpath + File.separator + filename;
			if( !isFile(filename) ) {
				loopJavaFolder(filename);
			}
			indexTheJavaFile(filename);
		}
	}

	private void indexTheJavaFile(String filename) {
		try {
			File file = new File(filename);
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", Util.getUniqueIncrementId());
			doc.addField("fileName", filename.substring(filename.lastIndexOf(File.separator)+1,filename.lastIndexOf(".")));
			doc.addField("filePath", file.getAbsoluteFile());
			doc.addField("fileContent", getFileContent(file));
			server.add(doc);
			server.commit();
//			System.out.println(String.format("index done : ", filename));
			logger.info(String.format("index done : ", filename));
		} catch (SolrServerException e) {
//			System.out.println("!! index file failed : " + filename);
			logger.error("!! index file failed : " + filename);
			e.printStackTrace();
		} catch (IOException e) {
//			System.out.println("!! index file failed : " + filename);
			logger.error("!! index file failed : " + filename);
			e.printStackTrace();
		}
	}

	/**
	 * read the file's content as a long string
	 * @throws IOException 
	 */
	private String getFileContent(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		StringBuffer buffer = new StringBuffer();
		while(line!=null) {
			//TODO file length is too much
//			if(buffer.length() > 5000){
//				break;
//			}
			
			buffer.append(line);
			buffer.append("      ");
			line = br.readLine();
		}
		
		
		return buffer.toString();
	}

	private boolean isFile(String filename) {
		File f = new File(filename);
		return f.isFile();
	}

}
