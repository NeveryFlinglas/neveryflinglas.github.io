import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
@ManagedBean(name="result")
  
@RequestScoped  
public class Result{  
String name;  
String age;  
String gender;
String q1,q2,q3;
  
public String getName() {  
return name;  
}  
public void setName(String name) {  
this.name = name;  
}  
public String getAge() {  
return age;  
}  
  
public void setAge(String age) {  
this.age = age;  
}  
public String getGender() {  
return gender;  
}  
public void setGender(String gender) {  
this.gender = gender;  
}  
public String getQ1() {  
return q1;  
}  
public void setQ1(String q1) {  
this.q1 = q1;  
}  
public String getQ2() {  
return q2;  
}  
public void setQ2(String q2) {  
this.q2 = q2;  
}  
public String getQ3() {  
return q3;  
}  
public void setQ3(String q3) {  
this.q3 = q3;  
}  
public String add() throws ClassNotFoundException, SQLException
{
        Class.forName("com.mysql.jdbc.Driver");
       String url = "jdbc:mysql://localhost:3306/";
       String dbName = "surveytest";
       Connection con=DriverManager.getConnection(url+dbName,"root","");
        Statement st=con.createStatement();
        //Inserting data using SQL query 
        st.executeUpdate("insert into survey values('"+name+"','"+age+"','"+gender+"','"+q1+"','"+q2+"','"+q3+"')");
    return "final";
        
}
}
