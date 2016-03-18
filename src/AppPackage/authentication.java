/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gulnar
 */
public class authentication {
   static Connection conn=null;
   static PreparedStatement pst=null;
   static ResultSet rs=null;
   public static String UN;
   public static String PW;
   public static ArrayList<Long> PT;
   public static ArrayList<Long> IKT;
   public static Long TT;
   
   
   public static void setUsername(String un)
   {
       UN=un;
   }
   public static void setPassword(String pw)
   {
       PW=pw;
   }
   public static void setpresstime(ArrayList<Long> pt)
   {
       PT=pt;
   }
    public static void setinterkeytime(ArrayList<Long> ikt)
   {
       IKT=ikt;
   }
    public static void settotaltime(Long tt)
   {
       TT=tt;
   }
   public static boolean match()
   {
       int Id=0;
    ArrayList<Float> p1=new ArrayList<>();
    ArrayList<Float> p2=new ArrayList<>();
    ArrayList<Float> p3=new ArrayList<>();
    ArrayList<Float> p4=new ArrayList<>();
    ArrayList<Float> p5=new ArrayList<>();
    ArrayList<Float> p6=new ArrayList<>();
    ArrayList<Float> p7=new ArrayList<>();
    ArrayList<Float> p8=new ArrayList<>();
    ArrayList<Float> p9=new ArrayList<>();
    ArrayList<Float> p10=new ArrayList<>();
    ArrayList<Float> i1=new ArrayList<>();
    ArrayList<Float> i2=new ArrayList<>();
    ArrayList<Float> i3=new ArrayList<>();
    ArrayList<Float> i4=new ArrayList<>();
    ArrayList<Float> i5=new ArrayList<>();
    ArrayList<Float> i6=new ArrayList<>();
    ArrayList<Float> i7=new ArrayList<>();
    ArrayList<Float> i8=new ArrayList<>();
    ArrayList<Float> i9=new ArrayList<>();
    ArrayList<Float> i10=new ArrayList<>();
    float t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0,t10=0;
    float[] meanp=new float[20]; // for mean presstime of each character
    float[] meanik=new float[20];
    float meant;
    float[] sdp=new float[20]; // for SD of presstime for each character
    float[] sdik=new float[20];
    float sdt;
    float[] Dp=new float[20]; // for avg. Difference of presstime for each character
    float[] Dik=new float[20];
    float Dt;
    float[] scorep=new float[20];
    float[] scoreik=new float[20];
    float scoret;
    float score=0;
      try{ 
         conn=mysqlconnect.ConnectDb(); 
         String sql="select * from user where username=? and password=?";
         pst=conn.prepareStatement(sql);
         pst.setString(1,UN);
         pst.setString(2,PW);
         rs=pst.executeQuery();   
         while(rs.next()){
           Id=rs.getInt("userid");   
         }
         //JOptionPane.showMessageDialog(null,Id);
         String sql2="select * from press_time";
          pst=conn.prepareStatement(sql2);
          rs=pst.executeQuery();
          while(rs.next()){
             float id=rs.getFloat("id");
             if(Id==(int)id)
             { 
               p1.add(rs.getFloat("rs1"));
               p2.add(rs.getFloat("rs2"));
               p3.add(rs.getFloat("rs3"));
               p4.add(rs.getFloat("rs4"));
               p5.add(rs.getFloat("rs5"));
               p6.add(rs.getFloat("rs6"));
               p7.add(rs.getFloat("rs7"));
               p8.add(rs.getFloat("rs8"));
               p9.add(rs.getFloat("rs9"));
               p10.add(rs.getFloat("rs10"));
             }  
          }
          String sql3="select * from interkeytime";
          pst=conn.prepareStatement(sql3);
          rs=pst.executeQuery();
          while(rs.next()){
             float id=rs.getFloat("id");
             if(Id==(int)id)
             { 
               i1.add(rs.getFloat("rs1"));
               i2.add(rs.getFloat("rs2"));
               i3.add(rs.getFloat("rs3"));
               i4.add(rs.getFloat("rs4"));
               i5.add(rs.getFloat("rs5"));
               i6.add(rs.getFloat("rs6"));
               i7.add(rs.getFloat("rs7"));
               i8.add(rs.getFloat("rs8"));
               i9.add(rs.getFloat("rs9"));
               i10.add(rs.getFloat("rs10"));
             }  
          }
          String sql4="select * from totaltime";
          pst=conn.prepareStatement(sql4);
          rs=pst.executeQuery();
          while(rs.next()){
             int id=rs.getInt("id");
             if(Id==id)
             {
               t1=rs.getFloat("rs1");
               t2=rs.getFloat("rs2");
               t3=rs.getFloat("rs3");
               t4=rs.getFloat("rs4");
               t5=rs.getFloat("rs5");
               t6=rs.getFloat("rs6");
               t7=rs.getFloat("rs7");
               t8=rs.getFloat("rs8");
               t9=rs.getFloat("rs9");
               t10=rs.getFloat("rs10");
             }
          }
        int num=p1.size();
        for(int i=0;i<num;i++)
        {
          meanp[i]=(p1.get(i)+p2.get(i)+p3.get(i)+p4.get(i)+p5.get(i)+p6.get(i)+p7.get(i)+p8.get(i)+p9.get(i)+p10.get(i))/10; 
          meanik[i]=(i1.get(i)+i2.get(i)+i3.get(i)+i4.get(i)+i5.get(i)+i6.get(i)+i7.get(i)+i8.get(i)+i9.get(i)+i10.get(i))/10; 
          float m,m1,m2,n,n1,n2;
          m1=(float) Math.pow((p1.get(i)-meanp[i]),2)+(float) Math.pow((p2.get(i)-meanp[i]),2)+(float) Math.pow((p3.get(i)-meanp[i]),2)+(float) Math.pow((p4.get(i)-meanp[i]),2)+(float) Math.pow((p5.get(i)-meanp[i]),2);
          m2=(float) Math.pow((p6.get(i)-meanp[i]),2)+(float) Math.pow((p7.get(i)-meanp[i]),2)+(float) Math.pow((p8.get(i)-meanp[i]),2)+(float) Math.pow((p9.get(i)-meanp[i]),2)+(float) Math.pow((p10.get(i)-meanp[i]),2);
          m=m1+m2;
          n1=(p1.get(i)-meanp[i])+(p2.get(i)-meanp[i])+(p3.get(i)-meanp[i])+(p4.get(i)-meanp[i])+(p5.get(i)-meanp[i]);
          n2=(p6.get(i)-meanp[i])+(p7.get(i)-meanp[i])+(p8.get(i)-meanp[i])+(p9.get(i)-meanp[i])+(p10.get(i)-meanp[i]);
          n=((float) Math.pow(n1+n2,2))/10; 
          sdp[i]=(float) Math.sqrt((m-n)/9);
          m1=(float) Math.pow((i1.get(i)-meanik[i]),2)+(float) Math.pow((i2.get(i)-meanik[i]),2)+(float) Math.pow((i3.get(i)-meanik[i]),2)+(float) Math.pow((i4.get(i)-meanik[i]),2)+(float) Math.pow((i5.get(i)-meanik[i]),2);
          m2=(float) Math.pow((i6.get(i)-meanik[i]),2)+(float) Math.pow((i7.get(i)-meanik[i]),2)+(float) Math.pow((i8.get(i)-meanik[i]),2)+(float) Math.pow((i9.get(i)-meanik[i]),2)+(float) Math.pow((i10.get(i)-meanik[i]),2);
          m=m1+m2;
          n1=(i1.get(i)-meanik[i])+(i2.get(i)-meanik[i])+(i3.get(i)-meanik[i])+(i4.get(i)-meanik[i])+(i5.get(i)-meanik[i]);
          n2=(i6.get(i)-meanik[i])+(i7.get(i)-meanik[i])+(i8.get(i)-meanik[i])+(i9.get(i)-meanik[i])+(i10.get(i)-meanik[i]);
          n=((float) Math.pow(n1+n2,2))/10; 
          sdik[i]=(float) Math.sqrt((m-n)/9);
        }
        meant=(t1+t2+t3+t4+t5+t6+t7+t8+t9+t10)/10;
        //JOptionPane.showMessageDialog(null,meant);
        float m1=(float) Math.pow((t1-meant),2)+(float) Math.pow((t2-meant),2)+(float) Math.pow((t3-meant),2)+(float) Math.pow((t4-meant),2)+(float) Math.pow((t5-meant),2);
        float m2=(float) Math.pow((t6-meant),2)+(float) Math.pow((t7-meant),2)+(float) Math.pow((t8-meant),2)+(float) Math.pow((t9-meant),2)+(float) Math.pow((t10-meant),2);
        float m=m1+m2;
        //JOptionPane.showMessageDialog(null,m);
        float n1=(t1-meant)+(t2-meant)+(t3-meant)+(t4-meant)+(t5-meant);
        float n2=(t6-meant)+(t7-meant)+(t8-meant)+(t9-meant)+(t10-meant);
        float n=((float) Math.pow(n1+n2,2))/10;
        //JOptionPane.showMessageDialog(null,n);
        sdt=(float) Math.sqrt((m-n)/9);
        //JOptionPane.showMessageDialog(null,sdt);
        //Calculating Difference
        for(int i=0;i<num;i++)
        {
          float d1,d2;
          d1=(PT.get(i)-p1.get(i))+(PT.get(i)-p2.get(i))+(PT.get(i)-p3.get(i))+(PT.get(i)-p4.get(i))+(PT.get(i)-p5.get(i));
          d2=(PT.get(i)-p6.get(i))+(PT.get(i)-p7.get(i))+(PT.get(i)-p8.get(i))+(PT.get(i)-p9.get(i))+(PT.get(i)-p10.get(i));
          Dp[i]=Math.abs((d1+d2)/10);
          d1=(IKT.get(i)-i1.get(i))+(IKT.get(i)-i2.get(i))+(IKT.get(i)-i3.get(i))+(IKT.get(i)-i4.get(i))+(IKT.get(i)-i5.get(i));
          d2=(IKT.get(i)-i6.get(i))+(IKT.get(i)-i7.get(i))+(IKT.get(i)-i8.get(i))+(IKT.get(i)-i9.get(i))+(IKT.get(i)-i10.get(i));
          Dik[i]=Math.abs((d1+d2)/10);
        }
        float d1=(TT-t1)+(TT-t2)+(TT-t3)+(TT-t4)+(TT-t5);
        float d2=(TT-t6)+(TT-t7)+(TT-t8)+(TT-t9)+(TT-t10);
        Dt=Math.abs((d1+d2)/10);
       //Calculating Score 
       for(int i=0;i<num;i++)
       {
         scorep[i]=(float)(Dp[i]/(2*sdp[i]));
         //JOptionPane.showMessageDialog(null,i+"-"+scorep[i]);
         scoreik[i]=(float)(Dik[i]/(2*sdik[i]));
         //JOptionPane.showMessageDialog(null,i+"-"+scoreik[i]);
       }
       scoret=(float)(Dt/(2*sdt));
      // JOptionPane.showMessageDialog(null,"t-"+scoret);
       for(int i=0;i<num;i++)
       {
           score=score+scorep[i];
           score=score+scoreik[i];
       }
       score=score+scoret;
       score=score/((2*num)+1);
       //JOptionPane.showMessageDialog(null,score); 
      }
        catch (Exception e) {
         JOptionPane.showMessageDialog(null,e); 
        }
      if(score<=1)
        return true;
      else 
         return false;
   }
   public static void main(String args[])
   {
       
   }
}
