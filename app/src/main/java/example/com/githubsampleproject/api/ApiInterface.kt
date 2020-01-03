package example.com.githubsampleproject.api

import GitHubData
import example.com.githubsampleproject.util.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("repositories")
    fun getGitHubRepository():Call<List<GitHubData>>
}