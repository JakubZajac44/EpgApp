package pl.proexe.junior.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.nav_drawe.view.*
import pl.proexe.junior.R
import pl.proexe.junior.model.data.NavigationDrawerModel

class NavDrawerAdapter (private var items: NavigationDrawerModel) :
    RecyclerView.Adapter<NavDrawerAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(R.layout.nav_drawe, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.drawerItem.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        if(items.drawerItem[position].isSelected){
            holder.itemView.navigation_title.setTextColor(ContextCompat.getColor(context,R.color.colorAccent))
        }else{
            holder.itemView.navigation_title.setTextColor(ContextCompat.getColor(context,R.color.colorWhite))
        }
        holder.itemView.navigation_title.text = context.getString(items.drawerItem[position].labelId)
    }

}