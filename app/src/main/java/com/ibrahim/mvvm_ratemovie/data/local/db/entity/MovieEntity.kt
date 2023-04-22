package com.ibrahim.mvvm_ratemovie.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    var movieId :Int=0,

    @ColumnInfo(name ="userVote")
    var userVote:Int,

    @ColumnInfo(name ="posterPath")
    var posterPath:String,

    @ColumnInfo(name ="title")
    var title:String,

    @ColumnInfo(name ="genreIds")
    var genreIds:String,

    @ColumnInfo(name ="voteAverage")
    var voteAverage:String,

    @ColumnInfo(name ="releaseDate")
    var releaseDate:String,


)
/*@Entity Veritabanının bir varlığını temsil eden tüm sınıflara @Entity olarak belirtilmesi gerekir.
@PrimaryKey: Bu bizim primarykey yani birincil anahtarımızdır. Otomatik olarak generate eder yani id olarak 0’dan basmaya başlar.
@ColumnInfo: oluşturulan sütunlardır. Tek sütundan fazla oluşturulmasını istiyorsanız başına @ColumnInfo eklemeniz gerekir.*/

