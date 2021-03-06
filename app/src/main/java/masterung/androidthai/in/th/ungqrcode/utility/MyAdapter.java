package masterung.androidthai.in.th.ungqrcode.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import masterung.androidthai.in.th.ungqrcode.R;

/**
 * Created by masterung on 12/3/2018 AD.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] titleStrings, imageStrings;

    public MyAdapter(Context context,
                     String[] titleStrings,
                     String[] imageStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.imageStrings = imageStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_layout, viewGroup, false);

        TextView textView = view1.findViewById(R.id.txtTitle);
        textView.setText(titleStrings[i]);

        ImageView imageView = view1.findViewById(R.id.imvImage);
        Picasso.get().load(imageStrings[i]).into(imageView);

        return view1;
    }
}
