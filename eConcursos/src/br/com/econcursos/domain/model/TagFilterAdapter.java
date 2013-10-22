package br.com.econcursos.domain.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public class TagFilterAdapter extends BaseAdapter implements Filterable {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new CustomFilter();
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}
	private class CustomFilter extends Filter {

	    @Override
	    protected FilterResults performFiltering(CharSequence constraint) {
	        FilterResults results = new FilterResults();

/*	        if(constraint == null || constraint.length() == 0) {
	            ArrayList<String> list = new ArrayList<String>(mOrigionalValues);
	            results.values = list;
	            results.count = list.size();
	        } else {
	            ArrayList<String> newValues = new ArrayList<String>();
	            for(int i = 0; i < mOrigionalValues.size(); i++) {
	                String item = mOrigionalValues.get(i);
	                if(item.contains(constraint)) {
	                    newValues.add(item);
	                }
	            }
	            results.values = newValues;
	            results.count = newValues.size();
	        }   */    

	        return results;
	    }

	    @Override
	    protected void publishResults(CharSequence constraint, FilterResults results) {
/*	        mObjects = (List<String>) results.values;
	        Log.d("CustomArrayAdapter", String.valueOf(results.values));
	        Log.d("CustomArrayAdapter", String.valueOf(results.count));*/
	        notifyDataSetChanged();
	    }

	}

}