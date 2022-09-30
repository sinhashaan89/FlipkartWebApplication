package org.flipkart.genericUtility;

public interface IConstants {
		/**
		 * @author shaan
		 * This static final variable gives absolute path 
		 */
			public String ABSOLUTEPATH=System.getProperty("user.dir");
		

		/**
		 * @author shaan
		 * this static final variable gives the path of property file
		 */
		public String PROPERTYFILEPATH="./src/test/resources/commonData.properties";
		/**
		 * @author shaan
		 * this static final variable gives the path of excel file
		 */
		public String EXCELFILEPATH="./src/test/resources/TestData.xlsx";

		public String NameOfSheet="Flipkart";
}
