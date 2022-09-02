package com.example.filmslist

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.filmslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    Напишите приложение по дизайну ниже, которое:
//    ● Отображает список фильмов и поддерживает пагинацию. API можно найти по ссылке;
//    ● При тапе на элемент списка должен отображаться экран с описанием выбранного фильма;
//    ● Опционально:
//    ○ иконка рейтинга фильма,
//    ○ список актеров и их фото,
//    ○ поиск по фильмам на главном экране,
//    ○ тесты.
//    Ключ разработчика: 274f828ad283bd634ef4fc1ee4af255f
//    Примеры запроса:
//    https://api.themoviedb.org/3/movie/550?api_key=274f828ad283bd634ef4fc1ee4af255f
//    https://api.themoviedb.org/3/discover/movie?api_key=274f828ad283bd634ef4fc1ee4af255f
//    Выбор архитектуры и библиотек остается за вами.
//    Альтернативаня АПИ https://imdb-api.com/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_films, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}