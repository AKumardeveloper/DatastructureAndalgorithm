package com.modanwalmatrimonialsamaj;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by ashish gupta on 23-02-2018.
 */
public class SearchList extends ArrayAdapter<Modeldata>{
    private Activity context;
    private List<Modeldata> searchList;
    public static ArrayList<Modeldata> wishlist;
    public SearchList(Activity context,List<Modeldata>searchList){
        super(context,R.layout.list_layout, searchList);
        this.context=context;
        this.searchList=searchList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textView13);
        TextView textViewDob=(TextView)listViewItem.findViewById(R.id.textView15);
        TextView textViewHeight=(TextView)listViewItem.findViewById(R.id.textView22);
        TextView textViewProfession=(TextView)listViewItem.findViewById(R.id.textView17);
        TextView textViewColor=(TextView)listViewItem.findViewById(R.id.textView19);
        TextView textViewParentname=(TextView)listViewItem.findViewById(R.id.textView24);
        TextView textViewMobile=(TextView)listViewItem.findViewById(R.id.textView41);
        TextView textViewAddress=(TextView)listViewItem.findViewById(R.id.textView28);
        TextView textViewProfileId=(TextView)listViewItem.findViewById(R.id.textView26);
        ImageView imageViewphoto=(ImageView)listViewItem.findViewById(R.id.imageView4);
        final Modeldata modeldata=searchList.get(position);
        textViewName.setText(modeldata.getName());
        String Date=modeldata.getDob();
        String d,m,y,Dobdym="";
         d=Date.substring(0,2);
         m=Date.substring(2,4);
         y=Date.substring(4);
         Dobdym=d+"/"+m+"/"+y;
        textViewDob.setText(Dobdym);
        textViewHeight.setText(modeldata.getHeight());
        textViewAddress.setText(modeldata.getAddress()+", "+modeldata.getDistrict()+", "+modeldata.getState());
        textViewProfession.setText(modeldata.getProfession());
        textViewParentname.setText(modeldata.getParentname());
        textViewColor.setText(modeldata.getColor());
        textViewMobile.setText(modeldata.getMob());
        textViewProfileId.setText(modeldata.getEmail());
        String str="https://firebasestorage.googleapis.com/v0/b/madanwalmatrimonialsamaj.appspot.com/o/images%2Fstorage"+"%2Femulated%2F0%2Fdownload%2Funnamed%20(1).png?alt=media&token=29431856-b56d-4d4f-8dc9-1200c655a8ad";
        if(!modeldata.getUrl().equals(str)) {
            Picasso.with(context).load(modeldata.getUrl()).into(imageViewphoto);
        }
        else
        {
            imageViewphoto.setImageResource(R.drawable.age);
        }
        try{
        }
        catch (Exception e){

        }
        return listViewItem;
    }
}
