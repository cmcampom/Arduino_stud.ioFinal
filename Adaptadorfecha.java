package co.edu.icesi.id.studio;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by estudiante on 30/05/18.
 */

public class Adaptadorfecha extends BaseAdapter {

    Activity activity;

    public Adaptadorfecha(Activity activity){
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
