package example.com.githubsampleproject.activity

import GitHubData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import example.com.githubsampleproject.R
import kotlinx.android.synthetic.main.activity_git_hub_detail.*

class GitHubDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_hub_detail)
        val gitHubData = intent.getSerializableExtra("gitHubData") as? GitHubData
        if (gitHubData != null) {
            tv_name.setText(gitHubData.name)
        };
        if (gitHubData != null) {
            tv_releases_url.setText(gitHubData.releasesUrl)
        }
        if (gitHubData != null) {
            tv_description.setText(gitHubData.description)
        }

        //val intent = Intent(this)

    }
}
