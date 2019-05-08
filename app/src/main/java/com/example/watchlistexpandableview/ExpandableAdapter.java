package com.example.watchlistexpandableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> movie_list;
    HashMap<String, List<String>> movie_category;

    public ExpandableAdapter(Context context, List<String> movie_list, HashMap<String, List<String>> movie_category) {

        this.context=context;
        this.movie_list=movie_list;
        this.movie_category=movie_category;
    }

    @Override
    public int getGroupCount() {
        return movie_category.size();
    }

    @Override
    public int getChildrenCount(int parent) {
        return movie_category.get(movie_list.get(parent)).size();
    }

    @Override
    public Object getGroup(int parent) {
        return movie_list.get(parent);
    }

    @Override
    public Object getChild(int parent, int child) {

        return movie_category.get(movie_list.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int parent) {
        return parent;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean b, View convertView, ViewGroup viewGroup)
    {
        String title = (String) getGroup(parent);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_group_lay, viewGroup,false);

        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.GroupName);
        listTitleTextView.setText(title);
        return convertView;


    }

    @Override
    public View getChildView(int parent, int child, boolean b, View convertView, ViewGroup parentview) {
        final String expandedListText = (String) getChild(parent, child);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.collapse_single_lay, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.collapse_single_lay);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
