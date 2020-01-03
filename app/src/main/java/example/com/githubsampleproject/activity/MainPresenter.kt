package example.com.githubsampleproject.activity

import GitHubData
import android.provider.SyncStateContract
import android.util.Log
import example.com.githubsampleproject.api.ApiClient
import example.com.githubsampleproject.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private var iMainView: MainViewPresenter.MainView) : MainViewPresenter.MainPresenter    {
    override fun getData() {
        iMainView.showProgress()
        val apiService = ApiClient.client.create(ApiInterface::class.java)
        val call = apiService.getGitHubRepository()
        call.enqueue(object:Callback<List<GitHubData>>{
            override fun onResponse(call: Call<List<GitHubData>>, response: Response<List<GitHubData>>) {
                iMainView.hideProgress()
                response.body()?.let { iMainView.setGitData(it) }
               // response.body()?.let { iMainView?.setGitData(it) }
            }

            override fun onFailure(call: Call<List<GitHubData>>, t: Throwable) {
                iMainView.hideProgress()
                iMainView.getDataFailed(call.toString())
            }

        })
    }

    override fun getItemClicked(gitHubData: GitHubData) {
           iMainView.moveToNextScreen(gitHubData)
    }


}