package com.iongeger.radiostreaming;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentList extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayList<RadioInfo> radioList;
    private ListView listView;
    private View view;

    private OnFragmentInteractionListener mListener;

    public FragmentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);
        setRetainInstance(true);
        radioList = new ArrayList<RadioInfo>();
        listView = (ListView) view.findViewById(R.id.listViewNames);
        FillList();
        FillListView();
       // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //la posicion comienza en 0
        mListener.setRadioOnActivity(radioList.get(position));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void setRadioOnActivity(RadioInfo radio);
    }

    private void FillList(){
        radioList.add(new RadioInfo("Calm Radio - Felix Mendelssohn", "http://38.110.126.108:12428/stream", "Classical", "Canada"));
        radioList.add(new RadioInfo("Calm Radio - Reiki", "http://38.110.126.108:9528/stream", "New Age", "Canada"));
        radioList.add(new RadioInfo("Calm Radio - 90s Hits", "http://38.110.126.108:18428/stream", "90s", "Canada"));
        radioList.add(new RadioInfo("Calm Radio - Workout", "http://38.110.126.108:19428/stream", "Electronica-House", "Canada"));
        radioList.add(new RadioInfo("Calm Radio - Orient", "http://calm1.calmradio.com:10408/;", "Asian", "Canada"));
        radioList.add(new RadioInfo("Calm Radio - I Love 80's", "http://38.110.126.108:17228/stream", "70s/80s", "Canada"));
        radioList.add(new RadioInfo("KBBL 106.3 FM Cazadero, CA", "http://icy2.abacast.com/redwoodempire-kbblfmaac-48", "Country", "USA"));
        radioList.add(new RadioInfo("Beat Bird FM", "http://37.221.209.146:9290/beat_live.mp3", "Electronica-House", "Hungary"));
        radioList.add(new RadioInfo("AddictedToRadio - Chillout Lounge", "http://addictedtoradio.com/Listen/AAC/14410.pls", "Electronica-Chillout", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - House Channel", "http://streamsrus.com/listen/1CFM14810.pls", "Electronica-House", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - Q100 (Today’s Hard Rock)", "http://addictedtoradio.com/Listen/AAC/15510.pls", "Rock", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - Hot Mix Dance Classics", "http://streamsrus.com/listen/1CFM9910.pls", "70s/80s", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - Trance", "http://streamsrus.com/listen/1CFM12810.pls", "Electronica-Trance", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - Q97 (Today’s Modern Rock Alternative)", "http://streamsrus.com/listen/1CFM16010.pls", "Rock-Alternative", "USA"));
        radioList.add(new RadioInfo("AddictedToRadio - Love Bites", "http://streamsrus.com/listen/1CFM15910.pls", "Rock", "USA"));
        radioList.add(new RadioInfo("CINEMIX Flim Music Station", "http://streaming.radionomy.com/CINEMIX?lang=es-419%2ces%3bq%3d0.8%2cen%3bq%3d0.6", "Soundtracks", "USA"));
        radioList.add(new RadioInfo("Todelar - La X « Cali", "http://184.154.28.210:1935/todcallax/default.stream/playlist.m3u8", "Electronica", "Colombia"));
        radioList.add(new RadioInfo("The Music Spot Radio", "http://streaming.radionomy.com/TheMusicSpotRadio?lang=es-419%2ces%3bq%3d0.8%2cen%3bq%3d0.6", "Rock-Indie", "Portugal"));
        radioList.add(new RadioInfo("1Radio.mk - Classic Rock", "http://185.80.220.101/1radio_classicrock_128", "Rock", "Macedonia"));
        radioList.add(new RadioInfo("RTVC - Radiónica 2", "http://173.192.25.13:1935/RADIO/rrock.stream/playlist.m3u8", "Rock", "Colombia"));
        radioList.add(new RadioInfo("Sweet Sounz", "http://soho.wavestreamer.com:7333/stream/1/", "Island-Hawaii", "New Zealand"));
        radioList.add(new RadioInfo("Word of Truth Christmas Classics", "http://199.189.86.22:8090", "Seasonal-Christmas", "USA"));
        radioList.add(new RadioInfo("Calm Radio - Country Folk", "http://38.110.126.108:13628/stream", "Country", "Canada"));
        radioList.add(new RadioInfo("24-7 Legends", "http://www.24-7nicheradio.com:8012/;", "Rock-Classic", "United Kingdom"));
        radioList.add(new RadioInfo("Contemporary Celtic & Folk Rock Music", "http://streaming.radionomy.com/ContemporaryCeltic?lang=es-419%2ces%3bq%3d0.8%2cen%3bq%3d0.6&br=128", "Irish/Celtic", "Ireland"));
        radioList.add(new RadioInfo("KMTT 103.7 FM Seattle, WA", "http://provisioning.streamtheworld.com/pls/KMTTFM.pls", "Rock-Alternative", "USA"));
        radioList.add(new RadioInfo("J-Rock Powerplay", "http://cabhs30.sonixcast.com:9508/;", "Rock", "Japan"));
        radioList.add(new RadioInfo("RBR Rock Radio", "http://188.165.192.5:8703/stream", "Rock-Classic", "New Zealand"));
    }

    private void FillListView(){
        List<String> listName = new ArrayList<String>();
        for (RadioInfo ft : radioList) {
            listName.add(ft.getName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.select_dialog_item_material, listName);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }
}
