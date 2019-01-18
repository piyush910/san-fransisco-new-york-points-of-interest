package com.chandra.piyush.project3c.android.project3cfin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PointsOfInterestFragment.ListSelectionListener} interface
 * to handle interaction events.
 * Use the {@link PointsOfInterestFragment#mListener} factory method to
 * create an instance of this fragment.
 */
public class PointsOfInterestFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    private ListSelectionListener mListener = null;
    private static int selectedIndex = -1; // the current index

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position != selectedIndex) {
            selectedIndex = position;
            getListView().setItemChecked(position, true);
        }
        mListener.onListSelection(position);
    }


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (ListSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ListSelectionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // set array adapter
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.fragment_points_of_interest, Activity3.pointsOfInterestArray));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}
