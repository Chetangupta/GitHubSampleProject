package example.com.githubsampleproject.activity

import GitHubData
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.githubsampleproject.R
import example.com.githubsampleproject.adapter.GitHubAdapter
import example.com.githubsampleproject.util.showToast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(),MainViewPresenter.MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.GONE
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        this.presenter = MainPresenter(this)
        presenter.getData()


    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun getDataFailed(strError: String) {
      showToast(this,strError, Toast.LENGTH_SHORT)
    }

    override fun moveToNextScreen(gitHubData: GitHubData) {
        val intent = Intent(this,GitHubDetailActivity::class.java)
        intent.putExtra("gitHubData",gitHubData as Serializable)
        startActivity(intent)
    }


    override fun setGitData(arrGitHub: List<GitHubData>) {
        recyclerView.adapter = GitHubAdapter(arrGitHub) {
            presenter.getItemClicked(arrGitHub.get(it))
        }
    }
}


