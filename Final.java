import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
@ManagedBean
  
@RequestScoped  
public class Final{
    private List perInfoAll = new ArrayList();

    public List getperInfoAll() throws ClassNotFoundException, SQLException
{
   int i=0;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
       String url = "jdbc:mysql://localhost:3306/";
       String dbName = "surveytest";
       Connection con=DriverManager.getConnection(url+dbName,"root","");
      PreparedStatement st = con.prepareStatement("select * from survey"); 
      
         ResultSet rs=st.executeQuery();
         while(rs.next())
        {
    System.out.println(rs.getString(1));
    perInfoAll.add(i,new perInfo (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
  i++;
        }
    }
    catch (SQLException e){};
        return perInfoAll;
         
         
    
        
}
public class perInfo
{
    String name;  
String age;  
String gender;
String q1,q2,q3;

        public perInfo(String name, String age, String gender, String q1, String q2, String q3) {
           this.name=name;
           this.age=age;
           this.gender=gender;
           this.q1=q1;
           this.q2=q2;
           this.q3=q3;
        }

       
  
public String getName() {  
return name;  
}  

public String getAge() {  
return age;  
}  
  

public String getGender() {  
return gender;  
}  

public String getQ1() {  
return q1;  
}  

public String getQ2() {  
return q2;  
}  
 
public String getQ3() {  
return q3;  
}  

    }
}