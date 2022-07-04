package com.ibrahim.ratemovie.service

import com.ibrahim.ratemovie.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
//https://api.themoviedb.org/3/movie/top_rated?api_key=d8645a71bef876249378e16b83434d01
//https://api.orhanaydogdu.com.tr/deprem/live.php?limit=100
//BASE URL     /     "live.php" GET içerisine yazılacak
//BASE URL     /..... ?    "limit" Query içerisine yazılacak
//BASE URL     /live.php?limit=100 getPlaces fun çağırıldığında 100 değeri girilecek getPlaces(100) şeklinde
// https://api.themoviedb.org/3/movie/top_rated?api_key=d8645a71bef876249378e16b83434d01
    @GET("/3/movie/top_rated")
    fun getMovies(@Query("api_key") apikey: String,
                  @Query("language") language: String,
                  @Query("page") page: Int) : Call<MoviesResponse>
    //Liste değil [ ile başlamıyor Call<List<şeklinde yazmadık
 /*   @GET("/3/genre/movie/list?api_key=d8645a71bef876249378e16b83434d01")
    fun getGenres(): Call<Genre>*/
}