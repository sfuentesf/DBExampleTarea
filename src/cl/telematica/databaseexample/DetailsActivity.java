package cl.telematica.databaseexample;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import cl.telematica.databaseexample.adapters.RssAdapter2;
import cl.telematica.databaseexample.database.DataBaseClass;
import cl.telematica.databaseexample.models.EarthQuakeDataModel;

public class DetailsActivity extends Activity {
	
	private ListView listView;
	private DataBaseClass dbInstance;
	private List<EarthQuakeDataModel> list = new ArrayList<EarthQuakeDataModel>();
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad);
		
		listView = (ListView) findViewById(R.id.listView1);
		dbInstance = new DataBaseClass(this);
	
		func(list);
		RssAdapter2 adapter = new RssAdapter2(getApplicationContext(), R.string.app_name, list);
		listView.setAdapter(adapter);		
	}
	
	

	private void func(List<EarthQuakeDataModel> list){
		SQLiteDatabase db = dbInstance.getWritableDatabase();
		if(db != null){
			db.beginTransaction();
			try{
				
				Cursor c = db.rawQuery("SELECT * FROM alumnos", null);
						if(c.moveToFirst()){
						do{
						 EarthQuakeDataModel model = new EarthQuakeDataModel();
						 model.title = c.getString(1);
						 model.magnitude = c.getString(2);
						 model.location = c.getString(3);
						 model.depth = c.getString(4);
						 model.latitude = c.getString(5);
						 model.longitude = c.getString(6);
						 model.dateTime = c.getString(7);
						 model.link = c.getString(8);
						 list.add(model);
						} while (c.moveToNext());
						}
						c.close();
				    
			} finally {
				db.setTransactionSuccessful();
			}
			db.endTransaction();
		    db.close();
		}
	}

}
