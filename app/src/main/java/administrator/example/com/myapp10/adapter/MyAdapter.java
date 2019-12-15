package administrator.example.com.myapp10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

import administrator.example.com.myapp10.bean.DataSourse;
import administrator.example.com.myapp10.R;

public class MyAdapter extends BaseAdapter {
    /*
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    */

    private Context context ;
    private List<DataSourse> list;
    public MyAdapter(Context context, List<DataSourse> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            String ChinaShuyu;
            String EnglishShuyu;
            String Explain;

            ChinaShuyu = list.get(position).getChinaShuyu();
            EnglishShuyu = list.get(position).getEnglishShuyu();
            Explain = list.get(position).getExplain();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_layout, null);//实例化一个布局文件
            viewHolder = new ViewHolder();
            viewHolder.et_item_china = (EditText) convertView.findViewById(R.id.et_item_china);
            viewHolder.et_item_english = (EditText) convertView.findViewById(R.id.et_item_english);
            viewHolder.et_item_explain = (EditText) convertView.findViewById(R.id.et_item_explain);
            convertView.setTag(viewHolder);

            /*
            //不能直接在主线程中进行从网络端获取图片，而需要单独开一个子线程完成从网络端获取图片
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //根据表中图片的url地址来得到图片（Bitmap类型）
                    final Bitmap bitmap=getPicture(list.get(position).getIcon().getFileUrl());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    viewHolder.iv_img.post(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("*********************************");
                            viewHolder.iv_img.setImageBitmap(bitmap);//将图片放到视图中去
                        }
                    });
                }
            }).start();
            */
            viewHolder.et_item_china.setText(ChinaShuyu);
            viewHolder.et_item_english.setText(EnglishShuyu);
            viewHolder.et_item_explain.setText(Explain);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{
        EditText et_item_china;
        EditText et_item_english;
        EditText et_item_explain;
    }

}
