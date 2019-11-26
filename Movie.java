/*
Author: Varun Jani
Compiler/IDE: Netbeans
Operating system: Windows 10
*/

package Movie;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class Movie {

    public static void main(String[] args)
    {
        Connection connection = null;
	      Statement statement = null;
	      ResultSet resultSet = null;

        try
        {
            // Try block starting with connection to connect to the database using apache derby
	          connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Movie_SQL", "Varun", "Varun");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM movieTitle");

            System.out.println("\"movieTitles\" Table of Movie Database");
            System.out.println("------------------------------------");
            System.out.println("(Format: movieID, title, rating, genre, director, star)");
           
            while(resultSet.next())
            {
                int Movie_ID = resultSet.getInt("movieID");
                String Title = resultSet.getString("title");
                String Rating = resultSet.getString("rating");
                String Genre = resultSet.getString("genre");
                String Director = resultSet.getString("director");
                String Star = resultSet.getString("star");
                    
                System.out.println(Movie_ID + ", " + Title + ", " + Rating + ", " + Genre + ", " + Director + ", " + Star);
            }
            
            resultSet = statement.executeQuery("SELECT * FROM movieAwards WHERE awardYear != 0000"); 
            
            System.out.println("\n\"movieAwards\" Table of Movie Database");
            System.out.println("------------------------------------");
            System.out.println("(Format: movieID, award, awardYear)");
            
            while(resultSet.next())
            {
                int Movie_ID = resultSet.getInt("movieID");
                String Award = resultSet.getString("award");
                int Award_Year = resultSet.getInt("awardYear");
                
                System.out.println(Movie_ID + ", " + Award + ", " + Award_Year);
            }
           
            resultSet = statement.executeQuery("SELECT * FROM movieAwards WHERE awardYear != 0000 ORDER BY awardYear DESC");
            
            System.out.println("\n\"movieAwards\" Table of Movie Database (sorted in descending order by award year): ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("(Format: movieID, award, awardYear)");      
            
            while(resultSet.next())
            {
                int Movie_ID = resultSet.getInt("movieID");
                int Award_Year = resultSet.getInt("awardYear");
                String Award = resultSet.getString("award");
                
                System.out.println(Movie_ID + ", " + Award + ", " + Award_Year);
            }
            
            resultSet = statement.executeQuery("SELECT movieTitle.movieID, movieTitle.title, movieTitle.director, movieTitle.star, movieAwards.award, movieAwards.awardYear FROM movieTitle INNER JOIN movieAwards ON movieTitle.movieID = movieAwards.movieID");
            
            System.out.println("\n\"Movies\" That Have Received Awards:");
            System.out.println("-----------------------------------");
            System.out.println("(Format: movieID, title, director, star, award, awardYear)");

            while(resultSet.next())
            {
                int Movie_ID = resultSet.getInt("movieID");
                String Award = resultSet.getString("award");
                int Award_Year = resultSet.getInt("awardYear");
                String Title = resultSet.getString("title");
                String Director = resultSet.getString("director");
                String Star = resultSet.getString("star");
                
                System.out.println(Movie_ID + ", " + Title + ", " + Director + ", " + Star + ", " + Award + ", " + Award_Year);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        }
        
        // Catch block where an exception is called if any shows up when running the program 
	      catch(SQLException sqlException)
        {
            sqlException.getMessage();
        }  
    }
}
