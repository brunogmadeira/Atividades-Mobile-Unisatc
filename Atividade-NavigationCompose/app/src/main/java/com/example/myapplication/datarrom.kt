package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Entity
data class User(
    @PrimaryKey(autoGenerate = true ) val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val last_name: String
)

@Dao
interface UserDao{
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Update
    fun updateAll(vararg users: User)

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}

abstract class AppDatabase: RoomDatabase(){
    abstract fun userDao() : UserDao
}




