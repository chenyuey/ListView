package com.example.listviewcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnScrollListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity implements OnItemClickListener{

	private ListView listView;
	private ArrayAdapter<String> arr_adapter;
	private SimpleAdapter simp_adapter;
	private List<Map<String,Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView)findViewById(R.id.listView);
        //新建一个数组适配器
        //ArrayAdapter(上下文，当前listview加载的每一个列表项所对应的布局文件，数据源)
        //SimpleAdapter()
        /*
         * context:上下文
         * data:(List<? extends Map<String, ?>> data)一个Map所组成的List集合
         *      每一个map都回去对应了listview列表中的一行
         *      每一个Map（键值对）中的键必须包含所有在from中所指定的键
         * resource:列表项的布局文件ID，与from成对应关系
         * from:Map中的键名
         * to:绑定数据视图中的ID
         */
        //适配器加载数据源
        String[] arr_data = {"几米学社1","几米学社2","几米学社3","几米学社4","几米学社5"};
        dataList = new ArrayList<Map<String,Object>>();
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","name","profile"}, new int[]{R.id.pic,R.id.name,R.id.profile});
        //视图加载适配器
//        listView.setAdapter(arr_adapter);
        listView.setAdapter(simp_adapter);
//        listView.setOnItemClickListener(this);
    }
    private List<Map<String,Object>> getData()
    {
    	int[] arr_pic = {R.drawable.fanbingbing,R.drawable.yangmi,R.drawable.zhangxinyi,R.drawable.aiweier,R.drawable.liushishi,R.drawable.piaoxinhui,R.drawable.yuner};
    	String[] arr_name = {"范冰冰","杨幂幂","张歆艺","艾薇儿","刘诗诗","朴信惠","允儿儿"};
    	String[] arr_profile = {
    			"1981年9月16日生于山东青岛，毕业于上海师范大学谢晋影视艺术学院，中国女演员。",
                "中国女演员、歌手、电视剧制片人。出生于北京。毕业于北京电影学院表演系。",
    			"中国内地女演员，出生于1981年5月29日，2005年毕业于中央戏剧学院表演系本科班。",
    			"1984年9月27日出生于加拿大安大略省，加拿大女歌手、词曲创作者、演员。",
    			"原名刘诗施，中国内地影视女演员，出生于北京，毕业于北京舞蹈学院芭蕾舞专业。",
    			"2001年，11岁的朴信惠拍摄了李承焕的第一部MV《爱吗》",
    			"1990年5月30日出生于首尔，韩国女歌手、演员，女子演唱团体少女时代成员。"
    	};
    	for(int i = 0; i < 7; i ++)
    	{
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("pic", arr_pic[i]);
    		map.put("name", arr_name[i]);
    		map.put("profile", arr_profile[i]);
    		dataList.add(map);
    	}
    	return dataList;
    }
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		// TODO Auto-generated method stub
		String text = listView.getItemAtPosition(position)+"";
		Toast.makeText(this, "position="+position+" text="+text, Toast.LENGTH_SHORT);
		
	}
}
