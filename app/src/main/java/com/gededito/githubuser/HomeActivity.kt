package com.gededito.githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gededito.githubuser.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var rvBio: RecyclerView
    private val list = ArrayList<DataBio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvBio = findViewById(R.id.rv_bio)
        rvBio.setHasFixedSize(true)

        list.addAll(listBio)
        showRecyclerList()
    }

    private val listBio: ArrayList<DataBio>
        get(){
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepo = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<DataBio>()
            for (i in dataName.indices) {
                val biouser = DataBio(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataRepo[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataPhoto.getResourceId(i,-1))
                listUser.add(biouser)
            }
            return listUser
        }

    private fun showRecyclerList(){

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvBio.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvBio.layoutManager = LinearLayoutManager(this)
        }

        val listBioAdapter = ListBioAdapter(list)
        rvBio.adapter = listBioAdapter

        listBioAdapter.setOnItemClickCallback(object : ListBioAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataBio) {
                val intent = Intent(this@HomeActivity, BioUserActivity::class.java)
                intent.putExtra(BioUserActivity.BIO_USER, data)
                startActivity(intent)
                showSelectedHero(data)
            }
        })

    }

    private fun showSelectedHero(data: DataBio) {
        Toast.makeText(this, "Kamu memilih " + data.name, Toast.LENGTH_SHORT).show()
    }

}
