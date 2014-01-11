package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.SpSystem.R;

public class MyTask
  extends Fragment
{
    private int id;
    public MyTask(int id){
       this.id = id;
    }
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.taskdetailefragment, paramViewGroup, false);
  }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        TextView tv = (TextView)getActivity().findViewById(R.id.textid);
        tv.setText(tv.getText()+String.valueOf(id));
        super.onActivityCreated(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
