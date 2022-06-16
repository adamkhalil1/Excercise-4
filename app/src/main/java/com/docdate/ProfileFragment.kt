import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.docdate.LoginActivity
import com.docdate.R
import com.docdate.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment(val user: User) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        firstname_text.text = user.firstName
        lastname_text.text = user.lastName
        email_text.text = user.email
        website_text.text = user.website
        profession_text.text = user.profession
        title_text.text = user.title
        address_text.text = user.address
        phone_text.text = user.phone
        specialisation_text.text = user.specialisation
        img.setImageURI(Uri.parse(user.uri));

        logout_btn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

}