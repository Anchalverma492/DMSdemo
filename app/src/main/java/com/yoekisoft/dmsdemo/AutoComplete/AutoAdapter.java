package com.yoekisoft.dmsdemo.AutoComplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.yoekisoft.dmsdemo.R;

import java.util.ArrayList;
import java.util.List;

class AutoAdapter extends ArrayAdapter<AutoModel> {
    Context context;
    int resource, textViewResourceId;
    List<AutoModel> items, tempItems, suggestions;

    public AutoAdapter(Context context, int resource, int textViewResourceId, List<AutoModel> items) {
        super(context, resource, textViewResourceId, items);
        this.context = context;
        this.resource = resource;
        this.textViewResourceId = textViewResourceId;
        this.items = items;
        tempItems = new ArrayList(items); // this makes the difference.
        suggestions = new ArrayList();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_layout, parent, false);
        }
        AutoModel people = items.get(position);
        if (people != null) {
            TextView lblName = view.findViewById(R.id.lbl_name);
            if (lblName != null) {

                    lblName.setText(people.getName()+"_"+people.getId());

            }
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            String str = ((AutoModel) resultValue).getName();
            String str2=((AutoModel)resultValue).getId();
            String str3= str+"_"+str2;
            return str3 ;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (AutoModel people : tempItems) {
                    if (people.getName().toLowerCase().contains(constraint.toString().toLowerCase())
                            || people.getId().contains(constraint.toString())) {
                        suggestions.add(people);
                    }

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<AutoModel> filterList = (ArrayList<AutoModel>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (AutoModel people : filterList) {
                    add(people);
                    notifyDataSetChanged();
                }
            }
        }
    };



}