package pl.proexe.junior.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.tv_programme_card_view.view.*
import pl.proexe.junior.R
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.util.convertDateToTimeStringFormat

class EpgRecyclerAdapter(public var tvProgramme: List<TvProgramme>): RecyclerView.Adapter<EpgRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var tvProgrammeTitle: TextView = itemView.findViewById(R.id.titleTextView)
        var tvProgrammeDescription: TextView = itemView.findViewById(R.id.descriptionTextView)
        var tvProgrammeIcon: ImageView = itemView.findViewById(R.id.iconImageView)
        var tvProgrammeProgressBarPercent: ProgressBar = itemView.findViewById(R.id.progressBarPercent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_programme_card_view, parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return tvProgramme.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvProgrammeTitle.text=tvProgramme[position].title
        val startTime = convertDateToTimeStringFormat(tvProgramme[position].startTime)
        val endTime = convertDateToTimeStringFormat(tvProgramme[position].endTime)
        val description = startTime + " - " + endTime + " | " + tvProgramme[position].type
        holder.tvProgrammeDescription.text=description
        holder.tvProgrammeProgressBarPercent.progress = tvProgramme[position].progressPercent

        Glide.with(holder.itemView)
            .load(tvProgramme[position].imageUrl)
            .centerCrop()
            .override(100,100)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
            .placeholder(R.drawable.ic_broken_image)
            .error(R.drawable.ic_broken_image)
            .fallback(R.drawable.ic_broken_image)
            .into(holder.tvProgrammeIcon)
    }




}