package com.iongeger.radiostreaming;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRadio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentRadio extends Fragment implements View.OnClickListener {

    private RadioInfo radio;
    private ImageButton playStopButton;
    private TextView radioName;
    private boolean playing = false;
    private RadioAsyncTask ra;
    private View view;
    private OnFragmentInteractionListener mListener;

    public FragmentRadio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_radio, container, false);
        setRetainInstance(true);
        playStopButton = (ImageButton) view.findViewById(R.id.play_stop_button);
        radioName = (TextView) view.findViewById(R.id.radio_name);
        try{
//            Snackbar.make(null,(String)view.getContext().getString(R.string.loading), Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
            Toast.makeText(view.getContext(),"Cargando",Toast.LENGTH_LONG).show();
            radio = (RadioInfo)getArguments().getSerializable("RadioInfo");
            ra = new RadioAsyncTask(radio.getUrl(),view.getContext());
            ra.execute();
            radioName.setText(radio.getName());
            playStopButton.setBackgroundResource(R.drawable.ic_stop);
            playStopButton.setOnClickListener(this);
            playing = true;
            createNotification();
        }catch (Exception e){
            Log.w("error", "onCreateView: ", e);
            Toast.makeText(view.getContext(),"Error",Toast.LENGTH_LONG).show();
        }

        // Inflate the layout for this fragment
        return view;
    }

    public void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
//        PendingIntent pIntent = PendingIntent.getActivity(view.getContext(), (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        Notification notification = new NotificationCompat.Builder(view.getContext())
                .setTicker(radio.getName())
                .setSmallIcon(android.R.drawable.btn_radio)
                .setContentTitle(radio.getName())
                .setContentText(radio.getGender())
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
        // hide the notification after its selected
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, notification);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
    public void onClick(View v) {
        if(playing){
            ra.cancel(true);
            ra.getRadioPlayer().getMediaPlayer().stop();
            playStopButton.setBackgroundResource(R.drawable.ic_play);
            playing = false;
            Log.d("YAAAAA", "STOP");
        }else {
            ra.getRadioPlayer().getMediaPlayer().start();
            playStopButton.setBackgroundResource(R.drawable.ic_stop);
            playing = true;
            Log.d("YAAAAA", "PLAY");
        }
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
        void onFragmentInteraction(Uri uri);
    }

    public void setRadioChannel(RadioInfo radioInfo){
        this.radio = radioInfo;
        ra.getRadioPlayer().setStream(radio.getUrl());
        radioName.setText(radio.getName());
        playStopButton.setBackgroundResource(R.drawable.ic_play);
    }



}
