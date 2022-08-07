package com.example.dula.ui.lessons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

//import com.example.dula.databinding.FragmentLessonsBinding;
import com.example.dula.R;

import com.example.dula.fragment0;
import com.example.dula.fragment1;
import com.example.dula.fragment2;
import com.example.dula.fragment3;
import com.example.dula.fragment4;
import com.example.dula.fragment5;
import com.example.dula.fragment6;
import com.example.dula.fragment7;
import com.example.dula.ui.VPAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class LessonsFragment extends Fragment {

    //private FragmentLessonsBinding binding;

    ViewPager pager;
    TabLayout mTabLayout;
    TabItem zeroItem, firstItem, secondItem, thirdItem, fourthItem, fifthItem, sixthItem, seventhItem;
    PagerAdapter adapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lessons,container,false);

        tabLayout = v.findViewById(R.id.tablayout);
        viewPager = v.findViewById(R.id.viewpager_id);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        //VPAdapter vpAdapter = new VPAdapter(this.getChildFragmentManager());
        vpAdapter.addFragment(new fragment1(), "Все категории");
        vpAdapter.addFragment(new fragment2(), "Идиомы");
        vpAdapter.addFragment(new fragment3(), "Сленг");
        vpAdapter.addFragment(new fragment4(), "Неправильные\nглаголы");
        vpAdapter.addFragment(new fragment5(), "ТОП\n100");
        vpAdapter.addFragment(new fragment6(), "ТОП\n1000");
        vpAdapter.addFragment(new fragment7(), "ТОП\n3000");

        viewPager.setAdapter(vpAdapter);

        return inflater.inflate(R.layout.fragment_lessons, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lessons,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager_id);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tablayout);
        tabs.setupWithViewPager(viewPager);
        //Открыть сразу вторую страницу
        viewPager.setCurrentItem(1);
        return view;
    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        //VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        Adapter adapter = new Adapter(getChildFragmentManager());

        adapter.addFragment(new fragment0(), "Дополнительные\nуроки");
        adapter.addFragment(new fragment1(), "ТОП\n100");
        adapter.addFragment(new fragment2(), "ТОП\n1000");
        adapter.addFragment(new fragment3(), "Прилагательные");
        adapter.addFragment(new fragment4(), "Неправильные\nглаголы");
        adapter.addFragment(new fragment5(), "Фразовые\nглаголы");
        adapter.addFragment(new fragment6(), "Бытовая лексика");
        adapter.addFragment(new fragment7(), "ТОП\n3000");
        viewPager.setAdapter(adapter);



    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}



