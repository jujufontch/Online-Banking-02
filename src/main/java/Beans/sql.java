package Beans;

import java.sql.*;



import jakarta.servlet.http.HttpServletRequest;

public class sql {
	
	 // Ruft den Inhalt der Tabelle ,dessen Name eingeben wird  ,auf , speichert und gibts es  in einem ResulSetobjekt zurück
	 public ResultSet Operation(String phrase){

	        ResultSet result = null;

	        try{

	            Connection connector = this.connect();

	            Statement sentence = connector.createStatement();

	            String satz = "SELECT * FROM "+phrase+" ;";

	            sentence.execute(satz);
	            result = sentence.executeQuery(satz);}
	        catch(Exception e){

	        }


	        return result;

	    }

	
	// Ruft den Inhalt einer SQLTabelle , fügt diese zu einem Htmltable 
    public String generateTable(ResultSet rs) throws SQLException {
        StringBuilder htmlTable = new StringBuilder("<table>");
        
        

        try {
            // Generate table headers
            htmlTable.append("<tr>");
            
            int columnCount = getResultColumn(rs);
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append("<th>").append(rs.getMetaData().getColumnLabel(i)).append("</th>");
            }
            htmlTable.append("</tr>");

            // Generate table rows
            while (rs.next()) {
                htmlTable.append("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    htmlTable.append("<td>").append(rs.getString(i)).append("</td>");
                }
                htmlTable.append("</tr>");
            }

            htmlTable.append("</table>");
        } catch (SQLException e) {
            // Log or handle the exception appropriately
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

        return htmlTable.toString();
    }
    
    
   // Prüft ob den eingegebenen Name im Datenbank steht
    public static Boolean Nameprüfer(String name){

        

        Boolean bool  ;
        int count = 0;

        ResultSet rs = result();
       

        try{

            while (rs.next()) {


                    if(rs.getString(1).equals(name)){

                        count+=1;
                        break;
                    }




            }rs.close();
        }
        catch(Exception e){}


       if (count==1){
           bool = true;
       }
       else {
           bool= false;
       }

    return bool ;}
    
   
    
    // Erstellst die Verbindung mit dem Datenbank
	public   Connection connect() {
		
	   
	    Connection connexion= null;
	   
	    
	    
	        try {
	        Class.forName("com.mysql.cj.jdbc.Driver");


	    } catch (ClassNotFoundException e) {

	        System.out.println("Error ");
	    }


	        try {

	        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/S", "root", "0000");


	    }
	        catch(Exception e ){

	        System.out.println("Verbindung fehlgeschlagen");
	    }
	        
	        return connexion;
	}
    
	
	// Speichert das Ergebniss der eingegebenen SQLQuery 
	// in einer ResultSetvariable und gibt diese zurück am Ende der Methode
	public static ResultSet result () {
		
		ResultSet resultat = null;
		
		 try{

		       sql sql = new sql();
		       
	           Connection connexion = sql.connect();
			 
		        Statement sentence = connexion.createStatement();

		        String satz = "SELECT * FROM Bankkonto;";

		        sentence.execute(satz);
		         resultat = sentence.executeQuery(satz);}
	     
		    catch(Exception e){
		    	
		    	System.out.println("Error in the result");

		    }
		 
		 return resultat;
	}
    
	
	//Ermittelt für die als paramter übergebene SQLtabbelle die Anzahl ihrer Spalten  
	public static int getResultColumn(ResultSet r){
	    int columns = 0;
	try{
	      columns = r.getMetaData().getColumnCount();}

	catch(Exception e){
	    System.out.println("Error");
	     }

	return columns;}
    
   
	
    //Gib den Inhalt einer SQLtabelle zurück 
	 public static void Select(int spalte, ResultSet rs){
		 try {

	            for (int i = 1; i < spalte+1; i++) {

	                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));}

	            System.out.println();
	            System.out.println("--------------------------------------------------------------");

	            while (rs.next()) {
	                for (int i = 1; i < spalte+1; i++) {

	                    System.out.print(String.format("%-15s", rs.getString(i)));}

	                System.out.println();

	            }


	            rs.close();


	        }
	        catch(Exception e){}



	    }
     
	 
	


}