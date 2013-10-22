/**
 * 
 */
package br.com.econcursos.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import br.com.econcursos.R;

/**
 * @author Paulo
 *
 */
public class ActionDialog extends Dialog implements OnItemClickListener {

	public ActionDialog(Context context) {
		super(context);
		setContentView(R.layout.detalhe_concurso_dialog_user_action);
		setCancelable(true);
		setTitle(R.string.detail_action_user_dialog_title);
		
		ListView options = (ListView) findViewById(R.id.list_actions);
		options.setOnItemClickListener(this);
		options.setAdapter(new DialogOptionAdapter(getContext()));
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		switch (position) {
		case 0:
			Log.i(getClass().getName(),"options 0");
			break;

		default:
			break;
		}		
	}
}
class DialogOptionAdapter extends BaseAdapter {
	
	private Context context;
	public static List<ActionItem> LIST_ACTIONS = null;
	
	static {
		
		LIST_ACTIONS = loadActionsLists();
	}	

	private static List<ActionItem> loadActionsLists() {
		
		List<ActionItem> toReturn = new ArrayList<ActionItem>();
		
		toReturn.add(new ActionItem(R.string.dialog_label_action_send_email, R.drawable.ic_action_send_my_email));
		toReturn.add(new ActionItem(R.string.dialog_label_action_send_another_email, R.drawable.ic_action_send_to_friend));
		toReturn.add(new ActionItem(R.string.dialog_label_action_share, R.drawable.ic_action_share));		
		
		return toReturn;
	}
	
	public DialogOptionAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return LIST_ACTIONS.size();
	}

	@Override
	public Object getItem(int position) {
		return LIST_ACTIONS.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ActionItem actionItem = LIST_ACTIONS.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View viewToReturn = inflater.inflate(R.layout.action_list_item_layout, null);
		
		ImageView actionImage = (ImageView) viewToReturn.findViewById(R.id.actionImage);
		actionImage.setImageResource(actionItem.getIcon());
		
		TextView labelAction = (TextView) viewToReturn.findViewById(R.id.labelAction);
		labelAction.setText(actionItem.getLabel());

		return viewToReturn;
	}
	
}

class ActionItem {
	
	private int label;
	private int icon;
	
	public ActionItem(int label, int icon) {
		this.icon = icon;
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public int getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(int label) {
		this.label = label;
	}

	/**
	 * @return the icon
	 */
	public int getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(int icon) {
		this.icon = icon;
	}	
}
