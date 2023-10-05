package pk.lab1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.room.Room
import pk.lab1.database.Time
import pk.lab1.database.TimeDatabase

class NumberReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val username = intent.getStringExtra(TimeService.USERNAME)
        val number = intent.getIntExtra(TimeService.NUMBER, 0)
        val db = Room.databaseBuilder(
            context.applicationContext,
            TimeDatabase::class.java, "time-database"
        ).allowMainThreadQueries().build()

        db.timeDao().insertAll(Time(0, username, number))

        Log.i("NumberReceiver", "Username: $username, number: $number")
    }
}