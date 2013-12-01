package cl.telematica.databaseexample.adapters;

import java.util.List;

import cl.telematica.databaseexample.R;
import cl.telematica.databaseexample.models.EarthQuakeDataModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RssAdapter2 extends ArrayAdapter<EarthQuakeDataModel> {
	
	LayoutInflater mInflater;
	int mCount;

	public RssAdapter2(Context context, int textViewResourceId,
			List<EarthQuakeDataModel> objects) {
		super(context, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
		mCount = objects.size();
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		TextView title = null;
		TextView location = null;
	    TextView magnitude = null;
	    TextView depth = null;
	    TextView latitude = null;
	    TextView longitude = null;
	    TextView dateTime = null;
	    TextView link = null;
	    
		final EarthQuakeDataModel model = (EarthQuakeDataModel) getItem(position);
	
		if(convertView == null){
	         convertView = mInflater.inflate(R.layout.data_item2, null);
	         holder = new ViewHolder(convertView);
	         convertView.setTag(holder);
	    } else {
	    	holder = (ViewHolder) convertView.getTag();
	    }
		
		title = holder.getTitle();
		location = holder.getLocationText();
		magnitude = holder.getMagnitude();
		depth = holder.getDepth();
		latitude = holder.getLatitude();
		longitude = holder.getLongitude();
		dateTime = holder.getDateTime();
		link = holder.getLink();
	
		title.setText(model.title);
		location.setText(model.location);
		magnitude.setText(model.magnitude);
		depth.setText(model.depth);
		latitude.setText(model.latitude);
		longitude.setText(model.longitude);
		dateTime.setText(model.dateTime);
		link.setText(model.link);
		
		return convertView;
	}
	
	@Override
    public int getCount() {
    	return mCount;
    }
	
	private class ViewHolder {
	    private View mRow;
	    private TextView title;
	    private TextView location;
	    private TextView magnitude;
	    private TextView depth;
	    private TextView latitude;
	    private TextView longitude;
	    private TextView dateTime;
	    private TextView link;
	    
	    
	    public ViewHolder(View row) {
	          mRow = row;
	    }
	    
	    public TextView getTitle(){
	    	if(title == null){
	    		title = (TextView) mRow.findViewById(R.id.title);
	    	}
	    	return title;
	    }
	    
	    public TextView getLocationText(){
	    	if(location == null){
	    		location = (TextView) mRow.findViewById(R.id.dist);
	    	}
	    	return location;
	    }
	    
	    public TextView getMagnitude(){
	    	if(magnitude == null){
	    		magnitude = (TextView) mRow.findViewById(R.id.magnitude);
	    	}
	    	return magnitude;
	    }
	    public TextView getDepth(){
	    	if(depth == null){
	    		depth = (TextView) mRow.findViewById(R.id.depth);
	    	}
	    	return depth;
	    }
	    public TextView getLatitude(){
	    	if(latitude == null){
	    		latitude = (TextView) mRow.findViewById(R.id.latitude);
	    	}
	    	return latitude;
	    }
	    public TextView getLongitude(){
	    	if(longitude == null){
	    		longitude = (TextView) mRow.findViewById(R.id.longitude);
	    	}
	    	return longitude;
	    }
	    public TextView getDateTime(){
	    	if(dateTime == null){
	    		dateTime = (TextView) mRow.findViewById(R.id.dateTime);
	    	}
	    	return dateTime;
	    }
	    public TextView getLink(){
	    	if(link == null){
	    		link = (TextView) mRow.findViewById(R.id.link);
	    	}
	    	return link;
	    }
	    
	}

}
