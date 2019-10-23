/*
 * Inspiration for this particular simple demo is WhatsApp
 * How does WhatsApp access your contact list and update it in the app?
 * The only way to do this is through the ContentProvider
 * Every ContentProvider contains a unique key called authorities(or simply the uri)
 * 
 * Communication between an application and the ContentProvider is through a ContentResolver
 * The ContentResolver may give you access to specific methods e.g. query(), insert(), update(), delete()
 */

package com.AceDevelopers.customcontactsapp;
/**
 * @author AceDevelopers
 * @since 23rd October 2019
 */

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.customListContacts);
		
		getContacts();
	}
	
	public void getContacts(){
		
		ArrayList<String> contacts = new ArrayList<String>();
		
		/*
		 * This refers to the content uri, meaning:
		 * we want to access the authorities from our content provider
		 * As long as you know the content uri, you can do anything
		 * Other examples include: recent calls, missed calls, your sms
		 */
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		
		//What do you want to access? Name and Phone number
		String [] projection = {
				ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
				ContactsContract.CommonDataKinds.Phone.NUMBER
		};
		String selection = null;
		String [] selectionArgs = null;
		String sortOrder = null;
		
		ContentResolver cr = getContentResolver();
		
		Cursor c = cr.query(uri, projection, selection, selectionArgs, sortOrder);
		
		while(c.moveToNext()){
			
			String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			String number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			
			//Log.i("@AceDevelopers", "Name: " + name + "Number: " + number);
			
			contacts.add(name + "\n" + number);
			
		}
		
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
