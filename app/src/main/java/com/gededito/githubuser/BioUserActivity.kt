package com.gededito.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gededito.githubuser.databinding.ActivityBioUserBinding

class BioUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBioUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBioUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

        supportActionBar?.title = "Biodata User"

    }

    private fun setData(){
        val bioUser = intent.getParcelableExtra<DataBio>(BIO_USER) as DataBio
        with(binding) {
            Glide.with(root)
                .load(bioUser.photo)
                .circleCrop()
                .into(imageProfile)
            tvUsername.text = bioUser.username
            tvName.text = bioUser.name
            tvLocation.text = bioUser.location
            tvFollowers.text = bioUser.followers
            tvFollowing.text = bioUser.following
            tvRepository.text = bioUser.repository
        }
    }

    companion object {
        const val BIO_USER = "bio_user"
    }

}