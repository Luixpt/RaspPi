/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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
        String ip="";
        String datahora="";
        String data="";
        String hora="";
        String devolver="";
        
        GregorianCalendar calendar = new GregorianCalendar();        
        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy' - 'HH':'mm':'ss");
        datahora=formatador.format(calendar.getTime());
        data=datahora.substring(0,10);
        hora=datahora.substring(13,21);       
        
        code=dadosrasp.substring(1, 12);
        ip=dadosrasp.substring(12,dadosrasp.length());
        
        //data=dadosrasp.substring(12, 22);
        //hora=dadosrasp.substring(25, 33);
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaspPica","root","root"); 
            Statement st= con.createStatement(); 
            st.executeQuery("select * from users where rfcode = '"+code+"'");
            ResultSet rs=st.executeQuery("select * from users where rfcode = '"+code+"'");
            int id=0;
            if (rs.next()) {
                id=rs.getInt("iduser");
                devolver=rs.getInt("iduser")+"-"+ rs.getString("nomecurto");
            }
            else{
                devolver="utilizador não encontrado!!!";
                
            }
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaspPica","root","root");
            st= con.createStatement();
            st.executeQuery("select * from salas where iprocket = '"+ip+"'");
            rs=st.executeQuery("select * from salas where iprocket = '"+ip+"'");
            
            int idsala=0;
            if (rs.next()) {
                idsala=rs.getInt("idsala");                
            }
            else{
                idsala=0;
                
            }
            
            int i=st.executeUpdate("insert into picas(iduser,idsala,data,hora) values ('"+id+"','"+idsala+"','"+data+"','"+hora+"')"); 
            
        }
        catch (Exception e){
            
            System.out.print(e.getMessage());
        }
        return devolver;
}
}
