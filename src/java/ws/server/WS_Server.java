/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author lfranco
 */
@WebService(serviceName = "WS_Server")
public class WS_Server {

    
    @WebMethod(operationName = "picagem")
    public String picagem(@WebParam(name = "dadosrasp") String dadosrasp) {
        //TODO write your implementation code here:
        String code="";
        String data="";
        String hora="";
        String devolver="";
        String dadoschegados=dadosrasp;
        code=dadosrasp.substring(0, 11);
        data=dadosrasp.substring(12, 22);
        hora=dadosrasp.substring(25, 33);
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaspPica","root","root"); 
            Statement st= con.createStatement(); 
            st.executeQuery("select * from users where rfcode = '"+code+"'");
            ResultSet rs=st.executeQuery("select * from users where rfcode = '"+code+"'");
            int id=0;
            while (rs.next()) {
                id=rs.getInt("iduser");
                devolver= "Numero Aluno:"+rs.getInt("iduser")+" Nome Aluno: "+ rs.getString("nomecurto");
            }
            
            
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaspPica","root","root"); 
            st= con.createStatement(); 
            
            int i=st.executeUpdate("insert into picas(iduser,idsala,data,hora) values ('"+id+"','"+"1"+"','"+data+"','"+hora+"')"); 
            
        }
        catch (Exception e){
            
            System.out.print(e.getMessage());
        }
        
        //return dadoschegados;
        return devolver;
}
}
