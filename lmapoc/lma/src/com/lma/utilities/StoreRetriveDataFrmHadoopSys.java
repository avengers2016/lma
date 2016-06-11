
package com.lma.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class StoreRetriveDataFrmHadoopSys {  
 
	
	public static String getDataFrmHadoomSys() throws IOException {	
	 
		 String line=null;
		
		try{
          Path pt=new Path("hdfs://npvm11.np.wc1.yellowpages.com:9000/user/john/abc.txt");
          FileSystem fs = FileSystem.get(new Configuration());
          BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
         
          line=br.readLine();
          while (line != null){
                  System.out.println(line);
                  line=br.readLine();
          }          
        
  }catch(Exception e){
	  System.out.println("failed to fetch data due to:"+e);
  }
	return line;  
	
	
}
}
