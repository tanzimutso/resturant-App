package com.example.utso.myrestaurantapp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.*-
 */
public class HomeFragment extends Fragment {

    RecyclerView rvMain;
    RelativeLayout relativeLayout;
    ViewGroup.LayoutParams params1, params2;
    ScrollView scrollView;
    boolean flag = false;
    TextView foodDesc;
    boolean isFlag = false;
    Button exBut;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvMain = (RecyclerView) view.findViewById(R.id.rec_view);
        Bitmap[] bitmaps = getBitmaps();
        String[] nameList = getName();

        foodDesc = (TextView)view.findViewById(R.id.food_desc);

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(bitmaps, nameList);
        rvMain.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvMain.setAdapter(myRecyclerAdapter);

        exBut = (Button)rvMain.findViewById(R.id.exploreBut);
        return view;
    }

    private Bitmap[] getBitmaps() {
        Bitmap[] tempBitmaps = new Bitmap[8];
        tempBitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bbq);
        tempBitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.burger);
        tempBitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.chicken_one);
        tempBitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.chicken_curry);
        tempBitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.chowmein);
        tempBitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.donut);
        tempBitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.egg);
        tempBitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.egg_stu);

        return tempBitmaps;
    }

    public String[] getName() {

        String[] tNameList = {"Barbecue Lazis Bla Bla", "Chicken Burger", "Chicken Tandury Katlet Masala Jhal Fry", "Chicken Manchurian Spicy Curry"
                , "Chinese Chilli Chowmein", "Donut Nuggett with Fruit Topings", "Egg Nuts with Vegies and Soup", "Eggs on top of Crispy Cutlet"};
        return tNameList;

    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;
        String[] nameList;

        public MyRecyclerAdapter(Bitmap[] bitmaps, String[] nameList) {
            this.bitmaps = bitmaps;
            this.nameList = nameList;
        }

        @NonNull
        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.grid_rv, parent, false);
            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int position) {
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("" + nameList[position]);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivMImage);
            textView = (TextView) itemView.findViewById(R.id.tvCaption);
        }
    }

}
