package com.example.linxhoursofoperation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private OnNoteListener mOnNoteListener;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, OnNoteListener onNoteListener) {
        this.mContext = context;
        this.mNames = imageNames;
        this.mImages = images;
        this.mOnNoteListener = onNoteListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnNoteListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);




        holder.imageName.setText(mNames.get(position));
// the long-sought after if-statement
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
                if(mNames.get(position).equals("Ed Hall Café")){
                    Intent intent = new Intent(mContext, EdHallCafe.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("Old Westbury Bookstore")){
                    Intent intent = new Intent(mContext, OWBookstore.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("Recreation Hall")){
                    Intent intent = new Intent(mContext, RecreationHall.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("Riland Café")){
                    Intent intent = new Intent(mContext, RilandCafe.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("SAC Dining Hall")){
                    Intent intent = new Intent(mContext, SACDiningHall.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("Salten Café")){
                    Intent intent = new Intent(mContext, SaltenHallCafe.class);
                    mContext.startActivity(intent);
                }
                else if(mNames.get(position).equals("Wisser Library")){
                    Intent intent = new Intent(mContext, WisserLibrary.class);
                    mContext.startActivity(intent);
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.imagename);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick (int position);

    }
}
