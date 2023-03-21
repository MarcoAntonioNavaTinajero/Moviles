    package com.example.practica1android.database

    import android.content.Context
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase

    @Database(entities = [Comanda::class, Orden::class], version = 1, exportSchema = false)
    abstract class PizzasDataBase : RoomDatabase() {
        abstract val ordenDatabaseDao : OrdenDatabaseDAO
        companion object {
            @Volatile
            private var INSTANCE : PizzasDataBase? = null
            fun getInstance(context: Context): PizzasDataBase {
                synchronized(this) {
                    var instance = INSTANCE
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            PizzasDataBase::class.java,
                            "pizzas_database").fallbackToDestructiveMigration().build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
    }