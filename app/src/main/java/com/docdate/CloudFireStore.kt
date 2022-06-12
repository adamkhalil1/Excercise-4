package com.docdate
import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class CloudFirestore {
    private val fireStoreInstance = FirebaseFirestore.getInstance()

    fun saveUserInfoOnCloudFirestore(registerActivity : DocRegistrationActivity, currentUser : User){

        //Users is the name of the DB-collection/table
        fireStoreInstance.collection(Constants.TABLENAME_USERS)
            .document(currentUser.id.toString())
            .set(currentUser, SetOptions.merge())
            .addOnSuccessListener {
                registerActivity.userRegistrationSuccess()
            }
            .addOnFailureListener { e->
                Log.e(registerActivity.javaClass.simpleName, "Error while registering the current user.", e)
            }
    }

    fun getUserDetails(loginActivity: LoginActivity){
        fireStoreInstance.collection(Constants.TABLENAME_USERS)
            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->
                val user: User = document.toObject(User::class.java)!!
                //TODO loginActivity.userLoggedInSuccess(user)
            }
            .addOnFailureListener { e->
                Log.e(loginActivity.javaClass.simpleName, "Error while reading the current user information.", e)
            }

    }

    //read currentUserID from Google Firebase Authentification module
    private fun getCurrentUserID() : String {
        //Attention: We are getting the currentuser ID from the Authentification module and
        // NOT from the cloud firestore

        //das sollte auch möglich sein: return FirebaseAuth.getInstance().currentUser?.uid ?: ""
        val currentUser = FirebaseAuth.getInstance().currentUser

        if(currentUser != null)
            return currentUser.uid

        return ""
    }
}