package com.ibrahim.ratemovie.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahim.ratemovie.db.entity.MovieEntity


@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table where userVote = :rate")
    fun getRateMoviesByRate(rate:Int): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(note:MovieEntity)

    @Query("DELETE from movie_table where movieId = :movieId")
    fun deleteById(vararg movieId :Int) :Int
}

/*DAO’lar, Room’u çalıştırırken verilerinize erişmek için kullanılır. Her DAO, verilerinizi işlemek için bir
yöntem içermesi gerekir. Bu yöntemler, veriyi eklemek için INSERT, veriyi getirmek ve silmesi @Query’dir.
Yani ekleme, güncelleme, silme.
DAO sınıfı abstract bir sınıftır. Bir kere oluşturmamız yeterlidir.

getAllNotes() : Burada tüm notları veritabanından çağıran bir metodu.
insertAll(): Veritabanına veri eklemek için kullanılan metoddur.
deletebyID: Belirtilen id’ye göre veritabanında sorgulama yapar ve ilgili sütunu siler.*/