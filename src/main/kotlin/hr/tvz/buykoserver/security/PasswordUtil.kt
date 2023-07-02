package hr.tvz.buykoserver.security

import java.security.MessageDigest

class PasswordUtil {

    fun isPasswordMatch(input: String, password: String, seed:String): Boolean {
        val hashedPassword = seededSHA(password, seed)
        return hashedPassword == input

    }

    fun seededSHA(input: String, seed: String): String {
        val message = input + seed
        return sha256(message)
    }

    private fun sha256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(input.toByteArray())
        val hexString = StringBuilder()
        for (byte in hashBytes) {
            val hex = String.format("%02x", byte)
            hexString.append(hex)
        }

        return hexString.toString()
    }


}