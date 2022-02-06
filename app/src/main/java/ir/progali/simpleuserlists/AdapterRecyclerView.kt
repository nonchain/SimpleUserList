package ir.progali.simpleuserlists

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class AdapterRecyclerView(var data: List<Items>) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    var cxt: Context? = null

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val username:TextView
        val userType:TextView
        val civUser:CircleImageView

        init {
            username = view.findViewById(R.id.tvUserName)
            userType = view.findViewById(R.id.tvType)
            civUser = view.findViewById(R.id.civUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vv:View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false);
        cxt = parent.context

        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(data.get(position).owner?.profile_image).into(holder.civUser)
        holder.username.setText(data.get(position).owner?.display_name)
        holder.userType.setText(data.get(position).owner?.user_type)

        holder.itemView.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.get(position).owner?.link))
            cxt?.startActivity(intent)
        }
    }

    override fun getItemCount() = data.size

}

