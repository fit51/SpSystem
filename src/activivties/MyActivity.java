package activivties;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.android.SpSystem.R;
import fragments.MyListFragment;
import fragments.MyTask;
import intefaces.OnItemListClicked;
import kernel.Factory;
import kernel.connection.HttpConn;
import kernel.database.HahaDB;
import kernel.database.InsertTables;
import org.json.JSONException;

public class MyActivity
  extends Activity implements OnItemListClicked
{
  private Factory _factory;
  Context mContext = this;
  private DrawerLayout mDrawerLayout;
  private ListView mDrawerList;
  private CharSequence mDrawerTitle = "SpSystem";
  private ActionBarDrawerToggle mDrawerToggle;
  private String[] mMenuTitles;
  private CharSequence mTitle;
  
  private void selectItem(int paramInt)
  {
    MyListFragment localMyListFragment = new MyListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("menu_number", paramInt);
    localMyListFragment.setArguments(localBundle);
    getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
            replace(R.id.content_frame, localMyListFragment).commit();
    this.mDrawerList.setItemChecked(paramInt, true);
    setTitle(mMenuTitles[paramInt]);
    DrawerLayout localDrawerLayout = this.mDrawerLayout;
    ListView localListView = this.mDrawerList;
    localDrawerLayout.closeDrawer(localListView);
  }
    @Override
    public void OnClicked(int id) {
        MyTask newFragment = new MyTask(id);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                R.anim.fragment_slide_left_exit,
                R.anim.fragment_slide_right_enter,
                R.anim.fragment_slide_right_exit);
        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);


// Commit the transaction
        transaction.commit();
    }

  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mDrawerToggle.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_main);
    mMenuTitles = getResources().getStringArray(R.array.menu_array);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mDrawerList = (ListView) findViewById(R.id.left_drawer);

      // set a custom shadow that overlays the main content when the drawer opens
      mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
      // set up the drawer's list view with items and click listener
      mDrawerList.setAdapter(new ArrayAdapter<String>(this,
              R.layout.drawer_list_item, mMenuTitles));
      mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


    this._factory = new Factory();
    Context[] arrayOfContext = {mContext};
    _factory.execute(arrayOfContext);

    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);

      mDrawerToggle = new ActionBarDrawerToggle(
              this,                  /* host Activity */
              mDrawerLayout,         /* DrawerLayout object */
              R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
              R.string.drawer_open,  /* "open drawer" description for accessibility */
              R.string.drawer_close  /* "close drawer" description for accessibility */
      ) {
          public void onDrawerClosed(View view) {
              getActionBar().setTitle(mTitle);
              invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
          }

          public void onDrawerOpened(View drawerView) {
              getActionBar().setTitle(mDrawerTitle);
              invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
          }
      };
      mDrawerLayout.setDrawerListener(mDrawerToggle);

          selectItem(0);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.main, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mDrawerToggle.onOptionsItemSelected(paramMenuItem)) {
      return true;
    }
    switch (paramMenuItem.getItemId())
    {
        case R.id.refresh:
          InsertTables localInsertTables = new InsertTables();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = 0;
          localInsertTables.execute(arrayOfObject);
          return true;
        case R.id.menu_settings:

          return true;
      default:
            return super.onOptionsItemSelected(paramMenuItem);
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.mDrawerToggle.syncState();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = mDrawerLayout.isDrawerOpen(mDrawerList);
      //do with menu when drawer opened - closed
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    ActionBar localActionBar = getActionBar();
    CharSequence localCharSequence = this.mTitle;
    localActionBar.setTitle(localCharSequence);
  }



    private class TakeTable
    extends AsyncTask<String, Void, String>
  {
    private TakeTable() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      String str = "";
      String[] arrayOfString = paramVarArgs;
      int i = arrayOfString.length;
      int j = 0;
      while (j < i)
      {
        str = HttpConn.connect(arrayOfString[j]);
        j += 1;
      }
      return str;
    }
    
    protected void onPostExecute(String paramString)
    {
      if (paramString == null) {
        return;
      }
      try
      {
        if (paramString.isEmpty()) {
          return;
        }
        HahaDB.createList1(paramString);
        Toast.makeText(MyActivity.this.mContext, "Refreshed", 0).show();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private class DrawerItemClickListener
    implements AdapterView.OnItemClickListener
  {
    private DrawerItemClickListener() {}
    
    public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      MyActivity.this.selectItem(paramInt);
    }
  }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     activivties.MyActivity

 * JD-Core Version:    0.7.0.1

 */