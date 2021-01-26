package com.molodovViktor.instagram.common.firebase

import com.molodovViktor.instagram.common.AuthManager
import com.molodovViktor.instagram.common.toUnit
import com.molodovViktor.instagram.data.firebase.common.auth
import com.google.android.gms.tasks.Task

class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()
    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}