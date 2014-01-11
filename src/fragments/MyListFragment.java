package fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.android.SpSystem.R;
import intefaces.OnItemListClicked;
import kernel.tableitem.*;
import kernel.database.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/8/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyListFragment extends ListFragment {
    public static final String ARG_LIST_NUMBER = "menu_number";
    private MyTableItem[] list1;
    public MyArrayAdapter adapter;
    int selected = -1;
    OnItemListClicked mListener;

    public MyListFragment() {
        // Empty constructor required for fragment subclasses
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnItemListClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        int i = getArguments().getInt(ARG_LIST_NUMBER);
        boolean b = false;
        switch (i){
            case 0:{
                list1 = HahaDB.list1;
                if(list1==null)
                    break;
                b = true;
                break;
            }
            case 1:{
                if(GetTasks.alltasks == null)
                GetTasks.getAllTasks();
                list1 = GetTasks.alltasks;
                if(list1==null)
                    break;
                b = true;
                break;
            }
            default:
                ;
        }
        if(b) {
//        adapter = new ArrayAdapter<String>(getActivity(), R.layout.rawlayout, listtodisp);
            adapter = new MyArrayAdapter(getActivity(), list1);
//            Title = new ArrayList<String>();
//            Title.add("1");
//            Title.add("2");
//            Title.add("3");
//            Title.add("4");
//            Title.add("5");
//            Title.add("6");
//            Title.add("1");
//            Title.add("2");
//            Title.add("3");
//            Title.add("4");
//            Title.add("5");
//            Title.add("6");
//            setListAdapter(new ArrayAdapter<String>(getActivity(),
//                    android.R.layout.simple_list_item_activated_1, Title));
            setListAdapter(adapter);
        }

//        String planet = getResources().getStringArray(R.array.menu_array)[i];
//
//        int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
//                "drawable", getActivity().getPackageName());
        getActivity().setTitle(getResources().getStringArray(R.array.menu_array)[i]);
        return rootView;
    }
    public void showDetails(int pos){
          mListener.OnClicked(pos);
    }
    private ArrayList<String> Title;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        ListView v = getListView();
        if(v !=null){
            v.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//            v.setSelector(R.drawable.selector);
            v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    showDetails(position);
                }
            });
        }
    }

    class LoadTablesInBackground extends AsyncTask<Integer, Void, Void>{

        @Override
        protected Void doInBackground(Integer... params) {
            int i  = params[0];
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);    //To change body of overridden methods use File | Settings | File Templates.
        }
    }



    class MyArrayAdapter extends ArrayAdapter<MyTableItem>{
        private Context context;
        private MyTableItem[] objects;

        public MyArrayAdapter(Context context, MyTableItem[] objects) {
            super(context, R.layout.rawlayout, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            MyTableItem item = objects[position];

            View rowView = inflater.inflate(R.layout.rawlayout, parent, false);
            ((TextView) rowView.findViewById(R.id.label)).setText(item.Name);
            TextView t  = ((TextView) rowView.findViewById(R.id.theme));
            t.setText(item.Thema);
            ((TextView) rowView.findViewById(R.id.datastart)).setText(item.Data);
            ImageView imguser_status = (ImageView)rowView.findViewById(R.id.user_status);
            switch (item.User_status){
                case 0:
                    imguser_status.setImageResource(R.drawable.user3);
                case 1:
                    imguser_status.setImageResource(R.drawable.user2);
                case 2:
                    imguser_status.setImageResource(R.drawable.user1);
            }

            return rowView;
        }
    }
}

