package example.com.likewechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import example.com.likewechat.fragment.ChatFragment;
import example.com.likewechat.fragment.ContactsFragment;
import example.com.likewechat.fragment.DiscoveryFragment;
import example.com.likewechat.fragment.MeFragment;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private RadioButton rbChat,rbContacts,rbDiscovery,rbMe;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        /**
         * RadioGroup部分
         */
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rbChat = (RadioButton)findViewById(R.id.radio_chat);
        rbContacts =(RadioButton)findViewById(R.id.radio_contact);
        rbDiscovery = (RadioButton)findViewById(R.id.radio_find);
        rbMe = (RadioButton)findViewById(R.id.radio_me);
        //radioButton选定状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_chat:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true表示打开，false表示关闭
                         */
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.radio_contact:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.radio_find:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.radio_me:
                        viewPager.setCurrentItem(3,false);
                        break;
                }
            }
        });
        /**
         * viewPager部分
         */
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        ChatFragment weChatFragment = new ChatFragment();
        ContactsFragment contactsFragment = new ContactsFragment();
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        MeFragment meFragment = new MeFragment();
        List<Fragment> allFragment = new ArrayList<Fragment>();
        allFragment.add(weChatFragment);
        allFragment.add(contactsFragment);
        allFragment.add(discoveryFragment);
        allFragment.add(meFragment);
        //ViewPager适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),allFragment));
        //viewpager显示第一个fragment
        viewPager.setCurrentItem(0);
        //viewpager页面切换监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case (0):
                        radioGroup.check(R.id.radio_chat);
                        break;
                    case (1):
                        radioGroup.check(R.id.radio_contact);
                        break;
                    case (2):
                        radioGroup.check(R.id.radio_find);
                        break;
                    case (3):
                        radioGroup.check(R.id.radio_me);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
