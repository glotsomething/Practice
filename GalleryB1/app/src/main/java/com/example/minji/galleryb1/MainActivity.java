package com.example.minji.galleryb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {
//Gallery에서 보여줄 이미지를 지정한다.
    //이미지들은/res/drawable-hdpi 아래에 pic1.jpg, pic2.jpg와 같은 이름으로 저장한다.'
    //이미지 이름은 숫자로 싲가해서는 안되며, 영문자, 숫자,_문자로 구성되어야 한다.
    Integer[] images={R.drawable.image1,R.drawable.you};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        //갤러리에서 보여줄 이미지를 처리하는 어댑터를 설정한다.
        //ImageAdapter는 BaseAdapter를 확장해서 만들어야 한다.
        gallery.setAdapter(new ImageAdapter(this));


        //갤러리의 이미지를 클릭했을 때 해당 이미지를 크게 보여주기 위한 로직을 설정한다.
        //OnItemClickListener 객체를 갤러리에 설정하면 클릭 이벤트가 발생했을 때 원하는 처리를 할 수 있다.
        gallery.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id){
                //갤러리에서 선택된 이미지를 보여주기 위한 ImageView를 가지고 온다.
                ImageView imageView = (ImageView) findViewById(R.id.image1);

                //ImageView에 표시되는 이미지를 가로, 세로 비율에 맞게 보여질 수 있도록 설정한다.
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                //사용자가 선택한 위치에 있는 이미지를 ImageView에 설정한다.
                //사용자가 선택한 이미지의 위치는 positioin으로 알 수 있으며 이를 통해 배열에서 적절한 이미지를 얻으면 된다.
                imageView.setImageResource(images[position]);
            }
        });
    }

    //갤러리에 보여질 이미지 어댑터를 선언한다.
    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context c){
            context = c;
        }
        //이미지전체개수를 반환하다.
        public int getCount(){
            return images.length;
        }
        //주어진 position에 대한 이미지 리소스 아이디를 반환한다.
        public Integer getItem(int position){
            return images[position];
        }
        //주어진 position에 대한 이미지 리소스 아이디를 반환한다.
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

        //주어진 postiion에 대한 ImageView를 반환한다.
        public View getview(int position, View convertView, ViewGroup parent){
            //ImageView를 생성한다.
            ImageView imageView = new ImageView(context);

            //주어진 position에 해당하는 이미지 리소스 아이디를 설정한다.
            imageView.setImageResource(getItem(position));

            //갤러리에 보여지는 이미지 크기를 설정한다.
            imageView.setLayoutParams(new Gallery.LayoutParams(100,80));

            //ImageView를 반환한다.
            return imageView;
        }
    }
}
