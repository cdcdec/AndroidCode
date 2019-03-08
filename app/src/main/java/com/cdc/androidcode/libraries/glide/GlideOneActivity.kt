package com.cdc.androidcode.libraries.glide
import android.view.View
import com.cdc.androidcode.R
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract.Contacts
import com.bumptech.glide.util.Preconditions
import android.content.ContentUris
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import android.Manifest
import android.os.Bundle
import android.provider.ContactsContract
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.common.GlideApp
import kotlinx.android.synthetic.main.glide_contact_uri_activity.*


class GlideOneActivity : BaseActivity() {
    private val REQUEST_CONTACT = 1
    private val READ_CONTACTS = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.glide_contact_uri_activity)
        setBackBtn()
        setTitle("glide读取联系人头像")
        button_pick_contact.setOnClickListener(this)
        button_find.setOnClickListener(this)

        if (ContextCompat.checkSelfPermission(
                application,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.READ_CONTACTS),READ_CONTACTS)
        }

    }





    override fun onClick(v: View?) {
        super.onClick(v)
        when(v!!.id){
            R.id.button_pick_contact->{
                val intent = Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI)
                startActivityForResult(intent, REQUEST_CONTACT)
            }

            R.id.button_find->{
                val uri = Uri.withAppendedPath(
                    ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                    Uri.encode(number_entry.text.toString()))
                    GlideApp.with(this)
                    .load(uri)
                    .override(Target.SIZE_ORIGINAL)
                    .into(image_lookup)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CONTACT && resultCode == RESULT_OK) {
            val uri = Preconditions.checkNotNull(data!!.data)
            val cursor: Cursor = contentResolver.query(uri, null, null, null, null)
            cursor.use { cursor ->
                if (cursor != null && cursor.moveToFirst()) {
                    val  contactId = cursor.getLong(cursor.getColumnIndex(Contacts._ID))
                    showContact(contactId)
                }
            }
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun showContact(id:Long){
        val glideRequests = GlideApp.with(this)
        val originalSize = RequestOptions().override(Target.SIZE_ORIGINAL)

        val contactUri = ContentUris.withAppendedId(Contacts.CONTENT_URI, id)
        glideRequests.load(contactUri).apply(originalSize).into(image_contact)

        val lookupUri = Contacts.getLookupUri(contentResolver, contactUri)
        glideRequests.load(lookupUri).apply(originalSize).into(image_lookup)

        val photoUri = Uri.withAppendedPath(contactUri, Contacts.Photo.CONTENT_DIRECTORY)
        glideRequests.load(photoUri).apply(originalSize).into(image_photo)

        val displayPhotoUri = Uri.withAppendedPath(contactUri, Contacts.Photo.DISPLAY_PHOTO)
        glideRequests.load(displayPhotoUri).apply(originalSize).into(image_display_photo)
    }


}
