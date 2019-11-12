package com.smart_vellore_city.Digilocker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_vellore_city.Model.Image_Model;
import com.smart_vellore_city.R;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DigiLocker extends AppCompatActivity {

    public static final List<Image_Model> docsList = new ArrayList<>();

    FloatingActionButton fabAdd;

    ImageView addImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digilocker);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Digi Locker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ListView imagesList = (ListView) findViewById(R.id.friends);

        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);

        docsList.add(new Image_Model(R.drawable.salm, "Aadhar Card", R.color.sienna, "Sport", "Literature", "Music", "Art", "Technology"));
        docsList.add(new Image_Model(R.drawable.pan, "Pan Card", R.color.saffron, "Travelling", "Flights", "Books", "Painting", "Design"));
        docsList.add(new Image_Model(R.drawable.credit_card, "Credit Card", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
        docsList.add(new Image_Model(R.drawable.voter_id, "Voter Id", R.color.pink, "Android", "Development", "Design", "Wearables", "Pets"));
        docsList.add(new Image_Model(R.drawable.lic, "Licence", R.color.orange, "Design", "Fitness", "Healthcare", "UI/UX", "Chatting"));
        docsList.add(new Image_Model(R.drawable.pdf, "Certificate", R.color.saffron, "Development", "Android", "Healthcare", "Sport", "Rock Music"));

        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        imagesList.setAdapter(new ImageAdapter(this, docsList, settings));

        imagesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Image_Model f = (Image_Model) imagesList.getAdapter().getItem(position);

//                Toast.makeText(getApplicationContext(), f.getNickname(), Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder builder = new AlertDialog.Builder(DigiLocker.this);

                LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View dview = li.inflate(R.layout.alert_delete_doc,null);

                builder.setView(dview);
                final AlertDialog dialog = builder.create();
                dialog.show();
                dialog.setCancelable(true);

                dview.setBackgroundColor(getResources().getColor(f.getBackground()));

                TextView tvNickname = (TextView)dview.findViewById(R.id.nickname);
                ImageView imDelete = (ImageView) dview.findViewById(R.id.im_delete);

                tvNickname.setText(f.getNickname());
                imDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();
                        docsList.remove(position);
                        dialog.dismiss();
                        docsList.clear();
                        recreate();
                    }
                });

            }
        });

      fabAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              final AlertDialog.Builder builder = new AlertDialog.Builder(DigiLocker.this);

              LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

              final View dview = li.inflate(R.layout.alert_add_doc,null);

              builder.setView(dview);
              final AlertDialog dialog = builder.create();
              dialog.show();
              dialog.setCancelable(true);

              Button btnSave = (Button)dview.findViewById(R.id.btn_save);
              addImage = (ImageView) dview.findViewById(R.id.add_image);
              final EditText etName = (EditText) dview.findViewById(R.id.et_name);

              addImage.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                              android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      startActivityForResult(pickPhoto , 1);
                  }
              });
              btnSave.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      if (etName.getText().toString().equalsIgnoreCase("")){

                          Toast.makeText(getApplicationContext(),"Enter Name of the Document",Toast.LENGTH_SHORT).show();
                      }else {
                          Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_SHORT).show();
                          dialog.dismiss();
                          docsList.clear();
                          recreate();
                      }
                  }
              });


          }
      });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    addImage.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    addImage.setImageURI(selectedImage);
                }
                break;
        }
    }

    class ImageAdapter extends BaseFlipAdapter {

        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2};

        public ImageAdapter(Context context, List<Image_Model> items, FlipSettings settings) {
            super(context, items, settings);
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Object item1,
                            Object item2) {
            final ImageHolder holder;

            if (convertView == null) {
                holder = new ImageHolder();
                convertView = getLayoutInflater().inflate(R.layout.friends_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.friends_info, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);
                holder.imageDelete = (ImageView) holder.infoPage.findViewById(R.id.im_delete);

                holder.interestsSecondary = (LinearLayout) holder.infoPage.findViewById(R.id.interestsSecondary);

                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));

                convertView.setTag(holder);
            } else {
                holder = (ImageHolder) convertView.getTag();
            }

            switch (position) {
                // Merged page with 2 friends
                case 1:
                    holder.leftAvatar.setImageResource(((Image_Model) item1).getAvatar());
                    if (item2 != null)
                        holder.rightAvatar.setImageResource(((Image_Model) item2).getAvatar());
                    break;


                default:
                    fillHolder(holder, position == 0 ? (Image_Model) item1 : (Image_Model) item2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }

            holder.interestsSecondary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(),"DElete pressed",Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(final ImageHolder holder, final Image_Model imageModel) {
            if (imageModel == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            final Iterator<String> iInterests = imageModel.getInterests().iterator();
            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());
            holder.infoPage.setBackgroundColor(getResources().getColor(imageModel.getBackground()));
            holder.nickName.setText(imageModel.getNickname());


        }

        class ImageHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;
            LinearLayout interestsSecondary;
            ImageView imageDelete;

            List<TextView> interests = new ArrayList<>();
            TextView nickName;
        }
    }
}
