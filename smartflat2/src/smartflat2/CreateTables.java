package smartflat2;
import java.sql.*;

public class CreateTables {
	
	private String outputInfo; 
	
	public CreateTables(){
		outputInfo = null;
	}
	
	protected String createTables()
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Stephen/Database/SmartFlatTest.db");
	      outputInfo = "Opened database successfully \n";
	      String sql, sql_1, sql_2, sql_3 =  null;
	      stmt = c.createStatement();
	      try{
		      sql =			  "CREATE TABLE OCCUPANT " +
		                      "(ID INT 				 	 PRIMARY KEY 		   	NOT NULL, " +
		                      " LASTNAME          			  	TEXT 		   	NOT NULL, " + 
		                      " FIRSTNAME          			 	TEXT			NOT NULL, " + 
		                      " OTHERNAMES         				TEXT					, " + 
		                      " PAYEEIDENTIFIER           		TEXT  					, " + 
		                      " PREFERREDNAME           		TEXT  					, " + 
		                      " MOBILE NUMBER         			 INT 				 	, " + 
		                      " EMAIL           				TEXT  				 	, " +
		                      " NOTEDATE           				TEXT  				 	, " + 
		                      " NOTE            				TEXT  		 			 )"; 
		      stmt.executeUpdate(sql);
		      outputInfo += "Table OCCUPANT created successfully \n";
		      }catch ( Exception e ){
		    	  outputInfo += e.getMessage() + "\n" ;
		    	  //System.err.print( e.getClass().getName() + ": " + e.getMessage() + "\n" );
		      }
	      try{
		      sql_1 =   	  "CREATE TABLE PROPERTY " +
				    		  "(ID INT 					 PRIMARY KEY		 	NOT NULL, " +
			                  " PROPERTYNAME      			  	TEXT 		   	NOT NULL, " + 
			                  " STREETNUMBER       		 	     INT			NOT NULL, " + 
			                  " STREETNAME         				TEXT			NOT NULL, " + 
			                  " SUBURB			           		TEXT  			NOT NULL, " + 
			                  " AREACODE         		  		 INT  					, " + 
			                  " BUILDINGID         				TEXT 		 	NOT NULL, " + 
			                  " ROOMNUMBER           			 INT  		 	NOT NULL, " +
		                      " NOTEDATE           				TEXT  				 	, " + 
		                      " NOTE            				TEXT  		 	 		 )";
		      stmt.executeUpdate(sql_1);
		      outputInfo += "Table PROPERTY created successfully \n";
		      }catch ( Exception e ){
		    	  outputInfo +=  e.getMessage() + "\n";
		      } 
	      try{
		      sql_2 =         "CREATE TABLE TENANCY " +
				    		  "(ID INT 					 PRIMARY KEY		 	NOT NULL, " +
			                  " STARTDATE       			  	TEXT 		   	NOT NULL, " + 
			                  " ENDDATE         		 	    TEXT			NOT NULL, " + 
			                  " BONDAMOUNT         				REAL			NOT NULL, " + 
			                  " BONDRECEIVED	           		REAL  					, " + 
			                  " RENTRATE        		  		REAL  			NOT NULL, " + 
			                  " FREQUENCYOFPAYMENTS				TEXT 		 			 )" ;
		      stmt.executeUpdate(sql_2);
		      outputInfo += "Table TENANCY created successfully \n";
		      }catch ( Exception e ){
		    	  outputInfo += e.getMessage() + "\n";
		      } 	
	      try{
		      sql_3 =         "CREATE TABLE PAYMENT " +
				    		  "(ID INT 					 PRIMARY KEY		 	NOT NULL, " +
			                  " RENTPAYMENT       			  	REAL 		   	NOT NULL, " + 
			                  " DATE RECEIVED         	 	    TEXT			NOT NULL )"; 
		      stmt.executeUpdate(sql_3);
		      outputInfo += "Table PAYMENT created successfully \n";
		      }catch ( Exception e ){
		    	  outputInfo += e.getMessage() + "\n";
		      } 
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	    	outputInfo +=  e.getClass().getName() + ": " + e.getMessage() + "\n" ;
	      System.exit(0);
	    }
	    return outputInfo;
	  }
}
