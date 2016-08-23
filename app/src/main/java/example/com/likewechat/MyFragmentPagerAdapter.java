package example.com.likewechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 1992g on 2016/8/15.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list){
        super(fm);
        this.list=list;
    }
    @Override
    public Fragment getItem(int position){
        return list.get(position);
    }
    @Override
    public int getCount(){
        return list.size();
    }
}
