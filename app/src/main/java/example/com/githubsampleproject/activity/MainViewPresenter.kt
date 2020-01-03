package example.com.githubsampleproject.activity

import GitHubData
interface MainViewPresenter {
    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setGitData(arrNewsUpdates: List<GitHubData>)
        fun getDataFailed(strError: String)
        fun moveToNextScreen(gitHubData: GitHubData)

    }

    interface MainPresenter {
        fun getData()
        fun getItemClicked(gitHubData: GitHubData)
    }
}