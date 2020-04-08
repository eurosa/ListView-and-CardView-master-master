package com.ranx.xcosx;

import android.content.Context;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static androidx.core.content.ContextCompat.startActivity;

/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class CardsAdapter extends ArrayAdapter<CardModel> {
    private boolean isCheck=false;

    public CardsAdapter(Context context) {
        super(context, R.layout.card_item);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

         final CardModel model = getItem(position);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // CardModel model2 = getItem(position);
                //if (interstitialAd.isLoaded()) {
                //  interstitialAd.show();
                //} else {
                //  Log.d("TAG", "The interstitial wasn't loaded yet.");
                //}


                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bitmap bitmap = ((BitmapDrawable)holder.imageView.getDrawable()).getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap , 60, 60, false);
                intent.putExtra("title", holder.tvTitle.getText());
                intent.putExtra("subTitle",holder.tvSubtitle.getText());
                intent.putExtra("image_draw", bitmap);


               // intent.putExtra("image_draw", String.valueOf(holder.imageView.getDrawable()));




                startActivity(getContext(),intent,null);
            }
        });


        holder.imageView.setImageResource(model.getImageId());
        holder.tvTitle.setText(model.getTitle());
        holder.tvSubtitle.setText(model.getSubtitle());
        holder.tvSubtitle.setSingleLine(true);
       // holder.tvSubtitle.setEllipsize();
        holder.tvSubtitle.setHorizontalFadingEdgeEnabled(true);
        holder.tvSubtitle.setFadingEdgeLength(20);
        holder.tvSubtitle.setHorizontalFadingEdgeEnabled(true);

       // makeTextViewResizable(holder.tvSubtitle, 3, "See More", false);
/*
        holder.tvSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCheck) {
                    holder.tvSubtitle.setMaxLines(10);
                    isCheck = false;
                } else {
                    holder.tvSubtitle.setMaxLines(2);
                    isCheck = true;
                }
            }
        });*/

        return convertView;
    }



    static class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvSubtitle;

        ViewHolder(View view) {
            imageView =  view.findViewById(R.id.image);
            tvTitle = view.findViewById(R.id.text_title);
            tvSubtitle = view.findViewById(R.id.text_subtitle);
        }
    }






}
