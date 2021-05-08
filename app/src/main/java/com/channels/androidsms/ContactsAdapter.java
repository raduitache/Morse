package com.channels.androidsms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.R;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter {

    private List contactsInfoList;
    private Context context;

    public ContactsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.contactsInfoList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.contact_info, null);

            holder = new ViewHolder();
            holder.displayName = (TextView) convertView.findViewById(R.id.displayName);
            holder.lastMessage = (TextView) convertView.findViewById(R.id.lastMessage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ContactInfo contactInfo = (ContactInfo) contactsInfoList.get(position);
        holder.displayName.setText(contactInfo.getDisplayName());
        holder.lastMessage.setText(contactInfo.getLastMessage());

        return convertView;
    }

    private class ViewHolder {
        TextView displayName;
        TextView lastMessage;
    }
}