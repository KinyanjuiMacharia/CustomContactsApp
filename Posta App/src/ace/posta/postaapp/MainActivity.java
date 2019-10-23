package ace.posta.postaapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pb = (ProgressBar) findViewById(R.id.simpleProgressBar);
        pb.setIndeterminate(true);
       
        
        Thread t = new Thread(){
        	public void run(){
        		
        		try{
        			int i = 0;
        			while(i < 100){
        			
        				i++;
        				sleep(100);
        				pb.setProgress(i);  
        			}
        			
        			if(i == 100){
        			Intent intent = new Intent("ace.posta.postaapp.Login");
        			startActivity(intent);
        			}
        			
        		}catch(Exception e){
        			
        		}
        		finally{
        			
        			//close the splash activity
        			finish();
        		}
        		
        	}
        	
        };
        
        t.start();        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
