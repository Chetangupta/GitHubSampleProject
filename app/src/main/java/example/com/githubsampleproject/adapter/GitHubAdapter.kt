package example.com.githubsampleproject.adapter

import GitHubData
import android.view.View

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.com.githubsampleproject.R
import example.com.githubsampleproject.util.inflate
import kotlinx.android.synthetic.main.adapter_githubdata.view.*

class GitHubAdapter(private val arrNewsUpdates: List<GitHubData>, private val listener: (Int) -> Unit) : RecyclerView.Adapter<GitHubAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(inflate(parent.context, R.layout.adapter_githubdata, parent, false))
    }

    override fun getItemCount(): Int {
        return arrNewsUpdates.size
    }

    override fun onBindViewHolder(holder: GitHubAdapter.MyViewHolder, position: Int) {
        holder.bind(arrNewsUpdates[position], listener)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(GitHubItem: GitHubData, listener: (Int) -> Unit) = with(itemView) {
            tv_heading.text = GitHubItem.fullName
            tv_description.text = GitHubItem.description
            tv_source.text = GitHubItem.downloadsUrl
            itemView.setOnClickListener{listener(adapterPosition)}
        }
    }
}