package masterung.androidthai.in.th.ungqrcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import masterung.androidthai.in.th.ungqrcode.R;

/**
 * Created by masterung on 13/3/2018 AD.
 */

public class DisplayQRfragment extends Fragment{

    private String qrScanString;

    public static DisplayQRfragment displayQRInstance(String qrCodeString,
                                                      String[] loginStrings) {

        DisplayQRfragment displayQRfragment = new DisplayQRfragment();
        Bundle bundle = new Bundle();
        bundle.putString("QRcode", qrCodeString);
        bundle.putStringArray("Login", loginStrings);
        displayQRfragment.setArguments(bundle);
        return displayQRfragment;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Show QRscan
        showQRscan();

//        Search Controller
        searchController();

//        QRscan Controller
        QRscanController();


    }   // Main Method

    private void QRscanController() {
        Button button = getView().findViewById(R.id.btnQRscan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment,
                                QRscanFragment.qRscanInstance(getArguments().getStringArray("Login")))
                        .commit();

            }
        });
    }

    private void searchController() {
        Button button = getView().findViewById(R.id.btnSearchQR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showQRscan() {
        TextView textView = getView().findViewById(R.id.txtQRcode);
        qrScanString = getArguments().getString("QRcode");
        textView.setText(qrScanString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_scan, container, false);
        return view;
    }
}
