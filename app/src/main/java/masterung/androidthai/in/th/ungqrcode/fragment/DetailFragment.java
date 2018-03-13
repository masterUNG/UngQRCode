package masterung.androidthai.in.th.ungqrcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import masterung.androidthai.in.th.ungqrcode.R;

/**
 * Created by masterung on 12/3/2018 AD.
 */

public class DetailFragment extends Fragment{

    public static DetailFragment detailInstance(
            String nameFood,
            String imagePath,
            String category,
            String price,
            String detail) {

        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NameFood", nameFood);
        bundle.putString("ImagePath", imagePath);
        bundle.putString("Category", category);
        bundle.putString("Price", price);
        bundle.putString("Detail", detail);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }   // Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }
}
