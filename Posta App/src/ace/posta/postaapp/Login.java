package ace.posta.postaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity {
	
	Button btnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btnRegister = (Button) findViewById(R.id.button2);
		
		btnRegister.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(Login.this, RegistrationActivity.class);
    			startActivity(intent);
    			
    			//finish();
				
			}			
		});
		
	}

}
